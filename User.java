import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class User
{
    private String username;

    User(String uName)
    {
	username = uName;
    }

    User(User userInfo)
    {
	this.username = userInfo.username;
    }

    public String getUsername()
    {
	return username;
    }

    public boolean login(String password)
    {
	try
	    {
		// Read login info/OIT records
		File filePath = new File("LoginInfo.txt");
		Scanner fileRead = new Scanner(filePath);
		
		while(fileRead.hasNextLine())
		    {
			String userPass[] = (fileRead.nextLine()).split(",");
			if(userPass.length == 2)
			    {
				if(userPass[0].equals(username))
				    {
					if(userPass[1].equals(password))
					    return true;
					else
					    return false;
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
	
	return false;
    }

    public boolean isHSO()
    {
	// Will contact A&R to see if user is the HSO

	// Was thinking that the A&R "database" file will list username data by comma in order
	// So after the username, I was thinking that we could have a value of 0 or 1
	// where 1 means user is a student and 0 means user is the HSO

        try
	    {
		// Read AR records
		File filePath = new File("ARInfo.txt");
		Scanner fileRead = new Scanner(filePath);

		while(fileRead.hasNextLine())
		    {
			String userRecord[] = (fileRead.nextLine()).split(",");
			if(userRecord.length >= 2)
			    {
				if(userRecord[0].equals(username))
				    {
				        if(Integer.parseInt(userRecord[1]) == 0)
					    return true;
					else
					    return false;					
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
	
	return false;
    }

    public boolean isEC()
    {
    // Will have an isEC() method that will call a method from the ECList class (which will read
    // and store EC usernames) that will pass the username and return a response if the name
    // is contained in the ECList

	ECList tempList = new ECList();

	if(tempList.hasUser(username))
	    return true;

	return false;
    }
}
