package JavaFxOne.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PropertyDemo {
    public static void main(String[] args) {

        Integer number = 23;
        //u JavaFx se koristi JavaFxOne.property:
        IntegerProperty numberProperty = new SimpleIntegerProperty(23);
        // na JavaFxOne.property se mogu dodati i Listner
        numberProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Stara vrijednost je: " + oldValue + " a nova vrijednost je: " + newValue);
            }
        });
        // da bi pristupili vrijednosti propertija koristi se get
        System.out.println(numberProperty.get());
        // Za izmjenu vrijednosti propertija koristimo set:
        numberProperty.set(45);
        System.out.println(numberProperty.get());
        numberProperty.set(56);
    }
}
