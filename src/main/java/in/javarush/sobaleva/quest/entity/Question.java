package in.javarush.sobaleva.quest.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {
    private final int id;
    private final String text;
    private final List<Answer> answers;
    private int nextQuestionId;
    private final Map<Integer, Map<Integer, String>> imagePaths = new HashMap<>();

    public Question(int id, String text, List<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public int getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(int nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }

    public void setImagePath(int gameId, int questionId, String imagePath) {
        imagePaths.computeIfAbsent(gameId, k -> new HashMap<>()).put(questionId, imagePath);
    }

    public String getImagePath(int gameId, int questionId) {
        return imagePaths.getOrDefault(gameId, Collections.emptyMap()).get(questionId);
    }
}