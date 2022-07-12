package com.example.foodiebuy.models;

import javax.persistence.*;

@Entity
@Table
public class Cart {
    @Id
    @SequenceGenerator(
            name="cart_product_sequence",
            sequenceName= "cart_product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_product_sequence"
    )
    @Column( name = "cart_product_id", updatable = false)
    private Long cartProductId;
    @Column( name = "product_id" , nullable = false)
    private Long productId;
    @Column(name = "user_id" , nullable = false)
    private Long userId;
    @Column(name = "quantity" , nullable = false)
    private Integer quantity;

    public Cart() {
    }

    public Cart(Long cartProductId, Long productId, Long userId, Integer quantity) {
        this.cartProductId = cartProductId;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public Cart(Long productId, Long userId, Integer quantity) {
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public Long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartProductId=" + cartProductId +
                ", productId=" + productId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                '}';
    }
}
