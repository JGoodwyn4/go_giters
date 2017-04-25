import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class ManageECGUI extends JFrame implements ActionListener
{
    // Attributes
    private ArrayList<JPanel> ecPanel;
    private JPanel ecContainer;
    private ECList holder;

    ManageECGUI()
    {
        holder = new ECList();
	ArrayList<String> nameList = holder.getList();
	ecPanel = new ArrayList<JPanel>();
	
	setTitle("Manage Election Commissioners");
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

        setSize(400,360);
        setResizable(false);
	
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(display);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) /2 );
        int y = (int) ((dimension.getHeight() - getHeight()) /2);
        setLocation(x, y);
        setVisible(true);
	
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
		temp.setLayout(new BoxLayout(temp,BoxLayout.LINE_AXIS));

		
		// Gap before name
		temp.add(Box.createRigidArea(new Dimension(90,0)));
		
		JLabel namePanel = new JLabel(name);
		temp.add(namePanel);

		// Gap between name and remove button
		temp.add(Box.createHorizontalGlue());
		
		JButton removeButton = new JButton("X");
		removeButton.addActionListener(this);
		removeButton.setActionCommand(name);
		temp.add(removeButton);

		// Gap after remove button
		temp.add(Box.createRigidArea(new Dimension(90,0)));

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
	    {
		// Gap used to space out each panel
	        ecContainer.add(Box.createRigidArea(new Dimension(0,5)));
		
		ecContainer.add(ec);

		// Gap used to space out each panel
	        ecContainer.add(Box.createRigidArea(new Dimension(0,5)));
	    }
    }

    public void actionPerformed(ActionEvent e)
    {
	if(e.getActionCommand().equals("closeEC"))
	    {
	        this.dispose();
	    }
	else if(e.getActionCommand().equals("addEC"))
	    {
		new ecDialog();
	    }
	else
	    {
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
	    
	    dialogPanel.setLayout(new BoxLayout(dialogPanel,BoxLayout.PAGE_AXIS));

	    // Gap between the top of the window and the first JLabel
	    dialogPanel.add(Box.createRigidArea(new Dimension(0,10)));
	    
	    JLabel instruct = new JLabel("Enter a Username to be added:");
	    instruct.setAlignmentX(Component.CENTER_ALIGNMENT);
	    dialogPanel.add(instruct);

	    // Gap between JLabel and JPanel
	    dialogPanel.add(Box.createRigidArea(new Dimension(0,10)));

	    /* ********************************************************** */
	    /*  Create a horizontal group to contain the Username: input  */
	    /* ********************************************************** */
	    
	    JPanel horizGroup = new JPanel();
	    horizGroup.setLayout(new BoxLayout(horizGroup,BoxLayout.LINE_AXIS));

	    // Create glue/gap between username prompt
	    //horizGroup.add(Box.createHorizontalGlue());
	    horizGroup.add(Box.createRigidArea(new Dimension(50,0)));
	    
	    JLabel userLabel = new JLabel("Username: ");
	    horizGroup.add(userLabel);

	    // Gap between Username label and text field
	    //horizGroup.add(Box.createRigidArea(new Dimension(20,0)));
	    horizGroup.add(Box.createHorizontalGlue());

	    userInput = new JTextField();
	    horizGroup.add(userInput);

	    // Create glue/gap between username prompt
	    //horizGroup.add(Box.createHorizontalGlue());
	    horizGroup.add(Box.createRigidArea(new Dimension(50,0)));

	    /* ********************************************************** */
	    /*                 End of horizontal JPanel                   */
	    /* ********************************************************** */

	    dialogPanel.add(horizGroup);

	    // Gap between JPanel and buttons
	    dialogPanel.add(Box.createRigidArea(new Dimension(0,15)));
	    
	    JButton addButton = new JButton("Add EC");
	    addButton.addActionListener(this);
	    addButton.setActionCommand("addNewEC");
	    addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(this);
	    cancelButton.setActionCommand("cancelAdd");
	    cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    dialogPanel.add(addButton);

	    // Small gap between buttons
	    dialogPanel.add(Box.createRigidArea(new Dimension(0,5)));
	    
	    dialogPanel.add(cancelButton);

	    // Small gap after buttons
	    dialogPanel.add(Box.createRigidArea(new Dimension(0,10)));
	    
	    setSize(400,140);
	    setResizable(false);
	    
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
			    JOptionPane.showMessageDialog(null,"No Username was entered\n\nPlease enter in a Username","Incorrect Username",JOptionPane.ERROR_MESSAGE);
			}
		    else if(holder.hasUser(newEC))
			{
			    JOptionPane.showMessageDialog(null,"The Username you entered is already an EC\n\nPlease enter in a Username that is not already an EC","Incorrect Username",JOptionPane.ERROR_MESSAGE);
			}
		    else
			{
			    User temp = new User(newEC);

			    // Check if "temp" user is actually a user in the system and
			    // if they are a student. If either of these are false, then
			    // alert that entered username is unable to become an EC.
			    if(!temp.isUser())
				{
				    JOptionPane.showMessageDialog(null,"The Username entered is not a valid Username in the System\n\nPlease enter a valid Username","Incorrect Username",JOptionPane.ERROR_MESSAGE);
				}
			    else if(!temp.isStudent())
				{
				    JOptionPane.showMessageDialog(null,"The Username entered is not a Student\n\nPlease enter a Username associated with a Student","Incorrect Username",JOptionPane.ERROR_MESSAGE);
				}
			    else
				{
				    holder.addEC(newEC);
				    
				    JOptionPane.showMessageDialog(null,"Username has been added","Success",JOptionPane.PLAIN_MESSAGE);

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
