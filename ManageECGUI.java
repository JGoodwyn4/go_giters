import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class ManageECGUI implements ActionListener
{
    // Attributes
    //ArrayList<JPanel> ecPanel;
    JFrame window;

    ManageECGUI()
    {
	ECList holder = new ECList();
	ArrayList<String> nameList = holder.getList();
	//ecPanel = new ArrayList<JPanel>();
	
        window = new JFrame("Manage Election Commissioners");
	JPanel display = new JPanel();

	GridLayout layout = new GridLayout(0,1);
	display.setLayout(layout);

	JTextField info = new JTextField("Add and/or Remove Election Commissioners:");
	info.setEditable(false);
	display.add(info);

	for(int i = 0; i < nameList.size(); i++)
	    {
		String name = nameList.get(i);
		
		JPanel temp = new JPanel();
		temp.setLayout(new FlowLayout());

		JTextField namePanel = new JTextField(name);
		namePanel.setEditable(false);
		temp.add(namePanel);
		
		JButton removeButton = new JButton("X");
		removeButton.addActionListener(this);
		removeButton.setActionCommand(name);
		temp.add(removeButton);

		//ecPanel.add(temp);

		display.add(temp);
	    }

	JButton addEC = new JButton("Add a New EC");
	addEC.addActionListener(this);
	addEC.setActionCommand("addEC");

	JButton close = new JButton("Close");
	close.addActionListener(this);
	close.setActionCommand("closeEC");

	display.add(addEC);
	display.add(close);

	window.setSize(500,350);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().add(display);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - window.getWidth()) /2 );
        int y = (int) ((dimension.getHeight() - window.getHeight()) /2);
        window.setLocation(x, y);
        window.setVisible(true);
	
    }

    public void actionPerformed(ActionEvent e)
    {
	String insert = e.getActionCommand();
	JOptionPane.showMessageDialog(null,"Remove Command for: " + insert,"Test",JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args)
    {
	new ManageECGUI();
    }
}
