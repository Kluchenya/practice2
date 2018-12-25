package tests.loginTest;

import model.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import tests.loginTest.data.DataForLoginTest;

public class TestLoginIncorrectEmail extends FunctionalTest {

    @Test(dataProvider = "dataLogin", dataProviderClass = DataForLoginTest.class)
    public void testLoginIncorrectEmail(Login login){
        app.login(login.getInCorrEmail(),login.getInCorrPassword());
        Assert.assertEquals(login.getErrMsgEmail(),app.loginPage.getErrorMessage());
    }
}
