package database;

import java.util.*;
import java.sql.*;

public class DbConnection {

    public static Connection connection;
    public static String url;
    public static String username;
    public static String password;
    public static String driver;


    public static Connection getConnection() {

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        try {
            prop.load(cl.getResourceAsStream("DbConnection.properties"));

            url = prop.getProperty("jdbc.url");
            username = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            driver = prop.getProperty("jdbc.driverClassName");

            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, username, password);


            return connection;
        } catch (Exception ex) {
            try {
                connection.close();
            } catch (Exception e) {
                ex.printStackTrace();
            }
        }
        return null;

    }


}
