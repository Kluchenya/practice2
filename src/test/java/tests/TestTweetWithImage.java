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
        System.out.println(app.tweetPage.getCountOfTwitts());
        app.tweetPage.writeTweetWithImage(message,pathToFile);
        Assert.assertTrue(app.tweetPage.imagePresntInTwitt());
        System.out.println(app.tweetPage.getCountOfTwitts());
        app.tweetPage.logout();
    }

}
