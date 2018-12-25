package business.model;

public class Tweet {

    private String login;
    private String password;
    private String tweetText;
    private String messageText;
    private String pathToImage_1;
    private String pathToImage_2;
    private String comment;
    private String gifImageText;
    private String corrLink;
    private String InCorrLink;
    private String errMsgInLinkTest;

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

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getPathToImage_1() {
        return pathToImage_1;
    }

    public void setPathToImage_1(String pathToImage_1) {
        this.pathToImage_1 = pathToImage_1;
    }

    public String getPathToImage_2() {
        return pathToImage_2;
    }

    public void setPathToImage_2(String pathToImage_2) {
        this.pathToImage_2 = pathToImage_2;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGifImageText() {
        return gifImageText;
    }

    public void setGifImageText(String gifImageText) {
        this.gifImageText = gifImageText;
    }

    public String getCorrLink() {
        return corrLink;
    }

    public void setCorrLink(String corrLink) {
        this.corrLink = corrLink;
    }

    public String getInCorrLink() {
        return InCorrLink;
    }

    public void setInCorrLink(String inCorrLink) {
        InCorrLink = inCorrLink;
    }

    public String getErrMsgInLinkTest() {
        return errMsgInLinkTest;
    }

    public void setErrMsgInLinkTest(String errMsgInLinkTest) {
        this.errMsgInLinkTest = errMsgInLinkTest;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", tweetText='" + tweetText + '\'' +
                ", messageText='" + messageText + '\'' +
                ", pathToImage_1='" + pathToImage_1 + '\'' +
                ", pathToImage_2='" + pathToImage_2 + '\'' +
                ", comment='" + comment + '\'' +
                ", gifImageText='" + gifImageText + '\'' +
                ", corrLink='" + corrLink + '\'' +
                ", InCorrLink='" + InCorrLink + '\'' +
                ", errMsgInLinkTest='" + errMsgInLinkTest + '\'' +
                '}';
    }
}
