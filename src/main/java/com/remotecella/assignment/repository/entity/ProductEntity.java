package com.remotecella.assignment.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="product")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(length = 500)
    private String description;
    @Column(nullable = false)
    private Double weight;
    @Column(precision=6, scale=2, nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String country;

    public Integer getId() {
        return id;
    }

    public ProductEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public ProductEntity setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProductEntity setCountry(String country) {
        this.country = country;
        return this;
    }
}
