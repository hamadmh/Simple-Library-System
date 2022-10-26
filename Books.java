import java.util.ArrayList;
import java.util.List;

public class Books implements Resources {// The Undo function is here
    private static List<borrower> observers = new ArrayList<borrower>();
    private String title;
    private String author;
    private static boolean available;
    static Books[] books = new Books[6];
    private int index;

    Books(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        Books.available = available;
    }

    Books() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public static void availabilityToTrue() {
        available = true;
    }

    public static void availabilityToFalse() {
        available = false;
    }

    public Books add(String title, String author, boolean available) {
        Books book1 = new Books(title, author, available);
        books[index++] = book1;
        return book1;
    }


    public void attach(borrower o) {
        observers.add(o);
    }
 
    @Override
    public void detach(borrower o) {
        observers.remove(o);
    }
 
    public static void notifyUpdate(Message m) {
        for(borrower o: observers) {
            o.update(m);
        }
    }
     
    
 
}


 class Message 
{
    final String messageContent;
     
    public Message (String m) {
        this.messageContent = m;
    }
 
    public String getMessageContent() {
        return messageContent;
    }
}
