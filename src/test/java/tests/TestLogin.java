package tests;

import data.DataForTest;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestLogin extends FunctionalTest {

    @Test(dataProvider = "dataForLogin", dataProviderClass = DataForTest.class)
    public void testLogin(String login, String password){
        app.login(login, password);
        app.tweetPage.logout();
    }
}
