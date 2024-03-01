package com.example.bitbook;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class Category {

    private Long id=null;
    private String name;
    private List <Book> books;

    public Category(){
    }

    public Category( String name){
        super();
        this.name=name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBook() {
        return books;
    }

    public void setBook(List<Book> books){
        this.books=books;
    }
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", listbooks=" + books + "]";
    }

}
