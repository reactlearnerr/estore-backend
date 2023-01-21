package com.catalog.services.dto;

import java.io.Serializable;

import lombok.*;


@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto  implements Serializable{
    private  String identifier;
    private  String name;
    private String imageUrl;
}
