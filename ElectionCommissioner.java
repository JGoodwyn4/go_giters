
public class ElectionCommissioner extends Student
{
    ElectionCommissioner(String username,String password)
    {
	super(username,password);
    }

    ElectionCommissioner(User userInfo)
    {
	super(userInfo);
    }

    public Election createElection(int sDay, int sMonth, int sYear, int sHour, int sMinute,
				   int eDay, int eMonth, int eYear, int eHour, int eMinute)
    {
	
    }

    public Ballot createBallot()
    {

    }

    
}
