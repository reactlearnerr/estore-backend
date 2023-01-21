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
@Setter
@Getter
@ToString
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(unique = true)
    private String identifier;
    private String name;
    
    @Builder.Default
    private int markForDelete = 0;
    private boolean topCategory;
    private String imageUrl;

    @ManyToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Product> product = new LinkedHashSet<>();

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}
