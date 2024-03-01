package com.example.bitbook.controller;
import java.util.Optional;

import com.example.bitbook.service.CategoryService;
import com.example.bitbook.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categorys")
    public String showCategorys(Model model) {

        model.addAttribute("categorys", categoryService.findAll());

        return "show_categorys";
    }

    @GetMapping("/categorys/{id}")
    public String showBook(Model model, @PathVariable long id) {

        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("shop", category.get());
            return "show_category";
        } else {
            return "show_categorys";
        }

    }
}
