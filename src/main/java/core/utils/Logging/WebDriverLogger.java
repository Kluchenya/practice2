package core.utils.Logging;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Arrays;

public class WebDriverLogger extends AbstractWebDriverEventListener {

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        Log.info("WebDriver navigated to '" + url + "'");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        Log.info("WebDriver click on element - "
                + formatWebElement(element));
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        Log.info("WebDriver try \"Send keys\" to element - "
                + formatWebElement(element) + " value: " + Arrays.asList(keysToSend).toString());
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        Log.info("WebDriver \"Send keys\" element - "
                + formatWebElement(element) + " value: " + Arrays.asList(keysToSend).toString());
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        Log.error("Error "+  throwable);
    }

    private String formatWebElement(WebElement element){
        String locator=element.toString().split("-> ")[1];
        String fLocator = locator.substring(0, locator.length()-1);
        return fLocator;
    }


}
