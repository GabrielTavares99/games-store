package com.br.gamestore.service;

import com.br.gamestore.model.Game;
import com.br.gamestore.model.dao.GameLevelDAO;
import com.br.gamestore.model.GameLevel;

import java.util.List;

public class GameService {
    private GameLevelDAO gameLevelDAO = new GameLevelDAO();
    public GameLevel findGameLevelById(long id) {
        return gameLevelDAO.findById(id);
    }

    public List<GameLevel> findAllGameLevel() {
        return gameLevelDAO.findAll();
    }

    public List<GameLevel> searchByName(String name) {
        return gameLevelDAO.searchByName(name);
    }

    public void saveGame(Game game){
        gameLevelDAO.save(game);
    }
}
