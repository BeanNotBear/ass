/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment01.fileprocess;

import assigment01.datastructure.MyLinkedList;
import assigment01.datastructure.Node;
import assigment01.entity.Book;
import assigment01.entity.Reader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Admin
 */
public class FileProcess {

    public MyLinkedList<Book> readFromFileBook(String nameFile) {
        MyLinkedList<Book> listBook = new MyLinkedList<>();
        try {
            FileReader fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split("\\s*\\|\\s*");
                String bcode = txt[1];
                String title = txt[2];
                int quantity = Integer.parseInt(txt[3]);
                int lended = Integer.parseInt(txt[4]);
                double price = Double.parseDouble(txt[5]);
                Book book = new Book(bcode, title, quantity, lended, price);
                listBook.addLast(book);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listBook;
    }

    public MyLinkedList<Reader> readFromFileReader(String nameFile) {
        MyLinkedList<Reader> listReader = new MyLinkedList<>();
        try {
            FileReader fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split("\\s*\\|\\s*");
                String rcode = txt[1];
                String name = txt[2];
                int byear = Integer.parseInt(txt[3]);
                Reader reader = new Reader(rcode, name, byear);
                listReader.addLast(reader);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listReader;
    }

    public void inputFileBook(String nameFile) {
        String[] str = {"| B03 | Morning  | 12 | 0 | 25.1 |",
            "| B01 | The noon | 10 | 0 | 5.2 |",
            "| B02 | River    |  5 | 0 | 4.3 |",
            "| B05 | Physics	|  7 | 0 | 15.4 |",
            "| B07 | Biology	| 11 | 0 | 12.2 |",
            "| B04 | Southern |  9 | 0 | 5.2 |"};
        try {
            FileWriter fw = new FileWriter(nameFile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String listStr : str) {
                bw.write(listStr);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
//        Fileprocess fp = new Fileprocess();
//        MyLinkedList<Book> list = fp.readFromFile("book.data");
//        list.traverse();
    }

    public void inputFileReader(String nameFile) {
        String[] str = {"| R03 | Hoa | 1902 |",
            "| R01 | La | 1901 |",
            "| R02 | Canh | 1903 |",
            "| R05 | Cay  | 1910 |"};
        try {
            FileWriter fw = new FileWriter(nameFile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String listStr : str) {
                bw.write(listStr);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void writeToFileBook(MyLinkedList<Book> bookList) {
        try {
            FileWriter fw = new FileWriter("book.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < bookList.getSize(); i++) {
                bw.write(bookList.get(i).toString());
                bw.newLine();
            }
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void writeAllToFileBook(MyLinkedList<Book> bookList) {
        try {
            FileWriter fw = new FileWriter("book.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            Node<Book> curr = bookList.getHead();
            while (curr != null) {
                bw.write(curr.toString());
                bw.newLine();
                curr = curr.getNext();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void writeToFileReader(MyLinkedList<Reader> readerList) {
        try {
            FileWriter fw = new FileWriter("reader.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < readerList.getSize(); i++) {
                bw.write(readerList.get(i).toString());
                bw.newLine();
            }
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void writeAllToFileReader(MyLinkedList<Reader> readerList) {
        try {
            FileWriter fw = new FileWriter("reader.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            Node<Reader> curr = readerList.getHead();
            while (curr != null) {
                bw.write(curr.toString());
                bw.newLine();
                curr = curr.getNext();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}