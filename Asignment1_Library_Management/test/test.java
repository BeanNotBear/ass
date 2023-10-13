
import assigment01.datastructure.MyLinkedList;
import assigment01.datastructure.Node;
import assigment01.entity.Book;
import assigment01.gui.Menu;
import assigment01.validation.Validation;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nghin
 */
public class test {
    public static void main(String[] args) {
        MyLinkedList<Book> temp = new MyLinkedList<>();
        Book book = new Book("B01", "IT1", 10, 2, 3);
        temp.addFirst(book);
        Validation.getInputBookID("Enter book ID: ", temp);
    }
}
