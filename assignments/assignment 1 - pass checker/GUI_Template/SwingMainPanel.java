

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
public class SwingMainPanel extends JPanel{

	private JPanel buttonPanel, dataPanel, leftPanel, rightPanel, topPanel;
	private JButton otherButton, exitButton, callMgrButton;
	private JTextField exampleTextField;
	private JLabel exampleLabel;
	private JRadioButton radioButton1, radioButton2, radioButton3;
	private String userText = "";
	
	//The manager is the way the GUI communicates with the worker code
	private DataManager dataManager;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this template.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	SwingMainPanel() {
		//make the main panel's layout be a BorderLayout
		setLayout(new BorderLayout());

		//create the dataManager instance
		dataManager = new DataManager();
		
	    //create the exitButton
	    exitButton = new JButton("Exit");
	    exitButton.setMnemonic('E');
	    exitButton.setToolTipText("Exit the program");
	    //create a listener for the exit button
	    exitButton.addActionListener(new ButtonListener());
	    
	    //create another button
	    otherButton = new JButton("Some other button");
	    otherButton.setToolTipText("Select this to see what the user entered");
	    //create a listener for the other button
	    otherButton.addActionListener(new ButtonListener());
	    
	    //create the mgrButton
	    callMgrButton = new JButton("Call the Manager");
	    callMgrButton.setToolTipText("Show how to access the Manager from the GUI");
	    //create a listener for the exit button
	    callMgrButton.addActionListener(new ButtonListener());
	    
	    //create an example JTextField and an example JLabel
	    exampleTextField = new JTextField(10);
	    exampleLabel = new JLabel("...Example JLabel...");
	    
	    //create three radio button instances
	    radioButton1 = new JRadioButton("button 1");
	    radioButton2 = new JRadioButton("button 2");
	    radioButton3 = new JRadioButton("button 3");
	    
	    //create a group to make the radio buttons mutually exclusive
	    ButtonGroup radioButtonGroup = new ButtonGroup();
	    radioButtonGroup.add(radioButton1);
	    radioButtonGroup.add(radioButton2);
	    radioButtonGroup.add(radioButton3);
	    
	    //create a single listener for the radio buttons to share; note that a different
	    //example is used for the JButtons, where a separate listener object is 
	    //created for each JButton.  Either way works fine, although the way it is done
	    //here is more efficient.
	    RadioButtonListener radioButtonListener = new RadioButtonListener();
	    radioButton1.addActionListener(radioButtonListener);
	    radioButton2.addActionListener(radioButtonListener);
	    radioButton3.addActionListener(radioButtonListener);
		
		//create the buttonPanel
	    buttonPanel = new JPanel();
	    //These dimensions don't always have the final say in determining the panel's size
	    //It basically is the default if other constraints allow
	    buttonPanel.setPreferredSize(new Dimension(50,50));
	    
	    //The border around each panel is optional.
	    //buttonPanel.setBorder(BorderFactory.createTitledBorder("...<button panel>..."));
	    buttonPanel.setVisible(true);
	    buttonPanel.add(exitButton);
	    buttonPanel.add(otherButton);
	    buttonPanel.add(callMgrButton);
	    //add the panel to the bottom section of the main panel
	    add(buttonPanel, BorderLayout.SOUTH);
	      
	    //create the center panel
	    dataPanel = new JPanel();
	    dataPanel.setPreferredSize(new Dimension(300,100));
	    dataPanel.setBorder(BorderFactory.createTitledBorder("...<center panel>..."));
	    
	    //here is an example of the GridLayout.  Items are filled in left-to-right, 
	    //top-to-bottom, leaving unused cells empty.  The justification is optional.
	    dataPanel.setLayout(new GridLayout(3,2));
	    dataPanel.setVisible(true);
	    dataPanel.add(new JLabel("1", JLabel.CENTER));
	    dataPanel.add(new JLabel("2", JLabel.CENTER));
	    dataPanel.add(new JLabel("3", JLabel.CENTER));
	    dataPanel.add(new JLabel("4", JLabel.CENTER));
	    dataPanel.add(new JLabel("5", JLabel.CENTER));
	    //add the panel to the center section of the main panel
	    add(dataPanel, BorderLayout.CENTER);
	    
	    //create the leftPanel
	    leftPanel = new JPanel();
	    leftPanel.setPreferredSize(new Dimension(150,300));
	    leftPanel.setBorder(BorderFactory.createTitledBorder("...<left panel>..."));
	    leftPanel.setVisible(true);
	    leftPanel.add(exampleLabel);
	    leftPanel.add(exampleTextField);
	    //add the panel to the left section of the main panel
	    add(leftPanel, BorderLayout.WEST);
	    
	    //create the rightPanel
	    rightPanel = new JPanel();
	    rightPanel.setPreferredSize(new Dimension(120,300));
	    rightPanel.setBorder(BorderFactory.createTitledBorder("...<right panel>..."));
	    rightPanel.setVisible(true);
	    //add the panel to the right section of the main panel
	    add(rightPanel, BorderLayout.EAST);
	    
	    //create the topPanel
	    topPanel = new JPanel();
	    topPanel.setPreferredSize(new Dimension(100,50));
	    topPanel.setBorder(BorderFactory.createTitledBorder("...<top panel>..."));
	    topPanel.setVisible(true);
	    //add the radio buttons to the top panel - note: the group is brought along
	    topPanel.add(radioButton1);
	    topPanel.add(radioButton2);
	    topPanel.add(radioButton3);
	    //add the panel to the top section of the main panel
	    add(topPanel, BorderLayout.NORTH);
	    

	}
	
	/**
	 * ActionListener is an interface that requires that the method actionPerformed 
	 * be implemented. When a button is pressed, the actionPerformed method is called.  
	 * You can determine which button was pushed with e.getSource()
	 * @author ralexander
	 *
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			if (source == exitButton) {
				System.exit(0);
			}
			else if (source == otherButton)	{
				System.out.println("...doing something else...");
				userText = exampleTextField.getText();
				System.out.println("User entered: "+userText);
			}
			else if (source == callMgrButton) {
				
				String str = dataManager.doSomething(exampleTextField.getText());
				System.out.println("Sending text to the manager: "+str);
				System.out.println("Getting value from mgr: "+dataManager.sendSomething());
			}
		}
	}
	
	/**
	 * When a radio button is selected, the actionPerformed method is called.  Determine
	 * which radio button was selected using e.getSource()
	 * @author ralexander
	 *
	 */
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			if (source == radioButton1)
			{
				System.out.println("Button 1 was selected");
			}
			else if(source == radioButton2)
			{
				System.out.println("Button 2 was selected");
			}
			else if(source == radioButton3)
			{
				System.out.println("Button 3 was selected");
			}
		}
	}
}
