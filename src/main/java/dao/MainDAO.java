package dao;

import database.DbConnection;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class MainDAO {

    protected Connection connection;

    public MainDAO() {
        this.connection = DbConnection.getConnection();
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

    protected abstract List<User> executeGetQuery(String query);

    public Connection getConnection(){
        return this.connection;
    }
}
