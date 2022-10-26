import java.util.ArrayList;
import java.util.List;

public class Student implements borrower {// The Domain Specific Language Functions are in this class
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfJoin;
    private String department;
    private static int index;
    private static int limit;

    public static borrower[] studentsArray = new Student[10];
  
    public Student(Student st) {

    }

    public Student() {
    }

    // ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public borrower sId(String id) {// The Domain Specific Language Function
        this.id = id;
        return this;
    }

    // FIRSTNAME
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public borrower sFirstName(String firstName) {// The Domain Specific Language Function
        this.firstName = firstName;
        return this;
    }

    // LASTNAME
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public borrower sLastName(String lastName) {// The Domain Specific Language Function
        this.lastName = lastName;
        return this;
    }

    // DEPARTMENT
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public borrower sDepartment(String department) {// The Domain Specific Language Function
        this.department = department;
        return this;
    }

    // Date of Join
    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public borrower sDateOfJoin(Date dateOfJoin) {// The Domain Specific Language Function
        this.dateOfJoin = dateOfJoin;
        return this;
    }

    // Limit
    public static int getLimit() {
        return limit;
    }

    public static void limitIncreaser() {
        Student.limit++;
    }

    public String toString() {
        return String.format("%s %s %s %s %s", id, firstName, lastName, dateOfJoin, department);
    }

    public borrower add(borrower member) {
        studentsArray[index++] = member;
        return member;
    }

    ////////////////////////////////////////////////////////////////////////
    // Snapshot Functions
    public StudentSnapshot create() {
        return new StudentSnapshot(this.id, this.firstName, this.lastName, this.dateOfJoin, this.department);
    }

    public void restore(StudentSnapshot snapshot) {
        this.id = snapshot.getId();
        this.firstName = snapshot.getFirstName();
        this.lastName = snapshot.getLastName();
        this.dateOfJoin = snapshot.getDateOfJoin();
        this.department = snapshot.getDepartment();
    }

    public void update() {
        System.out.println("New Student registered.");
        
    }
    @Override
    public void update(Message m) {
        // TODO Auto-generated method stub
        
    }
}

// Snapshot Class
class StudentSnapshot {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Date dateOfJoin;
    private final String department;

    public StudentSnapshot(String id, String firstName, String lastName, Date dateOfJoin, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfJoin = dateOfJoin;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "StudentSnapshot {\n" +
                "\tId: " + id + "\n" +
                "\tFirst Name: " + firstName + "\n" +
                "\tLast Name: " + lastName + "\n" +
                "\tDepartment: " + department + "\n" +
                "\tDate of Join: " + dateOfJoin + "\n" +
                '}';
    }
}

class Agent {
    private List<StudentSnapshot> snapshot = new ArrayList<>();
    private Student originator;

    public Agent(Student originator) {
        this.originator = originator;
    }

    public void setPrice(String id) {
        this.originator.setId(id);
    }

    public void setFirstName(String firstName) {
        this.originator.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        this.originator.setLastName(lastName);
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.originator.sDateOfJoin(dateOfJoin);
    }

    public void setDepartment(String department) {
        this.originator.setDepartment(department);
    }

    public StudentSnapshot createSnapshot() {
        System.out.println("Creating snapshot...");
        StudentSnapshot snapshot = this.originator.create();
        this.snapshot.add(snapshot);
        return snapshot;
    }

    public List<StudentSnapshot> getSnapshot() {
        System.out.println("Retrieving snapshot...");
        return this.snapshot;
    }

    public void undo(StudentSnapshot snapshot) {
        System.out.println("Restoring snapshot...");
        this.originator.restore(snapshot);
    }
    
}
