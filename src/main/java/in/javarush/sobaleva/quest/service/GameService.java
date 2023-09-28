package in.javarush.sobaleva.quest.service;

import in.javarush.sobaleva.quest.entity.Answer;
import in.javarush.sobaleva.quest.entity.Game;
import in.javarush.sobaleva.quest.entity.Question;
import in.javarush.sobaleva.quest.repository.QuestionRepository;
import in.javarush.sobaleva.quest.repository.QuestionRepositoryImpl;

import java.util.List;

public class GameService {
    private Game game;
    private Question currentQuestion;
    private final String jsonFilePath;

    public GameService(int gameId, String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
        initializeGame(gameId, jsonFilePath);
    }

    private void initializeGame(int gameId, String jsonFilePath) {
        QuestionRepository repository = new QuestionRepositoryImpl("/" + jsonFilePath);
        game = repository.getGameById(gameId);
        List<Question> questions = game.getQuestions();
        currentQuestion = questions.get(0);
    }

    public String getCurrentQuestionText() {
        return currentQuestion.getText();
    }

    public void selectAnswer(int answerId) {
        if (currentQuestion != null) {
            for (Answer answer : currentQuestion.getAnswers()) {
                if (answer.getId() == answerId) {
                    int nextQuestionId = answer.getNextQuestionId();
                    if (nextQuestionId > 0) {
                        setCurrentQuestionById(nextQuestionId);
                    } else {
                        currentQuestion = null;
                    }
                    break;
                }
            }
        }
    }

    private void setCurrentQuestionById(int questionId) {
        for (Question question : game.getQuestions()) {
            if (question.getId() == questionId) {
                currentQuestion = question;
                break;
            }
        }
    }

    public boolean isGameFinished() {
        return currentQuestion == null;
    }

    public List<Answer> getCurrentQuestionAnswers() {
        return currentQuestion.getAnswers();
    }

    public String getGameName() {
        return game.getGameName();
    }

    public void resetGame() {
        initializeGame(game.getId(), jsonFilePath);
    }

    public String getCurrentQuestionImagePath() {
        if (currentQuestion != null) {
            return currentQuestion.getImagePath(game.getId(), currentQuestion.getId());
        }
        return null;
    }
}