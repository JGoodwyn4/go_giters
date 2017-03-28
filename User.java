
public class User
{
    private String username;

    User(String uName, String pWord)
    {
	username = uName;
	password = pWord;
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
	if(true)
	    return true;

	return false;
    }

    public boolean isHSO()
    {
	// Will contact A&R to see if user is the HSO
	return false;
    }
}
