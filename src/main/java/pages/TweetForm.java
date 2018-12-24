package pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;


@Name("tweet form")
@FindBy(xpath = "(//form[@class='t1-form tweet-form' and @target='tweet-post-iframe'])[1]")
public class TweetForm extends HtmlElement {

    @Name("Add image button")
    @FindBy(xpath = "")
    private Button addImageButton;


    @Name("Add gif Button")
    @FindBy(xpath = "")
    private Button addGifButton;


    @Name("Tweet button")
    @FindBy(xpath = "./div[3]/div[2]/button/span[1]")
    private Button tweetButton;


    @Name("Tweet area small")
    @FindBy(xpath = "//div[@id='tweet-box-home-timeline']")
    private TextBlock tweetArea;

    public void simpleTweet(String message){
        this.tweetArea.click();
        this.tweetArea.sendKeys(message);
        this.tweetButton.click();
    }
}
