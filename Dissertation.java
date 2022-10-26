
public class Dissertation implements Resources{

    private String title;
    private String author;
    private static boolean available;
    static Dissertation[] DissertationsArray = new Dissertation[6];
    private int index;

    Dissertation(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        Dissertation.available = available;
    }

    Dissertation() {

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

    public void availabilityToTrue() {
        available = true;
    }

    public static void availabilityToFalse() {
        available = false;
    }

    public Dissertation add(String title, String author, boolean available) {
        Dissertation book1 = new Dissertation(title, author, available);
        DissertationsArray[index++] = book1;
        return book1;
    }

    @Override
    public void attach(borrower o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void detach(borrower o) {
        // TODO Auto-generated method stub
        
    }

}
