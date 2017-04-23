import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class ECList
{
    ArrayList<String> usernameList;
    File list;
    Scanner dataReader;

    public ECList()
    {
	usernameList = new ArrayList<String>();
	
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

			if(!name.equals(""))
			    usernameList.add(name);
		    }
	    }
	catch(FileNotFoundException ex)
	    {
		System.out.println(ex.getMessage());
	    }
    }

    public void addEC(String user)
    {
	if(!hasUser(user))
	    usernameList.add(user);
    }

    public void removeEC(String user)
    {
	boolean found = false;
        for(int i = 0; found != true && i < usernameList.size(); i++)
	    {
		if(user.equalsIgnoreCase(usernameList.get(i)))
		    {
			usernameList.remove(i);
			found = true;
		    }
	    }
	
	//update();
    }

    public ArrayList<String> getList() { return usernameList; }

    public boolean hasUser(String username)
    {
        for(String ec : usernameList)
	    {
		if(ec.equalsIgnoreCase(username))
		    return true;
	    }
	
	return false;
    }

    public void update()
    {

    }
}
