package tests.loginTest;

import business.model.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import tests.loginTest.data.DataForLoginTest;

public class TestLoginIncorrectUsers extends FunctionalTest {


    @Test(dataProvider = "dataLogin", dataProviderClass = DataForLoginTest.class)
    public void loginIncorrectUserTest(Login login){
        app.login(login.getInCorrUserName(),login.getInCorrPassword());
        System.out.println(login.toString());
        Assert.assertEquals(login.getErrMsgUser(),app.loginPage.getErrorMessage());
    }

}
