import java.time.LocalDate;

public class Borrowers {
    private String firstName;
    private String id;
    private LocalDate returnDate;
    private String bookTitle;
    static int index;

    static Borrowers[] BorrowersArray = new Borrowers[10];
    

    public Borrowers(String firstName, String id, LocalDate returnDate, String bookTitle) {
        this.firstName = firstName;
        this.id = id;
        this.returnDate = returnDate;
        this.bookTitle = bookTitle;
    }

    public Borrowers() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String toString() {
        return String.format("FirstName: %s ID: %s ReturnDate: %s  BookTitle:%s", firstName, id, returnDate, bookTitle);
    }

    public static Borrowers add(String firstName, String id, LocalDate returnDate, String bookTitle) {
        Borrowers s = new Borrowers(firstName, id, returnDate, bookTitle);
        BorrowersArray[index++] = s;
        return s;
    }

  
}
