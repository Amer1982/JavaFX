package JavaFx1.newScene;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class NewScene extends Application {
    private Scene Scene1;
    private Scene Scene2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//Kreiranje prve scene
        Label scene1Label = new Label("Dobrodošli na scenu 1");
        Button scene1Button = new Button("Prelazak na scenu 2");
        scene1Button.setOnAction(event -> primaryStage.setScene(Scene2));
        //Kontejner
        VBox scene1layout = new VBox(20);
        scene1layout.getChildren().addAll(scene1Label, scene1Button);
        Scene1 = new Scene(scene1layout, 700, 700);

        // Scena 2
        Label scene2Label = new Label("Dobrodošli na scenu 2");
        Button scene2Button = new Button("Vrati se na scenu 1");
        scene2Button.setOnAction(event -> primaryStage.setScene(Scene1));
        HBox scene2layout = new HBox(50);
        scene2layout.setPadding(new Insets(20,20,20,20));
        scene2layout.getChildren().addAll(scene2Label, scene2Button);
        Scene2 = new Scene(scene2layout, 400,300);

        primaryStage.setScene(Scene1);
        primaryStage.setTitle("New Scene");
        primaryStage.show();
    }
}
