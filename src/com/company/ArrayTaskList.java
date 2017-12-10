package com.company;

public class ArrayTaskList {

    private Task[] tasklist = new Task[5];
    int size = 0;

    public void add(Task task) {
//        if (task==null)
//            try {
//                throw new TaskIsNullException();
//            } catch (TaskIsNullException taskIsNullException) {
//                taskIsNullException.printStackTrace();
//            }
        if (size >= tasklist.length) {
            Task tempList[] = new Task[(int) (tasklist.length +tasklist.length*0.5)];
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
        if (index > tasklist.length)
            return null;
        else
            return tasklist[index];
    }

    public ArrayTaskList incoming (int from, int to) {
        ArrayTaskList incoming = new ArrayTaskList();
        for (Task listItem : tasklist) {
            if (listItem != null&&listItem.isActive) {
                    if (listItem.nextTimeAfter(from)<=to&&listItem.nextTimeAfter(from)!=-1) {
                        incoming.add(listItem); 
                }
            }
        }   
        return incoming;
    }

    @Override
    public String toString() {
        String temp = "";
        for(int i=0;i<size;i++){

            temp += tasklist[i].toString()+" ";
        }
        return temp;
    }
}
