package com.example.bitbook.model;

import java.util.List;


public class Book {

    private Long id=null;
    private String title;
    private String author;
    private List<Category>categorys;

    public Book(){

    }
    public Book (String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public List <Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category>Categorys) {
        this.categorys = categorys;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", title=" + title + ", author=" + author + ", categorys=" + categorys + "]";
    }



}
