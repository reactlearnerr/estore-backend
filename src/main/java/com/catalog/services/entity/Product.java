package com.catalog.services.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "Product")
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name = "catentry")
@NoArgsConstructor
public class Product {

    @Id
    @Column(name="catentry_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer catentryId;

    private Integer productId;
    private String productName;
    private String upProductName;
    @Column(name="identifier", unique = true)
    private String identifier;

    @Column(name="images",length = 5000)
    private String images;
    private String shortDesc;
    private String longDesc;
    private BigDecimal basePrice;
    private BigDecimal offerPrice;
    private BigDecimal exclusivePrice;
    private BigDecimal extraPrice;
    private int prodQty;
    private int sortOrder;

    @Column(name = "markfordelete")
    private int markForDelete = 0;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "catgpenrel",
            joinColumns = {@JoinColumn(name = "catentry_id", referencedColumnName = "catentry_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "category_id")})
    private Set<Category> category = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "storecatentry",
            joinColumns = {@JoinColumn(name = "catentry_id", referencedColumnName = "catentry_id")},
            inverseJoinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "store_id")})
    private Set<Store> stores = new LinkedHashSet<>();

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }
}
