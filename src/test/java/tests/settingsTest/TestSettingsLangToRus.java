package tests.settingsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestSettingsLangToRus extends FunctionalTest {

    private String alertMsg = "Спасибо, ваши настройки сохранены.";

    @Test
    public void SettingsLangTest(){
        app.login(app.user);
        app.tweetPage.changeLangSettings("1q2w3e", "ru");
        Assert.assertEquals(alertMsg, app.tweetPage.getTextFromAlertAfterChange());
    }
}
