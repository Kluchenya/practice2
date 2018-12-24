package tests.twittingTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestTweetWithLinkIncorr extends FunctionalTest {

    private final String errMsg = "ERR_NAME_NOT_RESOLVED";

    @Test
    public void tweetWithLinkIncorrTest(){
        app.login("7803691@gmail.com","1q2w3e");
        app.tweetPage.writeSimpleTweet("https://www.onliner.cy");
        app.tweetPage.clickOnLinkLastTweet();
        app.servicePage.switchTab(1);
        Assert.assertEquals(errMsg,app.errorPage.getErrorCodeText());
    }
}
