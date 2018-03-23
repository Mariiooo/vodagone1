package model;

public class User {

    //Login
    private String user = "mario";
    private String password = "test";

    // Account name
    private String username = "Mario Blautzik";

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
