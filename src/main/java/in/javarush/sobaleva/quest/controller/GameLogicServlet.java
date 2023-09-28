package in.javarush.sobaleva.quest.controller;

import in.javarush.sobaleva.quest.GameLauncher;
import in.javarush.sobaleva.quest.entity.Answer;
import in.javarush.sobaleva.quest.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GameLogicServlet", value = "/game")
public class GameLogicServlet extends HttpServlet {
    private GameService gameService;

    @Override
    public void init() {
        gameService = GameLauncher.getGameService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answerIdStr = request.getParameter("answerId");

        if (answerIdStr != null) {
            try {
                int answerId = Integer.parseInt(answerIdStr);

                 HttpSession session = request.getSession(false);

                if (session != null) {
                    String username = (String) session.getAttribute("authenticatedUserName");

                    if (username != null) {

                        if (gameService != null && !gameService.isGameFinished()) {
                            gameService.selectAnswer(answerId);

                            if (gameService.isGameFinished()) {
                                response.sendRedirect(request.getContextPath() + "/game-over.jsp");
                                return;
                            }

                            String currentQuestionText = gameService.getCurrentQuestionText();
                            List<Answer> currentQuestionAnswers = gameService.getCurrentQuestionAnswers();
                            String imagePath = gameService.getCurrentQuestionImagePath();

                            request.setAttribute("gameName", gameService.getGameName()); // Добавляем название игры как атрибут
                            request.setAttribute("questionText", currentQuestionText);
                            request.setAttribute("answers", currentQuestionAnswers);
                            request.setAttribute("questionImagePath", imagePath);

                            request.getRequestDispatcher("/game.jsp").forward(request, response);
                            return;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/game-over.jsp");
    }
}