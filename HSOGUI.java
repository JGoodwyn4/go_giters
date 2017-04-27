/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author najeeullah.williams
 */
public class HSOGUI extends JFrame implements ActionListener {
 

   private ArrayList<JPanel> HSO_pan;
   private JPanel HSOFRAME; 
   private ElectionList EL;
   private User currentUser;
    
    
    HSOGUI(){
    
        setTitle("Head Of Student Orgs");
	JPanel display = new JPanel();
         JToolBar toolBar = new JToolBar();
	toolBar.setBounds(10, 11, 500, 26);
	display.add(toolBar);	
		
	JMenuItem ManageEC = new JMenuItem("Manage EC");
        ManageEC.setActionCommand("ManageEC");
	ManageEC.addActionListener(this);
	ManageEC.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	toolBar.add(ManageEC);
		
	JMenuItem mntmLogout = new JMenuItem("Logout");
        mntmLogout.setActionCommand("logout");
        mntmLogout.addActionListener(this);
	mntmLogout.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	toolBar.add(mntmLogout);
		
        

        
        EL = new ElectionList();
	HSO_pan = new ArrayList<JPanel>();
        ArrayList<Election> EList = EL.getECElections(currentUser.getUsername());
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) /2 );
        int y = (int) ((dimension.getHeight() - getHeight()) /2);
        setLocation(x, y);
        setVisible(true);
        setSize(400,360);
        setResizable(false);
        getContentPane().add(display);
        
        BoxLayout layout = new BoxLayout(display,BoxLayout.PAGE_AXIS);
	display.setLayout(layout);

	// Gap used to space out each panel
        display.add(Box.createRigidArea(new Dimension(0,10)));

	JLabel info = new JLabel("Add and/or Remove Election Commissioners:");
	info.setAlignmentX(Component.CENTER_ALIGNMENT);
	display.add(info);

	// Add Space between title and panel
	display.add(Box.createRigidArea(new Dimension(0,10))); 

        HSOFRAME = new JPanel();
	HSOFRAME.setLayout(new BoxLayout(HSOFRAME,BoxLayout.PAGE_AXIS));

	UpdateHSOEpanel();
	addHSOComponents();

	JScrollPane scrollList = new JScrollPane(HSOFRAME);
	scrollList.setAlignmentX(Component.CENTER_ALIGNMENT);
	display.add(scrollList);

	// Add Space between panel and buttons
	display.add(Box.createRigidArea(new Dimension(0,10)));
        
       
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
      
        
        
    
    }
    
       
    
     private void UpdateHSOEpanel(){
      
         
        HSO_pan = new ArrayList<JPanel>();
        ArrayList<Election> EList = EL.getECElections(currentUser.getUsername());
        
        for(int i= 0; i < EList.size(); i++)
        {
        
        Election el = EList.get(i);
        JPanel SEtemp = new JPanel();
        
        
        JLabel lblElection_1 = new JLabel(el.getName()+"");
	lblElection_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        SEtemp.add(lblElection_1);
       
        JButton btnCertify = new JButton("Certify");
        btnCertify.setActionCommand("Certify");
        btnCertify.addActionListener(this);
        btnCertify.setFont(new Font("Times New Roman", Font.PLAIN, 11));
	SEtemp.add(btnCertify);
      
        
        JButton btnDQ = new JButton("Disqualify Voter");
        btnDQ.setActionCommand("DQ");
        btnDQ.addActionListener(this);
	btnDQ.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        SEtemp.add(btnDQ);
        
        JButton btnRecount = new JButton("Recount");
        btnRecount.setActionCommand("Recount");
        btnRecount.addActionListener(this);
	btnRecount.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        SEtemp.add(btnRecount);
        
                
       HSO_pan.add(SEtemp);
        }
      
        
		
         }
         
         private void addHSOComponents()
         {
             for(JPanel HE : HSO_pan)
	    {
		// Gap used to space out each panel
	        HSOFRAME.add(Box.createRigidArea(new Dimension(0,5)));
		
		HSOFRAME.add(HE);

		// Gap used to space out each panel
	        HSOFRAME.add(Box.createRigidArea(new Dimension(0,5)));
	    }
         }
           
         private void updateStudentList()
    {
	HSOFRAME.removeAll();
	UpdateHSOEpanel();
	addHSOComponents();

	HSOFRAME.revalidate();
	HSOFRAME.repaint();
	
    }
	
                

         public static void main(String[] args)
    {
	new HSOGUI();
    }
    
    
    
    
    
     public void actionPerformed(ActionEvent e)
    {
   
    if(e.getActionCommand().equals("Recount"))
	    {     
              
             int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want a recount " + e.getActionCommand() + " ?","Confirmation",JOptionPane.YES_NO_OPTION);
		
		if(choice == JOptionPane.YES_OPTION)
                JOptionPane.showMessageDialog(null,"Recount was Successful","Success",JOptionPane.PLAIN_MESSAGE);
 
                    }
    }
}