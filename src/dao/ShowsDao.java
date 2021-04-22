package dao;

import dao.connection.ConnectionPool;
import model.Shows;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ShowsDao implements Dao<Shows>{
    private ConnectionPool connectionPool;

    public ShowsDao(ConnectionPool connectionPool){
        this.connectionPool = Optional
                .ofNullable(connectionPool)
                .orElseThrow(()->new RuntimeException("Null ConnectionPool is not allowed"));
    }

    @Override
    public Shows create(Shows shows) throws SQLException {
        String sqlInsert = "INSERT INTO shows (show_title, num_of_seasons, initial_year) VALUES(?,?,?)";
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS);){
            /*uz pomoc RETURN_GENERATED_KEYS baza nam vraca ID */
            ps.setString(1, shows.getShowTitle());
            ps.setInt(2, shows.getNumOfSeasons());
            ps.setInt(3, shows.getInitialYear());
            int affected = ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            while(resultSet.next()){
                int lastGeneratedKey = resultSet.getInt(1);
                shows.setShowId(lastGeneratedKey);
            }
        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        return shows;
    }

    @Override
    public Shows retrieve(int primaryKey) throws SQLException {
        String sqlQuery = "SELECT * FROM shows WHERE shows.show_id=?";
        Connection connection = connectionPool.getConnection();
        Shows shows = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);            ){
            preparedStatement.setInt(1, primaryKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int showId = resultSet.getInt(1);
                String showTitle = resultSet.getString(2);
                int numOfSeasons = resultSet.getInt(3);
                int initialYear = resultSet.getInt(4);
                shows = new Shows(showId, showTitle, numOfSeasons, initialYear);
                break;
            }
        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        connectionPool.releaseConnection(connection);
        return shows;
    }

    @Override
    public List<Shows> retrieveAll() throws SQLException {
        String sqlQuery = "SELECT *FROM shows";
        List<Shows> showsList = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sqlQuery)){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int showId = resultSet.getInt(1);
                String showTitle = resultSet.getString(2);
                int numOfSeasons = resultSet.getInt(3);
                int initialYear = resultSet.getInt(4);
                Shows shows = new Shows(showId, showTitle, numOfSeasons, initialYear);
                showsList.add(shows);
            }
        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        connectionPool.releaseConnection(connection);
        return showsList;
    }

    @Override
    public void update(Shows entity) throws SQLException {
        String sqlUpdate = "UPDATE shows SET show_title = ? WHERE show_id = ?";
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sqlUpdate)){
            ps.setString(1, entity.getShowTitle());
            ps.setInt(2, entity.getShowId());
            int number = ps.executeUpdate();
            System.out.println("Broj ažuriranih: " + number);
        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        connectionPool.releaseConnection(connection);
    }

    @Override
    public void delete(Shows shows) throws SQLException {
        String sqlDelete = "DELETE FROM shows WHERE show_id=?";
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sqlDelete)){
            ps.setInt(1, shows.getShowId());
            int affectedRows =  ps.executeUpdate();
            System.out.println("Ukupno izbrisanih: " + affectedRows);
        }catch (SQLException sqlException){
            System.err.println(sqlException.getMessage());
        }
    }


    public Vector<String> getColumnNames(){
        String sqlQuery = "SELECT *FROM shows";
        Connection connection = connectionPool.getConnection();
        Vector<String> columnNames = new Vector<>();
        try(PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = ps.executeQuery()){
            //podatke ---> metapodatke
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int numberOfColumns = resultSetMetaData.getColumnCount();
            for(int i = 1; i<=numberOfColumns; i++){
                String nameOfColumn = resultSetMetaData.getColumnName(i);
                columnNames.addElement(nameOfColumn);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        connectionPool.releaseConnection(connection);
        return columnNames;
    }
}
