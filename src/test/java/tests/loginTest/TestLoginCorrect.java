package tests.loginTest;

import data.DataForTest;
import org.junit.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import webdriver.DriverManager;

public class TestLoginCorrect extends FunctionalTest {

    @Test(dataProvider = "dataForLogin", dataProviderClass = DataForTest.class)
    public void testLogin(String login, String password){
        app.login(login, password);
        Assert.assertEquals("Twitter", DriverManager.getInstance().getDriver().getTitle());
    }
}
