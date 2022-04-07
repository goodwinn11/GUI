package week5;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
    public class HelloWorld extends Application {
        @Override
        public void start(Stage primaryStage) {
            // Create an interactable button
            Button btn = new Button();
            btn.setText("Say ’Hello World Button’");
            // This is what we refer to as when we have event driven programming
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Hello World !");
                }
            });
            // Just like our border pane, this sets the boundaries for our buttons etc.
            StackPane root = new StackPane();
            root.getChildren().add(btn);
            // Scenes take in a pane/root and the stage renders the scene
            Scene scene = new Scene(root, 300, 250);
            primaryStage.setTitle("Hello World Title!");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        public static void main(String[] args) {
            launch(args);
        } }


