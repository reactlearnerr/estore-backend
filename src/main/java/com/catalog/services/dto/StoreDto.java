package com.catalog.services.dto;

import lombok.*;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreDto {

    private Integer storeId;
    private String storeName;
    private String currencyCode;
    private String identifier;
}
