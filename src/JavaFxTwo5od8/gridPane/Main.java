package JavaFxTwo5od8.gridPane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX GridPane");
        GridPane formGridPane = new GridPane();
        formGridPane.setPadding(new Insets(10));
        GridPane.setMargin(formGridPane, new Insets(20));
        formGridPane.setVgap(8);
        formGridPane.setHgap(10);


        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Enter username");
        GridPane.setConstraints(usernameTextField, 1, 0);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0,1);

        PasswordField passTextField = new PasswordField();
        passTextField.setPromptText("Enter password");
        GridPane.setConstraints(passTextField, 1, 1);

        Button loginButton=new Button("Login");
        GridPane.setConstraints(loginButton, 1,2);

        ObservableList<Node> children = formGridPane.getChildren();
        children.addAll(usernameLabel, usernameTextField, passLabel, passTextField, loginButton);

        Scene scene = new Scene(formGridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}