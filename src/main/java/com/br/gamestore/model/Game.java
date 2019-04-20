package com.br.gamestore.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    private long id;
    private String nome;
    private List<GameLevel> gameLevel = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToMany(targetEntity = GameLevel.class, fetch = FetchType.LAZY)
    public List<GameLevel> getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(List<GameLevel> gameLevel) {
        this.gameLevel = gameLevel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
