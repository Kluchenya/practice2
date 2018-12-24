package tests.twittingTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestDeleteTweet extends FunctionalTest {

    @Test
    public void deleteLastTweetTest(){
        app.login(app.user);
        String countOfTweetBefore = app.servicePage.getCountOfTweets();
        app.tweetPage.deleteLastTweet();
        app.servicePage.refereshPage();
        Assert.assertEquals(Integer.parseInt(countOfTweetBefore)-1, Integer.parseInt(app.servicePage.getCountOfTweets()));
    }
}
