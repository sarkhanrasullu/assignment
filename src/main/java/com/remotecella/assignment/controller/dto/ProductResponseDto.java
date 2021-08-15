package com.remotecella.assignment.controller.dto;

import java.math.BigDecimal;

public class ProductResponseDto {

    private Integer id;
    private String name;
    private String description;
    private Double weight;
    private BigDecimal price;
    private String country;

    public Integer getId() {
        return id;
    }

    public ProductResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductResponseDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public ProductResponseDto setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductResponseDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProductResponseDto setCountry(String country) {
        this.country = country;
        return this;
    }
}
