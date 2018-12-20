package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReTweetPage extends PageObject {

    @FindBy(id="retweet-with-comment")
    private WebElement reTweetBox;
    @FindBy(css = "span.RetweetDialog-tweetActionLabel")
    private WebElement reTweetButton;

    public void addComment(String comment){
        this.reTweetBox.sendKeys(comment);
        this.reTweetButton.click();
    }
}
