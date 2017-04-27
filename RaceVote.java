



import java.util.ArrayList;

public class RaceVote
{
    private String voterUsername;
    private int electionID;
    private int ballotID;
    private ArrayList<VoteCounter> VC;
    
    public RaceVote(String username, int eID, int bID, ArrayList<VoteCounter> voteCounter)
    {
	voterUsername = username;
	electionID = eID;
	ballotID = bID;
	VC = voteCounter;	
    }

    public boolean isUser(String username)
    {
	if(voterUsername.equalsIgnoreCase(username))
	    return true;

	return false;
    }

    public int getBallotID() { return ballotID; }
  

}
