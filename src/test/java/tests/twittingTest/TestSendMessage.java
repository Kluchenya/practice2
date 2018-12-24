package tests.twittingTest;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.FunctionalTest;


//@Listeners({ScreenShotOnFailure.class})
public class TestSendMessage extends FunctionalTest {
    @Test
    @Parameters({"login_1" ,"password_1","message"})
    public void testSendMessage(@Optional("7803691@gmail.co") String login, @Optional("1q2w3e") String password,@Optional("Optional") String message) {
        app.login(app.user);
        app.tweetPage.newMessage();

        app.messagePage.openMessageWindow();



        app.messagePage.sendMessage("@testAcc02011488",message);

        System.out.println("last message Text= "+ app.messagePage.getTextLastMessage());

        Assert.assertEquals(message, app.messagePage.getTextLastMessage());

        app.messagePage.closeMessageWindow();


        app.tweetPage.logout();
    }
}
