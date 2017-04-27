


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
	ePanel.setLayout(new BoxLayout(ePanel,BoxLayout.LINE_AXIS));
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
	ecPanel.setLayout(new BoxLayout(ecPanel,BoxLayout.LINE_AXIS));
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
	resultPanel.setLayout(new BoxLayout(ePanel,BoxLayout.LINE_AXIS));
	JLabel resultTag = new JLabel("<html><b><i>" + "Results:" + "</i></b></html>");
        resultTag.setFont(new Font("Serif",Font.PLAIN, 16));
	
	resultPanel.add(Box.createRigidArea(new Dimension(5,0))); // Gap on left
	resultPanel.add(resultTag);
	main.add(resultPanel);

	// BALLOT INFO
	Ballot mainBallot = election.getBallot();
	ArrayList<Race> tempRace = mainBallot.getRaceList();

	// RACE INFO
	for(Race race : tempRace)
	    {
		// Gap above each race panel
	        main.add(Box.createRigidArea(new Dimension(0,15)));

		// RACE NAME
		JPanel rTag = new JPanel();
		rTag.setLayout(new BoxLayout(rTag,BoxLayout.LINE_AXIS));
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
			result1.add(new JLabel("-- Vote Count: " + temp.get_vc1().getCount()));

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
			ArrayList<Candidates> orderedList = temp.orderedWinners();
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

				if(!can.getParty().equals(""))
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
	    }

	// Gap between race information and start of demographics section
	main.add(Box.createRigidArea(new Dimension(0,25)));
	

	// DEMOGRAPHIC INFO
	Vote record = election.getVote();
	
        JPanel demoPanel = new JPanel();
	demoPanel.setLayout(new BoxLayout(ePanel,BoxLayout.LINE_AXIS));
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
	for(int i = 0; i < collegeCount.length; i++)
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
				JLabel colCount = new JLabel("-- Count: " + collegeCount[i]);

				cPanel.add(college);
				cPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				cPanel.add(colCount);
				break;
				
			    case 1:
				JLabel college1 = new JLabel("Not Engineering");
				JLabel colCount1 = new JLabel("-- Count: " + collegeCount[i]);

				cPanel.add(college1);
				cPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				cPanel.add(colCount1);
				break;
				
			    default:
				JLabel college2 = new JLabel("Unrecognized");
				JLabel colCount2 = new JLabel("-- Count: " + collegeCount[i]);

				cPanel.add(college2);
				cPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				cPanel.add(colCount2);
				break;
			    }

			main.add(cPanel);
		    }
	    }

	// Gap between college and major demographic panel
	main.add(Box.createRigidArea(new Dimension(0,15)));
	

	// MAJOR DEMO INFO
	JPanel majorTagPanel = new JPanel();
        majorTagPanel.setLayout(new BoxLayout(majorTagPanel,BoxLayout.LINE_AXIS));
	JLabel majorText = new JLabel("Major Info:");

        majorTagPanel.add(Box.createRigidArea(new Dimension(20,0))); // Left Gap
        majorTagPanel.add(majorText);
	main.add(majorTagPanel);
	
	// Get each major and add them as a horizontal panel
	int[] majorCount = record.getMajorCount();
	for(int i = 0; i < majorCount.length; i++)
	    {
		if(majorCount[i] != 0)
		    {
			// Gap above each major
			main.add(Box.createRigidArea(new Dimension(0,5)));
			
			
			JPanel majorPanel = new JPanel();
			majorPanel.setLayout(new BoxLayout(majorPanel,BoxLayout.LINE_AXIS));
		        majorPanel.add(Box.createRigidArea(new Dimension(30,0))); // Left Gap
			
			// Each switch case matches the same switch structure in the Vote class
			switch(i)
			    {
			    case 0:
				JLabel major = new JLabel("Computer Science");
				JLabel mCount = new JLabel("-- Count: " + collegeCount[i]);

				majorPanel.add(major);
				majorPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				majorPanel.add(mCount);
				break;
				
			    case 1:
			        JLabel major1 = new JLabel("Electrical Engineering");
				JLabel mCount1 = new JLabel("-- Count: " + collegeCount[i]);

				majorPanel.add(major1);
				majorPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				majorPanel.add(mCount1);
				break;

			    case 2:
				JLabel major2 = new JLabel("Computer Engineering");
				JLabel mCount2 = new JLabel("-- Count: " + collegeCount[i]);

				majorPanel.add(major2);
				majorPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				majorPanel.add(mCount2);
				break;

			    case 3:
				JLabel major3 = new JLabel("Business");
				JLabel mCount3 = new JLabel("-- Count: " + collegeCount[i]);

				majorPanel.add(major3);
				majorPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				majorPanel.add(mCount3);
				break;

			    case 4:
				JLabel major4 = new JLabel("Art History");
				JLabel mCount4 = new JLabel("-- Count: " + collegeCount[i]);

				majorPanel.add(major4);
				majorPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				majorPanel.add(mCount4);
				break;
				
			    default:
				JLabel major5 = new JLabel("Unrecognized");
				JLabel mCount5 = new JLabel("-- Count: " + collegeCount[i]);

				majorPanel.add(major5);
				majorPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				majorPanel.add(mCount5);
				break;
			    }

			main.add(majorPanel);
		    }
	    }

	// Gap between major and rank demographic panel
	main.add(Box.createRigidArea(new Dimension(0,15)));


	// CLASS RANK DEMO INO
	JPanel rankTagPanel = new JPanel();
        rankTagPanel.setLayout(new BoxLayout(rankTagPanel,BoxLayout.LINE_AXIS));
	JLabel rankText = new JLabel("Class Rank Info:");

        rankTagPanel.add(Box.createRigidArea(new Dimension(20,0))); // Left Gap
        rankTagPanel.add(rankText);
	main.add(rankTagPanel);
	
	// Get each rank and add them as a horizontal panel
	int[] rankCount = record.getRankCount();
	for(int i = 0; i < rankCount.length; i++)
	    {
		if(rankCount[i] != 0)
		    {
			// Gap above each rank
			main.add(Box.createRigidArea(new Dimension(0,5)));
			
			
			JPanel rankPanel = new JPanel();
			rankPanel.setLayout(new BoxLayout(rankPanel,BoxLayout.LINE_AXIS));
		        rankPanel.add(Box.createRigidArea(new Dimension(30,0))); // Left Gap
			
			// Each switch case matches the same switch structure in the Vote class
			switch(i)
			    {
			    case 0:
				JLabel rank = new JLabel("Freshman");
				JLabel rCount = new JLabel("-- Count: " + collegeCount[i]);

			        rankPanel.add(rank);
				rankPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				rankPanel.add(rCount);
				break;
				
			    case 1:
			        JLabel rank1 = new JLabel("Sophomore");
				JLabel rCount1 = new JLabel("-- Count: " + collegeCount[i]);

			        rankPanel.add(rank1);
				rankPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				rankPanel.add(rCount1);
				break;

			    case 2:
			        JLabel rank2 = new JLabel("Junior");
				JLabel rCount2 = new JLabel("-- Count: " + collegeCount[i]);

			        rankPanel.add(rank2);
				rankPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				rankPanel.add(rCount2);
				break;

			    case 3:
			        JLabel rank3 = new JLabel("Senior");
				JLabel rCount3 = new JLabel("-- Count: " + collegeCount[i]);

			        rankPanel.add(rank3);
				rankPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				rankPanel.add(rCount3);
				break;
				
			    default:
			        JLabel rank4 = new JLabel("Unrecognized");
				JLabel rCount4 = new JLabel("-- Count: " + collegeCount[i]);

			        rankPanel.add(rank4);
				rankPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
				rankPanel.add(rCount4);
				break;
			    }

			main.add(rankPanel);
		    }
	    }

	// Gap between rank and undergrad demographic panel
	main.add(Box.createRigidArea(new Dimension(0,15)));

	
	// UNDERGRAD DEMO INFO
	JPanel uTagPanel = new JPanel();
        uTagPanel.setLayout(new BoxLayout(uTagPanel,BoxLayout.LINE_AXIS));
	JLabel uText = new JLabel("Undergrad Info:");

	uTagPanel.add(Box.createRigidArea(new Dimension(20,0))); // Left Gap
	uTagPanel.add(uText);
	main.add(uTagPanel);
	
	// Get each college and add them as a horizontal panel
	int[] underCount = record.getUndergradCount();
	
	JPanel underPanel = new JPanel();
	underPanel.setLayout(new BoxLayout(underPanel,BoxLayout.LINE_AXIS));
	JLabel under = new JLabel("Undergrad");
	JLabel uCount = new JLabel("-- Count: " + underCount[0]);

	main.add(Box.createRigidArea(new Dimension(0,5)));
	underPanel.add(Box.createRigidArea(new Dimension(30,0))); // Left Gap
	underPanel.add(under);
	underPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
	underPanel.add(uCount);
	main.add(underPanel);

	JPanel gradPanel = new JPanel();
        gradPanel.setLayout(new BoxLayout(gradPanel,BoxLayout.LINE_AXIS));
	JLabel grad = new JLabel("Graduate");
	JLabel gradCount = new JLabel("-- Count: " + underCount[1]);

	main.add(Box.createRigidArea(new Dimension(0,5)));
        gradPanel.add(Box.createRigidArea(new Dimension(30,0))); // Left Gap
        gradPanel.add(grad);
        gradPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
        gradPanel.add(gradCount);
	main.add(gradPanel);


	// Gap between undergrad and registration demographic panel
	main.add(Box.createRigidArea(new Dimension(0,15)));


	// REGISTERED STUDENT DEMO INFO
        JPanel rTagPanel = new JPanel();
        rTagPanel.setLayout(new BoxLayout(rTagPanel,BoxLayout.LINE_AXIS));
	JLabel rText = new JLabel("Registration Info:");

	rTagPanel.add(Box.createRigidArea(new Dimension(20,0))); // Left Gap
	rTagPanel.add(rText);
	main.add(rTagPanel);
	
	// Get each college and add them as a horizontal panel
	int[] regCount = record.getRegisteredCount();
	
	JPanel regisPanel = new JPanel();
        regisPanel.setLayout(new BoxLayout(regisPanel,BoxLayout.LINE_AXIS));
	JLabel regis = new JLabel("Registered");
	JLabel regisCount = new JLabel("-- Count: " + regCount[0]);

	main.add(Box.createRigidArea(new Dimension(0,5)));
        regisPanel.add(Box.createRigidArea(new Dimension(30,0))); // Left Gap
        regisPanel.add(regis);
        regisPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
        regisPanel.add(regisCount);
	main.add(regisPanel);

	JPanel unregisPanel = new JPanel();
        unregisPanel.setLayout(new BoxLayout(unregisPanel,BoxLayout.LINE_AXIS));
	JLabel unregis = new JLabel("Unregistered");
	JLabel unregisCount = new JLabel("-- Count: " + regCount[1]);

	main.add(Box.createRigidArea(new Dimension(0,5)));
        unregisPanel.add(Box.createRigidArea(new Dimension(30,0))); // Left Gap
        unregisPanel.add(unregis);
        unregisPanel.add(Box.createRigidArea(new Dimension(10,0))); // Gap between both labels
        unregisPanel.add(unregisCount);
	main.add(unregisPanel);


	// Gap between registration demographic panel and the HSO prompt
	main.add(Box.createRigidArea(new Dimension(0,15)));
	

	// SECTION CONTAINING THE "Formally Accept Results" PROMPT AND THE "Yes", "No", AND "Cancel" BUTTONS

	JLabel prompt = new JLabel("<html>Do you formally accept (certify) or reject this elections results and demographics?</html>");
	main.add(prompt);

	// Gap between prompt and buttons
	main.add(Box.createRigidArea(new Dimension(0,10)));

	JPanel ynPanel = new JPanel();
	ynPanel.setLayout(new BoxLayout(ynPanel,BoxLayout.LINE_AXIS));
	
	JButton yButt = new JButton("Yes");
	yButt.addActionListener(this);
	yButt.setActionCommand("confirm");
	
	JButton nButt = new JButton("No");
	nButt.addActionListener(this);
	nButt.setActionCommand("reject");

	ynPanel.add(Box.createRigidArea(new Dimension(100,0)));
	ynPanel.add(yButt);
	ynPanel.add(Box.createHorizontalGlue());
	ynPanel.add(nButt);
	ynPanel.add(Box.createRigidArea(new Dimension(100,0)));
	main.add(ynPanel);

	// Gap between yes/no buttons and cancel buttons
	main.add(Box.createRigidArea(new Dimension(0,5)));

	JPanel canPanel = new JPanel();
	canPanel.setLayout(new BoxLayout(canPanel,BoxLayout.LINE_AXIS));
	
	JButton cButt = new JButton("Cancel");
	cButt.addActionListener(this);
	cButt.setActionCommand("cancel");

	canPanel.add(Box.createHorizontalGlue());
	canPanel.add(cButt);
	canPanel.add(Box.createHorizontalGlue());
	main.add(canPanel);

	// Gap after last button
	main.add(Box.createRigidArea(new Dimension(0,10)));

	JScrollPane scrollList = new JScrollPane(main);
	scrollList.setAlignmentX(Component.CENTER_ALIGNMENT);
        
	

        setSize(500,400);
	setResizable(false);
	
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(scrollList);
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
		JOptionPane.showMessageDialog(null,"Results have been officially confirmed","Confirmation",JOptionPane.PLAIN_MESSAGE);
	    }
	else if(e.getActionCommand().equals("reject"))
	    {
		JOptionPane.showMessageDialog(null,"Results have been rejected and the corresponding EC has been notified","Rejection",JOptionPane.ERROR_MESSAGE);
	    }
	else if(e.getActionCommand().equals("cancel"))
	    {
		this.dispose();
	    }
    }

   
}
