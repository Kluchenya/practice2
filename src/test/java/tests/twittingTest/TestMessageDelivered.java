package tests.twittingTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test_setup.FunctionalTest;

public class TestMessageDelivered extends FunctionalTest {

    @Test
    @Parameters({"login_2", "password_2", "message"})
    public void testMessageDelivered(String login, String password, String message){
        app.login(login,password);
        app.tweetPage.newMessage();
        app.messagePage.selectSender();
        Assert.assertEquals(message, app.messagePage.getTextLastMessage());
        app.messagePage.closeMessageWindow();
        app.tweetPage.logout();
    }


}
