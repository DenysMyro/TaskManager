package com.company;

public class Main {

    public static void main(String[] args) {

        Task task1 = new Task("task1", 55, true);
        Task task2 = new Task("task2", 50, true);
        Task task3 = new Task("task3", 60, true);
        Task task4 = new Task("task4", 1, 55, 1, true);
//        Task task5 = new Task("task5", 0, 55, 22, true);
//        Task task6 = new Task("task6", 0, 60, 30, true);
//
        ArrayTaskList list = new ArrayTaskList();


//        task1=null;

        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);
//        list.add(task5);
//        list.add(task6);
        list.add(null);

        System.out.println(list);

        task1.setTime(-1);
        task4.setTime(-1, -1, -1);
        System.out.println(task1.getTime());
//
//        list.remove(task1);
//
//        System.out.println(list);
//
//        System.out.println("upcoming: " + list.incoming(50, 60));
//        System.out.println(task1);
    }
}
