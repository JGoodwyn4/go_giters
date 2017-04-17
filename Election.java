import java.util.ArrayList;


public class Election
{
    private String electionName;
    
    // We may want to create a class that holds all the start/end values. Maybe a Date class
    private int startDay, startMonth, startYear, startHour, startMinute, startSec;
    private int endDay, endMonth, endYear, endHour, endMinute, endSec;
    private String usernameEC;
    private int electionID;

    private Vote voteRecords;
    private ArrayList<Ballot> ballotList;


    // Constructor
    Election(String name, int sDay, int sMonth, int sYear, int sHour, int sMin, int sSec,
	     int eDay, int eMonth, int eYear, int eHour, int eMin, int eSec, String ECUser, int id)
    {
        electionName = name;
	
	startDay = sDay;
	startMonth = sMonth;
	startYear = sYear;
	startHour = sHour;
	startMinute = sMin;
	startSec = sSec;
	
	endDay = eDay;
	endMonth = eMonth;
	endYear = eYear;
	endHour = eHour;
	endMinute = eMin;
	endSec = eSec;

	usernameEC = ECUser;
	electionID = id;

	voteRecords = new Vote();
	ballotList = new ArrayList<Ballot>();
    }

    public String getName() { return electionName; }
    public void setName(String newName) { electionName = newName; }

    public boolean isActive()
    {
	// Return a boolean if election has started and not ended
	return (hasStarted() && (!hasEnded()));
    }

    private boolean hasStarted()
    {
	// Return a boolean if date/time is equal to or past start
    }

    public void setStart(int sDay, int sMonth, int sYear, int sHour, int sMin, int sSec)
    {
	startDay = sDay;
	startMonth = sMonth;
	startYear = sYear;
	startHour = sHour;
	startMinute = sMin;
	startSec = sSec;
    }

    public int getStartDay() { return startDay; }
    public int getStartMonth() { return startMonth; }
    public int getStartYear() { return startYear; }
    public int getStartHour() { return startHour; }
    public int getStartMinute() { return startMinute; }
    public int getStartSecond() { return startSecond; }

    public boolean hasEnded()
    {
	// Return a boolean if date/time is equal to or past end
    }

    public void setEnd(int eDay, int eMonth, int eYear, int eHour, int eMin, int eSec)
    {
	endDay = eDay;
	endMonth = eMonth;
	endYear = eYear;
	endHour = eHour;
	endMinute = eMin;
	endSec = eSec;
    }

    public int getEndDay() { return endDay; }
    public int getEndMonth() { return endMonth; }
    public int getEndYear() { return endYear; }
    public int getEndHour() { return endHour; }
    public int getEndMinute() { return endMinute; }
    public int getEndSecond() { return endSecond; }

    public void addBallot()
    {
	ballotList.add(new Ballot());
    }

    // Returns a ballot given it's specific ID
    public Ballot getBallot(int ballotID)
    {
	Ballot result = null;
	
	boolean found = false;
        for(int i = 0; found != true && i < ballotList.size(), i++)
	    {
		if((ballotList.get(i)).getBallotID() == ballotID)
		    {
			result = ballot;
			found = true;
		    }
	    }

	return result;
    }

    // Returns a corresponding ballot ID if user doesn't violate constraints.
    // If violated, will return a -1
    // Can be used to see if a user is eligable for any ballot in an election and get it's ID at the same time
    public int getValidBallotID(String college, String major, String rank, boolean registered, boolean undergrad)
    {
	int result = -1;

	if(!isActive())
	    return result;	    
	
	boolean found = false;
	for(int i = 0; found != true && i < ballotList.size(), i++)
	    {
		Ballot temp = ballotList.get(i);
		if(temp.isValid(college,major,rank,undergrad,registered))
		    {
			result = temp.getBallotID();
			found = true;
		    }
	    }

	return result;
    }

    public Vote getVote()
    {
	return voteRecords;
    }

}
