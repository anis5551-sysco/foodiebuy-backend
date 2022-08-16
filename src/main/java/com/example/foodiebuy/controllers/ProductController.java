package com.example.foodiebuy.controllers;


import com.example.foodiebuy.models.Product;
import com.example.foodiebuy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){ this.productService = productService;}

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = "{productId}")
    public Product getProduct(@PathVariable("productId") Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @PutMapping(path = "{productId}")
    public void editProduct(
                @PathVariable("productId") Long productId,
                @RequestParam(required = false) String productName,
                @RequestParam(required = false) String productDescription,
                @RequestParam(required = false) Float unitPrice,
                @RequestParam(required = false) Integer availableQuantity
                ){
        productService.updateProduct(productId, productName, productDescription, unitPrice, availableQuantity);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteAProduct(productId);
    }


}
