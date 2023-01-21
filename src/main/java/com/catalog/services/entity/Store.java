package com.catalog.services.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "store", uniqueConstraints = {
        @UniqueConstraint(name = "uc_store_identifier", columnNames = {"identifier"})
})
public class Store {

    @Id
    @Column(name="store_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storeId;

    private String storeName;

    @Column(name="identifier", unique = true)
    private String identifier;

    private String currencyCode;
    @Column(name = "markfordelete")
    private int markForDelete = 0;

    @ManyToMany(mappedBy = "stores",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Product> product = new LinkedHashSet<>();

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}
