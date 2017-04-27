

import java.util.ArrayList;


public class Election
{
    private String electionName;
    
    // Might want to use a Date class or something similar for the dates/times
    private int startDay, startMonth, startYear, startHour, startMinute, startSec;
    private int endDay, endMonth, endYear, endHour, endMinute, endSec;
    private String usernameEC;
    private int electionID;
    private boolean isCertified;

    private Vote voteRecords;
    //private ArrayList<Ballot> ballotList;
    private Ballot mainBallot;

    

    // Constructor
    Election(){}
    Election( String ECUser, int id)
    {
        electionName = "";
	
	startDay = 0;
	startMonth = 0;
	startYear = 0;
	startHour = 0;
	startMinute = 0;
	startSec = 0;
	
	endDay = 0;
	endMonth = 0;
	endYear = 0;
	endHour = 0;
	endMinute = 0;
	endSec = 0;

	usernameEC = ECUser;
	electionID = id;
	isCertified = false;

	voteRecords = new Vote(electionID);
	//ballotList = new ArrayList<Ballot>();
	mainBallot = new Ballot(electionID,0);
    }

    public boolean isElection(int eID) { return (electionID == eID); }
    public int getElectionID() { return electionID; }
    public String getName() { return electionName; }
    public void setName(String newName) { electionName = newName; }
    public String getECUser() { return usernameEC; }
  //  public boolean isActive() { return (hasStarted() && (!hasEnded())); }
    public void setCertify() { isCertified = true; }
    public boolean isCertified() { return isCertified; }
  //  public int numBallots() { return ballotList.size(); }

    

    // Returns a ballot given it's specific ID
    public Ballot getBallot()//int ballotID)
    {
	

	return mainBallot;
    }

   

    public boolean isBallotValid(String username, String college, String major, String rank, boolean registered, boolean undergrad)
    {
	if(voteRecords.hasVoted(username))
	    return false;

	return mainBallot.isValid(college,major,rank,registered,undergrad);
    }

    // Access vote to display records
    public Vote getVote()
    {
	return voteRecords;
    }

    public void disqualify(String username)
    {
	if(!voteRecords.hasVoted(username))
	    return;

	// Get each race ID's and choice ID's from user's racevote and decrement vote counters

	// After that, remove the racevote from the vote class
    }
    public int getEndDay() { return endDay; }

    public int getEndMonth() { return endMonth; }

    public int getEndYear() { return endYear; }

    public int getEndHour() { return endHour; }

    public int getEndMinute() { return endMinute; }

    public int getEndSecond() { return endSec; }


    public int getStartDay() { return startDay; }

    public int getStartMonth() { return startMonth; }

    public int getStartYear() { return startYear; }

    public int getStartHour() { return startHour; }

    public int getStartMinute() { return startMinute; }

    public int getStartSecond() { return startSec; }
}
