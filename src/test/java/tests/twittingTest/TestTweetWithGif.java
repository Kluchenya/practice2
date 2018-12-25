package tests.twittingTest;

import business.model.Tweet;
import org.junit.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import tests.twittingTest.data.DataForTweet;

public class TestTweetWithGif extends FunctionalTest {

    @Test(dataProvider = "tweetData", dataProviderClass = DataForTweet.class)
    public void tweetWithGifTest(Tweet tweet){

        app.login(tweet.getLogin(),tweet.getPassword());
        app.tweetPage
                .writeTweetWithGif(tweet.getTweetText(),tweet.getGifImageText());
        Assert.assertTrue(app.tweetPage.gifPresentInLastTweet());
    }
}
