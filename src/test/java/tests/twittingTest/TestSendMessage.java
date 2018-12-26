package tests.twittingTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test_setup.FunctionalTest;


public class TestSendMessage extends FunctionalTest {
    @Test
    @Parameters({"login_1", "password_1", "message", "sendToAccount"})
    public void testSendMessage(String login, String password, String message, String sendToAccount) {
        app.login(login, password);
        app.tweetPage.newMessage();
        app.messagePage.openMessageWindow();
        app.messagePage.sendMessage(sendToAccount,message);
        Assert.assertEquals(message, app.messagePage.getTextLastMessage());
        app.messagePage.closeMessageWindow();
        app.tweetPage.logout();

    }
}
