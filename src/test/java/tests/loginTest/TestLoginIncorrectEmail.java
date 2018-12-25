package tests.loginTest;

import business.model.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_setup.FunctionalTest;
import tests.loginTest.data.DataForLoginTest;

public class TestLoginIncorrectEmail extends FunctionalTest {

    @Test(dataProvider = "dataLogin", dataProviderClass = DataForLoginTest.class)
    public void testLoginIncorrectEmail(Login login){
        app.login(login.getInCorrEmail(),login.getInCorrPassword());
        Assert.assertEquals(login.getErrMsgEmail(),app.loginPage.getErrorMessage());
    }
}
