package tests.twittingTest;

import business.model.Tweet;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import tests.twittingTest.data.DataForTweet;

public class TestDeleteTweet extends FunctionalTest {

    @Test(dataProvider = "tweetData", dataProviderClass = DataForTweet.class)
    public void deleteLastTweetTest(Tweet tweet){
        app.login(tweet.getLogin(), tweet.getPassword());
        String countOfTweetBefore = app.servicePage.getCountOfTweets();
        app.tweetPage.deleteLastTweet();
        app.servicePage.refereshPage();
        Assert.assertEquals(Integer.parseInt(countOfTweetBefore)-1, Integer.parseInt(app.servicePage.getCountOfTweets()));
    }
}
