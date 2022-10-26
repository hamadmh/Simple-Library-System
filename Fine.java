
public class Fine {
    private static int StudentFine;
    private static int staffMemberFine;
    private static int facultyMemberFine;

    public static int increaseStudentFine() {
        return StudentFine++;
    }

    public static int increaseStaffMemberFine() {
        return staffMemberFine++;
    }

    public static int increaseFacultyMemberFine() {
        return facultyMemberFine++;
    }

    public static void eraseStudent() {
        StudentFine = 0;
    }

    public static void eraseStaffMember() {
        staffMemberFine = 0;
    }

    public static void eraseFacultyMember() {
        facultyMemberFine = 0;
    }

    public static int getStudentFine() {
        return StudentFine;
    }

    public static int getStaffMemberFine() {
        return staffMemberFine;
    }

    public static int getFacultyMemberFine() {
        return facultyMemberFine;
    }

}
