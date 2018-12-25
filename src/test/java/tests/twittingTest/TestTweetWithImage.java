package tests.twittingTest;

import business.model.Tweet;
import org.junit.Assert;
import org.testng.annotations.Test;
import test_setup.FunctionalTest;
import tests.twittingTest.data.DataForTweet;

public class TestTweetWithImage extends FunctionalTest {

    @Test(dataProvider = "tweetData", dataProviderClass = DataForTweet.class)
    public void tweetWithImageTest(Tweet tweet) {
        app.login(tweet.getLogin(), tweet.getPassword());
        app.tweetPage.writeTweetWithImage(tweet.getTweetText(),tweet.getPathToImage_1());
        Assert.assertTrue(app.tweetPage.imagePresntInTwitt());
        app.tweetPage.logout();
    }

}
