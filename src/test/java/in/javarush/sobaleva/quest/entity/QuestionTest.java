package in.javarush.sobaleva.quest.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class QuestionTest {
    private List<Answer> answers;
    private Question question;

    @BeforeEach
    public void setUp() {
        answers = new ArrayList<>();
        // Initialize the answers list with some test data
        answers.add(new Answer(1, "Answer 1", 2));
        answers.add(new Answer(2, "Answer 2", 3));

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
        assertNull(question.getImagePath(2, 1));
    }

    @Test
    public void testGetImagePathWithInvalidQuestionId() {
        assertNull(question.getImagePath(1, 2));
    }
}