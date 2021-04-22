package JavaFX3.tableViewDBConnection;

import dao.ShowsDao;
import dao.connection.ConnectionPool;
import dao.connection.controller.ShowsController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Shows;

import java.sql.SQLException;

public class Main extends Application {
    private TableView<Shows> showsTableView;
    //forma -> kreiram jedan record u bazi..tabeli shows i da kreiram jedan record u table view
    private TextField showTitleTextField;
    private TextField numOfSeasonsTextField;
    private TextField initialYearTextField;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Table inside JavaFx");

        //Kreiranje tabele ->
        TableColumn<Shows, Integer> showIdColumn = new TableColumn<>("Show ID");
        showIdColumn.setCellValueFactory(new PropertyValueFactory<>("showId"));

        TableColumn<Shows, String> TitleColumn = new TableColumn<>("Title");
        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("showTitle"));

        TableColumn<Shows, Integer> numbSeasonsColumn = new TableColumn<>("Number of seasons");
        numbSeasonsColumn.setCellValueFactory(new PropertyValueFactory<>("numOfSeasons"));

        TableColumn<Shows, Integer> initialYearColumn = new TableColumn<>("Initial year");
        initialYearColumn.setCellValueFactory(new PropertyValueFactory<>("initialYear"));
        //
        showsTableView = new TableView<>();

        //veza između TableView<Show> i ObservableList<Show> unutar koje se nalaze podaci
        ObservableList<Shows> dataList = new ShowsController().loadShows();
        showsTableView.getItems().addAll(dataList);

        //veza između TableView<Show> i prisutnih kolona TableColumn<Show, X>
        showsTableView.getColumns().addAll(showIdColumn, TitleColumn, numbSeasonsColumn, initialYearColumn);

        //FORMA
        showTitleTextField = new TextField();
        showTitleTextField.setPromptText("Enter title...");
        numOfSeasonsTextField = new TextField();
        numOfSeasonsTextField.setPromptText("Enter num of seasons...");
        //Uz pomoc ovoga izbacujemo sve sto nije uneseno kao broj
        numOfSeasonsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null && !newValue.matches("\\d*")){
                numOfSeasonsTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        initialYearTextField = new TextField();
        initialYearTextField.setPromptText("Enter initial year...");
        //Uz pomoc ovoga izbacujemo sve sto nije uneseno kao broj
        initialYearTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null && !newValue.matches("\\d*")){
                initialYearTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        Button addShowButton = new Button("Add");
        addShowButton.setOnAction(this::onAddShowButtonClick);
        Button deleteShowButton = new Button("Delete");
        deleteShowButton.setOnAction(this::onDeleteShowButtonClick);

        HBox forma = new HBox(10);
        forma.getChildren().addAll(showTitleTextField, numOfSeasonsTextField, initialYearTextField, addShowButton, deleteShowButton);
        forma.setPadding(new Insets(12));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(showsTableView, forma);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void onDeleteShowButtonClick(ActionEvent event) {
        ObservableList<Shows> selectedShows = showsTableView.getSelectionModel().getSelectedItems();
        ObservableList<Shows> allShows = showsTableView.getItems();
        try{
            ConnectionPool connectionPool = new ConnectionPool();
            ShowsDao showsDao = new ShowsDao(connectionPool);
            for(Shows shows : selectedShows){
                showsDao.delete(shows);
            }
        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        selectedShows.forEach(allShows::remove);
    }
    private void onAddShowButtonClick(Event event){
        //Insert u tabelu u bazi
        try {
            ConnectionPool connectionPool = new ConnectionPool();
            ShowsDao showsDao = new ShowsDao(connectionPool);//CRUD
            Shows shows = new Shows();
            //showId ne
            //showTitle, numOfSeasons, initalYear
            shows.setShowTitle(showTitleTextField.getText());
            shows.setNumOfSeasons(Integer.parseInt(numOfSeasonsTextField.getText()));
            shows.setInitialYear(Integer.parseInt(initialYearTextField.getText()));
            //INSERTUJE podatke iz show objekta u tabelu shows u bazi movies
            shows = showsDao.create(shows);//sva osim showId

            showsTableView.getItems().add(shows);
            showTitleTextField.clear();
            numOfSeasonsTextField.clear();
            initialYearTextField.clear();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        //INSERT U TABELU U JavaFx
    }
}
