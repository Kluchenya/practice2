package tests.loginTest;

import data.DataForTest;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import utils.JSHelper;
import webdriver.DriverManager;

public class TestLoginCloseTab extends FunctionalTest {

    @Test(dataProvider = "dataForCorrectLogin", dataProviderClass = DataForTest.class)
    public void testLoginCloseTab(User user){
        app.login(user);
        JSHelper.OpenNewTab();
        app.servicePage.switchTab(0);
        app.servicePage.closeTab();
        app.servicePage.switchTab(0);
        DriverManager.getInstance().getDriver().get("https://twitter.com/");
        Assert.assertEquals("Twitter", DriverManager.getInstance().getDriver().getTitle());
    }

}
