
//Example 1-1 Hello World
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class FXHelloWorldNamedClass extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        //This version implements an event-handler class and then instantiates it
        btn.setOnAction(new ButtonHandler());
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    public class ButtonHandler implements EventHandler<ActionEvent> {
    	@Override
        public void handle(ActionEvent event) {
    		
            System.out.println(" Hello World (from the Named Event Handler class)");
        }    	
    }
}