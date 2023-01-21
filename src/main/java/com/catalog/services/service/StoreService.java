package com.catalog.services.service;

import com.catalog.services.dto.StoreDto;
import com.catalog.services.dtomapper.StoreMapper;
import com.catalog.services.entity.Store;
import com.catalog.services.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreMapper storeMapper;

    public StoreDto getStoreDetails(String storeId){
        Store store = storeRepository.findByStoreId(Integer.valueOf(storeId));
        return storeMapper.storeToStoreDto(store);
    }

    public List<Store> getAllStores(){
        List<Store> stores = storeRepository.findAll();
        return stores;
    }

    public StoreDto addStore(StoreDto storeDto) {
        Store storeToSave = storeMapper.storeDtoToStore(storeDto);
        Store store = storeRepository.save(storeToSave);
        StoreDto storeSaved = storeMapper.storeToStoreDto(store);
        return storeDto;

    }

    public void deleteStore(String storeId) {
        storeRepository.deleteById(Integer.valueOf(storeId));
    }

    public Store updateStoreDetails(String storeId,Store store) {
        Store existingStore = storeRepository.findByStoreId(Integer.valueOf(storeId));
        existingStore.setStoreId(store.getStoreId());
        return storeRepository.saveAndFlush(existingStore);
    }
}
