package com.example.bitbook.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.bitbook.service.BookService;
import com.example.bitbook.service.CategoryService;
import com.example.bitbook.model.Book;
import com.example.bitbook.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/books")
    public String showBooks(Model model) {

        model.addAttribute("books", bookService.findAll());

        return "show_books";
    }

    @GetMapping("/books/{id}")
    public String showBook(Model model, @PathVariable long id) {

        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "book";
        } else {
            return "show_book";
        }

    }

    /*@GetMapping("/books/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {

        Optional<Book> op = bookService.findById(id);

        if(op.isPresent()) {
            Book book = op.get();
            Resource poster = imageService.getImage(book.getImage());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").body(poster);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film not found");
        }
    }*/

    @GetMapping("/book/new")
    public String newBook(Model model) {

        model.addAttribute("availableCategorys", categoryService.findAll());

        return "formulariobook";
    }

    @PostMapping("/book/new")
    public String newBookProcess(Model model, Book book, MultipartFile imageField, @RequestParam(required = false) List<Long> selectedCategorys) throws IOException {

        if (selectedCategorys != null){
            List<Category> categorys = categoryService.findByIds(selectedCategorys);
            book.setCategorys(categorys);
            for (Category category : categorys){
                category.getBooks().add(book);
            }
        }

        Book newBook = bookService.save(book, imageField);

        model.addAttribute("bookId", newBook.getId());

        return "redirect:/books/"+newBook.getId();
    }

}
