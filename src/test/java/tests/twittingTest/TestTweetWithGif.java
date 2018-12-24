package tests.twittingTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestTweetWithGif extends FunctionalTest {

    @Test
    public void tweetWithGifTest(){

        app.login("7803691@gmail.com","1q2w3e");
        app.tweetPage
                .writeTweetWithGif(RandomStringUtils.randomAlphanumeric(6),"JackRussel");
    }
}
