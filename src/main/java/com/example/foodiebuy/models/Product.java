package com.example.foodiebuy.models;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName= "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column( name = "product_id", updatable = false)
    private Long productId;
    @Column( name = "product_name" , nullable = false)
    private String productName;
    @Column( name = "category_id" , nullable = false)
    private Long categoryId;
    @Column ( name= "unit_price" ,  nullable = false)
    private Float unitPrice;
    @Column(name = "product_description" , nullable = false)
    private String productDescription;
    @Column(name = "available_quantity" , nullable = false )
    private Integer availableQuantity;
    @Column(name = "image_url" , nullable = false)
    private String imageUrl;

    public Product() {
    }

    public Product(Long productId, String productName, Long categoryId, Float unitPrice, String productDescription, Integer availableQuantity, String imageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
        this.productDescription = productDescription;
        this.availableQuantity = availableQuantity;
        this.imageUrl = imageUrl;
    }

    public Product(String productName, Long categoryId, Float unitPrice, String productDescription, Integer availableQuantity, String imageUrl) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
        this.productDescription = productDescription;
        this.availableQuantity = availableQuantity;
        this.imageUrl = imageUrl;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", categoryId=" + categoryId +
                ", unitPrice=" + unitPrice +
                ", productDescription='" + productDescription + '\'' +
                ", availableQuantity=" + availableQuantity +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
