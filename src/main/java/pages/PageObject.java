package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverManager;

class PageObject{

    private WebDriver driver = DriverManager.getInstance().getDriver();


    WebDriverWait wait = new WebDriverWait(driver, 30);

    PageObject() {
        PageFactory.initElements(driver, this);
    }

}
