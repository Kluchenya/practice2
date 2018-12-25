package tests.loginTest;

import model.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import tests.loginTest.data.DataForLoginTest;
import utils.JSHelper;
import utils.PropertyManager;
import webdriver.DriverManager;

public class TestLoginCloseTab extends FunctionalTest {

    @Test(dataProvider = "dataLogin", dataProviderClass = DataForLoginTest.class)
    public void testLoginCloseTab(Login login) {
        app.corrLogin(login);
        JSHelper.OpenNewTab();
        app.servicePage.switchTab(0);
        app.servicePage.closeTab();
        app.servicePage.switchTab(0);
        DriverManager.getInstance().getDriver().get(PropertyManager.getInstance().getUrl());
        Assert.assertEquals(login.getTitleTwitter(), DriverManager.getInstance().getDriver().getTitle());
    }
}
