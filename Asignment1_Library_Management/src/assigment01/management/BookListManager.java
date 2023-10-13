/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment01.management;

import assigment01.datastructure.MyLinkedList;
import assigment01.datastructure.Node;
import assigment01.entity.Book;
import assigment01.fileprocess.FileProcess;
import assigment01.validation.Validation;

/**
 *
 * @author Admin
 */
public class BookListManager {

    public void loadData(String nameFile) {
        FileProcess fp = new FileProcess();
        fp.inputFileBook(nameFile);
    }

    public void inputAndAddToLast(MyLinkedList<Book> listBook) {
        Validation valid = new Validation();
        String bcode = Validation.getInputBookID("Enter bcode: ", listBook);
        String title = Validation.getString("Enter title: ");
        int quantity = Validation.getPostiveInt("Enter quantity: ");
        int lending = Validation.getIntLimit("Enter lending: ", 0, quantity);
        double price = Validation.getPrice("Enter price: ");
        listBook.addLast(new Book(bcode, title, quantity, lending, price));
    }

    public void displayData(MyLinkedList<Book> listBook) {
        listBook.traverse();
    }

    public Node<Book> searchByCode(MyLinkedList<Book> listBook, String msg, boolean flag) {
        if (listBook.isEmpty()) {
            System.out.println("Empty list.");
        }
        String BCode = Validation.getString("Enter Bcode: ");
        Node<Book> curr = listBook.getHead();
        while (curr != null) {
            if (curr.getData().getBcode().equalsIgnoreCase(BCode)) {
                if (flag) {
                    System.out.println(msg);
                    System.out.println(curr.data.toString());
                }
                return curr;
            }
            curr = curr.getNext();
        }
        System.out.println("Not found.");
        return null;
    }

    public void deleteByCode(MyLinkedList<Book> listBook) {
        if (listBook.isEmpty()) {
            return;
        }
        String Bcode = Validation.getString("Enter book ID: ");
        Node<Book> curr = listBook.getHead();
        Node<Book> previ = null;
        if(curr.data.getBcode().equals(Bcode)) {
            listBook.setHead(curr.next);
            return;
        }
        while (curr != null) {
            if (curr.getData().getBcode().equalsIgnoreCase(Bcode)) {
                break;
            }
            previ = curr;
            curr = curr.next;
        }
        if(curr == null) {
            System.err.println("Not found");
            return;
        }
        previ.next = curr.next;
        if (listBook.getTail() == curr) {
            listBook.setTail(previ);
        }
    }

    public void sortByCode(MyLinkedList<Book> listBook) {
        if (listBook.isEmpty()) {
            System.err.println("Empty list.");
            return;
        }
        for (Node<Book> i = listBook.getHead(); i != null; i = i.next) {
            Node<Book> min = i;
            for (Node<Book> j = i.next; j != null; j = j.next) {
                if (min.getData().getBcode().compareToIgnoreCase(j.getData().getBcode()) > 0) {
                    min = j;
                }
            }
            Book temp = min.getData();
            min.setData(i.getData());
            i.setData(temp);
        }
    }

    public void inputAndAddToBegin(MyLinkedList<Book> listBook) {
        Validation valid = new Validation();
        String bcode = Validation.getInputBookID("Enter bcode: ", listBook);
        String title = Validation.getString("Enter title: ");
        int quantity = Validation.getPostiveInt("Enter quantity: ");
        int lending = Validation.getIntLimit("Enter lending: ", 0, quantity);
        double price = Validation.getPrice("Enter price: ");
        listBook.addFirst(new Book(bcode, title, quantity, lending, price));
    }

    public void addAfterPositionK(MyLinkedList<Book> listBook) {
        int index = Validation.getIntLimit("Enter position: ", 0, listBook.getSize() - 1);
        Validation valid = new Validation();
        String bcode = Validation.getInputBookID("Enter bcode: ", listBook);
        String title = Validation.getString("Enter title: ");
        int quantity = Validation.getPostiveInt("Enter quantity: ");
        int lending = Validation.getIntLimit("Enter lending: ", 0, quantity);
        double price = Validation.getPrice("Enter price: ");

        Node<Book> newNode = new Node<>(new Book(bcode, title, quantity, lending, price));
        Node<Book> curr = listBook.getHead();
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        listBook.setSize(listBook.getSize() + 1);
    }

    public void deletePos(MyLinkedList<Book> listBook) {
        int index = Validation.getIntLimit("Enter postition: ", 0, listBook.getSize() - 1);
        listBook.removeAtIndex(index);
    }

}
