
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author najeeullah.williams
 */
public class StudentGUI extends JFrame implements ActionListener {
   
   private ArrayList<JPanel> Student_pan;
   private JPanel StudentFrame; 
    private ElectionList EL;
    private User currentUser;
    
    
    StudentGUI(ElectionList EL, User currentUser){
	this.EL = EL;
	this.currentUser = currentUser;
        
        //EL = new ElectionList();
	Student_pan = new ArrayList<JPanel>();
        ArrayList<Election> EList = EL.getECElections(currentUser.getUsername());
        
      
	setTitle("Student");
	JPanel display = new JPanel();
        
        BoxLayout layout = new BoxLayout(display,BoxLayout.PAGE_AXIS);
	display.setLayout(layout);

	// Gap used to space out each panel
        display.add(Box.createRigidArea(new Dimension(0,10)));

	JLabel info = new JLabel("Add and/or Remove Election Commissioners:");
	info.setAlignmentX(Component.CENTER_ALIGNMENT);
	display.add(info);

	// Add Space between title and panel
	display.add(Box.createRigidArea(new Dimension(0,10))); 

        StudentFrame = new JPanel();
	StudentFrame.setLayout(new BoxLayout(StudentFrame,BoxLayout.PAGE_AXIS));

	UpdateStudentEpanel();
	addStudentComponents();

	JScrollPane scrollList = new JScrollPane(StudentFrame);
	scrollList.setAlignmentX(Component.CENTER_ALIGNMENT);
	display.add(scrollList);

	// Add Space between panel and buttons
	display.add(Box.createRigidArea(new Dimension(0,10)));
        
       
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        getContentPane().add(display);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) /2 );
        int y = (int) ((dimension.getHeight() - getHeight()) /2);
        setLocation(x, y);
        setVisible(true);
        setSize(400,360);
        setResizable(false);
        
    
    }
    
       
    
     private void UpdateStudentEpanel(){
      
        Student_pan = new ArrayList<JPanel>();
        ArrayList<Election> EList = EL.getECElections(currentUser.getUsername());
        
        for(int i= 0; i < EList.size(); i++)
        {
        
        Election el = EList.get(i);
        JPanel SEtemp = new JPanel();
        
        
        JLabel lblElection_1 = new JLabel(el.getName()+"");
	lblElection_1.setBounds(10, 21, 59, 13);
	lblElection_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        SEtemp.add(lblElection_1);
       
        JButton btnVote = new JButton("VOTE");
        btnVote.setBounds(108, 17, 80, 21);
        btnVote.setFont(new Font("Times New Roman", Font.PLAIN, 11));
	SEtemp.add(btnVote);
        
        Student_pan.add(SEtemp);
        
        
        }
      
        
		
     }
    
    private void addStudentComponents()
    {
	for(JPanel SE : Student_pan)
	    {
		// Gap used to space out each panel
	        StudentFrame.add(Box.createRigidArea(new Dimension(0,5)));
		
		StudentFrame.add(SE);
		
		// Gap used to space out each panel
	        StudentFrame.add(Box.createRigidArea(new Dimension(0,5)));
	    }
    }
    
    private void updateStudentList()
    {
	StudentFrame.removeAll();
	UpdateStudentEpanel();
	addStudentComponents();
	
	StudentFrame.revalidate();
	StudentFrame.repaint();
	
    }
    
    
    /*
         public static void main(String[] args)
    {
	new StudentGUI();
    }
    */
    
    
    
    
    public void actionPerformed(ActionEvent e)
    {
	
        
	
    }
    
    
    
    
    
    
    
    
}
