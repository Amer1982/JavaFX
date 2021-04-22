package JavaFX3.comboBox;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private ComboBox<String> movieComboBox;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx UI");
        movieComboBox = new ComboBox<>();
        ObservableList<String> movieList = movieComboBox.getItems();
        movieList.addAll("Dead pool", "Djevojka iz kaveza", "Joker");
        movieList.add("Batman");
        movieList.addAll("Supermen", "Hitman", "Starwars");
        movieList.addAll("Lucy", "Godfather");
        movieComboBox.setPromptText("Odaberi film...");//Opcija da se prikazuje text u polju

        movieComboBox.setEditable(true);
        movieComboBox.setOnAction(this::handleMovieChoose);

        Button chooseButton = new Button("Odaberi");
        chooseButton.setOnAction(this::handleMovieChoose);

        VBox vBox = new VBox();
        ObservableList<Node> children = vBox.getChildren();
        children.addAll(movieComboBox, chooseButton);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        Scene scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    private void handleMovieChoose(Event e){
        System.out.println("Omiljeni film: " + movieComboBox.getValue());
    }
}
