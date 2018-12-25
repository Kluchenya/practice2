package tests.twittingTest;

import core.webdriver.DriverManager;
import org.testng.annotations.Test;
import test_setup.FunctionalTest;
import tests.twittingTest.data.DataForTweet;

public class TestReTweet extends FunctionalTest {

    @Test(dataProvider = "tweetData", dataProviderClass = DataForTweet.class)
    public void testReTweetTest(String login, String password, String message) {
        DriverManager.getInstance().getDriver().get("https://twitter.com/login");

        app.loginPage.typeUserName(login);
        app.loginPage.typePassword(password);

        app.loginPage.submitLogin();

        app.tweetPage.reTweet();

        app.reTweetPage.addComment(message);
    }
}
