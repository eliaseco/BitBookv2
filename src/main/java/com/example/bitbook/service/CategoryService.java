package com.example.bitbook.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.example.bitbook.model.Category;
import org.springframework.stereotype.Service;
@Service
public class CategoryService {
    private AtomicLong nextId = new AtomicLong(1L);
    private ConcurrentHashMap<Long, Category> categorys = new ConcurrentHashMap<>();

    public Optional<Category> findById(long id) {
        if(this.categorys.containsKey(id)) {
            return Optional.of(this.categorys.get(id));
        }
        return Optional.empty();
    }

    public List<Category> findByIds(List<Long> ids){
        List<Category> categorys = new ArrayList<>();
        for(long id : ids){
            categorys.add(this.categorys.get(id));
        }
        return categorys;
    }

    public boolean exist(long id) {
        return this.categorys.containsKey(id);
    }

    public List<Category> findAll() {
        return this.categorys.values().stream().toList();
    }

    public Category save(Category category) {
        long id = nextId.getAndIncrement();
        category.setId(id);
        categorys.put(id, category);
        return category;
    }

    public void delete(long id) {
        this.categorys.remove(id);
    }
}
