package _solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class FXMainPane extends VBox {
	Label addTownLabel, townNameLabel, addRoadLabel, roadNameLabel, selectTownsForRoadLabel, findConnectionLabel, findConnectionFromLabel, toLabel, distLabel;
	VBox addTownVBox, addRoadVBox, findConnectionVBox, bottomVBox;
	HBox addTownHBox, addRoadNameHBox, addRoadHBox, addRoadTownsHBox, findConnectionHBox, bottomHBox;
	Button addTownButton, addRoadButton, findConnectionButton, readFileButton, exitButton;
	TextField addTownTextField, addRoadTextField, specifyDistanceTextField;
	TextArea findConnectionTextArea;
	ComboBox<String> addSourceTownComboBox, addDestTownComboBox, sourceConnectionComboBox, destConnectionComboBox; 
	Insets inset, inset2, inset3;

	TownGraphManager graph;
private JFileChooser chooser;
	
	FXMainPane() {
		
		graph = new TownGraphManager();
		//add-town area
		addTownLabel = new Label("Add Town");
		addTownLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold");
		townNameLabel = new Label("Town Name: ");
		
		addTownTextField = new TextField();
		addTownTextField.setPrefColumnCount(10);
		
		addTownButton = new Button("Add Town");
		
		addTownHBox = new HBox();
		addTownHBox.getChildren().addAll(townNameLabel, addTownTextField, addTownButton);
		
		
		
		addTownVBox = new VBox();
		
		inset = new Insets(10); //for setting margins
		inset2 = new Insets(20,5,20,5);
		inset3 = new Insets(20,5,0,20);

	
		VBox.setMargin(addTownLabel, inset);
	    HBox.setMargin(townNameLabel, inset);
	    VBox.setMargin(addTownHBox, inset);
	    HBox.setMargin(addTownLabel, inset);
	    HBox.setMargin(addTownButton, inset);
	    
	    addTownHBox.setAlignment(Pos.CENTER);
	    addTownVBox.setAlignment(Pos.CENTER);
	    setAlignment(Pos.CENTER);
		
		addTownVBox.getChildren().addAll(addTownLabel, addTownHBox);
		addTownVBox.setStyle("-fx-border-color: gray;");


		//add-road area
		addRoadLabel = new Label("Add Road");
		addRoadLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold");

		roadNameLabel = new Label("Road Name: ");
		selectTownsForRoadLabel = new Label("Select towns for road                                                                                         ");
		addRoadTextField = new TextField();
		addRoadTextField.setPrefColumnCount(10);
		
		addRoadHBox = new HBox();
		addRoadHBox.getChildren().addAll(roadNameLabel, addRoadTextField);
		addRoadHBox.setAlignment(Pos.CENTER);
		
		//ArrayList<String> comboTownList = new ArrayList<>();
		//move to read handle method: comboTownList = graph.allTowns();
		addSourceTownComboBox = new ComboBox<String>();
		//move to read handle method: addSourceTownComboBox.getItems().addAll(comboTownList);
		addDestTownComboBox = new ComboBox<String>();
		//move to read handle method: addDestTownComboBox.getItems().addAll(comboTownList);
		distLabel = new Label("distance");
		specifyDistanceTextField = new TextField();
		
		addRoadButton = new Button("Add Road");
		
		addRoadTownsHBox = new HBox();
		
	    HBox.setMargin(addSourceTownComboBox, inset);
	    HBox.setMargin(addDestTownComboBox, inset);
	    HBox.setMargin(distLabel, inset);
	    HBox.setMargin(specifyDistanceTextField, inset);
	    HBox.setMargin(addRoadButton, inset);


		addRoadTownsHBox.getChildren().addAll(addSourceTownComboBox, addDestTownComboBox, distLabel, specifyDistanceTextField, addRoadButton);
		
		addRoadVBox = new VBox();
		addRoadVBox.setAlignment(Pos.CENTER);
		addRoadVBox.getChildren().addAll(addRoadLabel, addRoadHBox, selectTownsForRoadLabel,addRoadTownsHBox);

		addRoadVBox.setStyle("-fx-border-color: gray;");
		
		VBox.setMargin(addRoadLabel, inset);
	    VBox.setMargin(addRoadHBox, inset);
		VBox.setMargin(selectTownsForRoadLabel, inset);
	    HBox.setMargin(roadNameLabel, inset);
	    HBox.setMargin(addRoadTextField, inset);

	    
	    //setMargin(addRoadVBox, inset2);
	    //setMargin(addTownVBox, inset2);
		//find connection area
	    sourceConnectionComboBox = new ComboBox<String>();
	    destConnectionComboBox = new ComboBox<String>();
	    //move to read handle method: comboTownList = graph.allTowns();
		//move to read handle method: sourceTownComboBox.getItems().addAll(comboTownList);

	    findConnectionLabel = new Label("Find Connection");
	    findConnectionLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold");
		findConnectionFromLabel = new Label("Find connection from ");
		toLabel = new Label("to");
		findConnectionButton = new Button("Sets");
		findConnectionVBox = new VBox();
		findConnectionHBox = new HBox();
		findConnectionTextArea = new TextArea();
	 	findConnectionHBox.getChildren().addAll(findConnectionFromLabel, sourceConnectionComboBox, toLabel, destConnectionComboBox, findConnectionButton);
		
	 
		findConnectionVBox.getChildren().addAll(findConnectionLabel, findConnectionHBox, findConnectionTextArea);
		findConnectionVBox.setStyle("-fx-border-color: gray;");

		VBox.setMargin(findConnectionHBox, inset);
	    VBox.setMargin(findConnectionLabel, inset);
	    HBox.setMargin(findConnectionFromLabel, inset);
	    HBox.setMargin(sourceConnectionComboBox, inset);
	    HBox.setMargin(toLabel, inset);
	    HBox.setMargin(destConnectionComboBox, inset);
	    HBox.setMargin(findConnectionButton, inset);

	    findConnectionHBox.setAlignment(Pos.CENTER);
	    findConnectionVBox.setAlignment(Pos.CENTER);
		//bottom button area
	    bottomHBox = new HBox();
		readFileButton = new Button("Read File");
		exitButton =new Button("Exit");

		bottomVBox = new VBox();
		bottomVBox.getChildren().addAll(bottomHBox);
		bottomVBox.setStyle("-fx-border-color: gray;");

		bottomHBox.getChildren().addAll(readFileButton, exitButton);
		
		bottomHBox.setAlignment(Pos.CENTER);

		VBox.setMargin(bottomHBox,inset);
	    HBox.setMargin(readFileButton, inset);
	    HBox.setMargin(exitButton, inset);

		getChildren().addAll(addTownVBox, addRoadVBox, findConnectionVBox, bottomHBox);
		
		addRoadButton.setOnAction(event -> {
			//System.out.println("addRoadButton");
			Town town1, town2;
			try {
				town1 = graph.getTown(addSourceTownComboBox.getValue().toString());
				town2 = graph.getTown(addDestTownComboBox.getValue().toString());
			} catch (NullPointerException e) {
				town1 = town2 = null;
			}
			String name = addRoadTextField.getText();
			String strWeight = specifyDistanceTextField.getText();
			int weight = 0;
			try {
				if (!strWeight.equals("")) weight = Integer.parseInt(strWeight);
			}
			catch (NumberFormatException e) {
				weight = -1;
			}
			if (weight < 0)
				JOptionPane.showMessageDialog(null, "Distance must be an integer");
			else if (name.equals("")) 
				JOptionPane.showMessageDialog(null, "Road name cannot be blank");
			else if (town1 !=null && town2!=null) {
				graph.addRoad(town1.getName(), town2.getName(), weight, name);
				System.out.println("added road "+name);
				addSourceTownComboBox.setValue(null);
				addDestTownComboBox.setValue(null);
				addRoadTextField.setText("");
				specifyDistanceTextField.setText("");
			}
			else 
				JOptionPane.showMessageDialog(null, "Must select towns");
		});
		addTownButton.setOnAction(event -> {
			//System.out.println("addTownButton");
			String townName = addTownTextField.getText();
			if (townName.equals(""))
				JOptionPane.showMessageDialog(null, "Town name cannot be empty");
			else if (graph.addTown(townName)){
				addDestTownComboBox.getItems().addAll(addTownTextField.getText());
				sourceConnectionComboBox.getItems().addAll(addTownTextField.getText());
				destConnectionComboBox.getItems().addAll(addTownTextField.getText());
				addSourceTownComboBox.getItems().addAll(addTownTextField.getText()); 
				addTownTextField.setText("");
			}
			else 
				JOptionPane.showMessageDialog(null, "Problem adding town "+townName);
		});
		findConnectionButton.setOnAction(event -> {
			//System.out.println("findConnectionButton");
			Town town1, town2;
			try {
				town1 = graph.getTown(sourceConnectionComboBox.getValue().toString());
				town2 = graph.getTown(destConnectionComboBox.getValue().toString());
			} catch (NullPointerException e) {
				town1 = town2 = null;
			}
			findConnectionTextArea.setText("");
			ArrayList<String> path = graph.getPathSets(town1.getName(), town2.getName());
			if (town1.equals(town2)){
				findConnectionTextArea.appendText("Select two different towns");
			}
			else if (path.isEmpty()){
				findConnectionTextArea.appendText("You can't get there from here");
			}
			else {
				for (String s : path){
					findConnectionTextArea.appendText(s);
				}
			}
			path = null;
			graph.clearTownFields();
		});
		readFileButton.setOnAction(event -> {
			//System.out.println("readFileButton");
			try {
				readFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		exitButton.setOnAction(event -> {
       	 	Platform.exit();
       	 	System.exit(0);
		});
			
	}
	public void readFile() {
		FileChooser chooser = new FileChooser();
		File selectedFile = null;
		Scanner input;
		try {
			selectedFile = chooser.showOpenDialog(null);
			if(selectedFile != null) {
				String[] line;
				String town1, town2;
				input = new Scanner(selectedFile);
				while(input.hasNext()){
					line = input.nextLine().split(";");
					town1 = line[1];
					town2 = line[2];
					graph.addTown(town1);
					graph.addTown(town2);
					graph.addRoad(town1, town2, line[0]);
				}
				ArrayList<String> townList = graph.allTowns();
				for (String town : townList){
					addDestTownComboBox.getItems().addAll(town);
					sourceConnectionComboBox.getItems().addAll(town);
					destConnectionComboBox.getItems().addAll(town);
					addSourceTownComboBox.getItems().addAll(town); 
				}
			}	
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Couldn't read file "+selectedFile);
		}
	}
}
