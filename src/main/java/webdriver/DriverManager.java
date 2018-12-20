package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.PropertyManager;
import utils.Logging.WebDriverLogger;

import java.util.concurrent.TimeUnit;


public class DriverManager{

    private static WebDriver driver;
    private static DriverManager instance = null;
    private static ThreadLocal<WebDriver> ThreadDriver = new ThreadLocal<>();

    private DriverManager(){
    }

    public static DriverManager getInstance(){
        if (instance == null){
            instance =  new DriverManager();
            driver = instance.createDriver();
        }
        return instance;
    }

    private WebDriver createDriver() {
        driver = DriverManager.ThreadDriver.get();

        switch (PropertyManager.getInstance().getBrowser()) {
            case "chrome":
                driver = new EventFiringWebDriver(new ChromeDriver()).register(new WebDriverLogger());
                break;
            case "firefox":
                driver = new EventFiringWebDriver(new FirefoxDriver()).register(new WebDriverLogger());
                break;
        }

        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setUpDriver(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void quit(){
        driver.quit();
    }
}
