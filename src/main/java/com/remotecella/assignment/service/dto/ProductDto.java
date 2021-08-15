package com.remotecella.assignment.service.dto;

import java.math.BigDecimal;

public class ProductDto  {

    private Integer id;
    private String name;
    private String description;
    private Double weight;
    private BigDecimal price;
    private String country;

    public Integer getId() {
        return id;
    }

    public ProductDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public ProductDto setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProductDto setCountry(String country) {
        this.country = country;
        return this;
    }
}
