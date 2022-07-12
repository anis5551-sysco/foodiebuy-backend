package com.example.foodiebuy.services;

import com.example.foodiebuy.models.Category;
import com.example.foodiebuy.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalStateException(
                "Category does not exist"
        ));
    }
    public Category addNewCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findByCategoryName(category.getCategoryName());
        if(categoryOptional.isPresent()){
            throw new IllegalStateException("Category already Exists");
        }
        return categoryRepository.save(category);

    }
    @Transactional
    public void updateCategory(Long categoryId, String categoryName, String categoryDescription) {
        Category category = categoryRepository.findById(categoryId).
                orElseThrow(() -> new IllegalStateException(
                        "Category does not exist. please add as new category"
                ));
        if(categoryName != null && categoryName.length() >0 && !Objects.equals(category.getCategoryName(), categoryName)){
            category.setCategoryName(categoryName);
        }
        if(categoryDescription != null && categoryDescription.length() >0 && !Objects.equals(category.getCategoryDescription(), categoryDescription)){
            category.setCategoryDescription(categoryName);
        }

    }


}
