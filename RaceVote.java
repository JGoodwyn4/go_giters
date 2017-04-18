
import java.util.ArrayList;

public class RaceVote
{
    private String voterUsername;
    private int electionID;
    private int ballotID;
    private ArrayList<int> raceIDs;
    private ArrayList<int> choiceIDs;

    public RaceVote(String username, int eID, int bID, ArrayList<int> rIDs, ArrayList<int> cIDs)
    {
	voterUsername = username;
	electionID = eID;
	ballotID = bID;
	voteChoices = votes;
	raceIDs = rIDs;
	choiceIDs = cIDs;
    }

    public boolean isUser(String username)
    {
	if(voterUsername.equalsIgnoreCase(username))
	    return true;

	return false;
    }

    public int getBallotID() { return ballotID; }
    public ArrayList<int> getRaceID() { return raceIDs; }
    public ArrayList<int> getChoiceID() { return choiceIDs; }
}
