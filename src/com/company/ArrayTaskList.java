package com.company;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayTaskList extends TaskList {

    private Task[] tasklist = new Task[5];
    private int size = 0;

    public void add(Task task) {
        if (task == null) {
            throw new NullPointerException("Task can't be null");
        }

        if (size >= tasklist.length) {
            Task tempList[] = new Task[(int) (tasklist.length + tasklist.length * 0.5)];
            for (int i = 0; i < tasklist.length; i++) {
                tempList[i] = tasklist[i];
            }
            tasklist = tempList;
        }
        tasklist[size] = task;
        size++;
    }

    public boolean remove(Task task) {
        for (int i = 0; i < tasklist.length; i++) {
            if (task.equals(tasklist[i])) {
                tasklist[i] = null;
                Task tempList[] = tasklist;
                for (int j = i; j < tasklist.length; j++) {
                    if (j + 1 < tempList.length)
                        tasklist[j] = tempList[j + 1];
                }
                size--;
                tasklist[size] = null;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Task getTask(int index) {
        if (index > tasklist.length) {
            throw new IndexOutOfBoundsException("No task found with index: " + index);
        }
        return tasklist[index];
    }

    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList incoming = new ArrayTaskList();
        for (Task listItem : tasklist) {
            if (listItem != null && listItem.isActive()) {
                if (listItem.nextTimeAfter(from) <= to && listItem.nextTimeAfter(from) != -1) {
                    incoming.add(listItem);
                }
            }
        }
        return incoming;
    }

    public int arraysize() {
        return tasklist.length;
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < size; i++) {

            temp += tasklist[i].toString() + " ";
        }
        return temp;
    }

    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return tasklist[currentIndex] != null && currentIndex < tasklist.length;
            }

            @Override
            public Task next() {
                return tasklist[currentIndex++];
            }

            @Override
            public void remove() {
                if (tasklist[currentIndex] == null) {
                    throw new IllegalStateException();
                }
                ArrayTaskList.this.remove(getTask(currentIndex));
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayTaskList tasks = (ArrayTaskList) o;

        if (size != tasks.size) return false;

        for (int i =0; i<size; i++){
            if(!this.getTask(i).equals(tasks.getTask(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(tasklist);
        result = 31 * result + size;
        return result;
    }
}
