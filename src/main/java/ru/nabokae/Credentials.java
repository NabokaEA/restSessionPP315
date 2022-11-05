package ru.nabokae;

public class Credentials {
    private String UserName;
    private String password;

    public Credentials(String userName, String password) {
        UserName = userName;
        this.password = password;
    }

    public Credentials() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "UserName='" + UserName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
