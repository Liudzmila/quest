package in.javarush.sobaleva.quest.controller;

import in.javarush.sobaleva.quest.GameLauncher;
import in.javarush.sobaleva.quest.service.GameService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RestartGameServlet", value = "/restart")
public class RestartGameServlet extends HttpServlet {
    private GameService gameService;
    @Override
    public void init() {
        gameService = GameLauncher.getGameService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        gameService.resetGame();
        response.sendRedirect("/quest/start");
    }
}