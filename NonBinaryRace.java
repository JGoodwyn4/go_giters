


import java.util.ArrayList;

public class NonBinaryRace extends Race{
    
    private ArrayList<Candidates> candidates;
    private int numWinners;
    private int maxChoices;
    private int count;

    
    public NonBinaryRace(int raceID, int ballotID, int electionID) {
	super(raceID, ballotID, electionID);
	this.candidates = new ArrayList<Candidates>();
	this.numWinners = 1;
	this.maxChoices = 1;
	count = 1;

	Candidates temp = new Candidates(0,raceID,ballotID,electionID);
	temp.setName("None of the above");
	candidates.add(temp);
    }
    
    public void setNumWinners(int numWinners){
	this.numWinners = numWinners;
    }
    
    public void setMaxChoices(int maxChoices){
	this.maxChoices = maxChoices;
    }
    
    public int getNumWinners(){
	return numWinners;
    }
    
    public int getMaxChoices(){
	return maxChoices;
    }
    
    public void addCandidate(Candidates candidate){
	candidates.add(candidate);
    }

    public void addCandidate(){
	candidates.add(new Candidates(count,0,0,0));
	count++;
    }
    
    public void removeCandidate(Candidates candidate){
	if(candidates.contains(candidate)) candidates.remove(candidate);
    }

    public void removeCandidate(int id)
    {
	boolean found = false;
	for(int i = 1; found != true && i < candidates.size(); i++)
	    {
		if((candidates.get(i)).matchID(id))
		    {
			candidates.remove(i);
			found = true;
		    }
	    }
    }
    
    public int numCandidates(){
	return candidates.size();
    }
    
    public ArrayList<Candidates> getCandidates(){
        return candidates;
    }

    public Candidates getCandidate(int cID)
    {
	for(int i = 1; i < candidates.size(); i++)
	    {
		if(candidates.get(i).matchID(cID))
		    return candidates.get(i);
	    }
	return null;
    }
    
    public ArrayList<Candidates> orderedWinners()
    {
	// Copy to not alter the original
	ArrayList<Candidates> unordered = new ArrayList<Candidates>(candidates);

	// Empty list to add Candidates from highest count to lowest count
	ArrayList<Candidates> ordered = new ArrayList<Candidates>();

	// Sort from unordered to ordered
	for(int i = 0; i < candidates.size(); i++)
	    {
		int maxCount = (unordered.get(0)).getCounter().getCount();
		int index = 0;

		for(int j = 0; j < unordered.size(); j++)
		    {
			Candidates can = unordered.get(j);
			
			if(can.getCounter().getCount() > maxCount)
			    {
				maxCount = can.getCounter().getCount();
				index = j;
			    }
		    }

		ordered.add(unordered.get(index));
		unordered.remove(index);
	    }

	return ordered;
    }
    
}
