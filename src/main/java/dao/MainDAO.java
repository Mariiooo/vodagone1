package dao;

import database.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MainDAO {


    protected Connection connection;


    public MainDAO() {
        this.connection = DbConnection.getConnection();
    }


    public Connection getConnection(){
        return this.connection;
    }

    protected void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
