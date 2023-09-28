package in.javarush.sobaleva.quest.repository;

import in.javarush.sobaleva.quest.entity.Game;
import in.javarush.sobaleva.quest.entity.GameBuilder;
import in.javarush.sobaleva.quest.entity.Question;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final String jsonFilePath;

    public QuestionRepositoryImpl(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    @Override
    public Game getGameById(int id) {
        JSONObject jsonGames = loadJsonFromFile(jsonFilePath);
        if (jsonGames != null) {
            JSONArray gamesArray = jsonGames.getJSONArray("games");
            for (int i = 0; i < gamesArray.length(); i++) {
                JSONObject jsonGame = gamesArray.getJSONObject(i);
                if (jsonGame.getInt("id") == id) {
                    Game game = GameBuilder.buildGameFromJson(jsonGame);
                    List<Question> questions = game.getQuestions();
                    for (Question question : questions) {
                        String imagePath = "images/game" + id + "/quest" + id + "question" + question.getId() + ".jpg";
                        question.setImagePath(id, question.getId(), imagePath);
                    }
                    return game;
                }
            }
        }
        return null;
    }

    private JSONObject loadJsonFromFile(String jsonFilePath) {
        JSONObject jsonQuestions = null;

        try {
            URL resourceUrl = getClass().getClassLoader().getResource(jsonFilePath);
            if (resourceUrl != null) {
                System.out.println(resourceUrl);

                try (InputStream inputStream = resourceUrl.openStream();
                     InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

                    JSONTokener tokener = new JSONTokener(reader);
                    jsonQuestions = new JSONObject(tokener);

                    System.out.println(jsonQuestions);

                }
            } else {
                System.err.println("Resource not found: " + jsonFilePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonQuestions;
    }
}