package business.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import core.utils.Logging.Log;

import static core.utils.JSHelper.HighlightElement;

public class TweetPage extends PageObject {

    @FindBy(xpath = "//div[@id='tweet-box-home-timeline']")
    private WebElement tweetBoxSmall;
    @FindBy(id = "tweet-box-home-timeline")
    private WebElement tweetBoxBig;
    @FindBy(xpath="(//form/div[3]/div[2])[1]/button")
    private WebElement tweetButton;
    @FindBy(xpath="//div[@id='timeline']/div[2]/div/form/div[3]/div[1]/span[1]/div/div/label/input")
    private WebElement addImageButton;
    @FindBy(xpath = "//img[contains(@class,'ComposerThumbnail-image')]")
    private WebElement previewImage;
    //Block GIG
    @FindBy(xpath="//div[@id='timeline']/div[2]/div/form/div[3]/div[1]/span[2]/div/button")
    private WebElement addGifButton;
    @FindBy(xpath = "//div[@id='timeline']/div[2]/div/form/div[3]/div[1]/span[2]//input")
    private WebElement inputGifText;
    @FindBy(xpath ="(//div[@id='timeline']/div[2]/div/form/div[3]/div[1]/span[2]/div/div/div[2]//div[contains(@class,'FoundMediaSearch-column')][1]/div/button)[1]")
    private WebElement firstGif;
    @FindBy(xpath = "//img[contains(@class,'ComposerThumbnail-image')]")
    private WebElement previewGif;
    @FindBy(xpath = "//div[contains(@class,'Icon Icon--close Icon--smallest')]")
    private WebElement closeGifPreview;
    @FindBy(xpath = "(//li[@data-item-type='tweet'])[1]/div/div[2]/div[3]//video")
    private WebElement gifInLastTweet;

    //Service block
    @FindBy(xpath = "(//li[@data-item-type='tweet'])[1]//div[2 ]/p")
    private WebElement lastTweetText;
    @FindBy(xpath = "(//li[@data-item-type='tweet'])[1]//div[2 ]/p/a")
    private WebElement lastTweetLink;
    @FindBy(xpath = "//a[contains(@class,'DashboardProfileCard-screennameLink')]")
    private WebElement userName;


    //Buttons
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

    //Block for change lang settings
    @FindBy(xpath = "//a[contains(@class,'js-nav') and contains(@data-nav,'settings')]")
    private WebElement settingsButton;
    @FindBy(xpath = "//select[@id='user_lang']")
    private WebElement langSelect;
    @FindBy(id = "settings_save")
    private WebElement saveSettingsButton;
    @FindBy(xpath = "//div[@id='password_dialog-dialog']//input")
    private WebElement inputPasswordOnChange;
    @FindBy(xpath = "//div[@id='password_dialog-dialog']//button[@id='save_password']")
    private WebElement saveChangesButton;
    @FindBy(xpath = "//div[@id='settings-alert-box']/h4")
    private WebElement alertAfterChangeLng;


    //Block for delete last tweet
    @FindBy(xpath = "(//li[@data-item-type='tweet'])[1]//span[contains(@class,'Icon--caretDownLight Icon--small')]")
    private WebElement tweetMenuButton;
    @FindBy(xpath = "(//li[@data-item-type='tweet'])[1]/div[1]/div[2]/div[1]/div/div/div/ul/li[6]")
    private WebElement deleteInMenuTweetButton;
    @FindBy(xpath = "//div[contains(@id,'delete-tweet-dialog-body')]/../div[4]/button[2]")
    private WebElement deleteInModalWinButton;
    @FindBy(xpath= "//div[@id='message-drawer']//span[contains(@class,'message-text')]")
    private WebElement messageAboutDeletion;


    public String getUserName(){
        return userName.getText();
    }

    public void deleteLastTweet(){
        this.tweetMenuButton.click();
        this.deleteInMenuTweetButton.click();
        this.deleteInModalWinButton.click();
        wait.until(ExpectedConditions.visibilityOf(messageAboutDeletion));
    }

    public void writeSimpleTweet(String message){
        this.tweetBoxSmall.click();
        this.tweetBoxBig.sendKeys(message);
        this.tweetButton.click();
        wait.until(ExpectedConditions.visibilityOf(this.newTweetBar));
    }

    public void writeTweetWithImage(String message, String pathToFile) {
        this.tweetBoxSmall.click();
        this.tweetBoxBig.sendKeys(message);
        this.addImageButton.sendKeys(pathToFile);
        wait.until(ExpectedConditions.visibilityOf(this.previewImage));
        this.tweetButton.click();
        wait.until(ExpectedConditions.visibilityOf(this.newTweetBar));
    }

    public void writeTweetWithTwoImage(String message, String pathToFile, String pathToFile2) {
        this.tweetBoxSmall.click();
        this.tweetBoxBig.sendKeys(message);
        this.addImageButton.sendKeys(pathToFile);
        this.addImageButton.sendKeys(pathToFile2);
        wait.until(ExpectedConditions.visibilityOf(this.previewImage));
        this.tweetButton.click();
        wait.until(ExpectedConditions.visibilityOf(this.newTweetBar));
    }


    public void writeTweetWithGif(String message, String gifText){
        this.tweetBoxSmall.click();
        this.tweetBoxBig.sendKeys(message);
        this.addGifButton.click();
        this.inputGifText.sendKeys(gifText);
        this.firstGif.click();
        wait.until(ExpectedConditions.visibilityOf(this.closeGifPreview));
        this.tweetButton.click();
        wait.until(ExpectedConditions.visibilityOf(this.gifInLastTweet));
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

    public void clickOnLinkLastTweet(){
        this.lastTweetLink.click();
    }

    public Boolean imagePresntInTwitt(){
        WebElement image = this.lastAddedImage;
        if(image.isDisplayed()){
            Log.info("Image is present"+image.getText());
            return true;
        }else {
            Log.error("Image is`t present");
            return false;
        }
    }


    public Boolean gifPresentInLastTweet(){
        if(this.gifInLastTweet.isDisplayed()){
            Log.info("Gif present in last tweet" + this.gifInLastTweet.getText());
            return true;
        }else {
            Log.error("Gif is`t present in last tweet");
            return false;
        }
    }



    public void changeLangSettings(String password, String lang){
        this.userMenuButton.click();
        this.settingsButton.click();
        new Select(this.langSelect).selectByValue(lang);
        this.saveSettingsButton.click();
        this.inputPasswordOnChange.sendKeys(password);
        this.saveChangesButton.click();
    }


    public String getTextFromAlertAfterChangeLng(){
        return this.alertAfterChangeLng.getText();
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
}
