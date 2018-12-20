package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Logging.Log;

import static utils.JSHelper.HighlightElement;

public class LoginPage extends PageObject {

    @FindBy(className = "js-username-field")
    private WebElement username;
    @FindBy(className = "js-password-field")
    private WebElement password;
    @FindBy(className = "EdgeButtom--medium")
    private WebElement loginButton;

    public void typeUserName(String userName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(this.username));
            HighlightElement(this.username);
            this.username.sendKeys(userName);
        } catch (Exception e) {
            Log.error("Not found element - " + this.username + e);
        }
    }

    public void typePassword(String password) {
        try {
            this.password.sendKeys(password);
        } catch (Exception e) {
            Log.error("Not found element - " + this.password);
            e.printStackTrace();
        }
    }

    public void submitLogin() {
        try {
            this.loginButton.click();
        } catch (Exception e) {
            Log.error("Not found element - " + this.loginButton);
            e.printStackTrace();
        }
    }

    public void submitSmartLoginExpectingFailure() {
        this.loginButton.submit();
    }

    public void loginAs(String userName, String password) {
        typeUserName(userName);
        typePassword(password);
    }


}
