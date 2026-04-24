package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("pizzas")
    public String index(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Pizza> pizzas;
        if (keyword != null && !keyword.trim().isEmpty()) {
            pizzas = pizzaRepository.findByNameContainingIgnoreCase(keyword);
        } else {
            pizzas = pizzaRepository.findAll();
        }
        model.addAttribute("pizzas", pizzas);
        model.addAttribute("keyword", keyword);
        return "pizzas/index";
    }

    @GetMapping("pizzas/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Pizza pizza = pizzaRepository.findById(id).get();
        model.addAttribute("pizza", pizza);
        return "pizzas/show";
    }
}
