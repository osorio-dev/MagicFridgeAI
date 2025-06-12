package com.dev.osorio.MagicFridgeAI.DTO;

import java.time.LocalDateTime;

public class FoodItemDTO {

    private Long id;
    private String name;
    private String category;
    private Integer amount;
    private LocalDateTime validity;

    public FoodItemDTO() {
    }

    public FoodItemDTO(String name, String category, Integer amount, LocalDateTime validity) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.validity = validity;
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
