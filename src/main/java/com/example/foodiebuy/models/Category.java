package com.example.foodiebuy.models;

import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @SequenceGenerator(
            name="category_sequence",
            sequenceName= "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @Column( name = "category_id", updatable = false)
    private Long categoryId;
    @Column( name = "category_name" , nullable = false)
    private String categoryName;
    @Column(name = "category_description" , nullable = false)
    private String categoryDescription;
    @Column(name = "image_url" , nullable = false)
    private String imageUrl;

    public Category() {
    }

    public Category(Long categoryId, String categoryName, String categoryDescription, String imageUrl) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.imageUrl = imageUrl;
    }

    public Category(String categoryName, String categoryDescription, String imageUrl) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.imageUrl = imageUrl;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
