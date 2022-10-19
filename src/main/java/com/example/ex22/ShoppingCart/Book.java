package com.example.ex22.ShoppingCart;

public class Book {
    private String name;
    private String author;
    private int price;
    private int id;

    public Book(String name, String author, int price, int id) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
