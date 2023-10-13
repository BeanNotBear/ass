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
public class Node<E> {
    public E data;
    public Node next;

    public Node() {
    }

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return data.toString();
    }
}