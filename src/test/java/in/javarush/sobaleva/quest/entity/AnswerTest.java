package in.javarush.sobaleva.quest.entity;

import in.javarush.sobaleva.quest.entity.Answer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTest {

    @Test
    public void testGetId() {
        Answer answer = new Answer(1, "Test Answer", 2);
        assertEquals(1, answer.getId());
    }

    @Test
    public void testGetText() {
        Answer answer = new Answer(1, "Test Answer", 2);
        assertEquals("Test Answer", answer.getText());
    }

    @Test
    public void testGetNextQuestionId() {
        Answer answer = new Answer(1, "Test Answer", 2);
        assertEquals(2, answer.getNextQuestionId());
    }
}