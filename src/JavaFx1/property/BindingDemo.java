package JavaFx1.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindingDemo {
    public static void main(String[] args) {
        IntegerProperty aProp = new SimpleIntegerProperty(23);
        System.out.println("A prop vrijednost "+ aProp.get());
        IntegerProperty bProp = new SimpleIntegerProperty(34);
        aProp.bind(bProp);
        System.out.println("Nova vrijednost A prop "+ aProp.get());
        /* Jednom vezana vrijednost se ne moze mjenjati (Runtime Exception) te da bi istu promjenili moramo mjenjati B vrijednost
        aProp.set(54);
         */
        bProp.set(54);
        System.out.println("Nova nova vrijednost A prop "+ aProp.get());
    }
}
