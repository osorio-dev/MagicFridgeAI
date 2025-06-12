package com.dev.osorio.MagicFridgeAI.Mapper;

import com.dev.osorio.MagicFridgeAI.DTO.FoodItemDTO;
import com.dev.osorio.MagicFridgeAI.Model.FoodItemModel;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {

    public FoodItemModel map(FoodItemDTO foodItemDTO) {
        FoodItemModel foodItemModel = new FoodItemModel();

        foodItemModel.setId(foodItemDTO.getId());
        foodItemModel.setName(foodItemDTO.getName());
        foodItemModel.setCategory(foodItemDTO.getCategory());
        foodItemModel.setAmount(foodItemDTO.getAmount());
        foodItemModel.setValidity(foodItemDTO.getValidity());

        return foodItemModel;
    }

    public FoodItemDTO map(FoodItemModel foodItemModel) {
        FoodItemDTO foodItemDTO = new FoodItemDTO();

        foodItemDTO.setId(foodItemModel.getId());
        foodItemDTO.setName(foodItemModel.getName());
        foodItemDTO.setCategory(foodItemModel.getCategory());
        foodItemDTO.setAmount(foodItemModel.getAmount());
        foodItemDTO.setValidity(foodItemModel.getValidity());

        return foodItemDTO;
    }

    public FoodItemDTO updateFood(FoodItemDTO userFood, FoodItemModel bdFood) {

        bdFood.setName(userFood.getName() == null ? bdFood.getName() : userFood.getName());
        bdFood.setCategory(userFood.getCategory() == null ? bdFood.getCategory() : userFood.getCategory());
        bdFood.setAmount(userFood.getAmount() == null ? bdFood.getAmount() : userFood.getAmount());
        bdFood.setValidity(userFood.getValidity() == null ? bdFood.getValidity() : userFood.getValidity());

        return this.map(bdFood);
    }
}
