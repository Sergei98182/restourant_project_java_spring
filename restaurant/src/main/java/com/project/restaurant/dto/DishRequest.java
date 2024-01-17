package com.project.restaurant.dto;

import lombok.Data;

@Data
public class DishRequest {

    private String name;
    private String description;
    private double price;
    private Integer kkal;
    private String imagepath;

}