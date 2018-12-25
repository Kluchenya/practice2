package tests.twittingTest;


import business.model.Tweet;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import tests.twittingTest.data.DataForTweet;

public class TestSimpleTweet extends FunctionalTest {

    @Test(dataProvider = "tweetData", dataProviderClass = DataForTweet.class)
    public void testSimpleTweet(Tweet tweet) {
        app.login(tweet.getLogin(),tweet.getPassword());
        app.tweetPage.writeSimpleTweet(tweet.getTweetText());
        app.tweetPage.getMessageFromLastTweet();
        Assert.assertEquals(tweet.getTweetText(), app.tweetPage.getMessageFromLastTweet());
        app.tweetPage.logout();
    }

}
