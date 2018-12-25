package business.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.utils.Logging.Log;
import core.webdriver.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class ServicePage extends PageObject {

    @FindBy(xpath = "//div[contains(@class,'ProfileCardStats')]/ul/li[1]//span[2]")
    private WebElement countOfTweets;

    public String getCountOfTweets(){
        return countOfTweets.getText();
    }

    public void refereshPage(){
        DriverManager.getInstance().getDriver().navigate().refresh();
    }

    public Integer getCountOfOpenTabs(){
        List<String> tabs = new ArrayList<>(DriverManager.getInstance().getDriver().getWindowHandles());
        return tabs.size();
    }

    public void closeTab(){
        Log.info("Close tab");
        DriverManager.getInstance().getDriver().close();
    }

    public void switchTab(int i){
        List<String> tabs = new ArrayList(DriverManager.getInstance().getDriver().getWindowHandles());
        Log.info("Switch to tab id - " + tabs.get(i));
        DriverManager.getInstance().getDriver().switchTo().window(tabs.get(i));
    }

}
