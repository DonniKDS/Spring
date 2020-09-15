package ru.geekbrains.donni.spring.model;

public class Product {

    private static long countId = 5;
    private long id;
    private String title;
    private long cost;

    public Product(String title, long cost) {
        countId++;
        this.id = countId;
        this.title = title;
        this.cost = cost;
    }

    public Product(long id, String title, long cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
