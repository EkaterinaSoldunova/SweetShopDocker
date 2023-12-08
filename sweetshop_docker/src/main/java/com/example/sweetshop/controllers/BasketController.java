package com.example.sweetshop.controllers;

import com.example.sweetshop.entities.Basket;
import com.example.sweetshop.entities.Cake;
import com.example.sweetshop.services.BasketService;
import com.example.sweetshop.services.CakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;
    private final CakeService cakeService;

    @GetMapping("/basket")
    public String basket(Model model){
        model.addAttribute("basket", basketService.listBasket());
        return "basket";
    }

    @PostMapping("/basket/add/{cakeId}")
    public String addToBasket(@PathVariable Long cakeId) {
        Cake cake = cakeService.getCakeById(cakeId);
        if (cake.getBeing() == 0) {
            return "redirect:/";
        }
        else {
            Basket basket = new Basket();
            basket.setCake(cake);
            basketService.addCakeToBasket(basket);
            return "redirect:/";
        }
    }

    @PostMapping("/basket/delete/{id}")
    public String deleteFromBasket(@PathVariable Long id) {
        basketService.deleteCakeFromBasket(id);
        return "redirect:/basket";
    }

    @PostMapping("/basket/deleteAll")
    public String deleteAllFromBasket() {
        basketService.deleteAllFromBasket();
        return "redirect:/basket";
    }
}
