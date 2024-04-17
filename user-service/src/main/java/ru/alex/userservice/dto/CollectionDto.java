package ru.alex.userservice.dto;

import lombok.Data;

@Data
public class CollectionDto {
    private String name;

    private Integer mangaCount;

    private String description;
}
