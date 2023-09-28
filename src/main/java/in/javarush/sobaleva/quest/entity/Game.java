package in.javarush.sobaleva.quest.entity;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int id;
    private final String gameName;
    private List<Question> questions;

    public Game(int id, String gameName, List<Question> questions) {
        this.id = id;
        this.gameName = gameName;
        this.questions = new ArrayList<>(questions);
    }

    public int getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}