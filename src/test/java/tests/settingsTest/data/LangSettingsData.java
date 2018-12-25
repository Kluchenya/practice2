package tests.settingsTest.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import business.model.LangSettings;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LangSettingsData {

    @DataProvider(name = "langSettingsData")
    public Iterator<Object[]> dataForLogin() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/data/langSettings.json"));
        String json = "";
        String line = reader.readLine();
        while(line!=null){
            json = json + line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<LangSettings> langSettings = gson.fromJson(json, new TypeToken<List<LangSettings>>(){}.getType());
        return langSettings.stream().map((LangSettings ls) -> new Object[] {ls}).collect(Collectors.toList()).iterator();
    }
}
