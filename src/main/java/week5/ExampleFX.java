package week5;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class ExampleFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        // Create a label
        Label label1 = new Label("Component 1");
        label1.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        // Create a text area (multi-line text entry box)
        TextArea textArea = new TextArea();
        textArea.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        // Create 2 buttons, and give them behaviour
        Button button1 = new Button();
        Button button2 = new Button();
        button1.setText("Click me!");
        button1.setOnAction((event) -> {
            String text = textArea.getText();
            label1.setText(text);
        });
        button2.setText("New window");
        button2.setOnAction((event) -> {
            // Create a new stage and show it
            Stage stage = new Stage();
            stage.setTitle("JavaFX Stage Window Title");
            stage.setX(500);
            stage.setY(500);
            stage.setWidth(600);
            stage.setHeight(300);
            // Try adding some new components here
            stage.showAndWait();
        });
        // Create a menu with items and behaviour
        Menu menu = new Menu("Menu");
        MenuItem menuItem1 = new MenuItem("Toggle bold");
        menu.getItems().add(menuItem1);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        final boolean[] bold = {false};
        menuItem1.setOnAction((event) -> {
            bold[0] = !bold[0];
            if (bold[0]) {
                label1.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            } else {
                label1.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
            }
        });
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textArea.getText();
                label1.setText(text);
            }
        });
        // Create the layout
        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 1);
        HBox hBox = new HBox(button1, spacer, button2);
        VBox vBox = new VBox(menuBar, label1, textArea, hBox);
        // Construct and show the main scene
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");
        primaryStage.show();
	
    }
}
