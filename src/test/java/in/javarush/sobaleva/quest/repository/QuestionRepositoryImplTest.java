package in.javarush.sobaleva.quest.repository;

import in.javarush.sobaleva.quest.entity.Game;
import in.javarush.sobaleva.quest.entity.GameBuilder;
import in.javarush.sobaleva.quest.entity.Question;
import in.javarush.sobaleva.quest.entity.Answer;
import in.javarush.sobaleva.quest.repository.QuestionRepositoryImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class QuestionRepositoryImplTest {

    public QuestionRepositoryImpl repository;

    @BeforeEach
    public void setUp() {
        // Mock the QuestionRepositoryImpl
        repository = Mockito.mock(QuestionRepositoryImpl.class);

        // Create a mock JSON object for testing purposes
        JSONObject jsonGame = new JSONObject();
        jsonGame.put("id", 1);
        jsonGame.put("name", "Sample Game");

        JSONArray jsonQuestions = new JSONArray();

        // Create a sample JSON question with answers
        JSONObject jsonQuestion1 = new JSONObject();
        jsonQuestion1.put("id", 1);
        jsonQuestion1.put("text", "Question 1");

        JSONArray jsonAnswers1 = new JSONArray();
        JSONObject jsonAnswer1_1 = new JSONObject();
        jsonAnswer1_1.put("id", 1);
        jsonAnswer1_1.put("text", "Answer 1-1");
        jsonAnswer1_1.put("nextQuestionId", 2); // Add nextQuestionId field
        jsonAnswers1.put(jsonAnswer1_1);

        jsonQuestion1.put("answers", jsonAnswers1);

        // Create another sample JSON question with answers
        JSONObject jsonQuestion2 = new JSONObject();
        jsonQuestion2.put("id", 2);
        jsonQuestion2.put("text", "Question 2");

        JSONArray jsonAnswers2 = new JSONArray();
        JSONObject jsonAnswer2_1 = new JSONObject();
        jsonAnswer2_1.put("id", 1);
        jsonAnswer2_1.put("text", "Answer 2-1");
        jsonAnswer2_1.put("nextQuestionId", 3); // Add nextQuestionId field
        jsonAnswers2.put(jsonAnswer2_1);

        jsonQuestion2.put("answers", jsonAnswers2);

        jsonQuestions.put(jsonQuestion1);
        jsonQuestions.put(jsonQuestion2);

        jsonGame.put("questions", jsonQuestions);

        // Mock the behavior of the getGameById method
        when(repository.getGameById(1)).thenReturn(GameBuilder.buildGameFromJson(jsonGame));
    }

    @Test
    public void testGetGameById() {
        // Call the getGameById method
        Game game = repository.getGameById(1);

        // Assertions
        assertEquals(1, game.getId());
        assertEquals("Sample Game", game.getGameName());

        List<Question> questions = game.getQuestions();
        assertEquals(2, questions.size());

        assertEquals(1, questions.get(0).getId());
        assertEquals("Question 1", questions.get(0).getText());

        assertEquals(2, questions.get(1).getId());
        assertEquals("Question 2", questions.get(1).getText());

        // Check answers for the first question
        List<Answer> answers1 = questions.get(0).getAnswers();
        assertEquals(1, answers1.size());
        assertEquals("Answer 1-1", answers1.get(0).getText());
        assertEquals(2, answers1.get(0).getNextQuestionId()); // Check nextQuestionId

        // Check answers for the second question
        List<Answer> answers2 = questions.get(1).getAnswers();
        assertEquals(1, answers2.size());
        assertEquals("Answer 2-1", answers2.get(0).getText());
        assertEquals(3, answers2.get(0).getNextQuestionId()); // Check nextQuestionId
    }
}