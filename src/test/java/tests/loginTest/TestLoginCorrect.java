package tests.loginTest;

import model.Login;
import org.junit.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import tests.loginTest.data.DataForLoginTest;
import webdriver.DriverManager;

public class TestLoginCorrect extends FunctionalTest {


    @Test(dataProvider = "dataLogin", dataProviderClass = DataForLoginTest.class)
    public void testLogin(Login login){
        app.corrLogin(login);
        Assert.assertEquals(login.getTitleTwitter(), DriverManager.getInstance().getDriver().getTitle());
        app.tweetPage.logout();
    }
}
