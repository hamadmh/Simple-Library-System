
public class Journal implements Resources {

    private String title;
    private String author;
    static boolean available;
    static Journal[] journalsArray = new Journal[6];
    private int index;

    Journal(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        Journal.available = available;
    }

    Journal() {

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

    public Journal add(String title, String author, boolean available) {
        Journal journal1 = new Journal(title, author, available);
        journalsArray[index++] = journal1;
        return journal1;
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
