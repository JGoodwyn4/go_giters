


import java.util.ArrayList;

public class BinaryRace extends Race {
    
    private String op1;
    private String op2;
    private String prompt;
    private VoteCounter vc1;
    private VoteCounter vc2;
    
    public BinaryRace(int raceID, int ballotID, int electionID) {
	super(raceID, ballotID, electionID);
	this.op1 = "yes";
	this.op2 = "no";
	VoteCounter vc1 = new VoteCounter(1,raceID,ballotID,electionID);
	VoteCounter vc2 = new VoteCounter(2,raceID,ballotID,electionID);
	prompt="";
    }
    
    public void set_op1(String op1) { this.op1 = op1; }
    public void set_op2(String op2) { this.op2 = op2; }
    public String get_op1() { return op1; }
    public String get_op2() { return op2; }
    public void set_vc1(VoteCounter vc1) { this.vc1 = vc1; }
    public void set_vc2(VoteCounter vc2) { this.vc2 = vc2; }
    public VoteCounter get_vc1() { return vc1; }
    public VoteCounter get_vc2() { return vc2; }
    
    public ArrayList<String> getWinners()
    {
	ArrayList<String> winner = new ArrayList<String>();
	int count1 = vc1.getCount();
	int count2 = vc2.getCount();
	
	if(count1 > count2)
	    winner.add(op1);
	else if(count2 > count1)
	    winner.add(op2);
	else
	    {
		winner.add(op1);
		winner.add(op2);
	    }

	return winner;
    }
    
   

   public String getPrompt() {
     return prompt;
    }
    
}
