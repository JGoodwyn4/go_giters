
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author najeeullah.williams
 */
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import java.net.*;




public class ElectionListGUI extends JFrame implements ActionListener {

	

	User user = new User("mbgable");

	String name = user.getUsername();

	ElectionList electionList = new ElectionList();

	ArrayList<Election> elections = electionList.getECElections(name);

	

	private JPanel display;

	private JFrame mainFrame;

	

	ElectionListGUI(){

		

		

		

		mainFrame = new JFrame();

		setVisible(true);

		setSize(500,1000);

		add(display);

		display = new JPanel();

		display.setSize(250,500);

		display.setVisible(true);

			

		for(Election elect : elections){

			JButton button = new JButton(elect.getName());

			button.setActionCommand(elect.getName());

			display.add(button);

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

				

				panel.add(sDay);

				panel.add(sMonth);

				panel.add(sYear);

				panel.add(sHour);

				panel.add(sMin);

				panel.add(sSec);

				panel.add(eDay);

				panel.add(eMonth);

				panel.add(eYear);

				panel.add(eHour);

				panel.add(eMin);

				panel.add(eSec);

				panel.add(college[0]);

				panel.add(college[1]);

				panel.add(majors[0]);

				panel.add(majors[1]);

				panel.add(majors[2]);

				panel.add(majors[3]);

				panel.add(majors[4]);

				panel.add(rank[0]);

				panel.add(rank[1]);

				panel.add(rank[2]);

				panel.add(rank[3]);

				

				Ballot ballot = election.getBallot();

				ArrayList<Race> races = ballot.getRaceList();

				

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
                                getContentPane().add(panel);

						

				

			//	String name, int sDay, int sMonth, int sYear, int sHour, int sMin, int sSec,

			 //    int eDay, int eMonth, int eYear, int eHour, int eMin, int eSec, String ECUser, int id

				

				//instanceOf binary or nonbinary race

				

				

			}

			

			@Override

			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub

				

			}

			

		}	

	}







	@Override

	public void actionPerformed(ActionEvent e) {

		

		ElectionList elect = new ElectionList();

		int id = Integer.parseInt(e.getActionCommand());

		Election election = elect.getElection(elections, id);

		

		

		}

		
public static void main(String[] args)
    {
	new ElectionListGUI();
    }
	}
