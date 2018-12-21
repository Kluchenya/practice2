package tests;

import data.DataForTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import utils.JSHelper;

public class TestTweetWithImage extends FunctionalTest {

    @Test(dataProvider = "dataForTweetWithImage", dataProviderClass = DataForTest.class)
    public void tweetWithImageTest(String login, String password, String message, String pathToFile) {
        app.login(login, password);
        JSHelper.WaitForPageLoad();
        app.tweetPage.writeTweetWithImage(message,pathToFile);
        Assert.assertTrue(app.tweetPage.imagePresntInTwitt());
        app.tweetPage.logout();
    }

}
