import in.javarush.sobaleva.quest.entity.Answer;
import in.javarush.sobaleva.quest.entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    @Mock
    private List<Answer> answers;

    private Question question;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        question = new Question(1, "Test Question", answers);
    }

    @Test
    public void testGetId() {
        assertEquals(1, question.getId());
    }

    @Test
    public void testGetText() {
        assertEquals("Test Question", question.getText());
    }

    @Test
    public void testGetAnswers() {
        assertEquals(answers, question.getAnswers());
    }

    @Test
    public void testGetNextQuestionId() {
        question.setNextQuestionId(2);
        assertEquals(2, question.getNextQuestionId());
    }

    @Test
    public void testSetImagePath() {
        question.setImagePath(1, 1, "imagePath");
        assertEquals("imagePath", question.getImagePath(1, 1));
    }

    @Test
    public void testGetImagePathWithInvalidGameId() {
        assertEquals(null, question.getImagePath(2, 1));
    }

    @Test
    public void testGetImagePathWithInvalidQuestionId() {
        assertEquals(null, question.getImagePath(1, 2));
    }
}