package tests.twittingTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import webdriver.DriverManager;

public class TestTweetWithLinkCorr extends FunctionalTest {

    @Test
    public void tweetWithLinkCorrTest(){
        app.login("7803691@gmail.com","1q2w3e");
        app.tweetPage.writeSimpleTweet("https://www.onliner.by/");
        app.tweetPage.clickOnLinkLastTweet();
        app.servicePage.switchTab(1);
        Assert.assertEquals("https://www.onliner.by/", DriverManager.getInstance().getDriver().getCurrentUrl());
    }
}
