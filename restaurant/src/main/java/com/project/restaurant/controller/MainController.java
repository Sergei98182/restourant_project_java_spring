package com.project.restaurant.controller;

import com.project.restaurant.model.Dish;
import com.project.restaurant.model.Guest;
import com.project.restaurant.dto.RegistrationForm;
import com.project.restaurant.repos.DishRepository;
import com.project.restaurant.service.GuestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.project.restaurant.service.GuestServiceImpl.createGuestFromRegistrationForm;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final GuestService guestService;
    private final DishRepository dishRepository;



    @GetMapping()
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/menu")
    public String getAllDishes(Model model) {
        List<Dish> dishes = dishRepository.findAll();
        model.addAttribute("dishes", dishes);
        return "menu";
    }

    @GetMapping("/entry")
    public String auth(Model model) {
        return "auth";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("RegistrationForm", new RegistrationForm());
        return "registry";
    }


    @PostMapping("/registration")
    public String registerUser(@Valid RegistrationForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registry";
        }

        try {
            Guest newGuest = createGuestFromRegistrationForm(form);
            guestService.saveGuest(newGuest);
            return "registration-success";
        } catch (Exception e) {
            model.addAttribute("error", "Произошла ошибка при обработке регистрации");
            return "registry";
        }

    }

}