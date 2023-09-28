import in.javarush.sobaleva.quest.entity.Answer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTest {

    @Test
    public void testGetters() {
        Answer answer = new Answer(1, "Текст ответа", 2);

        assertEquals(1, answer.getId());
        assertEquals("Текст ответа", answer.getText());
        assertEquals(2, answer.getNextQuestionId());
    }
}