package in.javarush.sobaleva.quest.entity;

public class Answer {
    private final int id;
    private final String text;
    private final int nextQuestionId;

    public Answer(int id, String text, int nextQuestionId) {
        this.id = id;
        this.text = text;
        this.nextQuestionId = nextQuestionId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getNextQuestionId() {
        return nextQuestionId;
    }
}