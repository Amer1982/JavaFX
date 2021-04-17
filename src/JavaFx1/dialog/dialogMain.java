package JavaFx1.dialog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class dialogMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("Otvori novi prozor");
        String title = "Message info";
        String message = "Text koji se prikazuje u drugom prozoru";
        button.setOnAction(event -> new MessageDialog(title, message).show());

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene1 = new Scene(stackPane, 300, 250);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("JavaFxOne.Main Stage");
        primaryStage.show();

    }
}
