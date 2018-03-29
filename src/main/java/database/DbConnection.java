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
            System.out.println(url);

//            username = prop.getProperty("jdbc.username");
//            System.out.println(username);
//
//            password = prop.getProperty("jdbc.password");
//            System.out.println(password);

            driver = prop.getProperty("jdbc.driverClassName");
            System.out.println("Driverr           :" +driver);

            Class.forName(driver).newInstance();
            System.out.println("ik ben hier              :");
            connection = DriverManager.getConnection(url);
            System.out.println("connectie        :" + url);

            System.out.println(connection);
            return connection;
        } catch (Exception ex) {
            ex.printStackTrace();

            try {
                connection.close();
            } catch (Exception e) {
                ex.printStackTrace();
            }
        }
        return null;

    }


}
