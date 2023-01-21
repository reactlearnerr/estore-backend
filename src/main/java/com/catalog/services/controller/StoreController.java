package com.catalog.services.controller;

import com.catalog.services.dto.StoreDto;
import com.catalog.services.entity.Store;
import com.catalog.services.service.ProductService;
import com.catalog.services.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/api/v1")
@CrossOrigin( origins = {"http://localhost:3000","http://localhost:5173","http://localhost:8001"})
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping(path = "/{storeId}")
    @Operation(summary = "Get the store details by storeID")
    public ResponseEntity<StoreDto> getStoreDetails(@PathVariable("storeId") String storeId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storeService.getStoreDetails(storeId));
    }
    @Autowired
    ProductService productService;

    @PostMapping(path = "/create")
    public ResponseEntity<StoreDto> addProduct(@RequestBody StoreDto requestStore){
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.addStore(requestStore));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Store>> getAllStores(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storeService.getAllStores());
    }

    //append all the method names that needs adming access with ForAdmin suffix
    @GetMapping(path = "/admin/all")
    public ResponseEntity<List<Store>> getAllStoresForAdmin(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storeService.getAllStores());
    }

    @DeleteMapping(path = "/{storeId}")
    public ResponseEntity<String> deleteStore(@PathVariable("storeId") String storeId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("store deleted..");
    }

    @PatchMapping(path = "/{storeId}")
    public ResponseEntity<Store> updateStore(@PathVariable("storeId") String storeId, @RequestBody Store store){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storeService.updateStoreDetails(storeId,store));
    }
}
