//Mohammed Diary 
//Dyary Yasin 
public class Display {
    public static void main(String[] args) {
        // Dependency Injection
        // The Facade design pattern
        MainFunctions execute = new MainFunctions(new Books(), new Ebook(), new Journal(), new Dissertation());
        execute.mainRunner();
    }
} //The Following Comments are references to the Main Functions class
        //Domain Specific Language usage Line 122, Created in the
        // Student,Faculty,StaffMember, and Borrower classes
        // Undo function using Snapshot Line 125, Created in the Student Class.
        // Dependency Injection created in Line 179, and used in the display class
        // Observer Design pattern is in line 277, and is created in the Books class.
