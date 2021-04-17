package JavaFx2.properClosing;

import JavaFx1.confirmationDialog.ConfirmationDialog;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ProperClosing extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage=primaryStage;
        primaryStage.setTitle("Proper closing of window");
        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(event);
        });//Uz pomoc ovoga nam trazi potvrdu izlaza i na X i spasava program
        //primaryStage.setOnCloseRequest(this::closeProgram);//Uz pomoc ovoga nam trazi potvrdu izlaza i na X
        Button button = new Button("Close application");
        button.setOnAction(this::closeProgram);
        StackPane stackPane = new StackPane();
        ObservableList<Node> children = stackPane.getChildren();
        children.add(button);

        Scene scene = new Scene(stackPane, 300, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void closeProgram(Event event) {
        String title = "User confirmation";
        String message = " Operations are in progress. Are you sure?";
        ConfirmationDialog confirmationDialog = new ConfirmationDialog(title, message);
        boolean answer = confirmationDialog.show();
        if (answer) {
            System.out.println("File is saved...");
            stage.close();
        }
    }
}
