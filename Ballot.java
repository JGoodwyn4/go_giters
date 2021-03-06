


import java.util.ArrayList;

public class Ballot
{
    private int ballotID;
    private int electionID;
    private int Bcounter;

    
    private ArrayList<String> collegeCons;
    private ArrayList<String> majorCons;
    private ArrayList<String> classCons;
    private boolean undergradCon;
    private boolean regCon;
    
    private ArrayList<Race> raceList;

    public Ballot(int eID, int bID)
    {
	electionID = eID;
	ballotID = bID;
	raceList = new ArrayList<Race>();
        Bcounter = 0;
    }

    public ArrayList<String> getCollegeConstraints() { return collegeCons; }
    public ArrayList<String> getMajorConstraints() { return majorCons; }
    public ArrayList<String> getClassConstraints() { return classCons; }
    public boolean getUndergradConstraints() { return undergradCon; }
    public boolean getRegistrationConstraints() { return regCon; }
    
    public void setCollegeConstraints(ArrayList<String> newCons) { collegeCons = newCons; }
    public void setMajorConstraints(ArrayList<String> newCons) { majorCons = newCons; }
    public void setClassConstraints(ArrayList<String> newCons) { classCons = newCons; }
    public void setUndergradConstraints(boolean newCons) { undergradCon = newCons; }
    public void setRegistrationConstraints(boolean newCons) { regCon = newCons; }

    public int getBallotID() { return ballotID; }
    public boolean isBallotID(int bID) { return (ballotID == bID); }
    public int numRaces() { return raceList.size(); }
    public ArrayList<Race> getRaceList() { return raceList; }

    public boolean isValid(String college, String major, String rank, boolean undergrad, boolean registered)
    {
	return (validCollege(college) && validMajor(major) && validRank(rank) && validUndergrad(undergrad) && validRegistered(registered));
    }

    public boolean validCollege(String voterCollege)
    {
	for(String college : collegeCons)
	    if(college.equalsIgnoreCase(voterCollege))
		return true;

	return false;
    }

    public boolean validMajor(String voterMajor)
    {
	for(String major : majorCons)
	    if(major.equalsIgnoreCase(voterMajor))
		return true;

	return false;
    }

    public boolean validRank(String voterRank)
    {
	for(String rank : classCons)
	    if(rank.equalsIgnoreCase(voterRank))
		return true;

	return false;
    }

    public boolean validUndergrad(boolean undergrad)
    {
        if((undergradCon == true) && (undergrad == false))
	    return false;

	return true;
    }

    public boolean validRegistered(boolean registered)
    {
	if((regCon == true) && (registered == false))
	    return false;

	return true;
    }

    // Add in data/parameters
    public void addBinaryRace()
    {
	raceList.add(new BinaryRace(Bcounter, ballotID, electionID));
        Bcounter++;
    }

    // Add in data/parameters
    public void addNonBinaryRace()
    {
	raceList.add(new NonBinaryRace(Bcounter, ballotID, electionID));
        Bcounter++;
    }

    public void removeRace(int raceID)
    {
	boolean found = false;
	for(int i = 0; found != true && i < raceList.size(); i++)
	    {
		if(raceList.get(i).matchID(raceID))
		    {
			raceList.remove(i);
			found = true;
		    }
           
	    }
    }

    public Race getRace(int raceID)
    {
        
        for (Race r: raceList){
            if(r.matchID(raceID)){
                return r;
            }
           
        }
        
	return null; 
    }

//    private int getRaceIndex(int raceID)
//    {
//
//        
//    }
//    
   
}
