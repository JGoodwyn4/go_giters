
public class Election
{
    private Constraint constraints;
    private Demographics demo;

    // We may want to create a class that holds all the start/end values. Maybe a Date class
    private int startDay, startMonth, startYear, startHour, startSec;
    private int endDay, endMonth, endYear, endHour, endSec;
    private String usernameEC;


    // Constructor
    Election(String[] college, String[] classStatus, boolean registered,
	     int sDay, int sMonth, int sYear, int sHour, int sSec,
	     int eDay, int eMonth, int eYear, int eHour, int eSec,
	     String uEC)
    {
        constraints = new Constraint(college, classStatus, registered);
	demo = new Demographics();
	
	startDay = sDay;
	startMonth = sMonth;
	startYear = sYear;
	startHour = sHour;
	startSec = sSec;
	
	endDay = eDay;
	endMonth = eMonth;
	endYear = eYear;
	endHour = eHour;
	endSec = eSec;

	usernameEC = uEC;
    }

    public Demographics getDemographics()
    {
	return demo;
    }

    public Constraint getConstraints()
    {
	return constraints;
    }

    // Get and Set methods for all of the start/stop times
    // Get methods -> creation of ballot
    // Set methods -> EC management of ballot

}
