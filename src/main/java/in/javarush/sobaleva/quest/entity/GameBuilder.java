package in.javarush.sobaleva.quest.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
    public static Game buildGameFromJson(JSONObject jsonGame) {
        int gameId = jsonGame.getInt("id");
        String gameName = jsonGame.getString("name");

        JSONArray jsonQuestions = jsonGame.getJSONArray("questions");
        List<Question> questions = buildQuestionsFromJson(jsonQuestions);

        return new Game(gameId, gameName, questions);
    }

    private static List<Question> buildQuestionsFromJson(JSONArray jsonQuestions) {
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < jsonQuestions.length(); i++) {
            JSONObject jsonQuestion = jsonQuestions.getJSONObject(i);
            int questionId = jsonQuestion.getInt("id");
            String questionText = jsonQuestion.getString("text");

            JSONArray jsonAnswers = jsonQuestion.getJSONArray("answers");
            List<Answer> answers = buildAnswersFromJson(jsonAnswers);

            int nextQuestionId = jsonQuestion.optInt("nextQuestionId", -1);

            Question question = new Question(questionId, questionText, answers);
            if (nextQuestionId != -1) {
                question.setNextQuestionId(nextQuestionId);
            }
            questions.add(question);
        }
        return questions;
    }

    private static List<Answer> buildAnswersFromJson(JSONArray jsonAnswers) {
        List<Answer> answers = new ArrayList<>();

        for (int i = 0; i < jsonAnswers.length(); i++) {
            JSONObject jsonAnswer = jsonAnswers.getJSONObject(i);
            int answerId = jsonAnswer.getInt("id");
            String answerText = jsonAnswer.getString("text");
            int nextQuestionId = jsonAnswer.getInt("nextQuestionId");

            Answer answer = new Answer(answerId, answerText, nextQuestionId);
            answers.add(answer);
        }
        return answers;
    }
}