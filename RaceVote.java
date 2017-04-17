
import java.util.ArrayList;

public class RaceVote
{
    private String voterUsername;
    private int electionID;
    private int ballotID;
    private ArrayList<VoteCounter> voteChoices;

    public RaceVote(String username, int eID, int bID, ArrayList<VoteCounter> votes)
    {
	voterUsername = username;
	electionID = eID;
	ballotID = bID;
	voteChoices = votes;
    }

    public void removeVotes()
    {
	for(VoteCounter vote : choices)
	    {
		// Rename method depending on what it's called in the VoteCounter class
		vote.down();
	    }
    }

    public boolean isUsername(String username)
    {
	if(voterUsername.equalsIgnoreCase(username))
	    return true;

	return false;
    }
}
