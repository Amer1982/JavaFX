package JavaFxTwo.borderPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Slaganje kontejnera unutar kontejnera");

        HBox topMenuBox = new HBox();
        Button fileButton = new Button("File");
        Button editButton = new Button("Edit");
        Button viewButton = new Button("View");
        topMenuBox.getChildren().addAll(fileButton,editButton,viewButton);

        VBox leftMenuBox = new VBox();
        Button fileButton1 = new Button("File");
        Button editButton1 = new Button("Edit");
        Button viewButton1 = new Button("View");
        leftMenuBox.getChildren().addAll(fileButton1, editButton1, viewButton1);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenuBox);
        borderPane.setLeft(leftMenuBox);


        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
