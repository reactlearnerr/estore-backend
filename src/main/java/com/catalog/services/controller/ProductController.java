package com.catalog.services.controller;

import com.catalog.services.dto.ProductDto;
import com.catalog.services.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/api/v1")
@CrossOrigin( origins = {"http://localhost:3000","http://localhost:5173","http://localhost:8001"})
public class ProductController {

    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.accepted().body("test endpoint");
    }
    @Autowired
    ProductService productService;

    @PostMapping(path = "/{storeId}/add")
    @Operation(summary = "add a product to a store")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product,@PathVariable String storeId){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product,storeId));
    }

    @PostMapping(path = "/{storeId}/multiadd")
    @Operation(summary = "add multiple products to a store")
    public ResponseEntity<List<ProductDto>> addProducts(@RequestBody List<ProductDto> products,@PathVariable String storeId){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProducts(products,storeId));
    }

    @GetMapping(path = "/all")
    @Operation(summary = "Get all products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getAllProducts());
    }

    @GetMapping(path = "/{storeId}/all")
    @Operation(summary = "Get all products by storeId")
    public ResponseEntity<List<ProductDto>> getProductsByStoreId(@PathVariable String storeId){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getProductsByStoreId(storeId));
    }

    @DeleteMapping(path = "/{storeId}/{productId}")
    @Operation(summary = "delete product from a store")
    public ResponseEntity<String> deleteProduct(@PathVariable String storeId, @PathVariable String productId){
        productService.deleteProduct(storeId,productId);
        return ResponseEntity.status(HttpStatus.CREATED).body("product deleted");
    }

    @DeleteMapping(path = "/clearAllProducts")
    @Operation(summary = "Clear all products data")
    public ResponseEntity<String> deleteAllProducts(){
        productService.deleteAllProducts();
        return ResponseEntity.status(HttpStatus.CREATED).body("all products data cleared");
    }

    @GetMapping(path="/product-count/{storeId}")
    @Operation(summary = "get count of all products")
    public ResponseEntity<Long> getProductCount(@PathVariable String storeId){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getProductCount(storeId));
    }

}
