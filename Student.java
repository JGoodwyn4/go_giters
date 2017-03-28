
public class Student extends User
{
    // Either have a separate class to hold all of student info or have a variable for each
    private String college;
    private String classRank;
    private boolean registered;

    Student(String username, String password)
    {
	super(username,password);

	// Call on method that goes to A&R and saves appropriate student info
	storeStudentInfo();
    }
    
    Student(User userInfo)
    {
	super(userInfo);

	// Call on method that goes to A&R and saves appropriate student info
	storeStudentInfo();
    }

    public String getCollege()
    {
	return college;
    }

    public String getClassRank()
    {
	return classRank;
    }

    public boolean isRegistered()
    {
	return registered;
    }

    private void storeStudentInfo()
    {
	// Call to A&R to obtain student info
	// Send this.getUsername() to A&R
	// Appropriately store returned info in correct variables
    }
}
