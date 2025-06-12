package com.dev.osorio.MagicFridgeAI.Controller;

import com.dev.osorio.MagicFridgeAI.DTO.FoodItemDTO;
import com.dev.osorio.MagicFridgeAI.Service.FoodItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    //POST
    @PostMapping("/create")
    public String saveFood(@RequestBody FoodItemDTO foodItemDTO) {
        foodItemService.saveFood(foodItemDTO);
        return "Alimento Salvo";
    }

    //GET ALL FOODS
    @GetMapping("/allfoods")
    public List<FoodItemDTO> getAllFoods() {
        return foodItemService.getAllFoods();
    }

    //GET BY ID
    @GetMapping("/food/{id}")
    public FoodItemDTO getFoodById(@PathVariable("id") Long id) {
        return foodItemService.getFoodById(id);
    }

    //PUT
    @PutMapping("/update/{id}")
    public FoodItemDTO updateFood(@PathVariable("id") Long id, @RequestBody FoodItemDTO foodItemDTO) {
        return foodItemService.updateFood(id, foodItemDTO);
    }

    //DELETE BY ID
    @DeleteMapping("/delete/{id}")
    public String deleteFoodById(@PathVariable Long id) {
        foodItemService.deleteById(id);
        return "Alimento Deletado";
    }
}
