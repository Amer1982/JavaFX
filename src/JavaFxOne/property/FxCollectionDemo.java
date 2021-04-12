package JavaFxOne.property;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class FxCollectionDemo {
    public static void main(String[] args) {
        ObservableList<Integer> matchScore = FXCollections.observableArrayList(1,2);
        matchScore.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> c) {
                System.out.format("Chelsea - Juve: %d - %d%n", c.getList().get(0), c.getList().get(1));
            }
        });
        //Kod se ispisuje kada god dode do promjene na nekom od indeksa
        matchScore.set(0,2);
        matchScore.set(1,3);
    }
}
