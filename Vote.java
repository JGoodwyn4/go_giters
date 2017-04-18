import java.util.ArrayList;

public class Vote
{
    private int electionID;
    private int[] collegeCount;    // 0 = college0, 1 = college1, ... , n = majorN, n+1 = unknown
    private int[] majorCount;      // 0 = major0, 1 = major1, ... , n = majorN, n+1 = unknown
    private int[] rankCount;       // 0 = freshman, 1 = sophomore, 2 = junior, 3 = senior, 4 = unknown
    private int[] undergradCount;  // 0 = undergrad, 1 = grad
    private int[] registeredCount; // 0 = registered, 1 = not registered
    private ArrayList<RaceVote> votes;

    public Vote(int eID)
    {
	electionID = eID;

	collegeCount = new int[3];
	majorCount = new int[6];
	rankCount = new int[5];
	undergradCount = new int[2];
	registeredCount = new int[2];

	votes = new ArrayList<RaceVote>();
    }

    public boolean hasVoted(String username)
    {
	for(RaceVote voter : votes)
	    if(voter.isUser(username))
		return true;

	return false;
    }

    public void addRaceVote(String username, int ballotID, ArrayList<int> raceIDs, ArrayList<int> choiceIDs)
    {
	votes.add(new RaceVote(username, electionID, ballotID, raceIDs, choiceIDs));
    }

    public void removeRaceVote(String username)
    {
	if(!hasVoted(username))
	    return;

	RaceVote temp = null;

	for(RaceVote voter : votes)
	    if(voter.isUser(username))
		temp = voter;

        votes.remove(temp);
    }

    public int[] getCollegeCount() { return collegeCount; }
    public int[] getMajorCount() { return majorCount; }
    public int[] getRankCount() { return rankCount; }
    public int[] getUndergradCount() { return undergradCount; }
    public int[] getRegisteredCount() { return registeredCount; }

    
    // Increment methods for each demographic
    public void addCollegeCount(String college)
    {
	int index = getCollegeIndex(college);
	collegeCount[index]++;
    }
    
    public void addMajorCount(String major)
    {
        int index = getMajorIndex(college);
	majorCount[index]++;
    }
    
    public void addRankCount(String rank)
    {
        int index = getRankIndex(college);
	rankCount[index]++;
    }
    
    public void addUndergradCount(boolean undergrad)
    {
        if(undergrad == true)
	    undergradCount[0]++;
	else
	    undergradCount[1]++;
    }
    
    public void addRegisteredCount(boolean registered)
    {
        if(registered == true)
	    registeredCount[0]++;
	else
	    registeredCount[1]++;
    }

    
    // Decrement methods for each demographic
    public void removeCollegeCount(String college)
    {
	int index = getCollegeIndex(college);
	collegeCount[index]--;
    }
    
    public void removeMajorCount(String major)
    {
        int index = getMajorIndex(college);
	majorCount[index]--;
    }
    
    public void removeRankCount(String rank)
    {
        int index = getRankIndex(college);
	rankCount[index]--;
    }
    
    public void removeUndergradCount(boolean undergrad)
    {
        if(undergrad == true)
	    undergradCount[0]--;
	else
	    undergradCount[1]--;
    }
    
    public void removeRegisteredCount(boolean registered)
    {
        if(registered == true)
	    registeredCount[0]--;
	else
	    registeredCount[1]--;
    }

    
    // Separate methods to get the correct index given a value
    private int getCollegeIndex(String college)
    {
	int index = collegeCount.length() - 1;
	
	switch(college)
	    {
	    case "college0":
		index = 0;
		break;
	    case "college1":
		index = 1;
		break;
	    default:
	        // Nothing
	    }
	
	return index;
    }

    private int getMajorIndex(String major)
    {
	int index = majorCount.length() - 1;
	
	switch(major)
	    {
	    case "major0":
		index = 0;
		break;
	    case "major1":
		index = 1;
		break;
	    case "major2":
		index = 2;
		break;
	    case "major3":
		index = 3;
		break;
	    case "major4":
		index = 4;
		break;
	    default:
	        // Nothing
	    }
	
	return index;
    }

    private int getRankIndex(String rank)
    {
	int index = 4;
	
	switch(rank)
	    {
	    case "freshman":
		index = 0;
		break;
	    case "sophomore":
		index = 1;
		break;
	    case "junior":
		index = 2;
		break;
	    case "senior":
		index = 3;
		break;
	    default:
	        // Nothing
	    }
	
	return index;
    }
}
