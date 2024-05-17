package org.example.DoublyLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    static class Node<T> {
        T value;
        Node<T> next; // reference
        Node<T> prev; //reference

        Node(T value) {
            this.value = value;
        }
    }

    //HELPER METHODS
    private Node<T> getNode(int index) {
        Node<T> n = first;
        int count = 0;
        while (n.next != null && count != index) {
            n = n.next;
            count++;
        }
        return n;
    }

    private Node<T> findNode(T element) {
        Node<T> n = first;
        while (n != null && n.value != element) {
            n = n.next;
        }
        return n;
    }

    void addTail(T tail) {
        Node<T> newNode = new Node<>(tail);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else if (size == 1) {
            first.next = newNode;
            last = newNode;
            last.prev = first;
        } else {
            Node<T> n = last;
            last = newNode;
            last.prev = n;
            n.next = last;
        }
        size++;
    }

    void addHead(T head) {
        Node<T> newNode = new Node<>(head);
        if (first == null) {
            first = newNode;
        } else {
            Node<T> n = first;
            first = newNode;
            newNode.next = n;
            n.prev = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.first==null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> n = first;
        for(int i = 0 ;i<size;i++){
            array[i] = n.value;
            n = n.next;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public T get(int index) {
        Node<T> n = first;
        int count = 0;
        while (count != index) {
            n = n.next;
            count++;
        }
        return n.value;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    public T getFirst() {
        return first.value;
    }

    public T getLast() {
        return last.value;
    }

    public T remove(int index) {
        if (first == null) {
            return null;
        } else if (index == size - 1) {
            size--;
            Node<T> n = getNode(size-1);
            removeLast();
            return n.value;
        } else {
            Node<T> n = getNode(index);
            Node<T> previous = n.prev;
            Node<T> next = n.next;
            previous.next = next;
            next.prev = previous;
            size--;
            return n.value;
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    boolean removeByValue(T element) {
        if (first == null) {
            return false;
        } else {
            Node<T> n = findNode(element);
            if (n == null) {
                return false;
            } else if (n == last) {
                removeLast();
                size--;
                return true;
            } else if (n == first) {
                removeFirst();
                return true;
            } else {
                Node<T> previous = n.prev;
                Node<T> next = n.next;
                previous.next = next;
                next.prev = previous;
                size--;
                return true;
            }
        }
    }

    public int indexOf(Object element) {
        int index = 0;
        Node<T> n = first;
        while (n.value != element) {
            n = n.next;
            index++;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    public boolean contains(Object element) {
        Node<T> n = first;
        int count = 0;
        while (n != null && n.value != element) {
            n = n.next;
            count++;
        }
        return count !=size;
    }

    void printAll() {
        Node<T> n = first;
        while (n.next != null) {
            System.out.println(n.value);
            n = n.next;
        }
        System.out.println(n.value);
    }


}
