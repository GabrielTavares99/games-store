package com.br.gamestore.controller;

import com.br.gamestore.model.Game;
import com.br.gamestore.model.GameLevel;
import com.br.gamestore.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.br.gamestore.config.Constants.*;


@WebServlet("/game/form")
public class GameFormController extends HttpServlet {

    private GameService gameService = new GameService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gameLevel = req.getParameter(GAME_LEVEL_ID);
        String gameName = req.getParameter(GAME_NAME);

        Game game = new Game();
        game.setNome(gameName);

        GameLevel gameLevelById = gameService.findGameLevelById(Long.parseLong(gameLevel));
        game.getGameLevel().add(gameLevelById);
        req.getSession().setAttribute(MESSAGE_FORM, "SALVOU DAHORA PARÇA");

        gameService.saveGame(game);

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute(GAME_LEVELS, gameService.findAllGameLevel());
        req.getRequestDispatcher("/WEB-INF/pages/form-game.jsp").forward(req, resp);
//        resp.sendRedirect("/WEB-INF/pages/form-game.jsp");
    }
}
