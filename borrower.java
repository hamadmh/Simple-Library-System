
interface borrower {// The Domain Specific Language Functions are in this class
     
    public borrower add(borrower member);

    // ID
    public String getId();

    public void setId(String id);

    public borrower sId(String id);// The Domain Specific Language Function

    // FIRSTNAME
    public String getFirstName();

    public void setFirstName(String name);

    public borrower sFirstName(String id);// The Domain Specific Language Function

    // LASTNAME
    public String getLastName();

    public void setLastName(String lastName);

    public borrower sLastName(String lastName);// The Domain Specific Language Function

    // DEPARTMENT
    public String getDepartment();

    public void setDepartment(String department);

    public borrower sDepartment(String id);// The Domain Specific Language Function

    public borrower sDateOfJoin(Date dateOfAuis);

    // these are related to the observer pattern
    public void update(Message m);
}
