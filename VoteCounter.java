

public class VoteCounter
{
    private int choiceID;
    private int raceID;
    private int ballotID;
    private int electionID;

    private int count;

    public VoteCounter(int cID, int rID, int bID, int eID)
    {
	choiceID = cID:
	raceID = rID;
	ballotID = bID;
	electionID = eID;

	count = 0;
    }

    public void up() { count++; }
    public void down() { count--; }
    public int getCount() { return count; }
}
