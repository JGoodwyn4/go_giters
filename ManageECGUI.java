import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class ManageECGUI implements ActionListener
{
    // Attributes
    private ArrayList<JPanel> ecPanel;
    private JFrame window;
    private JPanel ecContainer;
    private ECList holder;

    ManageECGUI()
    {
        holder = new ECList();
	ArrayList<String> nameList = holder.getList();
	ecPanel = new ArrayList<JPanel>();
	
        window = new JFrame("Manage Election Commissioners");
	JPanel display = new JPanel();

	BoxLayout layout = new BoxLayout(display,BoxLayout.PAGE_AXIS);
	//GridLayout layout = new GridLayout(0,1);
	display.setLayout(layout);

	JLabel info = new JLabel("Add and/or Remove Election Commissioners:");
	info.setAlignmentX(Component.CENTER_ALIGNMENT);
	display.add(info);

	// Add Space between title and panel
	display.add(Box.createRigidArea(new Dimension(0,10))); 

        ecContainer = new JPanel();
	ecContainer.setLayout(new BoxLayout(ecContainer,BoxLayout.PAGE_AXIS));

	updateComponents();
	addComponents();

	JScrollPane scrollList = new JScrollPane(ecContainer);
	scrollList.setAlignmentX(Component.CENTER_ALIGNMENT);
	display.add(scrollList);

	// Add Space between panel and buttons
	display.add(Box.createRigidArea(new Dimension(0,10)));

	JButton addEC = new JButton("Add a New EC");
	addEC.addActionListener(this);
	addEC.setActionCommand("addEC");
	addEC.setAlignmentX(Component.CENTER_ALIGNMENT);


	JButton close = new JButton("Close");
	close.addActionListener(this);
	close.setActionCommand("closeEC");
	close.setAlignmentX(Component.CENTER_ALIGNMENT);

	display.add(addEC);

	// Small gap between buttons
	display.add(Box.createRigidArea(new Dimension(0,5)));
	
	display.add(close);

	// Gap after close button
	display.add(Box.createRigidArea(new Dimension(0,10)));

	window.setSize(400,350);
	window.setResizable(false);
	
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.getContentPane().add(display);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - window.getWidth()) /2 );
        int y = (int) ((dimension.getHeight() - window.getHeight()) /2);
        window.setLocation(x, y);
        window.setVisible(true);
	
    }

    // Reupdates the entire list of panels for each EC name
    private void updateComponents()
    {
	ecPanel = new ArrayList<JPanel>();
	ArrayList<String> nameList = holder.getList();

	for(int i = 0; i < nameList.size(); i++)
	    {
		String name = nameList.get(i);
		
		JPanel temp = new JPanel();
		temp.setLayout(new FlowLayout());
		//temp.setLayout(new GridLayout(1,2,0,0));

		JLabel namePanel = new JLabel(name);
		temp.add(namePanel);
		
		JButton removeButton = new JButton("X");
		removeButton.addActionListener(this);
		removeButton.setActionCommand(name);
		temp.add(removeButton);

		//temp.setBorder(new EmptyBorder(10,10,10,10));

		ecPanel.add(temp);
	    }
    }

    // Updates the list of EC usernames
    private void updateList()
    {
	ecContainer.removeAll();
	updateComponents();
	addComponents();

	ecContainer.revalidate();
	ecContainer.repaint();
	
    }

    private void addComponents()
    {
	for(JPanel ec : ecPanel)
	    ecContainer.add(ec);
    }

    public void actionPerformed(ActionEvent e)
    {
	if(e.getActionCommand().equals("closeEC"))
	    {
		window.dispose();
	    }
	else if(e.getActionCommand().equals("addEC"))
	    {
		// Open user input dialog box

		
	        new ecDialog();
		//updateList();
	    }
	else
	    {
		//String insert = e.getActionCommand();
		
		//JOptionPane.showMessageDialog(null,"Remove Command for: " + insert,"Test",JOptionPane.PLAIN_MESSAGE);

		holder.removeEC(e.getActionCommand());
	        updateList();
	    }
    }

    public static void main(String[] args)
    {
	new ManageECGUI();
    }
    
    
    private class ecDialog extends JFrame implements ActionListener
    {
	private JTextField userInput;
	
	ecDialog()
	{
	    setTitle("Manage Election Commissioners");
	    
	    JPanel dialogPanel = new JPanel();
	    
	    //BoxLayout layout = new BoxLayout(dialogPanel,BoxLayout.Y_AXIS);
	    dialogPanel.setLayout(new BoxLayout(dialogPanel,BoxLayout.Y_AXIS));
	    
	    JLabel instruct = new JLabel("Enter the Election Commissioner Username to be added:");
	    dialogPanel.add(instruct);
	    
	    JLabel userLabel = new JLabel("Username: ");
	    dialogPanel.add(userLabel);

	    userInput = new JTextField();
	    dialogPanel.add(userInput);
	    
	    JButton addButton = new JButton("Add EC");
	    addButton.addActionListener(this);
	    addButton.setActionCommand("addNewEC");
	    addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(this);
	    cancelButton.setActionCommand("cancelAdd");
	    cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    dialogPanel.add(addButton);
	    dialogPanel.add(cancelButton);
	    
	    //setSize(400,350);
	    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    getContentPane().add(dialogPanel);
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) /2 );
	    int y = (int) ((dimension.getHeight() - getHeight()) /2);
	    setLocation(x, y);
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
	    if(e.getActionCommand().equals("addNewEC"))
		{
		    String newEC = userInput.getText();
		    
		    if(newEC.equals(""))
			{
			    JOptionPane.showMessageDialog(null,"No Username was entered. Please enter in a Username","Incorrect Username",JOptionPane.ERROR_MESSAGE);
			}
		    else if(holder.hasUser(newEC))
			{
			    JOptionPane.showMessageDialog(null,"The Username you entered is already an EC. Please enter in a Username that is not already an EC","Incorrect Username",JOptionPane.ERROR_MESSAGE);
			}
		    else
			{
			    User temp = new User(newEC);

			    // Check if "temp" user is actually a user in the system and
			    // if they are a student. If either of these are false, then
			    // alert that entered username is unable to become an EC.
			    if(!temp.isUser())
				{
				    JOptionPane.showMessageDialog(null,"The Username entered is not a valid Username in the System. Please enter a valid Username","Incorrect Username",JOptionPane.ERROR_MESSAGE);
				}
			    else if(!temp.isStudent())
				{
				    JOptionPane.showMessageDialog(null,"The Username entered is not a Student. Please enter a Username associated with a Student","Incorrect Username",JOptionPane.ERROR_MESSAGE);
				}
			    else
				{
				    holder.addEC(newEC);
				    
				    JOptionPane.showMessageDialog(null,"The Username was successfully added to the list of Election Commissioners","Success",JOptionPane.PLAIN_MESSAGE);

				    updateList();
				    this.dispose();
				}
			}
		}
	    if(e.getActionCommand().equals("cancelAdd"))
		{
		    this.dispose();
		}
	}
    }
    
    
}
