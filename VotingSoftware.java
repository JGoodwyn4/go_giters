import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class VotingSoftware extends JFrame implements ActionListener{

    User currentUser;
 
    BufferedReader readIn;
    PrintWriter writeOut;
    Socket sock;
    
    JTextField txtUser;
    JTextField txtPass;
    ButtonGroup btnGroup;
    
    VotingSoftware()
    {
	
        JPanel panelMain = new JPanel();
        GroupLayout layout = new GroupLayout(panelMain);
        JPanel pnlUser = new JPanel();
	JPanel pnlPass = new JPanel();
	
	
        // text fields
	txtUser = new JTextField(25);
	txtPass = new JTextField(25);
	
	
	// labels
        JLabel userLabel = new JLabel("Username:");
	JLabel passLabel = new JLabel("Password:");
	
	
	
	// Buttons
	JButton loginButton = new JButton("Login");
	loginButton.setActionCommand("log");
	loginButton.addActionListener(this);

	pnlUser.add(userLabel);
	pnlUser.add(txtUser);

	pnlPass.add(passLabel);
	pnlPass.add(txtPass);
	
	//layout
	panelMain.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
	
        layout.setHorizontalGroup(
				  layout.createSequentialGroup()
				  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					    .addComponent(pnlUser)
					    .addComponent(pnlPass)
					    .addComponent(loginButton))   
				  
				  );
        layout.setVerticalGroup(
				layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					  .addComponent(pnlUser)
					  .addComponent(pnlPass)
					  .addComponent(loginButton))
				);
        
	
	
	setSize(1000,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voting Software");
	//panelMain.setBackground(Color.green);
        getContentPane().add(panelMain);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) /2 );
        int y = (int) ((dimension.getHeight() - this.getHeight()) /2);
        setLocation(x, y);
        setVisible(true);
	
	
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
	if(e.getActionCommand().equals("log"))
	    {
		if((txtUser.getText()).equals(""))
		    {
			JOptionPane.showMessageDialog(null,"Username Box is Empty. Please Enter in a Username","Incorrect Username",JOptionPane.ERROR_MESSAGE);
		    }
		else if((txtPass.getText()).equals(""))
		    {
			JOptionPane.showMessageDialog(null,"Password Box is Empty. Please Enter in a Password","Incorrect Password",JOptionPane.ERROR_MESSAGE);
		    }
		else
		    {
			currentUser = new User(txtUser.getText());

			if(currentUser.login(txtPass.getText()))
			    {
				JOptionPane.showMessageDialog(null,"Login was Successful","Success",JOptionPane.PLAIN_MESSAGE);

				// Have part where we determine the type of user

				// Depending on type of user, change GUI layout to correct layout
			    }
			else
			    {
				JOptionPane.showMessageDialog(null,"Login Credentials Were Not Correct. Could Not Login","Could Not Login",JOptionPane.ERROR_MESSAGE);
			    }
		    } 
	    }
	
    }
    
    
    public static void main(String args[])
    {
        new VotingSoftware();
    }
}
