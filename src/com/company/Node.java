package com.company;

/*Class for linked list implementation.
Node represents placeholder for task and link to the next/previous node in the LinkedTask list*/

public class Node {

    private Node previous;
    private Node next;
    private Task storedTask;

    /*Add first Node to the list*/
    public Node(Task storedTask) {
        this.next = null;
        this.previous = null;
        this.storedTask = storedTask;
    }

    /*Add last node to the list*/
    public Node(Task storedTask, Node previous) {
        this.next = null;
        this.previous = previous;
        this.storedTask = storedTask;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    public Task getStoredTask() {
        return storedTask;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public void addTask(Task task) {
        this.storedTask = task;
    }

    @Override
    public String toString() {
        return getStoredTask().getTitle();
    }
}
