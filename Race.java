
public class Race {

	private String raceName;
	private int raceID;
	private int ballotID;
	private int electionID;
	
	public Race (String rName, int rID, int bID, int eID){
		
	        raceName = rName;
	        raceID = rID;
	        ballotID = bID;
	        electionID = eID;
	
		
	}
	
	public String getRaceName() { return raceName;	}	
	public void setRaceName(String rName) { raceName = rName; }	
	public boolean matchID(int rID) { return raceID == raceID; }
	
	
}
