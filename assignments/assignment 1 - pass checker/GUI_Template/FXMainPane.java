import javax.swing.JLabel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.BuilderFactory;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a BorderPane
public class FXMainPane extends BorderPane {

	private Pane buttonPanel, dataPanel, leftPanel, rightPanel, topPanel;
	private Button otherButton, otherButton2, exitButton, callMgrButton;
	private TextField exampleTextField, exampleTextField2;
	private Label exampleLabel, exampleLabel2;
	private RadioButton radioButton1, radioButton2, radioButton3;
	private String userText = "";
	
	//The manager is the way the GUI communicates with the worker code
	private DataManager dataManager;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this template.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		
		//create the dataManager instance
		dataManager = new DataManager();
		
		Insets inset = new Insets(10); //for setting margins
		
		//create label and text field and add to the left region
		//create an example JTextField and an example JLabel
	    exampleTextField = new TextField();
	    exampleTextField.setPrefColumnCount(8);
	    exampleLabel = new Label("Example Label #1");
	    exampleTextField2 = new TextField();
	    exampleTextField2.setPrefColumnCount(8);
	    exampleLabel2 = new Label("Example Label #2");
	    //create the leftPanel
	    VBox leftBox = new VBox(10);
	    leftBox.getChildren().addAll(exampleLabel, exampleTextField);
	    setLeft(leftBox);
		 
	    
	    //create the buttons and add them to the bottom region
	    //create the exitButton
	    exitButton = new Button("_Exit");
		//_ in label specifies that the next character is the mnemonic, ie, type Alt-m as a shortcut
	    //this activates the mnemonic on exitButton when the Alt key is pressed
	    exitButton.setMnemonicParsing(true);  
	    exitButton.setTooltip(new Tooltip("Select to close the application"));
	    //use a lambda expression for the EventHandler class for exitButton
        exitButton.setOnAction(
        		event -> {
            	 Platform.exit();
                 System.exit(0);
        		}
        	);
	    
	    //create another button
	    otherButton = new Button("Some _other button");
	    otherButton.setMnemonicParsing(true);  
	    otherButton.setTooltip(new Tooltip("Select this to see what the user entered in the left text field"));
	    //create a listener for the other button using a lambda expression
	    otherButton.setOnAction(event -> {
			System.out.println("...doing something else...");
			userText = exampleTextField.getText();
			System.out.println("User entered: "+userText);
		});
	    
	  //create another button
	    otherButton2 = new Button("_Yet another button");
	    otherButton2.setMnemonicParsing(true);  
	    otherButton2.setTooltip(new Tooltip("Select this to see what the user entered in the right text field"));
	    //create a listener for the other button using a lambda expression
	    otherButton2.setOnAction(event -> {
			System.out.println("...doing yet another action...");
			userText = exampleTextField2.getText();
			System.out.println("User entered: "+userText);
		});
	    
	    //create the mgrButton
	    callMgrButton = new Button("Call the Manager");
	    callMgrButton.setMnemonicParsing(true);  
	    callMgrButton.setTooltip(new Tooltip("Show how to access the Manager from the GUI"));
	    //create a listener for the exit button using a lambda expression
	    callMgrButton.setOnAction(event -> {
			String str = dataManager.doSomething(exampleTextField.getText());
			System.out.println("Sending text to the manager: "+str);
			System.out.println("Getting value from mgr: "+dataManager.sendSomething());
		});
	    
	    HBox bottomBox = new HBox();
	    HBox.setMargin(otherButton, inset);
	    HBox.setMargin(otherButton2, inset);
	    HBox.setMargin(callMgrButton, inset);
	    HBox.setMargin(exitButton, inset);
	    bottomBox.getChildren().addAll(otherButton, otherButton2, callMgrButton, exitButton); // 
	    setBottom(bottomBox);
	    bottomBox.setAlignment(Pos.CENTER);
		
		
		GridPane centerGridPane = new GridPane();
		centerGridPane.setAlignment(Pos.CENTER);
		centerGridPane.setHgap(75);
		centerGridPane.setVgap(75);
		centerGridPane.add(new Label("Alpha"), 0, 0);
		centerGridPane.add(new Label("Bravo"), 1, 0);
		centerGridPane.add(new Label("Charlie"), 2, 0);
		centerGridPane.add(new Label("Delta"), 0, 1);	
		centerGridPane.add(new Label("Echo"), 1, 1);
		centerGridPane.add(new Label("Foxtrot"), 2, 1);
		centerGridPane.add(new Label("Golf"), 0, 2);
		centerGridPane.add(new Label("Hotel"), 1, 2);
		
		centerGridPane.setStyle("-fx-border-color: gray;");

	    setCenter(centerGridPane);
	    
	   
	    
	    //create three radio button instances
	    radioButton1 = new RadioButton("button 1");
	    radioButton2 = new RadioButton("button 2");
	    radioButton3 = new RadioButton("button 3");
	    
	    
	    //create a group to make the radio buttons mutually exclusive
	    ToggleGroup radioButtonGroup = new ToggleGroup();
	    radioButton1.setToggleGroup(radioButtonGroup);
	    radioButton2.setToggleGroup(radioButtonGroup);
	    radioButton3.setToggleGroup(radioButtonGroup);
	    
	    radioButton1.setSelected(true);

	    //create a single listener for the radio buttons to share; note that a different
	    //example is used for the JButtons, where a separate listener object is 
	    //created for each JButton.  Either way works fine, although the way it is done
	    //here is more efficient.
	    RadioButtonListener radioButtonListener = new RadioButtonListener();
	    radioButton1.setOnAction(radioButtonListener);
	    radioButton2.setOnAction(radioButtonListener);
	    radioButton3.setOnAction(radioButtonListener);
		
	    HBox topBox = new HBox();
	    topBox.getChildren().addAll(radioButton1, radioButton2, radioButton3); 
	    topBox.setStyle("-fx-border-color: gray;");

	    //use inset as defined above
	    HBox.setMargin(radioButton1, inset);
	    HBox.setMargin(radioButton2, inset);
	    HBox.setMargin(radioButton3, inset);
	    setTop(topBox);
	    topBox.setAlignment(Pos.CENTER);
	    
	    VBox rightBox = new VBox(10);
	    rightBox.getChildren().addAll(exampleLabel2, exampleTextField2);
	    setRight(rightBox);
	}
	/**
	 * When a radio button is selected, the actionPerformed method is called.  Determine
	 * which radio button was selected using e.getSource()
	 * This class is an example of implementing a class that handles the results of an action
	 * @author ralexander
	 *
	*/
	class RadioButtonListener implements EventHandler<ActionEvent>
		{
			@Override
			public void handle(ActionEvent event) {
				Object source = event.getTarget();
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
	
