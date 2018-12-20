package tests;

import data.DataForTest;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestTweetWithGif extends FunctionalTest {

    @Test(dataProvider = "dataForSimpleTweet", dataProviderClass = DataForTest.class)
    public void tweetWithGifTest(String login, String password, String message){
        app.login(login,password);
        app.tweetPage
                .writeTweetWithGif(message);
    }
}
