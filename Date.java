import java.time.LocalDate;

public class Date {

    private String day;
    private String month;
    private String year;

    public Date(String day, String month, String year) {

        this.day = day;
        this.month = month;
        this.year = year;

    }

    public Date() {

    }

    public String toString() {
        return String.format("%s %s %s", day, month, year);
    }

    public static LocalDate returnDate(String resource, String borrower) {
        LocalDate currentDate = LocalDate.now();

        if (borrower == "student") {

            if (resource == "book") {

                LocalDate dateOfReturnStudents = currentDate.plusDays(30);
                return dateOfReturnStudents;
            } else if (resource == "ebook") {
                currentDate = LocalDate.now();
                LocalDate dateOfReturnStudents = currentDate.plusDays(60);
                return dateOfReturnStudents;
            }

            else if (resource == "journal") {
                currentDate = LocalDate.now();
                LocalDate dateOfReturnStudents = currentDate.plusDays(14);
                return dateOfReturnStudents;
            }

            else if (resource == "dissertation") {
                currentDate = LocalDate.now();
                LocalDate dateOfReturnStudents = currentDate.plusDays(10);
                return dateOfReturnStudents;
            }
            return currentDate;

        } else if (borrower == "faculty" || borrower == "staff") {
            currentDate = LocalDate.now();
            LocalDate dateOfReturnStudents = currentDate.plusDays(60);
            return dateOfReturnStudents;
        }
        return currentDate;
    }
}
