/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment01.datastructure;

/**
 *
 * @author nghin
 */
public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        ++size;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        ++size;
    }

    public void addAtIndex(E data, int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            addFirst(data);
        }
        if (index == size - 1) {
            addLast(data);
        }
        if (!isEmpty()) {
            Node<E> newNode = new Node<>(data);
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            ++size;
        }
    }

    public void removeHead() {
        if (!isEmpty()) {
            head = head.next;
            --size;
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            Node<E> current = head;
            Node<E> previ = current;
            while (current.next != null) {
                previ = current;
                current = current.next;
            }
            previ.next = null;
            --size;
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (!isEmpty()) {
            if (index == 0) {
                removeHead();
                return;
            }
            if (index == size - 1) {
                removeLast();
                return;
            }
            Node<E> current = head;
            Node<E> previ = null;
            for (int i = 0; i < index; i++) {
                previ = current;
                current = current.next;
            }
            previ.next = current.next;
            --size;
        }
    }

    public Node<E> get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    void visit(Node node) {
        if (node != null) {
            System.out.println(node.toString());
        }
    }

    public void traverse() {
        Node node = head;
        while (node != null) {
            visit(node);
            if (node.next == null) {
            }
            node = node.next;
        }
        System.out.println();
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
