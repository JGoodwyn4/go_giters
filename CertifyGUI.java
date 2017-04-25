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
        main.setLayout(new BoxLayout(main,BoxLayout.PAGE_AXIS));
	

	// Gap above first title
        main.add(Box.createRigidArea(new Dimension(0,10)));
	

	// ELECTION NAME
	JPanel ePanel = new JPanel();
	ePanel.setLayout(new BoxLayout(ePanel,BowLayout.LINE_AXIS));
	JLabel electionTag = new JLabel("<html><b>" + "Election:" + "</b></html>");
	JLabel electionName = new JLabel("<html><b>" + election.getName() + "</b></html>");
	electionTag.setFont(new Font("Serif",Font.PLAIN, 18));
	electionName.setFont(new Font("Serif",Font.PLAIN, 18));
	
	ePanel.add(Box.createRigidArea(new Dimension(5,0))); // Gap on left
	ePanel.add(electionTag);
	ePanel.add(Box.createRigidArea(new Dimension(20,0))); // Gap between tag and name
        ePanel.add(electionName);
	main.add(ePanel);

	
	// Gap between election name and EC
        main.add(Box.createRigidArea(new Dimension(0,10)));
	
	
	// ELECTION EC CREATOR
	JPanel ecPanel = new JPanel();
	ecPanel.setLayout(new BoxLayout(ecPanel,BowLayout.LINE_AXIS));
	JLabel ecTag = new JLabel("Election Commissioner:");
	JLabel ecUser = new JLabel(election.getECUser());

	ecPanel.add(Box.createRigidArea(new Dimension(20,0))); // Gap on left
	ecPanel.add(ecTag);
	ecPanel.add(Box.createRigidArea(new Dimension(15,0))); // Gap between tag and username
	ecPanel.add(ecUser);
	main.add(ecPanel);
	

	// Gap between EC and "Results" label
        main.add(Box.createRigidArea(new Dimension(0,25)));


	// "Results" LABEL
	JPanel resultPanel = new JPanel();
	resultPanel.setLayout(new BoxLayout(ePanel,BowLayout.LINE_AXIS));
	JLabel resultTag = new JLabel("<html><b><i>" + "Results:" + "</i></b></html>");
        resultTag.setFont(new Font("Serif",Font.PLAIN, 16));
	
	resultPanel.add(Box.createRigidArea(new Dimension(5,0))); // Gap on left
	resultPanel.add(resultTag);
	main.add(resultPanel);

	// BALLOT INFO
	Ballot mainBallot = election.getBallot();


	// RACE INFO
	for(Race race : mainBallot.getRaceList())
	    {
		// Gap above each race panel
	        main.add(Box.createRigidArea(new Dimension(0,15)));

		// RACE NAME
		JPanel rTag = new JPanel();
		rTag.setLayout(new BoxLayout(rTag,BowLayout.LINE_AXIS));
		JLabel raceName = new JLabel(race.getRaceName());

		rTag.add(Box.createRigidArea(new Dimension(20,0))); // Space between left and label
		rTag.add(raceName);
		main.add(rTag);


		// OPTION INFO FOR A BINARY RACE
		if(race instanceof BinaryRace)
		    {
			BinaryRace temp = (BinaryRace) race; // Re-cast race into appropriate type

			ArrayList<String> winner = temp.getWinners(); // Get winners of race

			// Add the name and vote count for both options in the race
			JPanel result1 = new JPanel();
			result1.setLayout(new BoxLayout(result1,BoxLayout.LINE_AXIS));
			String option1 = temp.get_op1();

			result1.add(Box.createRigidArea(new Dimension(30,0))); // Left Gap
			result1.add(new JLabel(option1));
			result1.add(Box.createRigidArea(new Dimension(10,0))); // Gap between labels
			resilt1.add(new JLabel("-- Vote Count: " + temp.get_vc1().getCount()));

			JPanel result2 = new JPanel();
			result2.setLayout(new BoxLayout(result2,BoxLayout.LINE_AXIS));
			String option2 = temp.get_op2();

			result2.add(Box.createRigidArea(new Dimension(30,0))); // Left Gap
			result2.add(new JLabel(option1));
			result2.add(Box.createRigidArea(new Dimension(10,0))); // Gap between labels
			result2.add(new JLabel("-- Vote Count: " + temp.get_vc2().getCount()));

			
			// Look at winners and set each respective winner to a unique design
			for(String win : winner)
			    {
				if(win.equalsIgnoreCase(option1))
				    {
					// Set background of result1 panel to the "winner" color
					result1.add(Box.createRigidArea(new Dimension(10,0)));
				        result1.add(new JLabel("<html>" + "-- " + "<b><i>" + "Winner" + "</i></b></html>"));
				        result1.setBackground(Color.decode("#FCF3CF"));
				    }
				else
				    {
					// Set background of result2 panel to the "winner" color
				        result2.add(Box.createRigidArea(new Dimension(10,0)));
				        result2.add(new JLabel("<html>" + "-- " + "<b><i>" + "Winner" + "</i></b></html>"));
				        result2.setBackground(Color.decode("#FCF3CF"));
				    }	    
			    }

			main.add(Box.createRigidArea(new Dimension(0,5))); // Space before option
		        main.add(result1);
			main.add(Box.createRigidArea(new Dimension(0,5))); // Space between options
		        main.add(result2);
			
		    }
		// CANDIDATE INFO FOR A NONBINARYRACE
		else if(race instanceof NonBinaryRace)
		    {
			NonBinaryRace temp = (NonBinaryRace) race; // Re-case race into appropriate type
			ArrayList<Candidate> orderedList = temp.orderedWinners();
			int maxWin = temp.getNumWinners();

			for(int i = 0; i < orderedList.size(); i++)
			    {
				// Gap above each candidate
				main.add(Box.createRigidArea(new Dimension(0,5)));
				
				Candidates can = orderedList.get(i);
				
				JPanel candHolder = new JPanel();
				candHolder.setLayout(new BoxLayout(candHolder,BoxLayout.LINE_AXIS));

				candHolder.add(Box.createRigidArea(new Dimension(30,0)));	
				JLabel name = new JLabel(can.getName());
				candHolder.add(name);

				if(!can.getParty.equals(""))
				    {
					candHolder.add(Box.createRigidArea(new Dimension(10,0)));
					JLabel party = new JLabel("-- Party: " + can.getParty());
					candHolder.add(party);
				    }

				candHolder.add(Box.createRigidArea(new Dimension(10,0)));
				JLabel count = new JLabel("-- Vote Count: " + can.getCounter().getCount());
				candHolder.add(count);

				if(i < maxWin)
				    {
					// Set candHolder panel to the specific "winner" color/design
					candHolder.add(Box.createRigidArea(new Dimension(10,0)));
					candHolder.add(new JLabel("<html>" + "-- " + "<b><i>" + "Winner" + "</i></b></html>"));
					candHolder.setBackground(Color.decode("#FCF3CF"));
				    }

			        main.add(candHolder);
			    }
		    }
		/*
		else
		    {
			JLabel error = new JLabel("Something went wrong");
			racePanel.add(error);
		    }
		*/
	    }

	// Gap between race information and start of demographics section
	main.add(Box.createRigidArea(new Dimension(0,25)));
	

	// DEMOGRAPHIC INFO
	Vote record = election.getVote();
	
        JPanel demoPanel = new JPanel();
	demoPanel.setLayout(new BoxLayout(ePanel,BowLayout.LINE_AXIS));
	JLabel demo = new JLabel("<html><b><i>" + "Demographics:" + "</i></b></html>");
        demo.setFont(new Font("Serif",Font.PLAIN, 16));
	
	demoPanel.add(Box.createRigidArea(new Dimension(5,0))); // Left Gap
	demoPanel.add(demo);
	main.add(demoPanel);


	// Gap between the demographics label and the "total voter" label
	main.add(Box.createRigidArea(new Dimension(0,10)));
	

	// TOTAL VOTE INTO
	JPanel totalPanel = new JPanel();
	totalPanel.setLayout(new BoxLayout(totalPanel,BoxLayout.LINE_AXIS));
	JLabel total = new JLabel("Total Voters: " + record.getNumVotes());

	totalPanel.add(Box.createRigidArea(new Dimension(20,0))); // Left Gap
	totalPanel.add(total);
	main.add(totalPanel);


	// Gap between total votes and college demographic panel
	main.add(Box.createRigidArea(new Dimension(0,15)));
	

	// COLLEGE INFO
	JPanel collTagPanel = new JPanel();
	collTagPanel.setLayout(new BoxLayout(collTagPanel,BoxLayout.LINE_AXIS));
	JLabel collegeText = new JLabel("College Info:");

	collTagPanel.add(Box.createRigidArea(new Dimension(20,0))); // Left Gap
	collTagPanel.add(collegeText);
	main.add(collTagPanel);
	
	// Get each college and add them as a horizontal panel
	int[] collegeCount = record.getCollegeCount();
	for(int i = 0; i < collegeCount.length(); i++)
	    {
		if(collegeCount[i] != 0)
		    {
			// Gap above each college
			main.add(Box.createRigidArea(new Dimension(0,5)));
			
			
			JPanel cPanel = new JPanel();
			cPanel.setLayout(new BoxLayout(cPanel,BoxLayout.LINE_AXIS));
		        cPanel.add(Box.createRigidArea(new Dimension(30,0))); // Left Gap
			
			// Each switch case matches the same switch structure in the Vote class
			switch(i)
			    {
			    case 0:
				JLabel college = new JLabel("Engineering");
				JLabel collegeCount = new JLabel("-- Count: " + collegeCount[i]);

				cPanel.add(college);
				cPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				cPanel.add(collegeCount);
				break;
				
			    case 1:
				JLabel college = new JLabel("Not Engineering");
				JLabel collegeCount = new JLabel("-- Count: " + collegeCount[i]);

				cPanel.add(college);
				cPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				cPanel.add(collegeCount);
				break;
				
			    default:
				JLabel college = new JLabel("Unrecognized");
				JLabel collegeCount = new JLabel("-- Count: " + collegeCount[i]);

				cPanel.add(college);
				cPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				cPanel.add(collegeCount);
				break;
			    }

			main.add(cPanel);
		    }
	    }

	// MAJOR DEMO INFO



	// CLASS RANK DEMO INO


	
	// UNDERGRAD DEMO INFO



	// REGISTERED STUDENT DEMO INFO



	// SECTION CONTAINING THE "Formally Accept Results" PROMPT AND THE "Yes", "No", AND "Cancel" BUTTONS
	

        setSize(500,400);
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
