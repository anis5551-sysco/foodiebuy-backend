package com.example.foodiebuy.services;

import com.example.foodiebuy.models.Category;
import com.example.foodiebuy.models.Product;
import com.example.foodiebuy.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){ this.productRepository=productRepository;}

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalStateException(
                "Product does not exist"
        ));
    }

    public void addNewProduct(Product product) {
        Optional<Product> productOptional = productRepository.findByProductName(product.getProductName());

        if(productOptional.isPresent()){
            throw new IllegalStateException("Product with same name already exists");
        }
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(Long productId, String productName, String productDescription, Float unitPrice, Integer availableQuantity) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new IllegalStateException(
                        "Product not found"
                ));
        if(productName != null && productName.length()>1 && !Objects.equals(product.getProductName(),productName)){
            product.setProductName(productName);
        }
        if(productDescription != null && productDescription.length()>1 && !Objects.equals(product.getProductDescription(),productDescription)){
            product.setProductDescription(productDescription);
        }
        if(unitPrice > 0 && !Objects.equals(product.getUnitPrice(),unitPrice)){
            product.setUnitPrice(unitPrice);
        }
        if(availableQuantity > 0 && !Objects.equals(product.getAvailableQuantity(),availableQuantity)){
            product.setAvailableQuantity(availableQuantity);
        }

    }

    public void deleteAProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new IllegalStateException(
                        "Product not found"
                ));
        productRepository.deleteById(productId);

    }
}
