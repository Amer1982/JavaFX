package JavaFX3.listView;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Person;

import javax.swing.*;

public class Main extends Application {
    private ListView<Person> personListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFx ListView");

        personListView = new ListView<>();
        ObservableList<Person> personObservableList = personListView.getItems();
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Aida", "Buza"));
        personObservableList.add(new Person("Amila", "Hasić"));
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Benjamin", "Knežević"));
        personObservableList.add(new Person("Amila", "Hasić"));
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Aida", "Buza"));
        personObservableList.add(new Person("Amila", "Hasić"));
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Aida", "Buza"));
        personObservableList.add(new Person("Amila", "Hasić"));
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Aida", "Buza"));
        personObservableList.add(new Person("Amer", "Jahjefendić"));

        //Omogucava nam da selektujemo vise objekata
        MultipleSelectionModel<Person> selectionModel = personListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        Button choosePersonButton = new Button("Choose person");
        choosePersonButton.setOnAction(this::favouritePersonSelect);

        VBox vBox = new VBox(10);
        ObservableList<Node> children = vBox.getChildren();
        children.addAll(personListView, choosePersonButton);

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void favouritePersonSelect(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Omiljene osobe:");
        sb.append(System.lineSeparator());
        ObservableList<Person> selectedPersons = personListView.getSelectionModel().getSelectedItems();
        for (Person person : selectedPersons) {
            sb.append(person.toString());
            sb.append(System.lineSeparator());
        }
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,sb.toString());
        System.out.println(sb.toString());
    }
}

