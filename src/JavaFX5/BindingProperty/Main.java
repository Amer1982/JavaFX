package JavaFX5.BindingProperty;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BindingProperty");
        IntegerProperty x = new SimpleIntegerProperty(7);
        IntegerProperty y = new SimpleIntegerProperty();
        //kad god se uzme vrijednost x -> y ce uzeti 10* vecu vrijednost
        y.bind(x.multiply(10));
        System.out.println("X: "+ x.getValue());
        System.out.println("Y: "+y.getValue());
        x.setValue(9);
        System.out.println("X: "+ x.getValue());
        System.out.println("Y: "+y.getValue());

    }
}
