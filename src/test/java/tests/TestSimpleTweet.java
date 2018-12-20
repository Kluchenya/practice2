package tests;


import data.DataForTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestSimpleTweet extends FunctionalTest {

    @Test(dataProvider = "dataForSimpleTweet", dataProviderClass = DataForTest.class)
    public void testSimpleTweet(String login, String password, String message) {
        app.login(login, password);
        app.tweetPage.writeSimpleTweet(message);
        app.tweetPage.getMessageFromLastTweet();
        Assert.assertEquals(message, app.tweetPage.getMessageFromLastTweet());
        app.tweetPage.logout();
    }

}
