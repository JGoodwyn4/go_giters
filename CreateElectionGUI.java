
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CreateElectionGUI extends JFrame implements ActionListener
{
    private ElectionList electionList;
    private Election newElection;
    private Ballot newBallot;

    private JPanel raceWrap;
    private ArrayList<JPanel> racePanels;
    private ArrayList<Integer> binaryRaceID;
    //private ArrayList<int> binaryIndex;
    private ArrayList<Integer> nBinaryRaceID;
    //private ArrayList<int> nBinaryIndex;
    private ArrayList<JTextField> binaryName;
    private ArrayList<JTextArea> binaryPrompt;
    private ArrayList<JTextField> binaryOP1;
    private ArrayList<JTextField> binaryOP2;
    private ArrayList<JTextField> nBinaryName;
    private ArrayList<JTextField> nBinaryMaxWin;
    private ArrayList<JTextField> nBinaryMaxPick;
    
    private ArrayList<JPanel> candidatePanels;
    private ArrayList<JTextField> candidateName;
    private ArrayList<JTextField> candidateParty;
    private ArrayList<String> candidateIDs;

    private JTextField eNameInput;
    private ArrayList<JCheckBox> colCheck;
    private ArrayList<JCheckBox> majorCheck;
    private ArrayList<JCheckBox> rankCheck;
    private ButtonGroup undergradCheck;
    private ButtonGroup registerCheck;
    
    CreateElectionGUI(String username, ElectionList electionList)
    {
	this.electionList = electionList;
	newElection = new Election(username,electionList.getCount());
	newBallot = newElection.getBallot();
	
	racePanels = new ArrayList<JPanel>();
	
	setTitle("Create Election");
	
	JPanel display = new JPanel();
	BoxLayout layout = new BoxLayout(display,BoxLayout.PAGE_AXIS);
	display.setLayout(layout);

	
	// Gap used to space out each panel
        display.add(Box.createRigidArea(new Dimension(0,10)));

	
	JPanel eName = new JPanel();
	eName.setLayout(new BoxLayout(eName,BoxLayout.LINE_AXIS));
        JLabel eNameLabel = new JLabel("Election Name: ");
	eNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        eNameInput = new JTextField(150);
        eName.add(eNameLabel);
	eName.add(eNameInput);
        eName.add(Box.createRigidArea(new Dimension(0,10))); // Add space between textfield and edge
	display.add(eName);

	
	// Add Space between title and panel
	display.add(Box.createRigidArea(new Dimension(0,15))); 


	JLabel eStart = new JLabel("Election Start:");
	eStart.setAlignmentX(Component.LEFT_ALIGNMENT);
        display.add(eStart);
	// Add space below

	JPanel sDate = new JPanel();
	sDate.setLayout(new BoxLayout(sDate,BoxLayout.LINE_AXIS));
	JLabel sMonth = new JLabel("Month: ");
	JLabel sDay = new JLabel("Day: ");
	JLabel sYear = new JLabel("Year: ");
        sMonth.setAlignmentX(Component.LEFT_ALIGNMENT);
        sDay.setAlignmentX(Component.LEFT_ALIGNMENT);
        sYear.setAlignmentX(Component.LEFT_ALIGNMENT);
	JTextField sMonthInput = new JTextField(2);
	JTextField sDayInput = new JTextField(2);
	JTextField sYearInput = new JTextField(4);

	//Glue
        sDate.add(sMonth);
	sDate.add(sMonthInput);
	//Gap
	sDate.add(sDay);
	sDate.add(sDayInput);
	//Gap
	sDate.add(sYear);
	sDate.add(sYearInput);
	//Glue
	display.add(sDate);

	// Space between date and time inputs
	display.add(Box.createRigidArea(new Dimension(0,5)));

	JPanel sTime = new JPanel();
	sTime.setLayout(new BoxLayout(sTime,BoxLayout.LINE_AXIS));
	JLabel sHour = new JLabel("Hour: ");
	JLabel sMinute = new JLabel("Minute: ");
        sHour.setAlignmentX(Component.LEFT_ALIGNMENT);
        sMinute.setAlignmentX(Component.LEFT_ALIGNMENT);
	JTextField sHourInput = new JTextField(2);
	JTextField sMinuteInput = new JTextField(2);

	//Glue
        sTime.add(sHour);
	sTime.add(sHourInput);
	//Gap
	sTime.add(sMinute);
	sTime.add(sMinuteInput);
	//Glue
	display.add(sTime);

	
	// Space between start time panels and end time panels
	display.add(Box.createRigidArea(new Dimension(0,10)));


	JLabel eEnd = new JLabel("Election End:");
	eEnd.setAlignmentX(Component.LEFT_ALIGNMENT);
        display.add(eEnd);
	// Add space below

	JPanel eDate = new JPanel();
	eDate.setLayout(new BoxLayout(eDate,BoxLayout.LINE_AXIS));
	JLabel eMonth = new JLabel("Month: ");
	JLabel eDay = new JLabel("Day: ");
	JLabel eYear = new JLabel("Year: ");
        eMonth.setAlignmentX(Component.LEFT_ALIGNMENT);
        eDay.setAlignmentX(Component.LEFT_ALIGNMENT);
        eYear.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField eMonthInput = new JTextField(2);
	JTextField eDayInput = new JTextField(2);
	JTextField eYearInput = new JTextField(4);

	//Glue
        eDate.add(eMonth);
	eDate.add(eMonthInput);
	//Gap
	eDate.add(eDay);
	eDate.add(eDayInput);
	//Gap
	eDate.add(eYear);
	eDate.add(eYearInput);
	//Glue
	display.add(eDate);

	// Space between date and time inputs
	display.add(Box.createRigidArea(new Dimension(0,5)));

	JPanel eTime = new JPanel();
	eTime.setLayout(new BoxLayout(eTime,BoxLayout.LINE_AXIS));
	JLabel eHour = new JLabel("Hour: ");
	JLabel eMinute = new JLabel("Minute: ");
	eHour.setAlignmentX(Component.LEFT_ALIGNMENT);
	eMinute.setAlignmentX(Component.LEFT_ALIGNMENT);
	JTextField eHourInput = new JTextField(2);
	JTextField eMinuteInput = new JTextField(2);

	//Glue
	//eTime.add(Box.createHorizontalGlue());
        eTime.add(eHour);
	eTime.add(eHourInput);
	//Gap
        //eTime.add(Box.createHorizontalGlue());
	eTime.add(eMinute);
	eTime.add(eMinuteInput);
	//Glue
        //eTime.add(Box.createHorizontalGlue());
	display.add(eTime);


	// Space between end time panels and the constraint boxes
	display.add(Box.createRigidArea(new Dimension(0,15)));


        JLabel constraintInfo = new JLabel("<html>For each of the following sections, check each respective boxes for constraints that will be eligible to vote</html>");
        constraintInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
	display.add(constraintInfo);

	// Gap

	JLabel conColl = new JLabel("College Constraints:");
        conColl.setAlignmentX(Component.LEFT_ALIGNMENT);
	display.add(conColl);

	// Gap

	JCheckBox col1 = new JCheckBox("Engineering");
	col1.setActionCommand("Engineering");
	JCheckBox col2 = new JCheckBox("Not Engineering");
	col2.setActionCommand("Not Engineering");

	colCheck = new ArrayList<JCheckBox>();
	colCheck.add(col1);
	colCheck.add(col2);
	
	display.add(col1);
	display.add(col2);

	
	// Space between College constraints and major constraints
	display.add(Box.createRigidArea(new Dimension(0,10)));

	
	JLabel conMajor = new JLabel("Major Constraints:");
        conMajor.setAlignmentX(Component.LEFT_ALIGNMENT);
	display.add(conMajor);

	// Gap

	JCheckBox major1 = new JCheckBox("Computer Science");
        major1.setActionCommand("Computer Science");
	JCheckBox major2 = new JCheckBox("Electrical Engineering");
        major2.setActionCommand("Electrical Engineering");
	JCheckBox major3 = new JCheckBox("Computer Engineering");
        major2.setActionCommand("Computer Engineering");
	JCheckBox major4 = new JCheckBox("Business");
        major2.setActionCommand("Business");
	JCheckBox major5 = new JCheckBox("Art History");
        major2.setActionCommand("Art History");

        majorCheck = new ArrayList<JCheckBox>();
        majorCheck.add(major1);
        majorCheck.add(major2);
	majorCheck.add(major3);
	majorCheck.add(major4);
	majorCheck.add(major5);
	
	display.add(major1);
	display.add(major2);
	display.add(major3);
	display.add(major4);
	display.add(major5);

	
	// Space between major constraints and rank constraints
	display.add(Box.createRigidArea(new Dimension(0,10)));

	
	JLabel conRank = new JLabel("Class Rank Constraints:");
        conRank.setAlignmentX(Component.LEFT_ALIGNMENT);
	display.add(conRank);

	// Gap

	JCheckBox rank1 = new JCheckBox("Freshman");
        rank1.setActionCommand("Freshman");
	JCheckBox rank2 = new JCheckBox("Sophomore");
        rank2.setActionCommand("Sophomore");
	JCheckBox rank3 = new JCheckBox("Junior");
        rank3.setActionCommand("Junior");
	JCheckBox rank4 = new JCheckBox("Senior");
        rank4.setActionCommand("Senior");

        rankCheck = new ArrayList<JCheckBox>();
        rankCheck.add(rank1);
        rankCheck.add(rank2);
	rankCheck.add(rank3);
	rankCheck.add(rank4);
	
	display.add(rank1);
	display.add(rank2);
	display.add(rank3);
	display.add(rank4);

	
	// Space between rank constraints and the undergrad constraint
	display.add(Box.createRigidArea(new Dimension(0,10)));

	
        JLabel conUndergrad = new JLabel("Limit to undergrad students only:");
        conUndergrad.setAlignmentX(Component.LEFT_ALIGNMENT);
	display.add(conUndergrad);

	// Gap

	JRadioButton underY = new JRadioButton("Yes");
	underY.setActionCommand("true");
	JRadioButton underN = new JRadioButton("No");
	underN.setActionCommand("false");
	underN.setSelected(true);

	undergradCheck = new ButtonGroup();
	undergradCheck.add(underY);
	undergradCheck.add(underN);

	display.add(underY);
	display.add(underN);

	
	// Space between undergrad constraint and registered constraint
	display.add(Box.createRigidArea(new Dimension(0,10)));

	
	JLabel conRegister = new JLabel("Limit to registered students only:");
        conRegister.setAlignmentX(Component.LEFT_ALIGNMENT);
	display.add(conRegister);

	// Gap

	JRadioButton regY = new JRadioButton("Yes");
        regY.setActionCommand("true");
	regY.setSelected(true);
	JRadioButton regN = new JRadioButton("No");
        regN.setActionCommand("false");

        registerCheck = new ButtonGroup();
        registerCheck.add(regY);
        registerCheck.add(regN);

	display.add(regY);
	display.add(regN);

	
	// Space between registered constraint and the race panel(s)
	display.add(Box.createRigidArea(new Dimension(0,15)));

	
        raceWrap = new JPanel();
	raceWrap.setLayout(new BoxLayout(raceWrap, BoxLayout.PAGE_AXIS));

	readRacePanels();
	addRacePanels();

	display.add(raceWrap);

	// Gap
	
	JPanel addPanel = new JPanel();
	addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.LINE_AXIS));
	
	JButton addBinary = new JButton("Add Binary Race");
        addBinary.addActionListener(this);
        addBinary.setActionCommand("addBinary");
	JButton addNonBinary = new JButton("Add NonBinary Race");
        addNonBinary.addActionListener(this);
        addNonBinary.setActionCommand("addNonBinary");

	// Gap between button and wall
	addPanel.add(addBinary);
	// Glue between buttons
	addPanel.add(addNonBinary);
	// Gap between button and wall
	display.add(addPanel);

	// Space between buttons

	JButton submitElection = new JButton("Submit");
        submitElection.addActionListener(this);
        submitElection.setActionCommand("subElection");
	display.add(submitElection);

	// Space between buttons

	JButton cancelElection = new JButton("Cancel");
        cancelElection.addActionListener(this);
        cancelElection.setActionCommand("cancelElection");
	display.add(cancelElection);

	// Gap after cancel button
	display.add(Box.createRigidArea(new Dimension(0,10)));

	//JScrollPane scrollPanel = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JScrollPane scrollPanel = new JScrollPane(display);
	

        setSize(500,500);
        //setResizable(false);
	
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(scrollPanel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) /2 );
        int y = (int) ((dimension.getHeight() - getHeight()) /2);
        setLocation(x, y);
        setVisible(true);
    }

    public void readRacePanels()
    {
	racePanels = new ArrayList<JPanel>();
	candidatePanels = new ArrayList<JPanel>();
	
	binaryRaceID = new ArrayList<Integer>();
	nBinaryRaceID = new ArrayList<Integer>();

	binaryName = new ArrayList<JTextField>();
	binaryPrompt = new ArrayList<JTextArea>();
	binaryOP1 = new ArrayList<JTextField>();
	binaryOP2 = new ArrayList<JTextField>();

	nBinaryName = new ArrayList<JTextField>();
	nBinaryMaxWin = new ArrayList<JTextField>();
	nBinaryMaxPick = new ArrayList<JTextField>();

	candidateName = new ArrayList<JTextField>();
	candidateParty = new ArrayList<JTextField>();
	candidateIDs = new ArrayList<String>();
	    
	ArrayList<Race> raceList = newBallot.getRaceList();

	for(int i = 0; i < raceList.size(); i++)
	    {
		Race temp = raceList.get(i);
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.PAGE_AXIS));

		if(temp instanceof BinaryRace)
		    {
			BinaryRace tempBin = (BinaryRace)temp;
			binaryRaceID.add(tempBin.getRaceID());
			
			JPanel nPanel = new JPanel();
			nPanel.setLayout(new BoxLayout(nPanel, BoxLayout.LINE_AXIS));
			JLabel nameTag = new JLabel("Binary Race Name: ");
			JTextField nameInput = new JTextField(tempBin.getRaceName());
			binaryName.add(nameInput);

			nPanel.add(nameTag);
			nPanel.add(nameInput);
			tempPanel.add(nPanel);

			// Space between race name panel and prompt panel

			JLabel promptTag = new JLabel("Race Description/Prompt:");
			JTextArea promptInput = new JTextArea(tempBin.getPrompt());
			promptInput.setLineWrap(true);
			promptInput.setWrapStyleWord(true);
			binaryPrompt.add(promptInput);
			JScrollPane promptScroll = new JScrollPane(promptInput);

			tempPanel.add(promptTag);
			tempPanel.add(promptScroll);

			// Space between prompt and option names

			JPanel opPanel1 = new JPanel();
			opPanel1.setLayout(new BoxLayout(opPanel1, BoxLayout.LINE_AXIS));
			JLabel opTag1 = new JLabel("Option 1 Name: ");
			JTextField opInput1 = new JTextField(tempBin.get_op1());
			binaryOP1.add(opInput1);

			opPanel1.add(opTag1);
			opPanel1.add(opInput1);
			tempPanel.add(opPanel1);

			// Space between first option and second option

			JPanel opPanel2 = new JPanel();
			opPanel2.setLayout(new BoxLayout(opPanel2, BoxLayout.LINE_AXIS));
			JLabel opTag2 = new JLabel("Option 2 Name: ");
			JTextField opInput2 = new JTextField(tempBin.get_op2());
			binaryOP2.add(opInput2);

			opPanel2.add(opTag2);
			opPanel2.add(opInput2);
			tempPanel.add(opPanel2);

			// Space between second option and remove race button

			JButton remRace = new JButton("Remove Race");
			remRace.addActionListener(this);
			remRace.setActionCommand("removeRace," + tempBin.getRaceID());

			tempPanel.add(remRace);
		    }
		else if(temp instanceof NonBinaryRace)
		    {
		        NonBinaryRace tempNon = (NonBinaryRace)temp;
			nBinaryRaceID.add(tempNon.getRaceID());

			JPanel nPanel = new JPanel();
			nPanel.setLayout(new BoxLayout(nPanel, BoxLayout.LINE_AXIS));
			JLabel nameTag = new JLabel("Non-Binary Race Name: ");
			JTextField nameInput = new JTextField(tempNon.getRaceName());
			nBinaryName.add(nameInput);

			nPanel.add(nameTag);
			nPanel.add(nameInput);
			tempPanel.add(nPanel);

			// Add some space here

			JPanel maxPanel = new JPanel();
		        maxPanel.setLayout(new BoxLayout(maxPanel, BoxLayout.LINE_AXIS));
			JLabel winTag = new JLabel("Number of winners: ");
			JLabel pickTag = new JLabel("Max number voter can select: ");
			JTextField winInput = new JTextField(tempNon.getNumWinners() + "");
			JTextField pickInput = new JTextField(tempNon.getMaxChoices() + "");
			nBinaryMaxWin.add(winInput);
			nBinaryMaxPick.add(pickInput);

			maxPanel.add(winTag);
			maxPanel.add(winInput);
			maxPanel.add(pickTag);
			maxPanel.add(pickInput);
			tempPanel.add(maxPanel);

			// Space between race name panel and candidate panel

			int canPanelID = candidatePanels.size();
			
			JPanel canPanel = new JPanel();
			canPanel.setLayout(new BoxLayout(canPanel,BoxLayout.PAGE_AXIS));
			candidatePanels.add(canPanel);

			addCandidates(tempNon.getRaceID(),canPanel,canPanelID);

			tempPanel.add(canPanel);

			// Small space between candidate panel and the add candidate button

			JButton addCan = new JButton("Add a Candidate");
			addCan.addActionListener(this);
			addCan.setActionCommand("addCan," + tempNon.getRaceID() + "," + canPanelID);
			tempPanel.add(addCan);
			
			// Space between candidate button and remove race button

			JButton remRace = new JButton("Remove Race");
			remRace.addActionListener(this);
			remRace.setActionCommand("removeRace," + tempNon.getRaceID());

			tempPanel.add(remRace);
		    }

		racePanels.add(tempPanel);
	    }
    }

    private void updateRacePanels()
    {
	System.out.println("Update Called");
	raceWrap.removeAll();
	
	readRacePanels();
	addRacePanels();

	raceWrap.revalidate();
	raceWrap.repaint();
    }

    private void addRacePanels()
    {
	for(JPanel rPanelTemp : racePanels)
	    {
		System.out.println("Added Race!");
		// Gap used to space out each panel
	        raceWrap.add(Box.createRigidArea(new Dimension(0,5)));
		
	        raceWrap.add(rPanelTemp);

		// Gap used to space out each panel
	        raceWrap.add(Box.createRigidArea(new Dimension(0,5)));
	    }
    }

    /*
    private void newBinaryRace()
    {
	
    }

    private void newNonBinaryRace()
    {
	
    }
    */

    private void addCandidates(int raceID, JPanel candidatePanel, int panelIndex)
    {
	ArrayList<Candidates> canList = ((NonBinaryRace)(newBallot.getRace(raceID))).getCandidates();

	// Starts at 1 to skip the "None of the above" candidate option
	for(int i = 1; i < canList.size(); i++)
	    {
		// Add space before each candidate
		//candidatePanel.add

		Candidates temp = canList.get(i);
		
		JPanel candidate = new JPanel();
		candidate.setLayout(new BoxLayout(candidate, BoxLayout.LINE_AXIS));
		JLabel canName = new JLabel("Candidate Name: ");
		JLabel canParty = new JLabel("-- Party: ");
		JTextField canInput = new JTextField(temp.getName());
		JTextField canPartyInput = new JTextField(temp.getParty());
		JButton canRem = new JButton("X");
		canRem.addActionListener(this);
		canRem.setActionCommand("removeCan," + temp.getID() + "," + raceID + "," + panelIndex);

		candidateName.add(canInput);
		candidateParty.add(canPartyInput);
		candidateIDs.add(raceID + "," + temp.getID());

		// Gap between edge and first label
		candidate.add(canName);
		candidate.add(canInput);
		// Gap
		candidate.add(canParty);
		candidate.add(canPartyInput);
		// Larger gap between remove button
		candidate.add(canRem);
		// Gap between button and edge
		candidatePanel.add(candidate);
	    }
    }

    public void updateCandidates(int raceID, JPanel candidatePanel, int panelIndex)
    {
	candidatePanel.removeAll();
	addCandidates(raceID,candidatePanel,panelIndex);

	candidatePanel.revalidate();
	candidatePanel.repaint();
    }

    public void recordRaceText(int skipID)
    {
	boolean skipFound = false;
        // Go through all binary ID's/arraylists
	for(int i = 0; i < binaryRaceID.size(); i++)
	    {
		if(skipFound == true || binaryRaceID.get(i).intValue() != skipID)
		    {
			BinaryRace bRace = (BinaryRace)(newBallot.getRace(binaryRaceID.get(i).intValue()));
			bRace.setRaceName(binaryName.get(i).getText());
			bRace.setPrompt(binaryPrompt.get(i).getText());
			bRace.set_op1(binaryOP1.get(i).getText());
			bRace.set_op2(binaryOP2.get(i).getText());
		    }
		else
		    skipFound = true;
	    }

	// Go through all nonbinary ID's/arrayLists
	for(int i = 0; i < nBinaryRaceID.size(); i++)
	    {
		if(skipFound == true || nBinaryRaceID.get(i).intValue() != skipID)
		    {
			NonBinaryRace nbRace = (NonBinaryRace)(newBallot.getRace(nBinaryRaceID.get(i).intValue()));
			nbRace.setRaceName(nBinaryName.get(i).getText());
			nbRace.setNumWinners(Integer.parseInt(nBinaryMaxWin.get(i).getText()));
			nbRace.setMaxChoices(Integer.parseInt(nBinaryMaxPick.get(i).getText()));

			// Go to candidate update method
			recordCandidateText(skipID);
		    }
		else
		    skipFound = true;
	    }
    }

    public void recordCandidateText(int skipID)
    {
	for(int i = 0; i < candidateIDs.size(); i++)
	    {
		String[] splitCan = candidateIDs.get(i).split(",");
		int rID = Integer.parseInt(splitCan[0]);
		int cID = Integer.parseInt(splitCan[1]);

		if(rID != skipID)
		    {
			Candidates tempCan = ((NonBinaryRace)(newBallot.getRace(rID))).getCandidate(cID);

			tempCan.setName(candidateName.get(i).getText());
			tempCan.setParty(candidateParty.get(i).getText());
		    }
	    }
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
	if(command.equals("addBinary"))
	    {
	        newBallot.addBinaryRace();
		recordRaceText(-1);
		updateRacePanels();
	    }
	else if(command.equals("addNonBinary"))
	    {
	        newBallot.addNonBinaryRace();
		recordRaceText(-1);
		updateRacePanels();
	    }
	else if(command.equals("cancelElection"))
	    {
		this.dispose();
	    }
	else if(command.equals("subElection"))
	    {
		// Ask for confirmation
		// do appropriate get/set methods for all the data

		newElection.setName(eNameInput.getText());

		ArrayList<String> colCons = new ArrayList<String>();
		for(JCheckBox cCheck : colCheck)
		    {
			if(cCheck.isSelected())
			    colCons.add(cCheck.getActionCommand());
		    }

		ArrayList<String> mCons = new ArrayList<String>();
		for(JCheckBox mCheck : majorCheck)
		    {
			if(mCheck.isSelected())
			    mCons.add(mCheck.getActionCommand());
		    }

		ArrayList<String> rCons = new ArrayList<String>();
		for(JCheckBox rCheck : rankCheck)
		    {
			if(rCheck.isSelected())
			    rCons.add(rCheck.getActionCommand());
		    }

		Boolean underCons = Boolean.parseBoolean(undergradCheck.getSelection().getActionCommand());
		Boolean regisCons = Boolean.parseBoolean(registerCheck.getSelection().getActionCommand());

		newBallot.setCollegeConstraints(colCons);
		newBallot.setMajorConstraints(mCons);
		newBallot.setClassConstraints(rCons);
		newBallot.setUndergradConstraints(underCons);
		newBallot.setRegistrationConstraints(regisCons);

		recordRaceText(-1);

		electionList.addElection(newElection);
	    }
	else
	    {
	        String[] panelCommands = command.split(",");

		if(panelCommands[0].equals("removeRace"))
		    {
			int rID = Integer.parseInt(panelCommands[1]);
			recordRaceText(rID);
			
			newBallot.removeRace(rID);

			updateRacePanels();
		    }
		else if(panelCommands[0].equals("removeCan"))
		    {
			int cID = Integer.parseInt(panelCommands[1]);
			int rID = Integer.parseInt(panelCommands[2]);
			int panIndex = Integer.parseInt(panelCommands[3]);
			recordCandidateText(-1);

			((NonBinaryRace)(newBallot.getRace(rID))).removeCandidate(cID);
			updateCandidates(rID,candidatePanels.get(panIndex),panIndex);
		    }
		else if(panelCommands[0].equals("addCan"))
		    {
			int rID = Integer.parseInt(panelCommands[1]);
			int panIndex = Integer.parseInt(panelCommands[2]);

			((NonBinaryRace)(newBallot.getRace(rID))).addCandidate();
			updateCandidates(rID,candidatePanels.get(panIndex),panIndex);
		    }
	    }
    }

    /*
    public static void main(String[] args)
    {
	ElectionList temp = new ElectionList();
	new CreateElectionGUI("TestUser",temp);
    }
    */
    
}
