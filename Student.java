import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Student extends User
{
    // Either have a separate class to hold all of student info or have a variable for each
    private String college;
    private String major;
    private String classRank;
    private boolean registered;
    private boolean undergrad;

    Student(String username)
    {
	super(username);

	// Call on method that goes to A&R and saves appropriate student info
	storeStudentInfo();
    }
    
    Student(User userInfo)
    {
	super(userInfo);

	// Call on method that goes to A&R and saves appropriate student info
	storeStudentInfo();
    }

    public String getCollege() { return college; }
    public String getMajor() { return major; }
    public String getClassRank() { return classRank; }
    public boolean isRegistered() { return registered; }
    public boolean isUndergrad() { return undergrad; }

    private void storeStudentInfo()
    {
	// Call to A&R to obtain student info
	// Send this.getUsername() to A&R
	// Appropriately store returned info in correct variables

	try
	    {
		// Read AR records
		File filePath = new File("ARInfo.txt");
		Scanner fileRead = new Scanner(filePath);

		boolean found = false;
		while(found == false && fileRead.hasNextLine())
		    {
			String userRecord[] = (fileRead.nextLine()).split(",");
			if(userRecord.length >= 2)
			    {
				if(userRecord[0].equals(this.getUsername()))
				    {
					college = userRecord[2];
					major = userRecord[3];
					classRank = userRecord[4];
					undergrad = Boolean.parseBoolean(userRecord[5]);
					registered = Boolean.parseBoolean(userRecord[6]);

					found = true;
				    }
			    }
		    }
	    }
	catch(NullPointerException ex)
	    {
		System.out.println(ex.getMessage());
	    }
	catch(FileNotFoundException ex)
	    {
		System.out.println(ex.getMessage());
	    }
    }
}
