package JavaFxOne.confirmationDialog;

import JavaFxOne.dialog.MessageDialog;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //stage->drugi stage
        primaryStage.setTitle("Glavni prozor");
        Button button = new Button("Accept license agreement?");
        //da bi dugmic imao funkciju dodajemo listner
        EventHandler<ActionEvent> eventHandler = (e) -> {
            String title = "License agreement";
            String message = "Ovo je prozor vezan za license agreement. Da li prihvatate uslove";
            ConfirmationDialog confirmationDialog = new ConfirmationDialog(title, message);
            boolean answer = confirmationDialog.show();
            if (answer) {
                new MessageDialog("Info", "Sve prihvatam samo me primi").show();
            } else {
                new MessageDialog("Info", "Ne pada mi na pamet po vašim uslovima").show();
            }
        };
        button.setOnAction(eventHandler);

        StackPane stackPane = new StackPane();
        ObservableList<Node> children = stackPane.getChildren();
        children.add(button);

        Scene scene = new Scene(stackPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
