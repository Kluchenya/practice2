package tests.twittingTest;

import data.DataForTest;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import core.webdriver.DriverManager;

public class TestReTweet extends FunctionalTest {

    @Test(dataProvider = "dataForSimpleTweet",dataProviderClass = DataForTest.class)
    public void testReTweetTest(String login, String password, String message) {
        DriverManager.getInstance().getDriver().get("https://twitter.com/login");

        app.loginPage.typeUserName(login);
        app.loginPage.typePassword(password);

        app.loginPage.submitLogin();

        app.tweetPage.reTweet();

        app.reTweetPage.addComment(message);
    }
}
