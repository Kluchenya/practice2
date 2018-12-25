package business.model;

import java.util.List;

public class LangSettings {

    private String login;
    private String password;
    private List<String> lang;
    private List<String> alertMsg;

    public List<String> getAlertMsg() {
        return alertMsg;
    }

    public void setAlertMsg(List<String> alertMsg) {
        this.alertMsg = alertMsg;
    }

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

    public List<String> getLang() {
        return lang;
    }

    public void setLang(List<String> lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "LangSettings{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", alertMsg=" + alertMsg +
                ", lang=" + lang +
                '}';
    }
}
