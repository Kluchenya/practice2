package tests.settingsTest;

import business.model.LangSettings;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import tests.settingsTest.data.LangSettingsData;

public class TestSettingsLangToRus extends FunctionalTest {

    @Test(dataProvider = "langSettingsData", dataProviderClass = LangSettingsData.class)
    public void SettingsLangTest(LangSettings langSettings){
        app.login(langSettings.getLogin(),langSettings.getPassword());
        app.tweetPage.changeLangSettings(langSettings.getPassword(), langSettings.getLang().get(0));
        Assert.assertEquals(langSettings.getAlertMsg().get(0), app.tweetPage.getTextFromAlertAfterChangeLng());
    }
}
