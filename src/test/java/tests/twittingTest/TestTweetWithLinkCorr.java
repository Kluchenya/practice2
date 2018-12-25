package tests.twittingTest;

import business.model.Tweet;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_setup.FunctionalTest;
import tests.twittingTest.data.DataForTweet;
import core.webdriver.DriverManager;

public class TestTweetWithLinkCorr extends FunctionalTest {

    @Test(dataProvider = "tweetData", dataProviderClass = DataForTweet.class)
    public void tweetWithLinkCorrTest(Tweet tweet){
        app.login(tweet.getLogin(),tweet.getPassword());
        app.tweetPage.writeSimpleTweet(tweet.getCorrLink());
        app.tweetPage.clickOnLinkLastTweet();
        app.servicePage.switchTab(1);
        Assert.assertEquals(tweet.getCorrLink(), DriverManager.getInstance().getDriver().getCurrentUrl());
    }
}
