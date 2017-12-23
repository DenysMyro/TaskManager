package com.company;


public abstract class TaskList implements Iterable<Task> {

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract Task getTask(int index);

    public abstract int size();

    public abstract TaskList incoming(int from, int to);

}
