import java.util.ArrayList;


public class ElectionList
{
    private ArrayList<Election> elections;             // List holding every election
    private ArrayList<Election> activeElections;       // List holding all elections open for voting
    private ArrayList<Election> uncertifiedElections;  // List holding all finished elections waiting to become certified

    public ElectionList()
    {
	elections = new ArrayList<Election>();
	activeElections = new ArrayList<Election>();
	uncertifiedElections = new ArrayList<Election>();
	
	updateActive();
	updateUncertified();
    }

    public ElectionList(ArrayList<Election> newElections)
    {
	elections = new ArrayList<election>(newElection);
	activeElections = new ArrayList<Election>();
	uncertifiedElections = new ArrayList<Election>();

	updateActive();
	updateUncertified();
    }

    public void updateActive()
    {
	
    }

    public void updateUncertified()
    {

    }

    public ArrayList<Election> getActiveElections()
    {

    }

    public ArrayList<Election> getUncertifiedElections()
    {

    }
    
    public ArrayList<Election> getECElections(String name){
    	ArrayList<Election> temp = new ArrayList<Election>();
    	
    	for(Election e: elections){
    		if(!e.hasStarted() && name.equalsIgnoreCase(e.getECUser())) temp.add(e);
    	}
    	return temp;
    }

    public void addActiveElection(Election newElection)
    {
	
    }

    public void addUncertifiedElection(Election newElection)
    {

    }
    
}
