/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment01.management;

import assigment01.datastructure.MyLinkedList;
import assigment01.datastructure.Node;
import assigment01.entity.Reader;
import assigment01.fileprocess.FileProcess;
import assigment01.validation.Validation;

/**
 *
 * @author Admin
 */
public class ReaderListManager {

    public void loadData(String nameFile) {
        FileProcess fp = new FileProcess();
        fp.inputFileReader(nameFile);
    }

    public void inputAndAddToEnd(MyLinkedList<Reader> listReader) {
        Validation valid = new Validation();
        String rcode = Validation.getInputReaderID("Enter rcode: ", listReader);
        String name = Validation.getString("Enter name: ");
        int byear = Validation.getIntLimit("Enter BYear: ", 1902, 2010);
        listReader.addLast(new Reader(rcode, name, byear));
    }

    public void displayData(MyLinkedList<Reader> listReader) {
        listReader.traverse();
    }

    public Node<Reader> searchByCode(MyLinkedList<Reader> listReader, String msg, boolean flag) {
        if (listReader.isEmpty()) {
            return null;
        }
        Node<Reader> curr = listReader.getHead();
        String Rcode = Validation.getString("Enter Rcode: ");
        while (curr != null) {
            if (curr.data.getRcode().trim().equalsIgnoreCase(Rcode)) {
                if (flag) {
                    System.out.println(msg);
                    System.out.println(curr.data.toString());
                }
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public void deleteByCode(MyLinkedList<Reader> listReader) {
        if (listReader.isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        String Rcode = Validation.getString("Enter Reader code: ");
        Node<Reader> curr = listReader.getHead();
        Node<Reader> previ = null;
        while (curr != null) {
            if (curr.getData().getRcode().trim().equalsIgnoreCase(Rcode)) {
                previ.next = curr.next;
                if (listReader.getTail() == curr) {
                    listReader.setTail(curr);
                }
                return;
            }
            previ = curr;
            curr = curr.next;
        }
    }

}
