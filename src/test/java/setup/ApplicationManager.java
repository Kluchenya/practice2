package setup;

import pages.*;


public class ApplicationManager {
    public FirstPage firstPage = new FirstPage();
    public LoginPage loginPage = new LoginPage();
    public TweetPage tweetPage = new TweetPage();
    public MessagePage messagePage = new MessagePage();
    public ReTweetPage reTweetPage = new ReTweetPage();
    public ServicePage servicePage = new ServicePage();
    public ErrorPage errorPage = new ErrorPage();

    public void login(String login, String password) {
        firstPage.clickOnLogin();
        loginPage.typeUserName(login);
        loginPage.typePassword(password);
        loginPage.submitLogin();
    }
}
