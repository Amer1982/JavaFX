package JavaFxOne;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.event.ActionListener;

public class Main extends Application /*implements EventHandler<ActionEvent> */ {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //UI kontrole
        Button button = new Button("Klikni me");
        /*
       EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Klik na dugmic2");
            }
        };
        button.setOnAction(eventHandler);

        Umjesto konstrukcije iznad za povezivanje dugmica moze ici
         */
        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Klik na dugmic2");
            }
        });*/
/*
Ovo se moze uraditi i pomocu LAMBDA operatora

        button.setOnAction(event -> System.out.println("Ziv sam zahvaljuci LAMBDA"));*/

        /*
        ili preko Method referencing
         */
        button.setOnAction(this::handleButtonClick);

        //Kontejner
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Naša prva Fx App");
        primaryStage.show();

    }

    private void handleButtonClick(ActionEvent actionEvent) {
        System.out.println("Vozdra mala raja 2");
    }

    /*Prvi nacin da se da funkcija dugmicima je sa implements EventHandler<ActionEvent> i
     @Override metodom
         public void handle(ActionEvent event) {
        System.out.println("Vozdra mala raja 1");
    }*/
}
