
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;

	/**
	 *
	 * @author najeeullah.williams
	 */
	public class ECGUI extends JFrame implements ActionListener {
	 

	   private ArrayList<JPanel> EC_pan;
	   private JPanel ecFRAME; 
	   private ElectionList EL;
	   private User currentUser;
	    
	    
	    ECGUI(ElectionList EL, User currentUser){

		this.EL = EL;
		this.currentUser = currentUser;
		
	    	JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(10, 11, 500, 26);
		
		JMenuItem mntmCreateBallot = new JMenuItem("Create Ballot");
		mntmCreateBallot.setActionCommand("createElection");
		mntmCreateBallot.addActionListener(this);
		mntmCreateBallot.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		toolBar_1.add(mntmCreateBallot);
		
	        
		JMenuItem mntmEditBallot = new JMenuItem("Edit Ballot");
		mntmEditBallot.setActionCommand("editballot");
		mntmEditBallot.addActionListener(this);
		mntmEditBallot.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		toolBar_1.add(mntmEditBallot);


		JMenuItem mntmLogout_1 = new JMenuItem("Logout");
	        mntmLogout_1.setActionCommand("logout");
	        mntmLogout_1.addActionListener(this);
		mntmLogout_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		toolBar_1.add(mntmLogout_1);
		
		
	        
	        setTitle("Head Of Student Orgs");
		JPanel display = new JPanel();
		
		/*
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
		*/
		
	        
		
	        
	        //EL = new ElectionList();
		EC_pan = new ArrayList<JPanel>();
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

		display.add(toolBar_1);
		
		// Gap used to space out each panel
	        display.add(Box.createRigidArea(new Dimension(0,10)));
		
		JLabel info = new JLabel("Select an election to vote in:");
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		display.add(info);
		
		// Add Space between title and panel
		display.add(Box.createRigidArea(new Dimension(0,10)));
		
		
		
		ecFRAME = new JPanel();
		ecFRAME.setLayout(new BoxLayout(ecFRAME,BoxLayout.PAGE_AXIS));
		
		UpdateECpanel();
		addECComponents();
		
		JScrollPane scrollList = new JScrollPane(ecFRAME);
		scrollList.setAlignmentX(Component.CENTER_ALIGNMENT);
		display.add(scrollList);
		
		// Add Space between panel and buttons
		display.add(Box.createRigidArea(new Dimension(0,10)));
	        
		
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        
		
	        
	        
		
	    }
	    
	    
	    
	    private void UpdateECpanel(){
		
	        
	        EC_pan = new ArrayList<JPanel>();
	        ArrayList<Election> EList = EL.getECElections(currentUser.getUsername());
	        
	        for(int i= 0; i < EList.size(); i++)
		    {
			
			Election el = EList.get(i);
			JPanel SEtemp = new JPanel();
			
			
			/*
			JLabel lblElectionComissioner = new JLabel("Election Comissioner");
			lblElectionComissioner.setBounds(131, 59, 141, 18);
			lblElectionComissioner.setFont(new Font("Times New Roman", Font.BOLD, 15));
			*/
			
			JLabel lblElection_1 = new JLabel(el.getName()+":");
			lblElection_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			SEtemp.add(lblElection_1);

			/*
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
			*/

			JButton btnRecount = new JButton("Vote");
			btnRecount.setActionCommand(el.getElectionID() + "");
			btnRecount.addActionListener(this);
			btnRecount.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			SEtemp.add(btnRecount);
	                
			EC_pan.add(SEtemp);
		    }
		
	        
		
	    }
	    
	    private void addECComponents()
	    {
		for(JPanel ec : EC_pan)
		    {
			// Gap used to space out each panel
		        ecFRAME.add(Box.createRigidArea(new Dimension(0,5)));
			
			ecFRAME.add(ec);
			
			// Gap used to space out each panel
		        ecFRAME.add(Box.createRigidArea(new Dimension(0,5)));
		    }
	    }
	    
	    private void updateStudentList()
	    {
		ecFRAME.removeAll();
		UpdateECpanel();
		addECComponents();
		
		ecFRAME.revalidate();
		ecFRAME.repaint();
		
	    }
	    
	    
	    /*
	    public static void main(String[] args)
	    {
		new HSOGUI();
	    }
	    */
	    
	    
	    
	    
	    
	    public void actionPerformed(ActionEvent e)
	    {
		if(e.getActionCommand().equals("createElection"))
		    {
			new CreateElectionGUI(currentUser.getUsername(),EL);
		    }
		else if(e.getActionCommand().equals("editballot"))
		    {
			new electionListGUI(currentUser,EL);
		    }
		else if(e.getActionCommand().equals("logout"))
		    {
		        SwingUtilities.getWindowAncestor(this).setVisible(true);
			this.dispose();
		    }
		
	    }
	    
	}
