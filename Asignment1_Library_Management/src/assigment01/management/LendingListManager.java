package assigment01.management;

import assigment01.datastructure.MyLinkedList;
import assigment01.datastructure.Node;
import assigment01.entity.Book;
import assigment01.entity.Lending;
import assigment01.entity.Reader;
import assigment01.validation.Validation;

public class LendingListManager {
    
    public void inputData(MyLinkedList<Book> listBook, MyLinkedList<Reader> listReader,
            MyLinkedList<Lending> listLending) {

        BookListManager bm = new BookListManager();
        ReaderListManager rd = new ReaderListManager();
        
        
        Node<Book> book = bm.searchByCode(listBook, "Enter Bcode: ", false);
        Node<Reader> reader = rd.searchByCode(listReader, "", false);
        int state = Validation.getIntLimit("Enter state: ", 0, 2);
        
        if (state == 1) {
            System.out.println("The reader can't lend. Please Given back.");
        } else if (book.getData().getLended() == book.getData().getQuantity()) {
            listLending.addLast(new Lending(book.getData().getBcode(), reader.data.getRcode(), 0));
        } else if (book.getData().getLended() < book.getData().getQuantity()) {
            updateListBook(listBook, book.getData().getBcode());
            listLending.addLast(new Lending(book.getData().getBcode(), reader.data.getRcode(), 1));
        }
    }

    public void updateListBook(MyLinkedList<Book> listBook, String bcode) {
        Node<Book> curr = listBook.getHead();
        while (curr != null) {
            if (curr.getData().getBcode().trim().equalsIgnoreCase(bcode)) {
                curr.getData().setLended(curr.getData().getLended() + 1);
                curr.getData().setQuantity(curr.getData().getQuantity() - 1);
            }
            curr = curr.next;
        }
    }
    
    public void sort(MyLinkedList<Lending> listLending) {
        for(Node<Lending> i = listLending.getHead(); i != null; i = i.next) {
            Node<Lending> min = i;
            for(Node<Lending> j = i.next; j != null; j = j.next) {
                boolean comparator1 = min.data.getBcode().trim().compareToIgnoreCase(j.getData().getBcode().trim()) > 0;
                boolean comparator2 = min.data.getRcode().trim().compareToIgnoreCase(j.getData().getRcode().trim()) > 0;
                if(comparator1 && comparator2) {
                    min = j;
                }
            }
            Lending temp = min.getData();
            min.setData(i.getData());
            i.setData(temp);
        }
    }
}