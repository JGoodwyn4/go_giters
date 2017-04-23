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

	BoxLayout layout = new BoxLayout(display,BoxLayout.Y_AXIS);
	//GridLayout layout = new GridLayout(0,1);
	display.setLayout(layout);

	JLabel info = new JLabel("Add and/or Remove Election Commissioners:");
	display.add(info);

        ecContainer = new JPanel();
	ecContainer.setLayout(new BoxLayout(ecContainer,BoxLayout.PAGE_AXIS));

	updateComponents();
	addComponents();

	JScrollPane scrollList = new JScrollPane(ecContainer);
	display.add(scrollList);

	JButton addEC = new JButton("Add a New EC");
	addEC.addActionListener(this);
	addEC.setActionCommand("addEC");
	addEC.setAlignmentX(Component.CENTER_ALIGNMENT);

	JButton close = new JButton("Close");
	close.addActionListener(this);
	close.setActionCommand("closeEC");
	close.setAlignmentX(Component.CENTER_ALIGNMENT);

	display.add(addEC);
	display.add(close);

	window.setSize(400,350);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

		
		//holder.addEC();
		updateList();
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
    
    /*
    private class ecDialog extends JFrame implements ActionListener
    {
	ecDialog()
	{
	    
	}
    }
    */
    
}
