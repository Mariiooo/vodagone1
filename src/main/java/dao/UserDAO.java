package dao;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserDAO extends MainDAO {

    public UserDAO() {
        super();
    }

    protected List<User> executeGetQuery(String query) {
        List<User> users = new LinkedList<User>();
        try {

            Statement statement = getConnection().createStatement();
            System.out.println(" statement  connected??  " + statement);
            ResultSet resultSet = statement.executeQuery(query);

            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("idUser")));
                user.setUser(resultSet.getString("name"));
                users.add(user);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public List<User> getAllUsers() {

        String query = "SELECT * FROM users";
        return executeGetQuery(query);

    }


    public int getUserId(String name){
        String query = "SELECT idUser FROM users WHERE name = '" + name + "'";
        return executeGetQuery(query).get(0).getId();
    }

    public String getUsername(int idUser) {
        String query = "SELECT name FROM users WHERE id = '" + idUser + "'";
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
