package tests.twittingTest;

import data.DataForTest;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestTweetWithImage extends FunctionalTest {

    @Test(dataProvider = "dataForTweetWithImage", dataProviderClass = DataForTest.class)
    public void tweetWithImageTest(String login, String password, String message, String pathToFile) {
        app.login(login, password);
        app.tweetPage.writeTweetWithImage(message,pathToFile);
        app.tweetPage.logout();
    }

}
