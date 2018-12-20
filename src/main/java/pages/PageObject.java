package pages;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverManager;

public class PageObject{
    public WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 20);

    public PageObject() {
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
    }



}
