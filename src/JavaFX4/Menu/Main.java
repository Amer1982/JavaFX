package JavaFX4.Menu;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private BorderPane borderPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavFx MenuBar");
        borderPane = new BorderPane();
        //Menu: File
        Menu fileMenu = new Menu("_File"); //Kada zelimo da postavimo mnemonic stavljamo _ ispred slova
        ObservableList<MenuItem> menuItemObservableList = fileMenu.getItems();
        Menu newMenu = new Menu("_New");
        MenuItem newProjectMenuItem = new MenuItem("New Project..");
        newProjectMenuItem.setOnAction(event -> {
            System.out.println("New project has just been created....");
        });

        MenuItem newCloneItem = new MenuItem("Clone from Git...");
        newCloneItem.setOnAction(event -> {
            System.out.println("We have cloned a project..");
        });

        newMenu.getItems().addAll(newProjectMenuItem, newCloneItem);
        fileMenu.getItems().add(newMenu);
        menuItemObservableList.add(new MenuItem("Open Project..."));
        menuItemObservableList.add(new MenuItem("Close Project"));

        menuItemObservableList.add(new SeparatorMenuItem());//Separator korstimo da odvojimo polja linijom
        menuItemObservableList.add(new MenuItem("Settings"));
        menuItemObservableList.add(new MenuItem("Project structure"));

        menuItemObservableList.add(new SeparatorMenuItem());
        menuItemObservableList.add(new MenuItem("Exit"));

        //EDIT menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        MenuItem pasteMenuItem = new MenuItem("Paste");
        pasteMenuItem.setDisable(true);
        editMenu.getItems().add(pasteMenuItem);

        //Help menu
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLineNumbers = new CheckMenuItem("Show line numbers");
        showLineNumbers.setOnAction(event -> {
            if (showLineNumbers.isSelected()) {
                System.out.println("Program će prikazati brojeve linija..");
            } else {
                System.out.println("Program će sakriti brojeve linija...");
            }
        });
        helpMenu.getItems().add(showLineNumbers);
        //Level menu
        Menu levelMenu = new Menu("_Level");
        RadioMenuItem easyRadioMenuItem = new RadioMenuItem("Easy");
        RadioMenuItem mediumRadioMenuItem = new RadioMenuItem("Medium");
        RadioMenuItem hardRadioMenuItem = new RadioMenuItem("Hard");
        ToggleGroup toggleGroup = new ToggleGroup();
        easyRadioMenuItem.setToggleGroup(toggleGroup);
        mediumRadioMenuItem.setToggleGroup(toggleGroup);
        hardRadioMenuItem.setToggleGroup(toggleGroup);
        levelMenu.getItems().addAll(easyRadioMenuItem, mediumRadioMenuItem, hardRadioMenuItem);

        //MENU BAR
        MenuBar menuBar = new MenuBar();
        ObservableList<Menu> menuObservableList = menuBar.getMenus();
        menuObservableList.addAll(fileMenu, editMenu, levelMenu, helpMenu);
        borderPane.setTop(menuBar);
        Scene scene = new Scene(borderPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


