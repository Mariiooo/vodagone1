package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {

    public static final String DB_CONNECTION_PROPERTIES = "DbConnection.properties";
    public static final String JDBC_URL = "jdbc.url";
    public static final String JDBC_DRIVER_CLASS_NAME = "jdbc.driverClassName";

    public static Connection connection;
    public static String url;
    public static String driver;


    public static Connection getConnection() {

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        try {
            prop.load(cl.getResourceAsStream(DB_CONNECTION_PROPERTIES));

            url = prop.getProperty(JDBC_URL);
            driver = prop.getProperty(JDBC_DRIVER_CLASS_NAME);
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url);

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
