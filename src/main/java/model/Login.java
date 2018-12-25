package model;

public class Login {

    private String corrLogin;
    private String corrPassword;
    private String inCorrEmail;
    private String inCorrUserName;
    private String inCorrPassword;
    private String titleTwitter;
    private String errMsgEmail;
    private String errMsgUser;


    public String getCorrLogin() {
        return corrLogin;
    }

    public void setCorrLogin(String corrLogin) {
        this.corrLogin = corrLogin;
    }

    public String getCorrPassword() {
        return corrPassword;
    }

    public void setCorrPassword(String corrPassword) {
        this.corrPassword = corrPassword;
    }

    public String getInCorrEmail() {
        return inCorrEmail;
    }

    public void setInCorrEmail(String inCorrEmail) {
        this.inCorrEmail = inCorrEmail;
    }

    public String getInCorrUserName() {
        return inCorrUserName;
    }

    public void setInCorrUserName(String inCorrUserName) {
        this.inCorrUserName = inCorrUserName;
    }

    public String getInCorrPassword() {
        return inCorrPassword;
    }

    public void setInCorrPassword(String inCorrPassword) {
        this.inCorrPassword = inCorrPassword;
    }

    public String getTitleTwitter() {
        return titleTwitter;
    }

    public void setTitleTwitter(String titleTwitter) {
        this.titleTwitter = titleTwitter;
    }

    public String getErrMsgEmail() {
        return errMsgEmail;
    }

    public void setErrMsgEmail(String errMsgEmail) {
        this.errMsgEmail = errMsgEmail;
    }

    public String getErrMsgUser() {
        return errMsgUser;
    }

    public void setErrMsgUser(String errMsgUser) {
        this.errMsgUser = errMsgUser;
    }

    @Override
    public String toString() {
        return "Login{" +
                "corrLogin='" + corrLogin + '\'' +
                ", corrPassword='" + corrPassword + '\'' +
                ", inCorrEmail='" + inCorrEmail + '\'' +
                ", inCorrUserName='" + inCorrUserName + '\'' +
                ", inCorrPassword='" + inCorrPassword + '\'' +
                ", titleTwitter='" + titleTwitter + '\'' +
                ", errMsgEmail='" + errMsgEmail + '\'' +
                ", errMsgUser='" + errMsgUser + '\'' +
                '}';
    }
}
