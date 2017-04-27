
import java.util.ArrayList;



public class ElectionList
{
    private ArrayList<Election> elections;             // List holding every election
    private int count;
    
    public ElectionList()
    {
	count =0;
        elections = new ArrayList<Election>();
	
    }

    public ElectionList(ArrayList<Election> newElections)
    {
	elections = new ArrayList<Election>(newElections);
	
    }

   
    
    public ArrayList<Election> getECElections(String name){
    	ArrayList<Election> temp = new ArrayList<Election>();
    	
    	for(Election e: elections){
    		if( name.equalsIgnoreCase(e.getECUser())) temp.add(e);
    	}
    	return temp;
    }

    public void addElection(Election newElection)
    {
	count++;
        elections.add(newElection);
    }

    /*
    public Election getElection(ArrayList<Election> elections, int id){
        for(Election e: elections){
            if(id == e.getElectionID()) return e;
        }
        return null;
    }
    */

    public Election getElection(int eID)
    {
	for(int i = 0; i < elections.size(); i++)
	    {
		if(elections.get(i).isElection(eID))
		    {
			return elections.get(i);
		    }
	    }

	return null;
    }
    
    public int getCount(){
	return count;
    }
    

    
}
