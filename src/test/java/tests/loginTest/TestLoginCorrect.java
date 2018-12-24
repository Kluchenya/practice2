package tests.loginTest;

import data.DataForTest;
import model.User;
import org.junit.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import webdriver.DriverManager;

public class TestLoginCorrect extends FunctionalTest {

    @Test(dataProvider = "dataForCorrectLogin", dataProviderClass = DataForTest.class)
    public void testLogin(User user){
        app.login(user);
        Assert.assertEquals("Twitter", DriverManager.getInstance().getDriver().getTitle());
    }
}
