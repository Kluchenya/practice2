package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DataForTest {


    public static String getRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    @DataProvider(name = "dataForCorrectLogin")
    public static Iterator<Object[]> dataForLogin() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/data/correct_user.json"));
        String json = "";
        String line = reader.readLine();
        while(line!=null){
            json = json + line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<User> user = gson.fromJson(json, new TypeToken<List<User>>(){}.getType());
        return user.stream().map((User u) -> new Object[] {u}).collect(Collectors.toList()).iterator();
    }


    @DataProvider(name = "dataForSimpleTweet")
    public static Object [][] dataForSimpleTweet(){
        String message = getRandomString();
        return new Object[][]{
                {"7803691@gmail.com","1q2w3e",message},
                //{"7835177@gmail.com","1q2w3e","Message from testAccount2"}
        };
    }


    @DataProvider(name = "dataForTweetWithImage")
    public static Object [][] dataForTweetWithImage(){
        String message = getRandomString();
        return new Object[][]{
                {"7803691@gmail.com","1q2w3e",message, "C:\\User\\admin\\Documents\\dumps\\123.jpg"},
                // {"7835177@gmail.com","1q2w3e","Message from testAccount2"}
        };
    }
}
