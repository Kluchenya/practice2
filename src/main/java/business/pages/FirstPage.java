package business.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.utils.Logging.Log;

public class FirstPage extends PageObject {

    @FindBy(className="StaticLoggedOutHomePage-buttonLogin")
    private WebElement firstLoginButton;

    public void clickOnLogin(){
        try{
        this.firstLoginButton.click();
        }catch (Exception e){
            Log.error("Error not found WebElement" + firstLoginButton);
        }
    }
}
