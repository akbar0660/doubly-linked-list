package org.example.DoublyLinkedList;


public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addHead("salam");
        list.addTail("salam1");
        list.addTail("salam2");
        list.addHead("salam3");
        list.printAll();
        list.removeByValue("salam");
        System.out.println();
        list.printAll();
        System.out.println();
        list.remove(2);
        list.addHead("dsjkj");
        list.printAll();
        System.out.println(list.size());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.contains("sjjasf"));
        System.out.println(list.contains("salam1"));
    }
}