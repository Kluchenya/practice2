package tests.twittingTest;

import business.model.Tweet;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_setup.FunctionalTest;
import tests.twittingTest.data.DataForTweet;

public class TestTweetWithLinkIncorr extends FunctionalTest {

    @Test(dataProvider = "tweetData", dataProviderClass = DataForTweet.class)
    public void tweetWithLinkIncorrTest(Tweet tweet){
        app.login(tweet.getLogin(),tweet.getPassword());
        app.tweetPage.writeSimpleTweet(tweet.getInCorrLink());
        app.tweetPage.clickOnLinkLastTweet();
        app.servicePage.switchTab(1);
        Assert.assertEquals(tweet.getErrMsgInLinkTest(),app.errorPage.getErrorCodeText());
    }
}
