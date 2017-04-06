import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class LoginGUI extends JFrame implements ActionListener{
    
    BufferedReader readIn;
    PrintWriter writeOut;
    Socket sock;
    
    JTextField txtName;
    JTextField txtPassW;
    ButtonGroup btnGroup;
    JTextArea txtInfo;
    
    LoginGUI()
    {
	
        JPanel panelMain = new JPanel();
        GroupLayout layout = new GroupLayout(panelMain);
        JPanel pnlButtons = new JPanel();
	
	
        // text fields
	txtName = new JTextField(25);
	txtPassW = new JTextField(25);
	txtInfo = new JTextArea(15,50);
	
	
	// labels
        JLabel lName = new JLabel("Enter Username");
	JLabel lPassW = new JLabel("Enter Password");
	
	
	
	// Buttons
	JButton Butt1 = new JButton("Login");
	Butt1.setActionCommand("log");
	Butt1.addActionListener(this);
        
	JButton Butt2 = new JButton("Exit");
	Butt2.setActionCommand("SD");
	Butt2.addActionListener(this);
	
	
	JButton Butt3 = new JButton("Forgot Password");
	Butt3.setActionCommand("FP");
	Butt3.addActionListener(this);
	
	JButton Butt4 = new JButton("Forgot Username");
	Butt4.setActionCommand("FU");
	Butt4.addActionListener(this);
	
	
	
	btnGroup = new ButtonGroup();
        btnGroup.add(Butt1);
        btnGroup.add(Butt2);
	btnGroup.add(Butt3);
        btnGroup.add(Butt4);
	
	
	
	JLabel lblSize = new JLabel("Operations:  ");
        lblSize.setFont(new Font(lblSize.getFont().getName(), Font.PLAIN, 20));
        pnlButtons.add(lblSize);
        pnlButtons.add(Butt1);
        pnlButtons.add(Butt2);
	pnlButtons.add(Butt3);
	pnlButtons.add(Butt4);
	
	
	//layout
	panelMain.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
	
        layout.setHorizontalGroup(
				  layout.createSequentialGroup()
				  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					    .addComponent(lName)
					    .addComponent(txtName)
					    .addComponent(lPassW)
					    .addComponent(txtPassW)
					    .addComponent(txtInfo)
					    .addComponent(pnlButtons))   
				  
				  );
        layout.setVerticalGroup(
				layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					  .addComponent(lName)
					  .addComponent(txtName)
					  .addComponent(lPassW)
					  .addComponent(txtPassW)
					  .addComponent(txtInfo)
					  .addComponent(pnlButtons))
				);
        
	
	
	setSize(1000,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUI");
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
		StringBuffer strInfo = new StringBuffer();
		strInfo.append(txtName.getText() + "\n");
		txtInfo.setText(strInfo.toString());   
	    }
	
    }
    
    
    public static void main(String args[])
    {
        new LoginGUI();
    }
}
