package model;

public class Logout {

    private String login;
    private String password;
    private String firstPageTitle;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstPageTitle() {
        return firstPageTitle;
    }

    public void setFirstPageTitle(String firstPageTitle) {
        this.firstPageTitle = firstPageTitle;
    }

    @Override
    public String toString() {
        return "Logout{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstPageTitle='" + firstPageTitle + '\'' +
                '}';
    }
}
