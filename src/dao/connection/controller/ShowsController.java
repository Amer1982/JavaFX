package dao.connection.controller;

import dao.ShowsDao;
import dao.connection.ConnectionPool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Shows;

import java.sql.SQLException;
import java.util.List;

public class ShowsController {

    public ObservableList<Shows> loadShows(){
        ObservableList<Shows> showsObservableList = FXCollections.observableArrayList();
        try {
            ConnectionPool connectionPool = new ConnectionPool();
            ShowsDao showsDao = new ShowsDao(connectionPool);
            List<Shows> showsList = showsDao.retrieveAll();
            showsObservableList.addAll(showsList);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return showsObservableList;
    }
}
