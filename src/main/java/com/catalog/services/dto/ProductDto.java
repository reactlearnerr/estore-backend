package com.catalog.services.dto;

import com.catalog.services.entity.Store;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer productId;
    private String productName;
    private String upProductName;
    private String identifier;
    private String images;
    private String shortDesc;
    private String longDesc;
    private BigDecimal basePrice;
    private BigDecimal offerPrice;
    private int prodQty;
    private Set<Store> stores;
    private CategoryDto category;
    private int sortOrder;
    private BigDecimal exclusivePrice;
    private BigDecimal extraPrice;
}
