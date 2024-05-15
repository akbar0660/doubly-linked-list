package org.example.DoublyLinkedList;

public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    class Node<T> {
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

    private Node<T> removeLast() {
        Node<T> n = last.prev;
        Node<T> n1 = last;
        n.next = null;
        last = n;
        n1.prev = null;
        return last;
    }

    private Node<T> removeFirst() {
        Node<T> n = first.next;
        Node<T> n1 = first;
        first = n;
        first.prev = null;
        first.next = n.next;
        n1.next = null;
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

    int getSize() {
        return size;
    }

    T get(int index) {
        Node<T> n = first;
        int count = 0;
        while (count != index) {
            n = n.next;
            count++;
        }
        return n.value;
    }

    T getFirst() {
        return first.value;
    }

    T getLast() {
        return last.value;
    }

    T remove(int index) {
        if (first == null) {
            return null;
        } else if (index == size - 1) {
            size--;
            return removeLast().value;
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

    int indexOf(T element) {
        int index = 0;
        Node<T> n = first;
        while (n.value != element) {
            n = n.next;
            index++;
        }
        return index;
    }

    boolean contains(T element) {
        Node<T> n = first;
        int count = 0;
        while (n != null && n.value != element) {
            n = n.next;
            count++;
        }
        return count == size ? false : true;
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
