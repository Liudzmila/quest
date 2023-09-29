import in.javarush.sobaleva.quest.entity.Game;
import in.javarush.sobaleva.quest.entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1, "Вопрос 1", new ArrayList<>()));
        questions.add(new Question(2, "Вопрос 2", new ArrayList<>()));
        game = new Game(1, "Игра", questions);
    }

    @Test
    public void testGetters() {
        assertEquals(1, game.getId());
        assertEquals("Игра", game.getGameName());
        assertNotNull(game.getQuestions());
        assertEquals(2, game.getQuestions().size());
    }

}