package com.example.bitbook.service;
import java.io.IOException;
import java.util.List;

import com.example.bitbook.model.Book;
import com.example.bitbook.model.Category;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @PostConstruct
    public void init() throws IOException{
        Category category1=new Category("Ficcion");
        Category category2=new Category("Aventura");
        Category category3=new Category("Literatura");


        Book book1=new Book("Quijote", "Miguel Cervantes");
        Book book2=new Book("Campos de Castilla", "Antonio Machado");
        Book book3=new Book("Zanti en la escuela", "Dbid Rey");

        book1.setCategorys(List.of(category1,category2));
        category1.getBooks().add(book1);
        category2.getBooks().add(book1);


        book3.setCategorys(List.of(category2));
        category2.getBooks().add(book3);

        book2.setCategorys(List.of(category3));
        category3.getBooks().add(book2);

        bookService.save(book1, null);
        bookService.save(book2, null);
        bookService.save(book3, null);
        categoryService.save(category1);
        categoryService.save(category2);
        categoryService.save(category3);




    }





}
