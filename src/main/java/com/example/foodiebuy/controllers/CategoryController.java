package com.example.foodiebuy.controllers;

import com.example.foodiebuy.models.Category;
import com.example.foodiebuy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping(path = "{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PostMapping
    public ResponseEntity<Category> registerNewCategory(@RequestBody Category category){
        categoryService.addNewCategory(category);
        Category newCategory = categoryService.addNewCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(newCategory);
    }

    @PutMapping(path = "{categoryId}")
    public void editCategory(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String categoryDescription){
        categoryService.updateCategory(categoryId, categoryName, categoryDescription);

    }
}
