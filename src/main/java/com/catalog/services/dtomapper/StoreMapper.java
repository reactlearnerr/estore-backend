package com.catalog.services.dtomapper;

import com.catalog.services.dto.StoreDto;
import com.catalog.services.entity.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    public Store storeDtoToStore(StoreDto storeDto) {
        return Store.builder()
                .storeName(storeDto.getStoreName())
                .identifier(storeDto.getIdentifier())
                .currencyCode(storeDto.getCurrencyCode())
                .build();
    }

    public StoreDto storeToStoreDto(Store store) {
        return StoreDto.builder()
                .currencyCode(store.getCurrencyCode())
                .storeName(store.getStoreName())
                .identifier(store.getIdentifier())
                .storeId(store.getStoreId())
                .build();
    }

}
