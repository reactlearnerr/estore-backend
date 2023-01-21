package com.catalog.services.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Table(name="catgrprel")
public class CategoryRel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "category_id_child")
    private Integer categoryIdChild;

    @Column(name = "category_id_parent")
    private Integer categoryIdParent;

    @Builder.Default
    private String relationType = "product_item";

}
