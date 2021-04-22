package JavaFX3.treeView;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * TreeView
 * -root
 * --branch
 * ---leaf
 */

public class Main extends Application {

    private TreeView<String> treeView;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFx TreeView");

        //root
        TreeItem<String> rootItem = new TreeItem<>("Programski jezici");
        rootItem.setExpanded(false);

        //JavaBranch i JSBranch
        TreeItem<String> javaBranch = createBranch("Java", rootItem);
        createBranch("Ruby", javaBranch);
        TreeItem<String> rubyBranch = createBranch("Ruby2",javaBranch);
        createBranch("Amer", rubyBranch);
        createBranch("Scala", javaBranch);
        createBranch("Kotlin", javaBranch);

        TreeItem<String> jsBranch = createBranch("JavaScript", rootItem);
        createBranch("React.js", jsBranch);
        createBranch("Vue.js", jsBranch);
        createBranch("Angular", jsBranch);

        //IDEMO SLOŽITI STABLO
        treeView = new TreeView<>(rootItem);
        MultipleSelectionModel<TreeItem<String>> selectionModel = treeView.getSelectionModel();
        ReadOnlyObjectProperty<TreeItem<String>> property = selectionModel.selectedItemProperty();
        property.addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                System.out.println("OMILJENI jezik: " + newValue.getValue());
            }
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(treeView);

        Scene scene = new Scene(stackPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private TreeItem<String> createBranch(String title, TreeItem<String> parent){
        TreeItem<String> branchItem = new TreeItem<>(title);
        branchItem.setExpanded(true);
        parent.getChildren().add(branchItem);
        return branchItem;
    }
}

