package in.javarush.sobaleva.quest.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl {
    private String jsonFilePath;

    public QuestionRepositoryImpl(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    public List<JSONObject> getJsonQuestions() {
        List<JSONObject> jsonQuestions = new ArrayList<>();

        try (FileReader reader = new FileReader(jsonFilePath)) {
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject root = new JSONObject(tokener);
            JSONArray questionArray = root.getJSONArray("questions");

            for (int i = 0; i < questionArray.length(); i++) {
                JSONObject jsonQuestion = questionArray.getJSONObject(i);
                jsonQuestions.add(jsonQuestion);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Обработка ошибок чтения JSON-файла
        }

        return jsonQuestions;
    }
}