
public class Ebook implements Resources {

    private String title;
    private String author;
    static boolean available;
    static Ebook[] ebooksArray = new Ebook[6];
    private int index;

    Ebook(String title, String author, boolean available) {
        Ebook.available = available;
        this.title = title;
        this.author = author;
    }

    Ebook() {

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

    public Ebook add(String title, String author, boolean available) {
        Ebook ebook1 = new Ebook(title, author, available);
        ebooksArray[index++] = ebook1;
        return ebook1;
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
