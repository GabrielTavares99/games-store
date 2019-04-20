package com.br.gamestore.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerService {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GAMES-PU");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager entityManager) {
        entityManager.close();
    }

}
