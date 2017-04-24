import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class CertifyGUI extends JFrame implements ActionListener
{
    // Attributes
    private Election election;

    CertifyGUI(Election input)
    {
        election = input;
	
        setTitle("Certify Election");
	JPanel main = new JPanel();

	BoxLayout layout = new BoxLayout(main,BoxLayout.Y_AXIS);
	//GridLayout layout = new GridLayout(0,1);
        main.setLayout(layout);

	// Add Components

	// ELECTION INFO
	JLabel electionName = new JLabel("Election: " + election.getName());
	main.add(electionName);
	JLabel ecUser = new JLabel("Election Commissioner: " + election.getECUser());
	

	// BALLOT INFO
	//ArrayList<Ballot> ballot = election.getBallotList();

	//Since we're only worried about creating one ballot per election, we just get the first one
	//Ballot mainBallot = ballot.get(0);
	Ballot mainBallot = election.getBallot();


	// RACE INFO
	for(Race race : mainBallot.getRaceList())
	    {
		JPanel racePanel = new JPanel();
		
		JLabel raceName = new JLabel(race.getRaceName());
		racePanel.add(raceName);

		// OPTION INFO FOR A BINARY RACE
		if(race instanceof BinaryRace)
		    {
			BinaryRace temp = (BinaryRace) race; // Re-cast race into appropriate type

			ArrayList<String> winner = temp.getWinners(); // Get winners of race

			// Add the name and vote count for both options in the race
			JPanel result1 = new JPanel();
			String option1 = temp.get_op1();
			result1.add(new JLabel(option1));
			resilt1.add(new JLabel(" - Vote Count: " + temp.get_vc1().getCount()));

			JPanel result2 = new JPanel();
			String option2 = temp.get_op2();
			result2.add(new JLabel(option1));
			result2.add(new JLabel(" - Vote Count: " + temp.get_vc2().getCount()));

			
			// Look at winners and set each respective winner to a unique design
			for(String win : winner)
			    {
				if(win.equalsIgnoreCase(option1)){}
				    // Set background of result1 panel to the "winner" color
				else{}
				    // Set background of result2 panel to the "winner" color	    
			    }

			racePanel.add(result1);
			racePanel.add(result2);
			
		    }
		// CANDIDATE INFO FOR A NONBINARYRACE
		else if(race instanceof NonBinaryRace)
		    {
			NonBinaryRace temp = (NonBinaryRace) race; // Re-case race into appropriate type
			ArrayList<Candidate> orderedList = temp.orderedWinners();
			int maxWin = temp.getNumWinners();

			for(int i = 0; i < orderedList.size(); i++)
			    {
				Candidates can = orderedList.get(i);
				
				JPanel candHolder = new JPanel();

				JLabel name = new JLabel(can.getName());
				candHolder.add(name);

				if(!can.getParty.equals(""))
				    {
					JLabel party = new JLabel(" - Party: " + can.getParty());
					candHolder.add(party);
				    }

				JLabel count = new JLabel(" - Vote Count: " + can.getCounter().getCount());
				candHolder.add(count);

				if(i < maxWin){}
				    // Set candHolder panel to the specific "winner" color/design

				racePanel.add(candHolder);
			    }
		    }
		else
		    {
			JLabel error = new JLabel("Something went wrong");
			racePanel.add(error);
		    }

		main.add(racePanel);
	    }


	// DEMOGRAPHIC INFO
	Vote record = election.getVote();
	JLabel demo = new JLabel("Demographics:");
	main.add(demo);

	// TOTAL VOTE INTO
	JLabel total = new JLabel("Total Voters: " + record.getNumVotes());
	main.add(total);

	// COLLEGE DEMO INFO
	JPanel collegePanel = new JPanel();

	JLabel collegeText = new JLabel("College Info");
	collegePanel.add(collegeText);

	int[] collegeCount = record.getCollegeCount();

	for(int i = 0; i < collegeCount.length(); i++)
	    {
		if(collegeCount[i] != 0)
		    {
			// Each switch case matches the same switch structure in the Vote class
			switch(i)
			    {
			    case 0:
				JLabel college = new JLabel("Engineering");
				JLabel collegeCount = new JLabel(" - Count: " + collegeCount[i]);

				collegePanel.add(college);
				collegePanel.add(collegeCount);
				break;
				
			    case 1:
				JLabel college = new JLabel("Not Engineering");
				JLabel collegeCount = new JLabel(" - Count: " + collegeCount[i]);

				collegePanel.add(college);
				collegePanel.add(collegeCount);
				break;
				
			    case (collegeCount.length()-1):
				JLabel college = new JLabel("Unrecognized College");
				JLabel collegeCount = new JLabel(" - Count: " + collegeCount[i]);

				collegePanel.add(college);
				collegePanel.add(collegeCount);
				break;
			    }
		    }
	    }
	main.add(collegePanel);

	// MAJOR DEMO INFO



	// CLASS RANK DEMO INO


	
	// UNDERGRAD DEMO INFO



	// REGISTERED STUDENT DEMO INFO



	// SECTION CONTAINING THE "Formally Accept Results" PROMPT AND THE "Yes", "No", AND "Cancel" BUTTONS
	

        setSize(400,350);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(display);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) /2 );
        int y = (int) ((dimension.getHeight() - getHeight()) /2);
        setLocation(x, y);
        setVisible(true);
	
    }

    public void actionPerformed(ActionEvent e)
    {
	if(e.getActionCommand().equals("confirm"))
	    {

	    }
	else if(e.getActionCommand().equals("reject"))
	    {

	    }
	else if(e.getActionCommand().equals("cancel"))
	    {
		this.dispose();
	    }
    }

    public static void main(String[] args)
    {
	new CertifyGUI();
    }    
    
}
