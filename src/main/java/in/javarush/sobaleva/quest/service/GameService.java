package in.javarush.sobaleva.quest.service;

import in.javarush.sobaleva.quest.entity.Answer;
import in.javarush.sobaleva.quest.entity.Question;
import in.javarush.sobaleva.quest.repository.QuestionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestGameService {
    private QuestionRepository questionRepository;
    private Question currentQuestion;

    public QuestGameService(String jsonFilePath) {
        questionRepository = new QuestionRepository(jsonFilePath);
        currentQuestion = questionRepository.getQuestionById(1); // Начало квеста
    }

    public String getCurrentQuestionText() {
        return currentQuestion.getText();
    }

    public Map<Integer, String> getCurrentQuestionAnswers() {
        List<Answer> answers = currentQuestion.getAnswers();
        Map<Integer, String> answerMap = new HashMap<>();

        for (Answer answer : answers) {
            answerMap.put(answer.getId(), answer.getText());
        }

        return answerMap;
    }

    public void selectAnswer(int answerId) {
        Answer selectedAnswer = currentQuestion.getAnswerById(answerId);

        if (selectedAnswer != null) {
            currentQuestion = questionRepository.getQuestionById(selectedAnswer.getNextQuestionId());
        } else {
            currentQuestion = null; // Если ответ не найден, завершаем игру
        }
    }

    public boolean isGameFinished() {
        return currentQuestion == null;
    }
}