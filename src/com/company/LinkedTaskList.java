package com.company;

public class LinkedTaskList extends TaskList{
    @Override
    public void add(Task task) {

    }

    @Override
    public boolean remove(Task task) {
        return false;
    }

    @Override
    public Task getTask(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public TaskList incoming(int from, int to) {
        return null;
    }
}
