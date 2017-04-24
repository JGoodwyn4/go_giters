
public class Candidates {

	private int choiceID;
	private String name;
	private String party;
	private VoteCounter vc;
	
	
	public Candidates(int choiceID, String name, String party){
		this.choiceID = choiceID;
		this.name = name;
		this.party = party;
		VoteCounter vc = new VoteCounter();
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
		if(this.choiceID == id) return true;
		return false;
	}
	
}
