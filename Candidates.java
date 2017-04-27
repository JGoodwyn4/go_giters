


public class Candidates {

    private int choiceID;
    private int raceID;
    private int ballotID;
    private int electionID;
    private String name;
    private String party;
    private VoteCounter vc;
	
	
    public Candidates(int cID,int rID,int bID,int eID){
	        choiceID = cID;
		raceID = rID;
		ballotID = bID;
		electionID = eID;
	        name = "";
	        party = "";
		VoteCounter vc = new VoteCounter(cID,rID,bID,eID);
	}
	public void get(){
            
        }
	public void setID(int choiceID){
		this.choiceID = choiceID;
	}
	
        
	public void setName(String name){
		this.name = name;
	}
	
	public void setParty(String party){
		this.party = party;
	}
	
	public void setCounter(VoteCounter vc){
		this.vc = vc;
	}
	
	public int getID(){
		return choiceID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getParty(){
		return party;
	}
	
	public VoteCounter getCounter(){
		return vc;
	}
	
	public boolean matchID(int id){
	    return choiceID == id;
	}
	
}
