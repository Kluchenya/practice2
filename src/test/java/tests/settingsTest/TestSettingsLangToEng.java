package tests.settingsTest;

import model.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;

public class TestSettingsLangToEng extends FunctionalTest {

    private String alertMsg = "Thanks, your settings have been saved.";

    @Test
    public void SettingsLangTest(Login login){
        app.corrLogin(login);
        app.tweetPage.changeLangSettings("1q2w3e", "en");
        Assert.assertEquals(alertMsg, app.tweetPage.getTextFromAlertAfterChange());
    }
}
