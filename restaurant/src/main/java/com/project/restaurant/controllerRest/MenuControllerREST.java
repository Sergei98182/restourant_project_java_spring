package com.project.restaurant.controllerRest;

import com.project.restaurant.dto.DishRequest;
import com.project.restaurant.model.Dish;
import com.project.restaurant.service.DishService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class MenuControllerREST {

    private final DishService dishService;

    public MenuControllerREST(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping("/create")
    public Dish createDishREST(@RequestBody DishRequest dishRequest){
        return dishService.createDish(dishRequest);
    }
    @GetMapping("/all")
    public List<Dish> getAllDishesREST() {
        return dishService.getAllDishes();
    }

    @GetMapping("/showabyid/{id}")
    public Dish getDishByIdREST(@PathVariable Integer id) {
        return dishService.getDishById(id);
    }

    @PutMapping("/{id}")
    public Dish updateDishREST(@PathVariable Integer id, @RequestBody DishRequest dishRequest){
        return dishService.updateDish(id, dishRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteDishREST(@PathVariable Integer id) {
        dishService.deleteDish(id);
    }
}