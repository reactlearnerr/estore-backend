package com.catalog.services.repository;

import com.catalog.services.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(name = "findProductsByStoreId",value = "select * from catentry where catentry_id "+
    "in (select catentry_id from storecatentry where store_id = :storeId)", nativeQuery = true)
    public List<Product> findProductsByStoreId(@Param("storeId") Integer storeId);

    public Optional<Product> findByIdentifier(String identifier);
}
