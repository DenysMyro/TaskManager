package com.company;

import java.util.NoSuchElementException;

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
        Node tpm = head;
        Node previous;
        Node next;
        int counter = 1;
        //case for removing last element in the list
        if (head.equals(tail) && tpm.getStoredTask().equals(task)) {
            head = tail = null;
            size--;
            return true;
        }

        //iterate tmp variable to task for removal
        while (!tpm.getStoredTask().equals(task)) {
            tpm = tpm.getNext();
            if (counter >= size()) {
                break;
            }
            counter++;
        }
        if (tpm == null) {
            return false;
        } else {
            if (tpm.equals(head)) {
                previous = null;
                setHead(tpm.getNext());
            } else {
                previous = tpm.getPrevious();
            }
            if (tpm.equals(tail)) {
                next = null;
                setTail(tpm.getPrevious());
            } else {
                next = tpm.getNext();
            }

            if (previous != null) {
                previous.setNext(next);
            }
            if (next != null) {
                next.setPrevious(previous);
            }
            size--;
            return true;
        }
    }

    @Override
    public Task getTask(int index) {
        if (index > size) {
            throw new NoSuchElementException();
        } else {
            Node tpm = head;
            for (int i = 1; i < index; i++) {
                tpm = tpm.getNext();
            }
            return tpm.getStoredTask();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public TaskList incoming(int from, int to) {
        LinkedTaskList incoming = new LinkedTaskList();
        Node tmp = head;
        while (tmp != null) {
            if (tmp.getStoredTask().nextTimeAfter(from) <= to && tmp.getStoredTask().nextTimeAfter(from) != -1) {
                incoming.add(tmp.getStoredTask());
            }
            tmp = tmp.getNext();
        }
        return incoming;
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
