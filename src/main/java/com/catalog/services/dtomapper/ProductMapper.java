package com.catalog.services.dtomapper;

import com.catalog.services.dto.CategoryDto;
import com.catalog.services.dto.ProductDto;
import com.catalog.services.entity.Category;
import com.catalog.services.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class ProductMapper {

    @Autowired
    StoreMapper storeMapper;

    public Product productDtoToProduct(ProductDto productDto) {
        Set<Category> categories = new HashSet<>();
        categories.add(Category.builder()
                .name(productDto.getCategory().getName())
                .identifier(productDto.getCategory().getIdentifier())
                .build());
        return Product.builder()
                .basePrice(productDto.getBasePrice())
                .identifier(productDto.getIdentifier())
                .productId(productDto.getProductId())
                .images(productDto.getImages())
                .longDesc(productDto.getLongDesc())
                .shortDesc(productDto.getShortDesc())
                .productName(productDto.getProductName())
                .upProductName(productDto.getProductName().toUpperCase())
                .offerPrice(productDto.getOfferPrice())
                .prodQty(productDto.getProdQty())
                .sortOrder(productDto.getSortOrder())
                .basePrice(productDto.getBasePrice())
                .exclusivePrice(productDto.getExclusivePrice())
                .extraPrice(productDto.getExtraPrice())
                .category(categories)
                .build();
    }

    public ProductDto productToProductDto(Product product) {
        CategoryDto category = null;
        Set<Category> categories = product.getCategory();
        Iterator<Category> categoryIterator = categories.iterator();
        while (categoryIterator.hasNext()) {
            Category c = categoryIterator.next();
            category = CategoryDto.builder()
                    .name(c.getName())
                    .identifier((c.getIdentifier()))
                    .build();
            break;
        }
        return ProductDto.builder()
                .basePrice(product.getBasePrice())
                .identifier(product.getIdentifier())
                .images(product.getImages())
                .longDesc(product.getLongDesc())
                .productId(product.getProductId())
                .shortDesc(product.getShortDesc())
                .productName(product.getProductName())
                .upProductName(product.getProductName().toUpperCase())
                .offerPrice(product.getOfferPrice())
                .prodQty(product.getProdQty())
                .sortOrder(product.getSortOrder())
                .basePrice(product.getBasePrice())
                .stores(product.getStores())
                .category(category)
                .exclusivePrice(product.getExclusivePrice())
                .extraPrice(product.getExtraPrice())
                .build();
    }

}
