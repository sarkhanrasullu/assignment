package com.remotecella.assignment.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductRequestDto {

    private Integer id;
    private String description;
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "country is mandatory")
    private String country;
    @NotNull(message = "weight is mandatory")
    private Double weight;
    @NotNull(message = "price is mandatory")
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public ProductRequestDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductRequestDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductRequestDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public ProductRequestDto setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductRequestDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProductRequestDto setCountry(String country) {
        this.country = country;
        return this;
    }
}
