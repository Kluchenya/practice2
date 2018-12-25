package tests.loginTest.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Login;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DataForLoginTest {

    @DataProvider(name = "dataLogin")
    public Iterator<Object[]> dataForLogin() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/data/login.json"));
        String json = "";
        String line = reader.readLine();
        while(line!=null){
            json = json + line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<Login> login = gson.fromJson(json, new TypeToken<List<Login>>(){}.getType());
        return login.stream().map((Login l) -> new Object[] {l}).collect(Collectors.toList()).iterator();
    }
}
