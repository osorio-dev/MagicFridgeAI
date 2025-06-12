package com.dev.osorio.MagicFridgeAI.Service;

import com.dev.osorio.MagicFridgeAI.DTO.FoodItemDTO;
import com.dev.osorio.MagicFridgeAI.Mapper.FoodItemMapper;
import com.dev.osorio.MagicFridgeAI.Model.FoodItemModel;
import com.dev.osorio.MagicFridgeAI.Repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final FoodItemMapper foodItemMapper;

    public FoodItemService(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
    }

    //POST - Cria/Salva um alimento no Banco De Dados
    public FoodItemDTO saveFood(FoodItemDTO foodItemDTO) {
        FoodItemModel foodItemModel = foodItemMapper.map(foodItemDTO);
        foodItemModel = foodItemRepository.save(foodItemModel);

        return foodItemMapper.map(foodItemModel);
    }

    //GET - Lista todos os alimentos no Banco de Dados
    public List<FoodItemDTO> getAllFoods() {
        return foodItemRepository.findAll()
                .stream()
                .map(foodItemMapper::map)
                .collect(Collectors.toList());
    }

    //GET BY ID - Retorna o alimento relacionado ao ID passado
    public FoodItemDTO getFoodById(Long id) {
        Optional<FoodItemModel> foodItemModel = foodItemRepository.findById(id);

        return foodItemModel.map(foodItemMapper::map).orElse(null);
    }

    //PUT - Atualiza um Alimento com novos attr passados pelo Usuario
    public FoodItemDTO updateFood(Long id, FoodItemDTO foodItemDTO) {
        Optional<FoodItemModel> foodItemModel = foodItemRepository.findById(id);

        if (foodItemModel.isEmpty()) {
            return null;
        }

        FoodItemDTO foodItem = foodItemMapper.updateFood(foodItemDTO, foodItemModel.get());

        return this.saveFood(foodItem);
    }

    //DELETE BY ID - Deleta/Apaga/Remove um alimento do Banco de Dados
    public void deleteById(Long id) {
        Optional<FoodItemModel> foodItemModel = foodItemRepository.findById(id);

        foodItemModel.ifPresent(foodItem ->  {
            foodItemRepository.deleteById(foodItem.getId());
        });
    }
}
