package core.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.utils.Logging.Log;
import core.webdriver.DriverManager;

import java.io.File;
import java.io.IOException;

public class JSHelper {

    private static WebDriver  driver = DriverManager.getInstance().getDriver();


    //*Method open new tab in browser

    public static void OpenNewTab(){
        Log.info("Open new tab in browser");
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public static void CloseCurrentTab(){
        Log.info("Close current tab");
        ((JavascriptExecutor)driver).executeScript("window.close()");
    }

    //Method takes screenshot on error
    public static void TakeScreenShot(String methodName){
        String pathToScreenshot = "d:\\Project\\practice2\\screenshots\\";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(pathToScreenshot+methodName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method wait for page full loading
    public static void WaitForPageLoad(){
        ExpectedCondition<Boolean> pageLoadCondition = driver1 ->
                ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(pageLoadCondition);
    }

    //Method to highlight element
    public static WebDriver HighlightElement(WebElement element){
        if (driver instanceof JavascriptExecutor) {
            Log.info ("Highlight element" + element.toString());
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
        }
        return driver;
    }

    //Method to unhighlight element
    public static WebDriver UnhighlightElement(WebElement element){
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border=''", element);
        }
        return driver;
    }

    //Method to move mouse cursor to
    public static void MoveMouseToPosition(int x, int y){
        Log.info("Move cursor mouse to ");
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y)
                .click()
                .build()
                .perform();
    }

    //Method scroll page down
    public static void ScrollPageDown(){
        Log.info("Scroll page to bottom");
        ((JavascriptExecutor)driver)
                .executeScript("window.scroll(0, document.body.scrollHeight|| document.documentElement.scrollHeight)","");
    }

    //Method scroll page up
    public static void ScrollPageUp(){
        Log.info("Scroll page to the top");
        ((JavascriptExecutor)driver).executeScript("window.scroll(document.body.scrollHeight, 0)");
    }
}
