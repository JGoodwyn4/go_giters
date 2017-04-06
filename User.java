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
	// If statement would call to OIT for verification of username/password combo
	try
	    {
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
	return false;
    }
}
