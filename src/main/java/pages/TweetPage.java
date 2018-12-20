package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.JSHelper;
import utils.Logging.Log;

import java.util.List;

import static utils.JSHelper.*;

public class TweetPage extends PageObject {

    @FindBy(xpath = "//div[@id='tweet-box-home-timeline']")
    private WebElement tweetBoxSmall;
    @FindBy(id = "tweet-box-home-timeline")
    private WebElement tweetBoxBig;
    @FindBy(xpath="//button[contains(@class,'tweet-action EdgeButton EdgeButton--primary js-tweet-btn')]")
    private WebElement tweetButton;
    @FindBy(xpath="//div[contains(@class,'home-tweet-box')]/form/div[3]/div[1]/span[1]")
    private WebElement addImageButton;
    @FindBy(xpath="//div[contains(@class,'home-tweet-box')]/form/div[3]/div[1]/span[2]")
    private WebElement addGifButton;
    @FindBy(xpath ="//div[contains(@class,'home-tweet-box')]/form/div[3]/div[1]/span[2]//div[contains(@class,'FoundMediaSearch-results')]")
    private WebElement gifSearchBox;
    @FindBy(xpath="(//li[@data-item-type='tweet'])[1]//div[2]/p")
    private WebElement lastTweetText;
    @FindBy(xpath="//div[@id='timeline']/div[4]/div[2]/ol/li")
    private List<WebElement> twitts;
    @FindBy(xpath="(//div[@class='stream-item-footer']/div[2]/div[2]/button)[1]")
    private WebElement reTweetButton;
    @FindBy(className="global-dm-nav")
    private WebElement messageButton;
    @FindBy(id = "user-dropdown-toggle")
    private WebElement userMenuButton;
    @FindBy(xpath="//li[@id='signout-button']")
    private WebElement logoutButton;
    @FindBy(className="StaticLoggedOutHomePage-buttonLogin")
    private WebElement firstButtonSmartLogin;
    @FindBy(className="new-tweets-bar")
    private WebElement newTweetBar;
    @FindBy(xpath="//div[contains(@class,'timeline-end has-items')]//button")
    private WebElement endOfPage;
    @FindBy(xpath="(//li[@data-item-type='tweet'])[1]//img[@data-aria-label-part]")
    private WebElement lastAddedImage;


    public void writeSimpleTweet(String message){
        this.tweetBoxSmall.click();
        this.tweetBoxBig.sendKeys(message);
        this.tweetButton.click();
        wait.until(ExpectedConditions.visibilityOf(this.newTweetBar));
    }

    public void writeTweetWithImage(String message, String pathToFile){
        this.tweetBoxSmall.click();
        this.tweetBoxBig.sendKeys(message);
        this.addImageButton.sendKeys(pathToFile);
        this.tweetButton.click();
        wait.until(ExpectedConditions.visibilityOf(this.newTweetBar));
    }

    public void reTweet(){
        this.reTweetButton.click();
    }

    public void newMessage (){
        this.messageButton.click();
    }

    public String getMessageFromLastTweet(){
        return this.lastTweetText.getText();
    }

    public Boolean imagePresntInTwitt(){
        WebElement image = this.lastAddedImage;
        if(image.isDisplayed()){
            System.out.println("Image is present"+image.getText());
            return true;
        }else {
            System.out.println("Image is`t present");
            return false;
        }
    }

    public void writeTweetWithGif(String message){
        this.tweetBoxSmall.click();
        this.tweetBoxBig.sendKeys(message);
        this.addGifButton.click();
        JSHelper.HighlightElement(gifSearchBox);
        JSHelper.MoveMouseToPosition(615,483);
        wait.until(ExpectedConditions.visibilityOf(gifSearchBox));
        this.tweetButton.click();
        wait.until(ExpectedConditions.visibilityOf(this.newTweetBar));
    }

    public void logout(){
        try {
            HighlightElement(this.userMenuButton);
        }catch (Exception ignored){
        }
        try{
            this.userMenuButton.click();
        }catch (Exception ignored){
        }
        try {
            this.logoutButton.click();
        }catch (Exception e){
            Log.error("Error while click on " + this.logoutButton);
        }
        try {
            wait.until(ExpectedConditions.visibilityOf(this.firstButtonSmartLogin));
        }catch (Exception e){
            Log.error("Error wait element" + this.firstButtonSmartLogin);
        }
    }


    public Integer getCountOfTwitts() {
        ScrollPageDown();
        wait.until(ExpectedConditions.visibilityOf(this.endOfPage));
        ScrollPageUp();
        return twitts.size();
    }



}
