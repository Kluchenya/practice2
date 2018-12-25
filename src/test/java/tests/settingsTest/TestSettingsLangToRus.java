package tests.settingsTest;

import model.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestSettingsLangToRus extends FunctionalTest {

    private String alertMsg = "Спасибо, ваши настройки сохранены.";

    @Test
    public void SettingsLangTest(Login login){
        app.corrLogin(login);
        app.tweetPage.changeLangSettings("1q2w3e", "ru");
        Assert.assertEquals(alertMsg, app.tweetPage.getTextFromAlertAfterChange());
    }
}
