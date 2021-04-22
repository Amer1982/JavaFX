package JavaFX5.GUIBinding;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GUI Binding property");
        TextField userInputTextField = new TextField();
        userInputTextField.setMaxWidth(200);
        userInputTextField.setPromptText("Unesi svoje ime...");
        Label welcomeLabel = new Label("Welcome: ");
        Label bindedLabel = new Label();
        //labelu vezemo za textfield
        HBox bottomTextBox= new HBox(welcomeLabel, bindedLabel);
        bottomTextBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10, userInputTextField, bottomTextBox);
        vBox.setAlignment(Pos.CENTER);

        StringProperty bindedLabelProperty = bindedLabel.textProperty();
        StringProperty userInputLabelProperty = userInputTextField.textProperty();
        bindedLabelProperty.bind(userInputLabelProperty);
        //Na ovaj nacin kada kucamo tekst on se vezivanjem prikazuje i u welcome labeli

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
