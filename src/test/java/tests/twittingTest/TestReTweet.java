package tests.twittingTest;

import business.model.Tweet;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_setup.FunctionalTest;
import tests.twittingTest.data.DataForTweet;

public class TestReTweet extends FunctionalTest {

    @Test(dataProvider = "tweetData", dataProviderClass = DataForTweet.class)
    public void testReTweetTest(Tweet tweet) {
        app.login(tweet.getLogin(),tweet.getPassword());
        app.tweetPage.reTweetClick();
        app.reTweetPage.addComment(tweet.getMessageText());
        app.servicePage.refereshPage();
        Assert.assertEquals(tweet.getMessageText(), app.tweetPage.getMessageFromLastReTweet());
    }
}
