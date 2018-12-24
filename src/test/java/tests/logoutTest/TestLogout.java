package tests.logoutTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import webdriver.DriverManager;

public class TestLogout extends FunctionalTest {

    @Test
    public void logoutTest(){
        app.login("7803691@gmail.com", "1q2w3e");
        app.tweetPage.logout();
        Assert.assertEquals("Twitter. It's what's happening.", DriverManager.getInstance().getDriver().getTitle());
    }
}
