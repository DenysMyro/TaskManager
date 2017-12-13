package com.company;

public class LinkedTaskList extends TaskList {

    private Node head;
    private Node tail;
    private int size;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public void add(Task task) {
        if (getHead() == null) {
            Node node = new Node(task);
            setHead(node);
            setTail(node);
            size++;
        } else {
            Node newNode = new Node(task, getTail());
            getTail().setNext(newNode);
            setTail(newNode);
            size++;
        }
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
        return size;
    }

    @Override
    public TaskList incoming(int from, int to) {
        return null;
    }

    @Override
    public String toString() {
        String list = "";
        Node tmp = getHead();
        while (tmp != null) {
            list += tmp.getStoredTask().getTitle() + " ";
            tmp = tmp.getNext();
        }
        return "LinkedTaskList{ " + list + '}' + "\n" +
                "head = " + head + "\n" +
                "tail = " + tail + "\n" +
                "size = " + size;
    }
}
