package com.catalog.services.service;

import com.catalog.services.dto.ProductDto;
import com.catalog.services.dtomapper.ProductMapper;
import com.catalog.services.entity.Category;
import com.catalog.services.entity.Product;
import com.catalog.services.entity.Store;
import com.catalog.services.repository.CategoryRepository;
import com.catalog.services.repository.ProductRepository;
import com.catalog.services.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductMapper productMapper;

    public ProductDto addProduct(ProductDto requestProduct, String storeId) {
        Store store = storeRepository.findByStoreId(Integer.valueOf(storeId));
        log.info("store name is {}", store.getStoreName());
        Category category = new Category();
        Set<Category> categories = new HashSet<>();
        Optional<Category> categoryExists = categoryRepository.findByIdentifier(requestProduct.getCategory().getName());
        if(categoryExists.isPresent()){
            log.info("Category with -- {} -- already exists, so use the same instead of creating a new Category...",requestProduct.getCategory().getName());
            category = categoryExists.get();
        }else{
            Category categoryToSave = Category.builder()
                    .name(requestProduct.getCategory().getName())
                    .identifier(requestProduct.getCategory().getName())
                    .build();
            category = categoryRepository.saveAndFlush(categoryToSave);
        }
        Product productToSave = new Product();
        if(productRepository.findByIdentifier(requestProduct.getIdentifier()).isPresent()){
            productToSave = productRepository.findByIdentifier(requestProduct.getIdentifier()).get();
            productToSave.setImages(requestProduct.getImages());
            productToSave.setSortOrder(requestProduct.getSortOrder());
            productToSave.setExclusivePrice(requestProduct.getExclusivePrice());
            productToSave.setExtraPrice(requestProduct.getExtraPrice());
        }else {
            productToSave = productMapper.productDtoToProduct(requestProduct);
        }
        Set<Store> storeSet = new HashSet<>();
        storeSet.add(store);
        categories.add(category);
        productToSave.setCategory(categories);
        productToSave.setStores(storeSet);
        return productMapper.productToProductDto(productRepository.saveAndFlush(productToSave));
    }

    public List<ProductDto> addProducts(List<ProductDto> products, String storeId) {
        List<ProductDto> productsSaved = new ArrayList<>();
        products.stream().forEach(product -> {
            productsSaved.add(addProduct(product,storeId));
        });
        return productsSaved;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> productsList = productRepository.findAll();
        return productsList.stream().map(p -> productMapper.productToProductDto(p)).collect(Collectors.toList());
    }

    public void deleteProduct(String storeId, String productId) {
        productRepository.deleteById(Integer.valueOf(productId));
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    public List<ProductDto> getProductsByStoreId(String storeId) {
        List<Product> productsList = productRepository.findProductsByStoreId(Integer.valueOf(storeId));
        return productsList.stream().map(p -> productMapper.productToProductDto(p)).collect(Collectors.toList());
    }

    public Long getProductCount(String storeId){
        return productRepository.count();
    }

}
