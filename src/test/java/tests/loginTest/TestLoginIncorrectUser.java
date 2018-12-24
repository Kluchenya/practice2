package tests.loginTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestLoginIncorrectUser extends FunctionalTest {

    private final String errMsg = "Нам не удалось подтвердить ваши данные. Проверьте их ещё раз и попробуйте снова.";

    @Test
    public void loginIncorrectUserTest(){
        app.login("7803691", "1q2w3e");
        Assert.assertEquals(errMsg,app.loginPage.getErrorMessage());
    }

}
