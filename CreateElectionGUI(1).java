
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CreateElectionGUI extends JFrame implements ActionListener
{
    private Election newElection;
    private Ballot newBallot;

    private JPanel raceWrap;
    private ArrayList<JPanel> racePanels;
  //  private ArrayList<int> raceIDRecord; // ArrayList that will hold the race ID for each race panel
    private ArrayList<JPanel> candidatePanels;
    
    private ArrayList<JCheckBox> colCheck;
    private ArrayList<JCheckBox> majorCheck;
    private ArrayList<JCheckBox> rankCheck;
    private ButtonGroup undergradCheck;
    private ButtonGroup registerCheck;
    
    CreateElectionGUI(String username, ElectionList electionList)
    {
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
	JLabel eNameLabel = new JLabel("<html><b>Election Name: </b></html>");
	JTextField eNameInput = new JTextField();
        eName.add(eNameLabel);
	eName.add(eNameInput);
	// Add space between textfield and edge
	display.add(eName);

	
	// Add Space between title and panel
	display.add(Box.createRigidArea(new Dimension(0,10))); 


	JLabel eStart = new JLabel("<html><b><i>Election Start:</i></b></html>");
        display.add(eStart);
	// Add space below

	JPanel sDate = new JPanel();
	sDate.setLayout(new BoxLayout(sDate,BoxLayout.LINE_AXIS));
	JLabel sMonth = new JLabel("<html><b>Month: </b></html>");
	JLabel sDay = new JLabel("<html><b>Day: </b></html>");
	JLabel sYear = new JLabel("<html><b>Year: </b></html>");
	JTextField sMonthInput = new JTextField();
	JTextField sDayInput = new JTextField();
	JTextField sYearInput = new JTextField();

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

	JPanel sTime = new JPanel();
	sTime.setLayout(new BoxLayout(sTime,BoxLayout.LINE_AXIS));
	JLabel sHour = new JLabel("<html><b>Hour: </b></html>");
	JLabel sMinute = new JLabel("<html><b>Minute: </b></html>");
	JTextField sHourInput = new JTextField();
	JTextField sMinuteInput = new JTextField();

	//Glue
        sTime.add(sHour);
	sTime.add(sHourInput);
	//Gap
	sTime.add(sMinute);
	sTime.add(sMinuteInput);
	//Glue
	display.add(sTime);

	
	// Space between start time panels and end time panels


	JLabel eEnd = new JLabel("<html><b><i>Election End:</i></b></html>");
        display.add(eEnd);
	// Add space below

	JPanel eDate = new JPanel();
	eDate.setLayout(new BoxLayout(eDate,BoxLayout.LINE_AXIS));
	JLabel eMonth = new JLabel("<html><b>Month: </b></html>");
	JLabel eDay = new JLabel("<html><b>Day: </b></html>");
	JLabel eYear = new JLabel("<html><b>Year: </b></html>");
	JTextField eMonthInput = new JTextField();
	JTextField eDayInput = new JTextField();
	JTextField eYearInput = new JTextField();

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

	JPanel eTime = new JPanel();
	eTime.setLayout(new BoxLayout(eTime,BoxLayout.LINE_AXIS));
	JLabel eHour = new JLabel("<html><b>Hour: </b></html>");
	JLabel eMinute = new JLabel("<html><b>Minute: </b></html>");
	JTextField eHourInput = new JTextField();
	JTextField eMinuteInput = new JTextField();

	//Glue
        eTime.add(eHour);
	eTime.add(eHourInput);
	//Gap
	eTime.add(eMinute);
	eTime.add(eMinuteInput);
	//Glue
	display.add(eTime);


	// Space between end time panels and the constraint boxes


	JLabel constraintInfo = new JLabel("<html><b><i>For each of the following sections, check each respective boxes for constraints that will be eligible to vote</i></b></html>");
	display.add(constraintInfo);

	// Gap

	JLabel conColl = new JLabel("<html><b>College Constraints:</b></html>");
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

	
	JLabel conMajor = new JLabel("<html><b>Major Constraints:</b></html>");
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

	
	JLabel conRank = new JLabel("<html><b>Class Rank Constraints:</b></html>");
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

	
        JLabel conUndergrad = new JLabel("<html><b>Limit to undergrad students only:</b></html>");
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

	
	JLabel conRegister = new JLabel("<html><b>Limit to registered students only:</b></html>");
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

	
        raceWrap = new JPanel();
	raceWrap.setLayout(new BoxLayout(raceWrap, BoxLayout.PAGE_AXIS));

	readRacePanels();
	addRacePanels();

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

	JScrollPane scrollPanel = new JScrollPane(display);
	

        setSize(500,500);
        setResizable(false);
	
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
	ArrayList<Race> raceList = newBallot.getRaceList();

	for(int i = 0; i < raceList.size(); i++)
	    {
		Race temp = raceList.get(i);
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.PAGE_AXIS));

		if(temp instanceof BinaryRace)
		    {
			BinaryRace tempBin = (BinaryRace)temp;
			
			JPanel nPanel = new JPanel();
			nPanel.setLayout(new BoxLayout(nPanel, BoxLayout.LINE_AXIS));
			JLabel nameTag = new JLabel("<html><b>Binary Race Name: </b></html>");
			JTextField nameInput = new JTextField(tempBin.getRaceName());

			nPanel.add(nameTag);
			nPanel.add(nameInput);
			tempPanel.add(nPanel);

			// Space between race name panel and prompt panel

			JLabel promptTag = new JLabel("<html><b>Race Description/Prompt:</b></html>");
			JTextArea promptInput = new JTextArea(tempBin.getPrompt());
			promptInput.setLineWrap(true);
			promptInput.setWrapStyleWord(true);
                        // asdf = new JPanel();
                        //asdf.add(promptInput);
			JScrollPane promptScroll = new JScrollPane(promptInput);

			tempPanel.add(promptTag);
			tempPanel.add(promptScroll);

			// Space between prompt and option names

			JPanel opPanel1 = new JPanel();
			opPanel1.setLayout(new BoxLayout(opPanel1, BoxLayout.LINE_AXIS));
			JLabel opTag1 = new JLabel("<html><b>Option 1 Name: </b></html>");
			JTextField opInput1 = new JTextField(tempBin.get_op1());

			opPanel1.add(opTag1);
			opPanel1.add(opInput1);
			tempPanel.add(opPanel1);

			// Space between first option and second option

			JPanel opPanel2 = new JPanel();
			opPanel2.setLayout(new BoxLayout(opPanel2, BoxLayout.LINE_AXIS));
			JLabel opTag2 = new JLabel("<html><b>Option 2 Name: </b></html>");
			JTextField opInput2 = new JTextField(tempBin.get_op2());

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
		        NonBinaryRace tempNonBin = (NonBinaryRace)temp;

			JPanel nPanel = new JPanel();
			nPanel.setLayout(new BoxLayout(nPanel, BoxLayout.LINE_AXIS));
			JLabel nameTag = new JLabel("<html><b>Binary Race Name: </b></html>");
			JTextField nameInput = new JTextField(tempNonBin.getRaceName());

			nPanel.add(nameTag);
			nPanel.add(nameInput);
			tempPanel.add(nPanel);

			// Space between race name panel and candidate panel

			int canPanelID = candidatePanels.size();
			
			JPanel canPanel = new JPanel();
			canPanel.setLayout(new BoxLayout(canPanel,BoxLayout.PAGE_AXIS));
			candidatePanels.add(canPanel);

			addCandidates(tempNonBin.getRaceID(),canPanel,canPanelID);

			// Small space between candidate panel and the add candidate button

			JButton addCan = new JButton("Add a Candidate");
			addCan.addActionListener(this);
			addCan.setActionCommand("addCan," + tempNonBin.getRaceID() + "," + canPanelID);
			tempPanel.add(addCan);
			
			// Space between candidate button and remove race button

			JButton remRace = new JButton("Remove Race");
			remRace.addActionListener(this);
			remRace.setActionCommand("removeRace," + tempNonBin.getRaceID());

			tempPanel.add(remRace);
		    }

		racePanels.add(tempPanel);
	    }
    }

    private void updateRacePanels()
    {
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
		// Gap used to space out each panel
	        raceWrap.add(Box.createRigidArea(new Dimension(0,5)));
		
	        raceWrap.add(rPanelTemp);

		// Gap used to space out each panel
	        raceWrap.add(Box.createRigidArea(new Dimension(0,5)));
	    }
    }

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
		JLabel canName = new JLabel("<html><b>Candidate Name: </b></html>");
		JLabel canParty = new JLabel("<html><b>-- Party: </b></html>");
		JTextField canInput = new JTextField(temp.getName());
		JTextField canPartyInput = new JTextField(temp.getParty());
		JButton canRem = new JButton("X");
		canRem.addActionListener(this);
		canRem.setActionCommand("removeCan," + temp.getID() + "," + raceID + "," + panelIndex);

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

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
	if(command.equals("addBinary"))
	    {
	        mainBallot.addBinaryRace();
		updateRacePanels();
	    }
	else if(command.equals("addNonbinary"))
	    {
	        mainBallot.addNonBinaryRace();
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
	    }
	else
	    {
	        String[] panelCommands = command.split(",");

		if(panelCommands[0].equals("removeRace"))
		    {
			int rID = Integer.parseInt(panelCommands[1]);
			mainBallot.removeRace(rID);

			updateRacePanels();
		    }
		else if(panelCommands[0].equals("removeCan"))
		    {
			int cID = Integer.parseInt(panelCommands[1]);
			int rID = Integer.parseInt(panelCommands[2]);
			int panIndex = Integer.parseInt(panelCommands[3]);

			((NonBinaryRace)(mainBallot.getRace(rID))).removeCandidate(cID);
			updateCandidatePanels(rID,candidatePanels.get(panIndex),panIndex);
		    }
		else if(panelCommands[0].equals("addCan"))
		    {
			int rID = Integer.parseInt(panelCommands[1]);
			int panIndex = Integer.parseInt(panelCommands[2]);

			((NonBinaryRace)(mainBallot.getRace(rID))).addCandidate();
			updateCandidatePanels(rID,candidatePanels.get(panIndex),panIndex);
		    }
	    }
    }

    
    public static void main(String[] args)
    {
	ElectionList temp = new ElectionList();
	new CreateElectionGUI("TestUser",temp);
    }
    
}
