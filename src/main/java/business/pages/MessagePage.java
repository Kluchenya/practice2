package business.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.utils.JSHelper.HighlightElement;
import static core.utils.JSHelper.UnhighlightElement;

public class MessagePage extends PageObject {

    @FindBy(className="dm-new-button")
    private WebElement startNewMessageButton;

    @FindBy(xpath = "(//textarea[@class='TokenizedMultiselect-input twttr-directmessage-input js-initial-focus dm-to-input'])[1]")
    private WebElement sendTo;

    @FindBy(className = "dm-initiate-conversation")
    private WebElement nextButton;

    @FindBy(id = "tweet-box-dm-conversation")
    private WebElement areaForMessage;

    @FindBy(className = "messaging-text")
    private WebElement sendButton;

    @FindBy(xpath = "//div[contains(@class,'DMActivity DMConversation js-ariaDocument')]/div[1]/div[2]/button[2]/span[1]")
    private WebElement closeMessageButton;

    @FindBy(className = "DMTokenizedMultiselectSuggestion")
    private WebElement accIsSelected;

    @FindBy(xpath = "//ul[@id='DMComposeTypeaheadSuggestions'][1]/li[2]")
    private WebElement sendMessageTo;
    
    @FindBy(xpath = "(//div[@class='DirectMessage-contentContainer'])[last()]")
    private WebElement lastMessage;

    @FindBy(className = "DMInboxItem")
    private WebElement messageFrom;

    public void openMessageWindow() {
        this.startNewMessageButton.click();
    }

    public void sendMessage(String recipient, String message){
        this.sendTo.sendKeys(recipient);
        wait.until(ExpectedConditions.visibilityOf(this.nextButton));
        this.nextButton.click();
        this.areaForMessage.sendKeys(message);
        this.sendButton.click();
    }

    public void selectSender(){
        this.messageFrom.click();
    }

    public void closeMessageWindow(){
        HighlightElement(this.closeMessageButton);
        UnhighlightElement(this.closeMessageButton);
        this.closeMessageButton.click();
    }

    public  String getTextLastMessage() {
        return this.lastMessage.getText();
    }

}
