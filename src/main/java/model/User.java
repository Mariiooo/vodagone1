package model;

public class User {

    private String user = "mario";
    private String username = "Mario Blautzik";
    private String password = "test";

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
