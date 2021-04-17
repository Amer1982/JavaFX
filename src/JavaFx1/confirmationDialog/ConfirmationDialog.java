package JavaFx1.confirmationDialog;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Optional;

public class ConfirmationDialog {
    private boolean answer = false;
    private String title;
    private String message;

    public ConfirmationDialog(String title, String message) {
        this.title = Optional.ofNullable(title).orElseThrow(() -> new RuntimeException("Ne primam null kao title"));//Kada želimo da se ne moze proslijediti "null"
        this.message = message;
    }

    public boolean show() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(300);

        //UI kontrole
        //za statički teks koristimo Label
        Label messageLabel = new Label();
        messageLabel.setText(message);

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(event -> {
            answer=true;
            stage.close();
        });
        Button noButton = new Button("No");
        noButton.setOnAction(event -> {
            answer=false;
            stage.close();
        });
        HBox hBox= new HBox(10);
        hBox.setPadding(new Insets(10));
        ObservableList<Node> hBoxChildren = hBox.getChildren();//za dodavanje elemenata u kontejner koristimo liste
        hBoxChildren.addAll(yesButton, noButton);



        //Kontejner (VerticalBox)
        VBox vBox= new VBox(10);

        ObservableList<Node> vBoxChildren = vBox.getChildren();
        vBoxChildren.add(messageLabel);//može se dodavati jedan po jedan ili svi od jednom
        //children.addAll(yesButton, noButton); S obzirom da sam za dugmice posebno kreirao HBox ovdje ga dodajem
        vBoxChildren.add(hBox);

        //Na kraju se kreira scena i dodaju se elementi
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.showAndWait();
        return answer;
    }
}
