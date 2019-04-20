package com.br.gamestore.controller;

import com.br.gamestore.model.GameLevel;
import com.br.gamestore.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.br.gamestore.config.Constants.FIND_GAME_NAME;
import static com.br.gamestore.config.Constants.LIST_SEARCH_GAME;

@WebServlet("/games/find")
public class GameFindController extends HttpServlet {

    private GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gameNames = req.getParameter(FIND_GAME_NAME);
        List<GameLevel> gameLevels = gameService.searchByName(gameNames);
        req.getSession().setAttribute(LIST_SEARCH_GAME, gameLevels);
        req.getRequestDispatcher("../game/form").forward(req, resp);
    }
}
