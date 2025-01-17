import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * TODO
 * - testing
 * - comments/javadoc
 * - learning experience
 * - updated UML
 */

/**
 * @author Eugene Domrachev 
 * 
 * This class provides the user with a GUI to create a concordance via the ConcordanceDataManager.
 */

public class ConcordanceGUI extends Application {
	
	
	protected Button createConcordance, selInput, selOutput, clear, exit;
	private RadioButton radioFile, radioText;
	private ConcordanceDataManager manager;
	protected static TextArea textArea;
	private FileChooser fileChooser;
	private Stage stageRef;
	private BorderPane root;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
    
    /**
     * Initialize the GUI components.
     */
    
    @Override
    public void start(Stage primaryStage) {
    	
    	fileChooser = new FileChooser();
    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    	fileChooser.getExtensionFilters().add(extFilter);
    	ButtonListener buttonListener = new ButtonListener();
    	stageRef = primaryStage;
        primaryStage.setTitle("Concordance Generator");
        root = new BorderPane();

        
        
        
        
        // Radio buttons (top row)
        
        HBox radioBox = new HBox();
        radioBox.setPadding(new Insets(15, 12, 15, 12));
        radioBox.setSpacing(10);
        radioBox.setStyle("-fx-border-width: 1;" + "-fx-border-color: gray;");
        
        final ToggleGroup radioGroup = new ToggleGroup();

        radioFile = new RadioButton("Create concordance from file");
        radioFile.setToggleGroup(radioGroup);
        radioFile.setSelected(false);

        radioText = new RadioButton("Create concordance from text");
        radioText.setToggleGroup(radioGroup);
        radioText.setSelected(false);
        
        radioBox.getChildren().addAll(radioFile, radioText);
        root.setTop(radioBox);
        
        
        
        
        
        // Text area (middle)
        
        textArea = new TextArea();
        root.setCenter(textArea);
        
        
        
        
        
        // Button row (bottom)
        
        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        buttonBox.setSpacing(10);
        buttonBox.setStyle("-fx-border-width: 1;" + "-fx-border-color: gray;");
        

        createConcordance = new Button("Create concordance");
        createConcordance.setOnAction(buttonListener);
        
        selInput = new Button("Select input file");
        selInput.setOnAction(buttonListener);
        
        selOutput = new Button("Select output file");
        selOutput.setOnAction(buttonListener);
        
        clear = new Button("Clear");
        clear.setOnAction(
        		event -> {
            	 textArea.setText("");
        		}
        	);
        
        exit = new Button("Exit");
        exit.setOnAction(
        		event -> {
            	 Platform.exit();
                 System.exit(0);
        		}
        	);
        
        buttonBox.getChildren().addAll(createConcordance, selInput, selOutput, clear, exit);
        
        root.setBottom(buttonBox);
        
        
        
        
        
        // Start the GUI
        
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        
        
    }
    
    
    
    
    
    /**
     * An inner class which listens for actions based on the bottom row of buttons in the GUI.
     */
    
	class ButtonListener implements EventHandler<ActionEvent>
	{
		
		File inputFile, outputFile;
		
		
		@Override
		public void handle(ActionEvent event) {
			
			Object source = event.getTarget();
			
			if (source == createConcordance){
				
				manager = new ConcordanceDataManager();
				
				
				if(radioFile.isSelected()) {
					
					
					try {
						
						manager.createConcordanceFile(inputFile, outputFile);
						textArea.setText("A concordance was successfully made (" + inputFile.getName() + " -> " + outputFile.getName());
						
					} catch (NullPointerException e) { 
						
						if(inputFile == null && outputFile == null) {
							textArea.setText("Neither an input nor an output file was specified.");
						} else if(inputFile == null) {
							textArea.setText("No input file was specified.");
						} else {
							textArea.setText("No output file was specified.");
						}
						
					} catch (IOException e) {
						textArea.setText("A file could not be accessed.");
					}
					
					
				} else if (radioText.isSelected()) {
					
					
					if(!textArea.getText().equals("")) {
						
						ArrayList<String> concordance = manager.createConcordanceArray(textArea.getText());
						textArea.setText("");
						for(String line : concordance) {
							textArea.appendText(line);
						}
						
					} else {
						textArea.setText("There is nothing to create a concordance for.");
					}
					
				} else {
					textArea.appendText("No options were chosen.");
				}
				
				
			} else if (source == selOutput){
				outputFile = fileChooser.showOpenDialog(stageRef);
			} else if (source == selInput){
				inputFile = fileChooser.showOpenDialog(stageRef);
			}
			
		}
		
		
	}
	
	
	
	
}