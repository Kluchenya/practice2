package tests.loginTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestLoginIncorrectEmail extends FunctionalTest {
    private final String errMsg = "Введенные адрес электронной почты и пароль не совпадают с сохраненными в нашей базе данных. Проверьте правильность введенных данных и повторите попытку.";
    @Test
    public void testLoginIncorrectEmail(){
        app.login(app.user);
        Assert.assertEquals(errMsg,app.loginPage.getErrorMessage());
    }
}
