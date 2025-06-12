package com.dev.osorio.MagicFridgeAI.Repository;

import com.dev.osorio.MagicFridgeAI.Model.FoodItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItemModel, Long> {
}
