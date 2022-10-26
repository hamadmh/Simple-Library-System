public class StaffMember implements borrower {// The Domain Specific Language Functions are in this class

    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfJoin;
    private String department;
    private static int limit;
    public static borrower[] staffMembersArray = new borrower[10];
    int index;

    public StaffMember(String id, String firstName, String lastName, String department, Date dateOfJoin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfJoin = dateOfJoin;
        this.department = department;
    }

    public StaffMember() {
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

    public borrower sDateOfJoin(Date dateOfJoin) {// The Domain Specific Language Function
        this.dateOfJoin = dateOfJoin;
        return this;
    }

    public static int getLimit() {
        return limit;
    }

    public static void limitIncreaser() {
        StaffMember.limit++;
    }

    public String toString() {
        return String.format("%s %s %s %s %s", id, firstName, lastName, dateOfJoin, department);
    }

    public borrower add(borrower member) {
        staffMembersArray[index++] = member;
        return member;
    }

    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberOne :: " + m.getMessageContent());
    }
}
