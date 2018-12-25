package model;

import java.util.List;

public class Tweets {

    private String login;
    private String password;
    private List<String> tweetMessage;
    private List<String> messageText;
    private List<String> pathToImage;
    private List<String> comment;


    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Tweets{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", tweetMessage=" + tweetMessage +
                ", messageText=" + messageText +
                ", pathToImage=" + pathToImage +
                ", comment=" + comment +
                '}';
    }

    public Tweets withLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Tweets withPassword(String password) {
        this.password = password;
        return this;
    }

    public List<String> getTweetMessage() {
        return tweetMessage;
    }

    public Tweets withTweetMessage(List<String> tweetMessage) {
        this.tweetMessage = tweetMessage;
        return this;
    }

    public List<String> getMessageText() {
        return messageText;
    }

    public Tweets withMessageText(List<String> messageText) {
        this.messageText = messageText;
        return this;
    }

    public List<String> getPathToImage() {
        return pathToImage;
    }

    public Tweets withPathToImage(List<String> pathToImage) {
        this.pathToImage = pathToImage;
        return this;
    }

    public List<String> getComment() {
        return comment;
    }

    public Tweets withComment(List<String> comment) {
        this.comment = comment;
        return this;
    }
}
