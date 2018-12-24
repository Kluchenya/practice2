package tests.loginTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import utils.JSHelper;
import webdriver.DriverManager;

public class TestLoginCloseTab extends FunctionalTest {

    @Test
    public void testLoginCloseTab(){
        app.login("7803691@gmail.com", "1q2w3e");
        JSHelper.OpenNewTab();
        app.servicePage.switchTab(0);
        app.servicePage.closeTab();
        app.servicePage.switchTab(1);
        DriverManager.getInstance().getDriver().get("https://twitter.com/");
        Assert.assertEquals("Twitter", DriverManager.getInstance().getDriver().getTitle());
    }

}
