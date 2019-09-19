
//Example 1-1 Hello World
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class FXHelloWorldLambdaExpression extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        //This version uses a lambda expression to implement the event-handler class for the one time it is used
        //Since setOnAction expects a parameter of type EventHandler<ActionEvent>(), the compiler can
        //coerce event to be an instance of EventHandler<ActionEvent>().
        //All fields used (non in this example) must be effectively final, meaning their values cannot be changed
        btn.setOnAction(event ->
           System.out.println("Hello World (from the Lambda Expression Event Handler)")
           );
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
}