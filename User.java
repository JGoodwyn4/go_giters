
public class User
{
    private String username;
    private String password;

    User(String uName, String pWord)
    {
	username = uName;
	password = pWord;
    }

    User(User userInfo)
    {
	this(userInfo.username,userInfo.password);
    }

    public String getUsername()
    {
	return username;
    }

    public boolean login()
    {
	// If statement would call to OIT for verification of username/password combo
	if(true)
	    return true;

	return false;
    }
}
