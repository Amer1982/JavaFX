package JavaFx2.checkBox;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private CheckBox cevapiCheckBox;
    private CheckBox pizzaCheckBox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Narudžba hrane");
        cevapiCheckBox = new CheckBox("Čevapi");
        cevapiCheckBox.setSelected(true);//Kada hocemo da je nesto automatski selektovano pri pozivanju
        pizzaCheckBox = new CheckBox("Pizza");

        Button orderButton = new Button("Izvrši narudžbu");
        orderButton.setOnAction(this::handleOrder);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        ObservableList<Node> vBoxList = vBox.getChildren();
        vBoxList.addAll(cevapiCheckBox, pizzaCheckBox, orderButton);

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleOrder(Event event) {
        String message = "User's order:" + System.lineSeparator();//Novi red na svim OS
        if (cevapiCheckBox.isSelected()) {
            message += "Čevapi" + System.lineSeparator();
        }
        if (pizzaCheckBox.isSelected()) {
            message += "Pizza" + System.lineSeparator();
        }
        System.out.println(message);
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,message);
    }
}
