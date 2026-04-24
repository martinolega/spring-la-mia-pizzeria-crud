package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The name is required")
    private String name;

    @NotBlank(message = "The description is required")
    private String description;

    @NotNull(message = "The price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "The price must be positive")
    @Digits(integer = 10, fraction = 2, message = "The price must be a valid number with up to 10 digits and 2 decimal places")
    private BigDecimal price;

    @NotBlank(message = "The image URL is required")
    private String imageUrl;

    public Pizza(){}

    public Pizza(Integer id, String name, String description, BigDecimal price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        // return  "Name: " + name + '\'' +
        //         "Description: " + description + '\'' +
        //         "Price: " + price + '\'' + 
        //         "ImageUrl: '" + imageUrl + '\'';

        return String.format("Name: %s, Description: %s, Price: %s, ImageUrl: %s", name, description, price, imageUrl);
    }
}
