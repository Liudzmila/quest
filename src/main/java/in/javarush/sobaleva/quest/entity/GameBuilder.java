package in.javarush.sobaleva.quest.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuestBuilder {
    public static List<Question> buildQuestFromJson(String json) {
        List<Question> questions = new ArrayList<>();

        JSONObject questData = new JSONObject(json);
        JSONArray jsonQuestions = questData.getJSONArray("questions");

        for (int i = 0; i < jsonQuestions.length(); i++) {
            JSONObject jsonQuestion = jsonQuestions.getJSONObject(i);

            int questionId = jsonQuestion.getInt("id");
            String questionText = jsonQuestion.getString("text");

            Question question = new Question(questionId, questionText);

            JSONArray jsonAnswers = jsonQuestion.getJSONArray("answers");

            for (int j = 0; j < jsonAnswers.length(); j++) {
                JSONObject jsonAnswer = jsonAnswers.getJSONObject(j);

                int answerId = jsonAnswer.getInt("id");
                String answerText = jsonAnswer.getString("text");
                int nextQuestionId = jsonAnswer.getInt("nextQuestionId");

                Answer answer = new Answer(answerId, answerText, nextQuestionId);

                question.addAnswer(answer);
            }

            questions.add(question);
        }

        return questions;
    }
}
