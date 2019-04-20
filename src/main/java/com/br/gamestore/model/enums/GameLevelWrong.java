//package com.br.gamestore.model.enums;
//
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public enum GameLevelWrong {
//    EASY(1, "EASY"),
//    MEDIUM(2, "MEDIUM"),
//    HARD(3, "HARD"),
//    VERY_HARD(4, "VERY HARD");
//
//
//    private String description;
//    private int id;
//
//    GameLevelWrong(int id) {
//        this.id = id;
//    }
//
//    GameLevelWrong(int id, String description) {
//        this.id = id;
//        this.description = description;
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
