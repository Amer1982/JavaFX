package JavaFxTwo5od8.comboBox;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBox extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private ChoiceBox<String> fruitChoiceBox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fruitChoiceBox = new ChoiceBox<>();
        ObservableList<String> observableItems = fruitChoiceBox.getItems();
        observableItems.addAll("Jabuka", "Limun", "Kiwi", "Jagoda", "Mandarina");
        observableItems.add("Narandža");
        observableItems.add("Borovnice");
        observableItems.add("Banana");
        observableItems.add("Ananas");
        fruitChoiceBox.setValue("Jabuka");//kada hocemo da nam je automatski selektovan jedan unos iz liste
        // ili fruitChoiceBox.setValue(observableItems.get(1));

        //listen to selection changes
        SingleSelectionModel<String> selectionModel = fruitChoiceBox.getSelectionModel();
        ReadOnlyObjectProperty<String> itemProperty = selectionModel.selectedItemProperty();
        itemProperty.addListener(((observable, oldValue, newValue) -> {
            System.out.println("Pojeli smo " + oldValue + ", sada jedemo " + newValue);
        }));

        Button buyButton = new Button("Kupi");
        buyButton.setOnAction(this::handleFruitChoice);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(50));
        ObservableList<Node> children = vBox.getChildren();
        children.addAll(fruitChoiceBox, buyButton);

        Scene scene = new Scene(vBox, 300, 300);

        primaryStage.setTitle("Fruits");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void handleFruitChoice(Event event) {
        String fruit = fruitChoiceBox.getValue();
        System.out.println("Izabrano voće: " + fruit);
    }
}
