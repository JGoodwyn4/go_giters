import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ECList
{
    HashMap<String,String> usernameList;
    File list;
    Scanner dataReader;

    public ECList()
    {
	usernameList = new HashMap<String,String>();
	
	try
	    {
		list = new File("ECNames.txt");
	    }
	catch(NullPointerException ex)
	    {
		System.out.println(ex.getMessage());
	    }
	
	readNames();
    }

    public void readNames()
    {
	try
	    {
	        dataReader = new Scanner(list);

		while(dataReader.hasNextLine())
		    {
			String name = dataReader.nextLine();

			if(!name.equals("") && !usernameList.containsKey(name))
			    {
				usernameList.put(name,name);
			    }
		    }
	    }
	catch(FileNotFoundException ex)
	    {
		System.out.println(ex.getMessage());
	    }
    }

    public void addEC(String user)
    {
	if(!usernameList.containsKey(user))
	    {
		usernameList.put(user,user);
	    }
    }

    public void removeEC(String user)
    {

    }
}
