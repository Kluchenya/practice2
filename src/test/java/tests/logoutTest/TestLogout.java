package tests.logoutTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import webdriver.DriverManager;

public class TestLogout extends FunctionalTest {

    @Test
    public void logoutTest(){
        app.login(app.user);
        app.tweetPage.logout();
        Assert.assertEquals("Twitter. It's what's happening.", DriverManager.getInstance().getDriver().getTitle());
    }
}
