package tests.logoutTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Logout;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.FunctionalTest;
import webdriver.DriverManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestLogout extends FunctionalTest {

    @DataProvider(name = "dataLogout")
    public Iterator<Object[]> dataForLogin() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/data/logout.json"));
        String json = "";
        String line = reader.readLine();
        while(line!=null){
            json = json + line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<Logout> logouts = gson.fromJson(json, new TypeToken<List<Logout>>(){}.getType());
        return logouts.stream().map((Logout lt) -> new Object[] {lt}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "dataLogout")
    public void logoutTest(Logout logout){
        app.login(logout.getLogin(),logout.getPassword());
        app.tweetPage.logout();
        Assert.assertEquals(logout.getFirstPageTitle(), DriverManager.getInstance().getDriver().getTitle());
    }
}
