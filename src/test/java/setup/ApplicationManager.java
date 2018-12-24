package setup;

import model.User;
import pages.*;


public class ApplicationManager {
    public FirstPage firstPage = new FirstPage();
    public LoginPage loginPage = new LoginPage();
    public TweetPage tweetPage = new TweetPage();
    public MessagePage messagePage = new MessagePage();
    public ReTweetPage reTweetPage = new ReTweetPage();
    public ServicePage servicePage = new ServicePage();
    public ErrorPage errorPage = new ErrorPage();
    public User user = new User().withLogin("7803691@gmail.com").withPassword("1q2w3e");

    public void login(User user) {
        firstPage.clickOnLogin();
        loginPage.typeUserName(user.getLogin());
        loginPage.typePassword(user.getPassword());
        loginPage.submitLogin();
    }

    public void login(String login, String password) {
        firstPage.clickOnLogin();
        loginPage.typeUserName(login);
        loginPage.typePassword(password);
        loginPage.submitLogin();
    }

}
