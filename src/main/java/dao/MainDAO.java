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

    public Connection getConnection() {
        return this.connection;
    }

    protected void selectQuery(String query) {
        this.query = query;
    }

    protected void executeQuery() throws SQLException {
        this.statement = getConnection().createStatement();
        this.resultSet = this.statement.executeQuery(this.query);
    }

    protected void executeUpdate() {
        try {
            this.statement = connection.createStatement();
            this.statement.executeUpdate(this.query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.endAllConnections();
        }
    }

    protected void endAllConnections() {
        this.closeStatement();
        this.closeResultSet();
    }

    private void closeStatement() {
        if (this.statement != null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.statement = null;
        }
    }

    private void closeResultSet() {
        if (this.resultSet != null) {
            try {
                this.resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.resultSet = null;
        }
    }
}
