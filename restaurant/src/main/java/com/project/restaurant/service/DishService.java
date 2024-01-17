package com.project.restaurant.service;

import com.project.restaurant.dto.DishRequest;
import com.project.restaurant.model.Dish;
import com.project.restaurant.repos.DishRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish createDish(DishRequest dishRequest){
        Dish dish = new Dish();
        dish.setName(dishRequest.getName());
        dish.setDescription(dishRequest.getDescription());
        dish.setPrice(dishRequest.getPrice());
        dish.setKkal(dishRequest.getKkal());
        dish.setImagepath(dishRequest.getImagepath());

        return dishRepository.save(dish);
    }

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Dish getDishById(Integer id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Dish not found with id: " + id));
    }

    public Dish updateDish(Integer id, DishRequest dishRequest){
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Dish not found with id: " + id));

        dish.setName(dishRequest.getName());
        dish.setDescription(dishRequest.getDescription());
        dish.setPrice(dishRequest.getPrice());
        dish.setKkal(dishRequest.getKkal());
        dish.setImagepath(dishRequest.getImagepath());


        return dishRepository.save(dish);
    }

    public void deleteDish(Integer id) {
        dishRepository.deleteById(id);
    }

}