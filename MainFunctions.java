
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainFunctions {
    private Resources bookService;
    private Resources eBookService;
    private Resources journalService;
    private Resources dissertationService;

    public MainFunctions(Resources bookService, Ebook eBookService, Journal journalService, Dissertation dissertationService) {
        this.bookService = bookService;
        this.journalService = journalService;
        this.eBookService = eBookService;
        this.dissertationService = dissertationService;
    }

    static Scanner scanner = new Scanner(System.in);

    public void mainRunner() {

        addingAndPrintingTheResources();

        while (true) {

            welcomeMessage();

            int firstOperation = scanner.nextInt();

            if (firstOperation == 1) {
                register();
            }
            if (firstOperation == 2) {
                printTheRegistered();
            }
            if (firstOperation == 3) {
                Borrow();
            }
            if (firstOperation == 4) {
                for (int i = 0; i < Borrowers.BorrowersArray.length; i++) {
                    System.out.println(Borrowers.BorrowersArray[i]);
                }
            }
            if (firstOperation == 5) {
                LocalDate today = LocalDate.now();
                LocalDate returnDateOfbookStudent = Date.returnDate("book", "student");
                boolean isAfter = today.isAfter(returnDateOfbookStudent);

                if (isAfter == false) {
                    System.out.println("Enter name");
                    String Name = scanner.next();

                    System.out.println("Enter id");
                    String id = scanner.next();

                    System.out.println("Enter the resource title or name");
                    String resourceName = scanner.next();

                    Fine.eraseStudent();
                    System.out.println(
                            "Dear: " + Name + " " + id + "the Amount that you have to pay for returning the book"
                                    + resourceName + "is" + Fine.getStudentFine() + "$");
                }
            }
            if (firstOperation == 6) {
                break;
            }
        }
    }

    public static void welcomeMessage() {
        System.out.println("*****************************************************");
        System.out.println("Welcome to the library System");
        System.out.println("please enter a number coresponding to your need:");
        System.out.println("register: 1");
        System.out.println("Borrowed List: 2");
        System.out.println("Borrow: 3");
        System.out.println("List Of The Borrowers: 4");
        System.out.println("Return A Book: 5");
        System.out.println("exit: 6");
        System.out.println("*****************************************************");
    }

    public static void register() {
        System.out.println("please enter a number coresponding to your need:");
        System.out.println("register a student: 1");
        System.out.println("register a staffMember: 2");
        System.out.println("Register a Faculty: 3");
        System.out.println("exit: 4");

        int operation = scanner.nextInt();
        System.out.println("Enter first name");
        String firstName = scanner.next();

        System.out.println("Enter last name");
        String lastName = scanner.next();

        System.out.println("Enter id");
        String id = scanner.next();

        System.out.println("Enter department");
        String department = scanner.next();

        System.out.println("Enter the day joined AUIS");
        String day = scanner.next();

        System.out.println("Enter the month you joined AUIS ");
        String month = scanner.next();

        System.out.println("Enter the year you joined AUIS");
        String year = scanner.next();

        Date dateOfAuis = new Date(day, month, year);

        if (operation == 1) {
            Student s = new Student();
            Agent agent = new Agent(s);
            // The Domain Specific language
            s.sId(id).sFirstName(firstName).sLastName(lastName).sDepartment(department).sDateOfJoin(dateOfAuis);
            agent.createSnapshot();
            s.add(s);

            List<StudentSnapshot> snapshot = agent.getSnapshot();
            agent.undo(snapshot.get(0));
            System.out.println(s);
        }
        if (operation == 2) {
            borrower staffMember = new StaffMember();
            // The Domain Specific language
            staffMember.sId(id).sFirstName(firstName).sLastName(lastName).sDepartment(department)
                    .sDateOfJoin(dateOfAuis);
            staffMember.add(staffMember);

        }
        if (operation == 3) {
            borrower faculty = new Faculty();
            // The Domain Specific language
            faculty.sId(id).sFirstName(firstName).sLastName(lastName).sDepartment(department).sDateOfJoin(dateOfAuis);
            faculty.add(faculty);

        }
    }

    public static void printTheRegistered() {
        System.out.println("please enter a number coresponding to your need:");
        System.out.println("List of Students: 1");
        System.out.println("List of staffMembers: 2");
        System.out.println("List of Faculty: 3");
        System.out.println("exit: 4");
        int operation = scanner.nextInt();

        if (operation == 1) {
            for (int i = 0; i < Student.studentsArray.length; i++) {
                System.out.print(Student.studentsArray[i]);
                System.out.println(" ");
            }
        }
        if (operation == 2) {
            for (int i = 0; i < StaffMember.staffMembersArray.length; i++) {
                System.out.print(StaffMember.staffMembersArray[i]);
                System.out.println(" ");
            }
        }
        if (operation == 3) {
            for (int i = 0; i < Faculty.facultysArray.length; i++) {
                System.out.print(Faculty.facultysArray[i]);
                System.out.println(" ");
            }
        }
    }

    public void addingAndPrintingTheResources() {
        // Dependency Injection
        // Class MainFunctions needs Class Books inorder to add the books to the books
        // array
        // in the display class we have injected the Books object into the MainFunctions
        // object as the parameter
        bookService.add("TheHungerGames", "SuzanneCollins", true);
        bookService.add("EloquentJavascript", "MarjinHaverbeke", true);
        bookService.add("1984", "GeorgeOrwell", true);
        bookService.add("TheLastBookInTheUniverse", "RodmanPhilbrick", true);
        bookService.add("AlltheBrightPlaces", "JenniferNiven", true);

        System.out.println("List of the Books Available in the AUIS");
        System.out.println(" ");
        for (int i = 0; i < Books.books.length - 1; i++) {
            System.out.println(Books.books[i].getTitle());
        }
        System.out.println(" ");

        journalService.add("Algebra&NumberTheory", " MathematicalSciencesPublishers", true);
        journalService.add("DiscreteAnalysis", "TimothyGowers", true);
        journalService.add("LinearAlgebraanditsApplicationsi", "Elsevier", true);
        journalService.add("FoundationsofPhysics", "MyronW.Evans", true);
        journalService.add("AdvancesinSpaceResearch", "Elsevier", true);

        System.out.println("List Of The Journals Available in the AUIS");
        System.out.println(" ");
        for (int i = 0; i < Journal.journalsArray.length - 1; i++) {
            System.out.println(Journal.journalsArray[i].getTitle());
        }
        System.out.println(" ");

        eBookService.add("ThingsWeNeverGotOver", " LucyScore", true);
        eBookService.add("Alice’sAdventuresinWonderland", "LewisCarroll", true);
        eBookService.add("ATaleofTwoCities", "CharlesDickens", true);
        eBookService.add("TheAdventuresofSherlockHolmes", "ArthurConanDoyle", true);
        eBookService.add("Frankenstein", "MaryShelley", true);

        System.out.println("List Of The Ebooks Available in the AUIS");
        System.out.println(" ");
        for (int i = 0; i < Ebook.ebooksArray.length - 1; i++) {
            System.out.println(Ebook.ebooksArray[i].getTitle());
        }
        System.out.println(" ");

        dissertationService.add("Research on Radioactive Substances", "Marie Curie", true);
        dissertationService.add("A New Determination of Molecular Dimensions", "Albert Einstein", true);
        dissertationService.add("On the Hypotheses Which Lie At the Basis of Geometry", "Bernhard Riemann", true);
        dissertationService.add("The Difference Between the Democritean and Epicurean Philosophy of Nature", " Karl Marx",
                true);
        dissertationService.add("Properties of Expanding Universes", "Stephen Hawking", true);

        System.out.println("List Of The Dissertations Available in the AUIS");
        System.out.println(" ");
        for (int i = 0; i < Dissertation.DissertationsArray.length - 1; i++) {
            System.out.println(Dissertation.DissertationsArray[i].getTitle());
        }
    }

    public static void Borrow() {
        System.out.println("Whose borrwing?");
        System.out.println("Student: 1");
        System.out.println("Staff: 2");
        System.out.println("Faculty: 3");

        int whoseBorrowing = scanner.nextInt();
        if (whoseBorrowing == 1) {
            System.out.print("firstName of the Student:");
            String firstNameOfStudent = scanner.next();
            System.out.println(" ");

            System.out.print("id of the Student: ");
            String idOfStudent = scanner.next();

            pickType(firstNameOfStudent, idOfStudent, "Strudent");

        }
        if (whoseBorrowing == 2) {
            System.out.print("firstName of the Staff:");
            String firstNameOfStaff = scanner.next();
            System.out.println(" ");

            System.out.print("id of the staffMember: ");
            String idOfStaff = scanner.next();

            pickType(firstNameOfStaff, idOfStaff, "Staff");

        }
        if (whoseBorrowing == 3) {
            System.out.print("firstName of the Faculty:");
            String firstNameOfFaculty = scanner.next();
            System.out.println(" ");

            System.out.print("id of the Faculty: ");
            String idOfFaculty = scanner.next();

            pickType(firstNameOfFaculty, idOfFaculty, "Faculty");
        }
    }

    public static void borrowRecource(String resource, String typeOfEducation, String Chategoryes, String nameOf,
            String idOf, int operation) {
        if (operation == 1) {
            Books.availabilityToFalse();
            Books.notifyUpdate(new Message("The book " + Chategoryes + " is not available to borrow for 30 days."));
        }
        if (operation == 2) {
            Ebook.availabilityToFalse();
        }
        if (operation == 3) {
            Journal.availabilityToFalse();
        }
        if (operation == 3) {
            Dissertation.availabilityToFalse();
        }
        // LocalDate returnDate = Date.returnDate("book", "student");
        LocalDate returnDateOfBookStudent = Date.returnDate(resource, typeOfEducation);
        System.out.println("Today is " + LocalDate.now() + " \nYou successsfulyy borowed a book: with the name "
                + resource + " ;/\n" + "you have to return the book before" + returnDateOfBookStudent);
        Borrowers.add(nameOf, idOf, returnDateOfBookStudent, Chategoryes);

        Student.limitIncreaser();
    }

    public static void pickType(String firstName, String id, String type) {
        for (int i = 0; i < Faculty.facultysArray.length - 1; i++) {
            if (firstName.equals(Student.studentsArray[i].getFirstName()) && id.equals(Student.studentsArray[i].getId())
                    && Student.getLimit() < 5) {
                System.out.println("Enter the resource to borrow:");
                System.out.println("Enter the resource to books: 1");
                System.out.println("Enter the resource to ebooks: 2");
                System.out.println("Enter the resource to journals: 3");
                System.out.println("Enter the resource to dissertaions: 4");

                int choosingResources = scanner.nextInt();
                if (choosingResources == 1) {
                    System.out.println("Enter the bookName");
                    String bookName = scanner.next();
                    borrowRecource("book", type, bookName, firstName, id, choosingResources);
                }

                if (choosingResources == 2) {
                    System.out.println("Enter the ebook");
                    String ebook = scanner.next();

                    for (int j = 0; j < Ebook.ebooksArray.length - 1; j++) {
                        if (ebook.equals(Ebook.ebooksArray[j].getTitle()) && Student.getLimit() < 5) {
                            borrowRecource("ebook", type, ebook, firstName, id, choosingResources);
                            break;
                        }
                    }
                }

                if (choosingResources == 3) {
                    System.out.println("Enter the journal");
                    String journalName = scanner.next();
                    for (int j = 0; j < Journal.journalsArray.length - 1; j++) {
                        if (journalName.equals(Journal.journalsArray[j].getTitle()) && Student.getLimit() < 5) {
                            borrowRecource("journal", type, journalName, firstName, id, choosingResources);
                            break;
                        }
                    }
                }
                if (choosingResources == 4) {
                    System.out.println("Enter the Dissertation");
                    String DissertationName = scanner.next();

                    for (int j = 0; j < Dissertation.DissertationsArray.length - 1; j++) {
                        if (DissertationName.equals(Dissertation.DissertationsArray[j].getTitle())
                                && Student.getLimit() < 5) {
                            borrowRecource("Dissertation", type, DissertationName, firstName, id, choosingResources);
                            break;
                        }

                    }
                }
                break;
            }
        }
    }
}