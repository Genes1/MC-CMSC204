import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXLogin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        //setHgap and setVgap set the margins outside the components
        grid.setHgap(10); 
        grid.setVgap(10);
        //setPadding sets the spacing inside each component
        grid.setPadding(new Insets(25, 25, 25, 25)); 
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Button loginButton = new Button("Sign in");
        loginButton.setTooltip(new Tooltip("Select to print username and password"));
        //add button to an HBox to position it to the right
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginButton);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget1 = new Text();
        grid.add(actiontarget1, 1, 6);
        final Text actiontarget2 = new Text();
        grid.add(actiontarget2, 1, 7);

        //create the EventHandler class for loginButton as an anonymous inner class
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	//Here we do something with the username and password - for now just print them
            	String uname = userTextField.getText();
            	String pwd = pwBox.getText();
                actiontarget1.setFill(Color.FIREBRICK);
                actiontarget1.setText("User name: "+uname);
                actiontarget2.setFill(Color.FIREBRICK);
                actiontarget2.setText("Password:  "+pwd);
            }
        });
        
        Button exitButton = new Button("Exit");
        exitButton.setTooltip(new Tooltip("Select to close the application"));
        //add button to a second HBox to position it to the right
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(exitButton);
        grid.add(hbBtn2, 1, 5);

        //use a lambda expression for the EventHandler class for exitButton
        exitButton.setOnAction(
        		event -> {
            	 Platform.exit();
                 System.exit(0);
        		}
        	);

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

