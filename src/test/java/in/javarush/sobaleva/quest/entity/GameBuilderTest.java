package in.javarush.sobaleva.quest.entity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameBuilderTest {
    @Test
    public void testBuildGameFromJson() {
        // Create a sample JSON object
        JSONObject jsonGame = new JSONObject();
        jsonGame.put("id", 1);
        jsonGame.put("name", "Sample Game");

        // Create an array of JSON questions
        JSONArray jsonQuestions = new JSONArray();

        // Create a sample JSON question
        JSONObject jsonQuestion = new JSONObject();
        jsonQuestion.put("id", 1);
        jsonQuestion.put("text", "What is your favorite color?");

        // Create an array of JSON answers for the question
        JSONArray jsonAnswers = new JSONArray();

        // Create sample JSON answers
        JSONObject jsonAnswer1 = new JSONObject();
        jsonAnswer1.put("id", 1);
        jsonAnswer1.put("text", "Red");
        jsonAnswer1.put("nextQuestionId", 2);

        JSONObject jsonAnswer2 = new JSONObject();
        jsonAnswer2.put("id", 2);
        jsonAnswer2.put("text", "Blue");
        jsonAnswer2.put("nextQuestionId", 3);

        // Add answers to the question
        jsonAnswers.put(jsonAnswer1);
        jsonAnswers.put(jsonAnswer2);

        // Add answers array to the question
        jsonQuestion.put("answers", jsonAnswers);

        // Add the question to the questions array
        jsonQuestions.put(jsonQuestion);

        // Add questions array to the game
        jsonGame.put("questions", jsonQuestions);

        // Call the method to build the Game
        Game game = GameBuilder.buildGameFromJson(jsonGame);

        // Assertions
        assertEquals(1, game.getId());
        assertEquals("Sample Game", game.getGameName());
        assertEquals(1, game.getQuestions().size()); // Ensure that there is one question in the game
        assertEquals("What is your favorite color?", game.getQuestions().get(0).getText());
        assertEquals("Red", game.getQuestions().get(0).getAnswers().get(0).getText());
        assertEquals("Blue", game.getQuestions().get(0).getAnswers().get(1).getText());
        assertEquals(2, game.getQuestions().get(0).getAnswers().size()); // Ensure that there are two answers for the question
    }
}