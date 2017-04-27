

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;

import java.awt.event.*;
import java.util.*;
public class VotingSoftware implements ActionListener{

	private JFrame LogFrame;
        private JFrame HSOFrame;
        private JFrame ECFrame;
        private JFrame DQFrame;
        private JFrame Recount;
        private JFrame StudentFrame;
	private JTextField logtextField;
	private JPanel log_panel;
	private JPanel HSO_panel;
	private JPanel EC_panel;
        private ArrayList<JPanel> Student_pan;
	private User currentUser;
	private JPasswordField passwordField;
	private JPasswordField store;
	private static String Password;
        private String name;
	private char [] pass;
        private ElectionList EL;
        
 
	/**
	 * Launch the application.
	 */
	
        /**
	 * Create the application.
	 */
	
        
        
        
        
       public VotingSoftware() {
		initialize();
                
   
	}

        
                


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	    EL = new ElectionList();
               
               
          /************************************************/
         /*                   Login                      */ 	
        /************************************************/
		LogFrame = new JFrame("Login");
		LogFrame.setBounds(100, 100, 450, 300);
		LogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LogFrame.getContentPane().setLayout(new CardLayout(0, 0));
                
		JPanel log_panel = new JPanel();
		LogFrame.getContentPane().add(log_panel, "name_14683670128543");
	
                
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(49, 99, 57, 13);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(49, 150, 52, 13);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		logtextField = new JTextField();
		logtextField.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		logtextField.setBounds(116, 95, 213, 20);
		logtextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 146, 213, 20);
		passwordField.setEchoChar('*');
		store = new JPasswordField();
                
                JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(200, 202, 80, 23);
		btnLogin.setActionCommand("log");
		btnLogin.addActionListener(this);
		
		JLabel lblMorgantownUniversityVoting = new JLabel("Morgantown University Voting Software");
		lblMorgantownUniversityVoting.setBounds(49, 39, 302, 20);
		lblMorgantownUniversityVoting.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		log_panel.setLayout(null);
		log_panel.add(btnLogin);
		log_panel.add(lblMorgantownUniversityVoting);
		log_panel.add(lblPassword);
		log_panel.add(lblUsername);
		log_panel.add(logtextField);
		log_panel.add(passwordField);
                
		
                Dimension Ldimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int Lx = (int) ((Ldimension.getWidth() - LogFrame.getWidth()) /2 );
	        int Ly = (int) ((Ldimension.getHeight() - LogFrame.getHeight()) /2);
	        LogFrame.setLocation(Lx, Ly);
                
                
          /************************************************/
         /*             Head of Student Orgs             */ 	
        /************************************************/
		HSOFrame = new JFrame("HSO");
		HSOFrame.setBounds(100, 100, 450, 300);
		HSOFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HSOFrame.getContentPane().setLayout(new CardLayout(0, 0));
                
		JPanel HSO_panel = new JPanel();
		HSOFrame.getContentPane().add(HSO_panel, "name_14685468012814");
		
		JLabel lblHeadOfStudent = new JLabel("Head Of Student Organizations");
		lblHeadOfStudent.setBounds(108, 67, 203, 18);
		lblHeadOfStudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JPanel Election_panel = new JPanel();
		Election_panel.setBounds(10, 103, 395, 39);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 11, 500, 26);
		
		
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
		
		JLabel lblElection = new JLabel("ELECTION:");
		lblElection.setBounds(10, 16, 59, 13);
		lblElection.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		JButton btnCertify = new JButton("Certify");
                btnCertify.setActionCommand("Certify");
                btnCertify.addActionListener(this);
		btnCertify.setBounds(87, 12, 75, 21);
		btnCertify.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		JButton btnDQ = new JButton("Disqualify Voter");
                btnDQ.setActionCommand("DQ");
                btnDQ.addActionListener(this);
		btnDQ.setBounds(170, 11, 115, 23);
		btnDQ.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		JButton btnRecount = new JButton("Recount");
                btnRecount.setActionCommand("Recount");
                btnRecount.addActionListener(this);
		btnRecount.setBounds(295, 11, 73, 23);
		btnRecount.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
                HSO_panel.setLayout(null);
		HSO_panel.add(toolBar);
		HSO_panel.add(Election_panel);
		Election_panel.setLayout(null);
		Election_panel.add(lblElection);
		Election_panel.add(btnCertify);
		Election_panel.add(btnDQ);
		Election_panel.add(btnRecount);
		HSO_panel.add(lblHeadOfStudent);
                
                Dimension HSOdimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int HSOx = (int) ((HSOdimension.getWidth() - HSOFrame.getWidth()) /2 );
	        int HSOy = (int) ((HSOdimension.getHeight() - HSOFrame.getHeight()) /2);
	        HSOFrame.setLocation(HSOx, HSOy);
              
		
	  /************************************************/
         /*             Election Commissioner            */ 	
        /************************************************/
                ECFrame = new JFrame("EC");
		ECFrame.setBounds(100, 100, 450, 300);
		ECFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ECFrame.getContentPane().setLayout(new CardLayout(0, 0));
                
                
		JPanel EC_panel = new JPanel();
		ECFrame.getContentPane().add(EC_panel, "name_14690592761211");
		
          
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(10, 11, 500, 26);
		
               
		JPanel EC_Election_panel = new JPanel();
		EC_Election_panel.setBounds(10, 101, 364, 49);
		
		JLabel lblElection_1 = new JLabel("ELECTION:");
		lblElection_1.setBounds(10, 21, 59, 13);
		lblElection_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		JButton btnVote = new JButton("VOTE");
		btnVote.setBounds(108, 17, 80, 21);
		btnVote.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		JMenuItem mntmCreateBallot = new JMenuItem("Create Ballot");
		mntmCreateBallot.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		toolBar_1.add(mntmCreateBallot);
		
                JMenuItem mntmLogout_1 = new JMenuItem("Logout");
                mntmLogout_1.setActionCommand("logout");
                mntmLogout_1.addActionListener(this);
		mntmLogout_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	
                
		JMenuItem mntmEditBallot = new JMenuItem("Edit Ballot");
		mntmEditBallot.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		toolBar_1.add(mntmEditBallot);
		toolBar_1.add(mntmLogout_1);
		
		JLabel lblElectionComissioner = new JLabel("Election Comissioner");
		lblElectionComissioner.setBounds(131, 59, 141, 18);
		lblElectionComissioner.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		EC_panel.setLayout(null);
		EC_panel.add(toolBar_1);
		EC_panel.add(EC_Election_panel);
		EC_Election_panel.setLayout(null);
		EC_Election_panel.add(lblElection_1);
		EC_Election_panel.add(btnVote);
		EC_panel.add(lblElectionComissioner);
                
                Dimension ECdimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int ECx = (int) ((HSOdimension.getWidth() - ECFrame.getWidth()) /2 );
	        int ECy = (int) ((HSOdimension.getHeight() - ECFrame.getHeight()) /2);
	        ECFrame.setLocation(ECx, ECy);
               
          /************************************************/
         /*                   DQ Voter                   */ 	
        /************************************************/
                
                
                FlowLayout DQlayout = new FlowLayout();
               
        
		DQFrame = new JFrame("Disqualify Voter");
		JPanel display = new JPanel();
		
		JLabel name = new JLabel("Enter Voter Name");
			name.setForeground(Color.BLACK);
		JTextField DQName = new JTextField(30);
		
		JLabel disqualify = new JLabel("Do you want to disqualify this voter?");
		disqualify.setForeground(Color.BLACK);
		
		JButton yes = new JButton("Disqualify");
		yes.addActionListener(this);
		
		
		
		
		
		//DQFrame.setLocationByPlatform(true);
		DQFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DQFrame.setSize(600,150);
		DQFrame.getContentPane().add(display);
	        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int x = (int) ((dimension.getWidth() - DQFrame.getWidth()) /2 );
	        int y = (int) ((dimension.getHeight() - DQFrame.getHeight()) /2);
	        DQFrame.setLocation(x, y);
              
			
		display.setLayout(DQlayout);
		display.add(name);
		display.add(DQName);
		display.add(disqualify);
		display.add(yes);
		
		
		
          /************************************************/
         /*                   Recount                    */ 	
        /************************************************/
         
                
                JPanel panelMain = new JPanel();
                FlowLayout layout = new FlowLayout();
              
        
        
                Recount = new JFrame("Recount");
		JPanel Rdisplay = new JPanel();
		
		JLabel recount = new JLabel("Do you wish to perform a recount?");
		recount.setForeground(Color.black);
		
		JButton Ryes = new JButton("Yes");
		Ryes.setActionCommand("RYes");
                Ryes.addActionListener(this);
		
		
		JButton Rno = new JButton("No");
		Rno.setActionCommand("Rno");
		Rno.addActionListener(this);
		
		
		
		Recount.setLocationByPlatform(true);
		Recount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Recount.setSize(600,100);
		Recount.getContentPane().add(Rdisplay);
	        Dimension Rdimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int Rx = (int) ((Rdimension.getWidth() - Recount.getWidth()) /2 );
	        int Ry = (int) ((Rdimension.getHeight() - Recount.getHeight()) /2);
	        Recount.setLocation(x, y);
		
			
		Rdisplay.setLayout(layout);
		Rdisplay.add(recount);
		Rdisplay.add(Ryes);
		Rdisplay.add(Rno);
		
                
                    
                 
                
          /************************************************/
         /*                    student                   */ 	
        /************************************************/
         
              
                StudentFrame= new JFrame("Student");
		StudentFrame.setBounds(100, 100, 450, 300);
		StudentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StudentFrame.getContentPane().setLayout(new CardLayout(0, 0));
                
                
		JPanel Student_panel = new JPanel();
		StudentFrame.getContentPane().add(Student_panel, "name_14690592761211");
		
          
		
	
		JPanel Student_Election_panel = new JPanel();
		Student_Election_panel.setBounds(10, 101, 364, 49);
		
		JLabel SlblElection = new JLabel("ELECTION:");
		SlblElection.setBounds(10, 21, 59, 13);
		SlblElection.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		JButton SbtnVote = new JButton("VOTE");
		SbtnVote.setBounds(108, 17, 80, 21);
		SbtnVote.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setBounds(131, 59, 141, 25);
		lblStudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		Student_panel.setLayout(null);

		Student_panel.add(Student_Election_panel);
		Student_Election_panel.setLayout(null);
		Student_Election_panel.add(SlblElection);
		Student_Election_panel.add(SbtnVote);
                 
		Student_panel.add(lblStudent);
                
                Dimension Sdimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int Sx = (int) ((Sdimension.getWidth() - StudentFrame.getWidth()) /2 );
	        int Sy = (int) ((Sdimension.getHeight() - StudentFrame.getHeight()) /2);
	        StudentFrame.setLocation(Sx, Sy);
               
                
                
         
             
                       
	}
        
        
        
        
        
        
        
        public static void main(String[] args) {
	    
	    
	    EventQueue.invokeLater(new Runnable() {
		    public void run() {
			try {
			    VotingSoftware window = new VotingSoftware();
			    window.LogFrame.setVisible(true);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    }
		});
	}
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
        
	String temp = new String(passwordField.getPassword());
        
        
	
	if(e.getActionCommand().equals("log"))
	    {     
		if((logtextField.getText()).equals(""))
		    {
			
			JOptionPane.showMessageDialog(null,"Username Box is Empty. Please Enter in a Username","Incorrect Username",JOptionPane.ERROR_MESSAGE);
		    }
		else if(temp.equals(""))
		    {
			JOptionPane.showMessageDialog(null,"Password Box is Empty. Please Enter in a Password","Incorrect Password",JOptionPane.ERROR_MESSAGE);
		    }
		else
		    {
			currentUser = new User(logtextField.getText());
			
			if(currentUser.login(temp))
			    {
				JOptionPane.showMessageDialog(null,"Login was Successful","Success",JOptionPane.PLAIN_MESSAGE);
				if (currentUser.isEC()){
				    currentUser = new ElectionCommissioner(currentUser);
                                    
				    //ECFrame.setVisible(true);
				    LogFrame.setVisible(false);

				    new ECGUI(EL,currentUser);
                                    
				}
                                
                                
				else if (currentUser.isHSO()){
				    LogFrame.setVisible(false);
				    //HSOFrame.setVisible(true);

				    new HSOGUI(EL,currentUser);
                                    
				}
				else
				    { 
					currentUser = new Student(currentUser);
					//StudentFrame.setVisible(true);
					LogFrame.setVisible(false);

					new StudentGUI(EL,currentUser);
				    }
				
			    }
			else
			    {
				JOptionPane.showMessageDialog(null,"Login Credentials Were Not Correct. Could Not Login","Could Not Login",JOptionPane.ERROR_MESSAGE);
			    }
		    } 
	    }
	
	if(e.getActionCommand().equals("logout")){
	    ECFrame.setVisible(false);
	    LogFrame.setVisible(true);
	    HSOFrame.setVisible(false);
            
	} 
        
	if(e.getActionCommand().equals("DQ")){
	    
            
	    DQFrame.setVisible(true);
	    LogFrame.setVisible(false);
            
	}
	if(e.getActionCommand().equals("Recount")){
	    
            
	    Recount.setVisible(true);
	    LogFrame.setVisible(false);
            
            
	}
	if(e.getActionCommand().equals("ManageEC")){
	    
            
	    new ManageECGUI();
            
	}
	if(e.getActionCommand().equals("Certify")){
	    
            
	    // new CertifyGUI();
            
	}
	
	if(e.getActionCommand().equals("RYes"))
	    {     
		
                JOptionPane.showMessageDialog(null,"Recount was Successful","Success",JOptionPane.PLAIN_MESSAGE);
		
            }
	if(e.getActionCommand().equals("Rno"))
	    {     
		
                Recount.dispose();
                
            }
	
        
        
        
	
        
        
        
    }
    
}
