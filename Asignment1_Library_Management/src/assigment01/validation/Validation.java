/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment01.validation;

import assigment01.datastructure.MyLinkedList;
import assigment01.datastructure.Node;
import assigment01.entity.Book;
import assigment01.entity.Reader;
import java.util.Scanner;

/**
 *
 * @author nghin
 */
public class Validation {

    private final static Scanner sc = new Scanner(System.in);

    public static int getInputInteger(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer");
            }
        }
    }

    public static double getInputDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double price = Double.parseDouble(sc.nextLine());
                return price;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
            }
        }

    }

    public static String getString(String msg) {
        String result;
        while (true) {

            System.out.print(msg);
            result = sc.nextLine();
            if (!result.trim().isEmpty()) {
                break;
            } else {
                System.err.println("String must not emty");
            }

        }
        return result;
    }

    public static int getIntLimit(String msg, int min, int max) {
        while (true) {
            int result = getInputInteger(msg);
            if (result >= min && result <= max) {
                return result;
            } else {
                System.err.println("Must be input in range[" + min + ", " + max + "]");
            }
        }
    }

    public static int getPostiveInt(String msg) {
        while (true) {
            int result = getInputInteger(msg);
            if (result < 0) {
                System.err.println("Must be input postive Integer");
            } else {
                return result;
            }
        }

    }

    public static double getPrice(String msg) {
        while (true) {
            double result = getInputDouble(msg);
            if (result > 0) {
                return result;
            } else {
                System.err.println("Must be input postive Number");
            }
        }
    }

    public static String getInputBookID(String msg, MyLinkedList<Book> list) {
        while (true) {
            String result = getString(msg);
            if (!checkBookIDExist(list, result)) {
                return result;
            } else {
                System.err.println("ID was existed");
            }
        }
    }

    private static boolean checkBookIDExist(MyLinkedList<Book> list, String id) {
        Node<Book> curr = list.getHead();
        while (curr != null) {            
            if(curr.getData().getBcode().equalsIgnoreCase(id)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static String getInputReaderID(String msg, MyLinkedList<Reader> list) {
        while (true) {
            String result = getString(msg);
            if (checkReaderExist(list, result)) {
                return result;
            } else {
                System.err.println("ID was existed");
            }
        }
    }

    private static boolean checkReaderExist(MyLinkedList<Reader> list, String id) {
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).getData().getRcode().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean getInputDecision(String msg, String d1, String d2) {
        while (true) {            
            String result = getString(msg);
            if(result.equalsIgnoreCase(d1)) {
                // yes
                return true;
            } else if(result.equalsIgnoreCase(d2)) {
                // no
                return false;
            } else {
                System.err.println("Must be input (" + d1 + "/" + d2 + ")");
            }
        }
    }

}
