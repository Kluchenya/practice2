package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorPage extends PageObject {

    @FindBy(xpath = "//div[contains(@class,'error-code')]")
    private WebElement errorCodeText;

    public String getErrorCodeText(){
        return this.errorCodeText.getText();
    }

}
