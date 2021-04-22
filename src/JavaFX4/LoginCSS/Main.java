package JavaFX4.LoginCSS;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFx");
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.CENTER);
        //Username
        Label usernameLabel = new Label("Username");
        usernameLabel.setStyle("-fx-text-fill:white;");
        //0 kolona 0 red
        GridPane.setConstraints(usernameLabel, 0, 0);
        //u pane se moze dodati i na slijedeci nacin
        // gridPane.add(usernameLabel, 0,0);

        //1 kolona 0 red
        TextField usernameField = new TextField();
        usernameField.setPromptText("Unesi username....");
        GridPane.setConstraints(usernameField, 1, 0);
        //Password
        Label passwordLabel = new Label("Password");
        passwordLabel.setId("bold-label");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Unesi lozinku..");
        GridPane.setConstraints(passwordField, 1, 1);
        //Login
        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> setUserAgentStylesheet(STYLESHEET_CASPIAN));
        Button registerButton = new Button("Register");
        registerButton.getStyleClass().add("button-blue");
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        flowPane.setHgap(20);
        flowPane.getChildren().addAll(loginButton, registerButton);
        GridPane.setConstraints(flowPane, 1, 2);
        gridPane.getChildren().addAll(usernameField, usernameLabel, passwordField, passwordLabel, flowPane);
        Scene scene = new Scene(gridPane, 600, 300);
        //Da bi ubacili css u fx koristimo:
        // scene.getStylesheets().add(Main.class.getResource("Dark.css").toExternalForm());
        //Umjesto linije iznad Intellij prepoznaje i skraceno:
        scene.getStylesheets().add("Dark.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
