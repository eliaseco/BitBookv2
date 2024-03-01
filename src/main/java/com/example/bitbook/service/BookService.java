package com.example.bitbook.service;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.example.bitbook.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class BookService {

    private AtomicLong nextId = new AtomicLong(1L);
    private ConcurrentHashMap<Long, Book> books = new ConcurrentHashMap<>();

    public Optional<Book> findById(long id) {
        if(this.books.containsKey(id)) {
            return Optional.of(this.books.get(id));
        }
        return Optional.empty();
    }
    public boolean exist(long id) {
        return this.books.containsKey(id);
    }

    public List<Book> findAll() {
        return this.books.values().stream().toList();
    }

    public Book save(Book book, MultipartFile imageField) {

        /*if (imageField != null && !imageField.isEmpty()){
            String path = imageService.createImage(imageField);
            book.setImage(path);
        }

        if(book.getImage() == null || book.getImage().isEmpty()) book.setImage("no-image.png");*/

        long id = nextId.getAndIncrement();
        book.setId(id);
        books.put(id, book);
        return book;
    }





}
