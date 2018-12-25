package tests.logoutTest;

import model.Login;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import webdriver.DriverManager;

public class TestLogout extends FunctionalTest {

    @DataProvider

    @Test
    public void logoutTest(Login login){
        app.corrLogin(login);
        app.tweetPage.logout();
        Assert.assertEquals("Twitter. It's what's happening.", DriverManager.getInstance().getDriver().getTitle());
    }
}
