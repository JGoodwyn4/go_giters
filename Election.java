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

    public void setEnd(int sDay, int sMonth, int sYear, int sHour, int sMin, int sSec)
    {
	startDay = sDay;
	startMonth = sMonth;
	startYear = sYear;
	startHour = sHour;
	startMinute = sMin;
	startSec = sSec;
    }

    public int getEndDay() { return endDay; }
    public int getEndMonth() { return endMonth; }
    public int getEndYear() { return endYear; }
    public int getEndHour() { return endHour; }
    public int getEndMinute() { return endMinute; }
    public int getEndSecond() { return endSecond; }

    // Get and Set methods for all of the start/stop times
    // Get methods -> creation of ballot
    // Set methods -> EC management of ballot

}
