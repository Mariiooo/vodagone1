package dao;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO extends MainDAO {

    public UserDAO() {
        super();
    }


    protected ArrayList<User> executeGetQuery(String query) {
        ArrayList<User> users = new ArrayList<User>();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("idUser")));
                user.setUser(resultSet.getString("userName"));
                users.add(user);

            }
            resultSet.close();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }


    public ArrayList<User> getAllUsers() {

        String query = "SELECT * FROM Users";
        return executeGetQuery(query);

    }


    public int getUserId(String userName){
        String query = "SELECT idUser FROM Users WHERE name = '" + userName + "'";
        return executeGetQuery(query).get(0).getId();
    }


    public String getUsername(int idUser) {
        String query = "SELECT name FROM Users WHERE id = '" + idUser + "'";
        return executeGetQuery(query).get(0).getUsername();
    }

    public String getPassword(int idUser) {
        String query = "SELECT password FROM Users WHERE id = '" + idUser + "'";
        return executeGetQuery(query).get(0).getUsername();
    }


//    public void addNewUser(String userName) {
//        String query = "INSERT INTO Users (username, password) VALUES ('" + userName + "', 'password')";
//        super.executeUpdate(query);
//    }
//
//
//    public void deleteUser(String idUser){
//        String query = "DELETE FROM user WHERE id = " + idUser;
//        super.executeUpdate(query);
//
//
//    }













}
