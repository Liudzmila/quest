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

@WebServlet(name = "GameInitServlet", value = "/start")
public class GameInitServlet extends HttpServlet {
    private GameService gameService;

    @Override
    public void init() {
        gameService = GameLauncher.getGameService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        if (username != null && !username.isEmpty()) {

            HttpSession session = request.getSession();

            session.setAttribute("authenticatedUserName", username);

            if (gameService != null && !gameService.isGameFinished()) {
                String currentQuestionText = gameService.getCurrentQuestionText();

                List<Answer> currentQuestionAnswers = gameService.getCurrentQuestionAnswers();

                String imagePath = gameService.getCurrentQuestionImagePath();

                request.setAttribute("questionText", currentQuestionText);
                request.setAttribute("answers", currentQuestionAnswers);
                request.setAttribute("username", username);
                request.setAttribute("gameName", gameService.getGameName());
                request.setAttribute("questionImagePath", imagePath);

                request.getRequestDispatcher("/game.jsp").forward(request, response);
                return;
            }
            response.sendRedirect(request.getContextPath() + "/game.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}