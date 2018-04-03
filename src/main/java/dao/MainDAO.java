package dao;

import database.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MainDAO {

    protected Connection connection;
    private String query;
    private Statement statement;
    protected ResultSet resultSet;


    public MainDAO() {
        this.connection = DbConnection.getConnection();
    }


    protected void executeQuery() throws SQLException { //connectAndSelect()

        this.statement = getConnection().createStatement();
        this.resultSet = this.statement.executeQuery(this.query);
    }


    protected void selectQuery(String query) {  //setQuery()
        this.query = query;
    }


    protected void executeUpdate() { //connectAndManipulate()
        try {
            this.statement = connection.createStatement();
            this.statement.executeUpdate(this.query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.endAllConnections();
        }
    }

    protected void endAllConnections()  {
        try {
            this.statement.close();
            this.resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        return this.connection;
    }
}
