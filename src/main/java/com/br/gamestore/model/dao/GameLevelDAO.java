package com.br.gamestore.model.dao;

import com.br.gamestore.model.Game;
import com.br.gamestore.model.GameLevel;
import com.br.gamestore.service.EntityManagerService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GameLevelDAO {


    public GameLevel findById(long id) {
        EntityManager entityManager = EntityManagerService.getEntityManager();
        Query queryResult = entityManager.createQuery("select gl FROM GameLevel as gl WHERE gl.id=:id");
        queryResult.setParameter("id", id);
        List resultList = queryResult.getResultList();
        GameLevel gameLevel = null;
        if (resultList.size() > 0)
            gameLevel = (GameLevel) resultList.get(0);

        EntityManagerService.closeEntityManager(entityManager);
        return gameLevel;
    }

    public List<GameLevel> findAll() {
        EntityManager entityManager = EntityManagerService.getEntityManager();
        Query query = entityManager.createQuery("SELECT gl from GameLevel  gl");
        List resultList = query.getResultList();
        EntityManagerService.closeEntityManager(entityManager);
        return resultList;
    }

    public void save(Game game) {
        EntityManager entityManager = EntityManagerService.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(game);
        entityManager.getTransaction().commit();

        EntityManagerService.closeEntityManager(entityManager);
    }

    public List<GameLevel> searchByName(String name) {
        EntityManager entityManager = EntityManagerService.getEntityManager();
        Query query = entityManager.createQuery("SELECT g from Game g where lower(g.nome) LIKE lower(:name)");
        String p = "%" + name + "%";
        query.setParameter("name", p);
        List resultList = query.getResultList();
        EntityManagerService.closeEntityManager(entityManager);
        return resultList;
    }
}
