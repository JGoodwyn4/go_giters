import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class electionListGUI extends JFrame implements ActionListener {
	
	User user = new User("mbgable");
	String name = user.getUsername();
	ElectionList electionList = new ElectionList();
	ArrayList<Election> elections = electionList.getECElections(name);
	
	private JPanel display;
	private JFrame mainFrame;
	
	electionListGUI(){	
			// panelName.setLayout(new BoxLayout(panelName,BoxLayout.LINE_AXIS));
			//PAGE_AXIS vertical
		display = new JPanel();
			
		for(Election elect : elections){
			JButton button = new JButton(elect.getName());
			button.setActionCommand("edit,"+elect.getElectionID());
			button.addActionListener(this);
			display.add(button);
			JButton remove = new JButton("x");
			remove.setActionCommand("remove,"+elect.getElectionID());
			remove.addActionListener(this);
			display.add(remove);
			
		}
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500,1000);
		getContentPane().add(display);
		setVisible(true);
	}
		class EditFrame extends JFrame implements ActionListener{

			
			JPanel panel;
			
			EditFrame(Election election){
				
				panel = new JPanel();
				
				JTextField sDay = new JTextField(election.getStartDay()); 
				JTextField sMonth = new JTextField(election.getStartMonth());
				JTextField sYear = new JTextField(election.getStartYear());
				JTextField sHour = new JTextField(election.getStartHour());
				JTextField sMin = new JTextField(election.getStartMinute());
				JTextField sSec = new JTextField(election.getStartSecond());
				JTextField eDay = new JTextField(election.getEndDay()); 
				JTextField eMonth = new JTextField(election.getEndMonth());
				JTextField eYear = new JTextField(election.getEndYear());
				JTextField eHour = new JTextField(election.getEndHour());
				JTextField eMin = new JTextField(election.getEndMinute());
				JTextField eSec = new JTextField(election.getEndSecond());
				
				JCheckBox[] college = new JCheckBox[2];
				college[0] = new JCheckBox("Engineering");
				college[1] = new JCheckBox("Non-Engineering");
				
				JCheckBox[] majors = new JCheckBox[5];
				majors[0] = new JCheckBox("Computer Science");
				majors[1] = new JCheckBox("Electrical Engineering");
				majors[2] = new JCheckBox("Computer Engineering");
				majors[3] = new JCheckBox("Business");
				majors[4] = new JCheckBox("Art History");
				
				JCheckBox[] rank = new JCheckBox[4];
				rank[0] = new JCheckBox("Freshman");
				rank[1] = new JCheckBox("Sophomore");
				rank[2] = new JCheckBox("Junior");
				rank[3] = new JCheckBox("Senior");
				
				JPanel sub1 = new JPanel();
				sub1.setLayout(new BoxLayout(sub1,BoxLayout.LINE_AXIS));
				JLabel startDay = new JLabel("Starting day: ");
				sub1.add(startDay);
				sub1.add(sDay);
				JLabel startMonth = new JLabel("Startming Month: ");
				sub1.add(startMonth);
				sub1.add(sMonth);
				JLabel startYear = new JLabel("Starting Year: ");
				sub1.add(startYear);
				sub1.add(sYear);
				panel.add(sub1);
				
				JPanel sub2 = new JPanel();
				sub2.setLayout(new BoxLayout(sub2,BoxLayout.LINE_AXIS));
				JLabel startHour = new JLabel("Starting Hour: ");
				sub2.add(startHour);
				sub2.add(sHour);
				JLabel startMin = new JLabel("Starting Minute: ");
				sub2.add(startMin);
				sub2.add(sMin);
				JLabel startSec = new JLabel("Starting Second: ");
				sub2.add(startSec);
				sub2.add(sSec);
				panel.add(sub2);
				
				JPanel sub3 = new JPanel();
				sub3.setLayout(new BoxLayout(sub3,BoxLayout.LINE_AXIS));
				JLabel endDay = new JLabel("End Day: ");
				sub3.add(endDay);
				sub3.add(eDay);
				JLabel endMonth = new JLabel("End Month: ");
				sub3.add(endMonth);
				sub3.add(eMonth);
				JLabel endYear = new JLabel("End Year: ");
				sub3.add(endYear);
				sub3.add(eYear);
				panel.add(sub3);
				
				JPanel sub4 = new JPanel();
				sub4.setLayout(new BoxLayout(sub4,BoxLayout.LINE_AXIS));
				JLabel endHour = new JLabel("End Hour: ");
				sub4.add(endHour);
				sub4.add(eHour);
				JLabel endMin = new JLabel("End Minute: ");
				sub4.add(endMin);
				sub4.add(eMin);
				JLabel endSec = new JLabel("End Second: ");
				sub4.add(endSec);
				sub4.add(eSec);
				panel.add(sub4);
				
				JPanel sub5 = new JPanel();
				sub5.setLayout(new BoxLayout(sub5,BoxLayout.LINE_AXIS));
				JLabel colleges = new JLabel("Colleges: ");
				sub5.add(colleges);
				sub5.add(college[0]);
				sub5.add(college[1]);
				panel.add(sub5);
				
				JPanel sub6 = new JPanel();
				sub6.setLayout(new BoxLayout(sub6,BoxLayout.LINE_AXIS));
				JLabel major = new JLabel("Majors: ");
				sub6.add(major);
				sub6.add(majors[0]);
				sub6.add(majors[1]);
				sub6.add(majors[2]);
				sub6.add(majors[3]);
				sub6.add(majors[4]);
				panel.add(sub6);
				
				JPanel sub7 = new JPanel();
				sub7.setLayout(new BoxLayout(sub7,BoxLayout.LINE_AXIS));
				JLabel ranks = new JLabel("Rank: ");
				sub7.add(ranks);
				sub7.add(rank[0]);
				sub7.add(rank[1]);
				sub7.add(rank[2]);
				sub7.add(rank[3]);
				panel.add(sub7);
				
				Ballot ballot = election.getBallot();
				ArrayList<Race> races = ballot.getAllRaces();
				
				for(Race r: races){
					JPanel p = new JPanel();
					if(r instanceof BinaryRace){
						JPanel pan = new JPanel();
						JTextField op1 = new JTextField(((BinaryRace)r).get_op1());
						JTextField op2 = new JTextField(((BinaryRace)r).get_op2());
						pan.add(op1);
						pan.add(op2);
						p.add(pan);
					}
					else{
						ArrayList<Candidates> candidates = ((NonBinaryRace)r).getCandidates();
						
						for(Candidates c: candidates){
							JPanel pan = new JPanel();
							JTextField name = new JTextField(c.getName());
							JTextField party = new JTextField(c.getParty());
							pan.add(name);
							pan.add(party);
							p.add(pan);
						}
					}
					panel.add(p);
				}
				
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}	

	@Override
	public void actionPerformed(ActionEvent e) {
		String result = e.getActionCommand();
		String[] split = result.split(",");
		int id = Integer.parseInt(split[1]);
		ElectionList elect = new ElectionList();

		
		if(split[0].equals("edit")){
			Election election = elect.getElection(elections, id);
			EditFrame edit = new EditFrame(election);
		}
		else if(split[0].equals("remove")){
			elect.removeElection(id);
		}		
		
		}
		
	}
	
	

