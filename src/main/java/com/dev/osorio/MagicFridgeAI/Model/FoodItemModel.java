package com.dev.osorio.MagicFridgeAI.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "food_item")
public class FoodItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private Integer amount;
    private LocalDateTime validity;

    public FoodItemModel(Long id, String name, String category, Integer amount, LocalDateTime validity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.validity = validity;
    }

    public FoodItemModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDateTime getValidity() {
        return validity;
    }

    public void setValidity(LocalDateTime validity) {
        this.validity = validity;
    }
}
