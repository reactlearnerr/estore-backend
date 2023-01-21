package com.catalog.services.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class CategoryRelDto {

    private String childCategory;

    private String parentCategory;

    private String relationType;

}
