package JavaFx1.dialog;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageDialog {
    private String title;
    private String message;

    public MessageDialog(String title, String message){
        this.message=message;
        this.title=title;
    }
    public void show(){
        // S obzirom da se radi o skroz novom stageu moramo ga ovdje kreirati
        Stage secondStage= new Stage();
        secondStage.initModality(Modality.APPLICATION_MODAL);

        Label messageLabel = new Label(message);

        Button okButton = new Button("OK");
        okButton.setOnAction(event -> secondStage.close());

        VBox vBox= new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(messageLabel,okButton);

        Scene secondScene = new Scene(vBox, 200, 200);

        secondStage.setScene(secondScene);
        secondStage.setTitle(title);
        secondStage.showAndWait();
    }
}
