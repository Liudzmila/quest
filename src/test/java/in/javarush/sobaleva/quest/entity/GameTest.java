package in.javarush.sobaleva.quest.entity;

import in.javarush.sobaleva.quest.entity.Answer;
import in.javarush.sobaleva.quest.entity.Game;
import in.javarush.sobaleva.quest.entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        // Create a list of questions and answers
        List<Question> questions = new ArrayList<>();

        List<Answer> answers1 = new ArrayList<>();
        answers1.add(new Answer(1, "Answer 1.1", 2)); // Next question ID is 2
        answers1.add(new Answer(2, "Answer 1.2", 3)); // Next question ID is 3
        questions.add(new Question(1, "Question 1", answers1));

        List<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer(1, "Answer 2.1", 4)); // Next question ID is 4
        answers2.add(new Answer(2, "Answer 2.2", 5)); // Next question ID is 5
        questions.add(new Question(2, "Question 2", answers2));

        // Create the Game object and assign it to the game field
       game = new Game(1, "Test Game", questions);
    }

    @Test
    public void testGetId() {
        assertEquals(1, game.getId());
    }

    @Test
    public void testGetGameName() {
        assertEquals("Test Game", game.getGameName());
    }

    @Test
    public void testGetQuestions() {
        List<Question> questions = game.getQuestions();

        assertEquals(2, questions.size());

        // Verify the contents of the questions list
        assertEquals(1, questions.get(0).getId());
        assertEquals("Question 1", questions.get(0).getText());

        assertEquals(2, questions.get(1).getId());
        assertEquals("Question 2", questions.get(1).getText());

        // Verify the answers within the questions
        List<Answer> answers1 = questions.get(0).getAnswers();
        assertEquals(2, answers1.size());
        assertEquals(1, answers1.get(0).getId());
        assertEquals("Answer 1.1", answers1.get(0).getText());
        assertEquals(2, answers1.get(1).getId());
        assertEquals("Answer 1.2", answers1.get(1).getText());

        List<Answer> answers2 = questions.get(1).getAnswers();
        assertEquals(2, answers2.size());
        assertEquals(1, answers2.get(0).getId());
        assertEquals("Answer 2.1", answers2.get(0).getText());
        assertEquals(2, answers2.get(1).getId());
        assertEquals("Answer 2.2", answers2.get(1).getText());
    }
}