package tests.twittingTest.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import business.model.Tweet;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DataForTweet {
    @DataProvider(name = "tweetData")
    public Iterator<Object[]> dataForLogin() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/data/tweets.json"));
        String json = "";
        String line = reader.readLine();
        while(line!=null){
            json = json + line;
            line = reader.readLine();
        }
        String jsonReplaced = json.replaceAll("[$]\\d\\d\\d\\d\\d[$]", RandomStringUtils.randomAlphanumeric(5));
        Gson gson = new Gson();
        List<Tweet> tweets = gson.fromJson(jsonReplaced, new TypeToken<List<Tweet>>(){}.getType());
        return tweets.stream().map((Tweet tw) -> new Object[] {tw}).collect(Collectors.toList()).iterator();
    }
}
