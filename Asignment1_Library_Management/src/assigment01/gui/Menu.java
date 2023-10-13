/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment01.gui;

import assigment01.datastructure.MyLinkedList;
import assigment01.datastructure.Node;
import assigment01.entity.Book;
import assigment01.entity.Lending;
import assigment01.entity.Reader;
import assigment01.fileprocess.FileProcess;
import assigment01.management.BookListManager;
import assigment01.management.LendingListManager;
import assigment01.management.ReaderListManager;
import assigment01.validation.Validation;

/**
 *
 * @author nghin
 */
public class Menu {

    private MyLinkedList<Book> bookList = new MyLinkedList<>();
    private MyLinkedList<Reader> readerList = new MyLinkedList<>();
    private MyLinkedList<Lending> lendingList = new MyLinkedList<>();

    public void displayMainMenu() {
        String[] options = {
            "Book list",
            "Reader list",
            "Lending list",
            "Exit"
        };
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public void displayBookListMenu() {
        String[] options = {
            "Load data from file",
            "Input & add to the end",
            "Display data",
            "Save book list to file",
            "Search by bcode",
            "Delete by bcode",
            "Sort by bcode",
            "Input & add to beginning",
            "Add after osition k",
            "Delete position k",
            "Back to main menu"
        };
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public void displayReaderListMenu() {
        String[] options = {
            "Load data from file",
            "Input & add to the end",
            "Display data",
            "Save reader list to file",
            "Search by rcode",
            "Delete by rcode",
            "Back to main menu"
        };
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public void displayLendingListMenu() {
        String[] options = {
            "Input data",
            "Display data",
            "Sort by bcode + rcode",
            "Back to main menu"
        };

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public void getChoiceBookListMenu() {
        BookListManager blm = new BookListManager();
        FileProcess fp = new FileProcess();
        MyLinkedList<Book> bookList2 = new MyLinkedList<>();
        bookList = fp.readFromFileBook("book.txt");
        boolean flag = true;
        String s = String.format("| %-5s | %-15s | %-10s | %-10s | %-10s | %-11s |", "Code", "Title", "Quantity", "Lended", "Price", "Total Price");
        while (true) {
            displayBookListMenu();
            int choice = Validation.getIntLimit("Enter your choice: ", 1, 11);
            switch (choice) {
                case 1:
                    Node<Book> curr = bookList.getHead();
                    while (curr != null) {
                        if (curr.getData().getBcode().trim().equalsIgnoreCase("B03")) {
                            flag = false;
                        }
                        curr = curr.getNext();
                    }
                    if (bookList.isEmpty()) {
                        blm.loadData("book.txt");
                        bookList = fp.readFromFileBook("book.txt");
                    } else {
                        if (flag) {
                            blm.loadData("book1.txt");
                            bookList2 = fp.readFromFileBook("book1.txt");
                            fp.writeAllToFileBook(bookList2);
                            bookList = fp.readFromFileBook("book.txt");
                        }
                    }
                    break;
                case 2:
                    blm.inputAndAddToLast(bookList);
                    break;
                case 3:
                    System.out.println(s);
                    bookList.traverse();
                    break;
                case 4:
                    fp.writeToFileBook(bookList);
                    break;
                case 5:
                    blm.searchByCode(bookList, s, true);
                    break;
                case 6:
                    blm.deleteByCode(bookList);
                    System.out.println(s);
                    bookList.traverse();
                    break;
                case 7:
                    blm.sortByCode(bookList);
                    System.out.println(s);
                    bookList.traverse();
                    break;
                case 8:
                    blm.inputAndAddToBegin(bookList);
                    System.out.println(s);
                    bookList.traverse();
                    break;
                case 9:
                    blm.addAfterPositionK(bookList);
                    System.out.println(s);
                    bookList.traverse();
                    break;
                case 10:
                    blm.deletePos(bookList);
                    break;
                case 11:
                    return;
            }
        }
    }

    public void getChoiceReaderListMenu() {
        ReaderListManager rlm = new ReaderListManager();
        FileProcess fp = new FileProcess();
        MyLinkedList<Reader> readerList2 = new MyLinkedList<>();
        readerList = fp.readFromFileReader("reader.txt");
        boolean flag = true;
        String s = String.format("| %-10s | %-15s | %-5s |", "Rcode", "Name", "Year");
        while (true) {
            displayReaderListMenu();
            int choice = Validation.getIntLimit("Enter your choice: ", 1, 7);
            switch (choice) {
                case 1:
                    Node<Reader> curr = readerList.getHead();
                    while (curr != null) {
                        if (curr.getData().getRcode().trim().equalsIgnoreCase("R03")) {
                            flag = false;
                        }
                        curr = curr.getNext();
                    }
                    if (readerList.isEmpty()) {
                        rlm.loadData("reader.txt");
                        readerList = fp.readFromFileReader("reader.txt");
                    } else {
                        if (flag) {
                            rlm.loadData("reader1.txt");
                            readerList2 = fp.readFromFileReader("reader1.txt");
                            fp.writeAllToFileReader(readerList2);
                            readerList = fp.readFromFileReader("reader.txt");
                        }
                    }
                    break;
                case 2:
                    rlm.inputAndAddToEnd(readerList);
                    break;
                case 3:
                    System.out.println(s);
                    readerList.traverse();
                    break;
                case 4:
                    fp.writeToFileReader(readerList);
                    break;
                case 5:
                    rlm.searchByCode(readerList, s, true);
                    break;
                case 6:
                    rlm.deleteByCode(readerList);
                    System.out.println(s);
                    readerList.traverse();
                    break;
                case 7:
                    return;
            }
        }
    }

    public void getChoiceLendingListMenu() {
        LendingListManager llm = new LendingListManager();
        String s = String.format("| %-10s | %-10s | %-5s |", "Bcode", "Rcode", "State");
        while (true) {
            displayLendingListMenu();
            int choice = Validation.getIntLimit("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    llm.inputData(bookList, readerList, lendingList);
                    System.out.println(s);
                    lendingList.traverse();
                    break;
                case 2:
                    System.out.println(s);
                    lendingList.traverse();
                    break;
                case 3:
                    llm.sort(lendingList);
                    System.out.println(s);
                    lendingList.traverse();
                    break;
                case 4:
                    return;
            }
        }
    }

    public void getChoiceMainMenu() {
        while (true) {
            displayMainMenu();
            int choice = Validation.getIntLimit("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    // call book list menu
                    getChoiceBookListMenu();
                    break;
                case 2:
                    // call reader list menu
                    getChoiceReaderListMenu();
                    break;
                case 3:
                    getChoiceLendingListMenu();
                    // call lending list menu
                    break;
                case 4:
                    // exit program
                    return;
            }
        }
    }
}
