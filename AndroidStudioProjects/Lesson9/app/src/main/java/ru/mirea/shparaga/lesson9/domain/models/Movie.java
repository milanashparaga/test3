package ru.mirea.shparaga.lesson9.domain.models;

public class Movie {
    private final int id;
    private final String name;
    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}