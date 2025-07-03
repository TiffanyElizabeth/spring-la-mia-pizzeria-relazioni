package exercises.spring.spring_la_mia_pizzeria_relazioni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import exercises.spring.spring_la_mia_pizzeria_relazioni.model.Ingredient;
import exercises.spring.spring_la_mia_pizzeria_relazioni.model.Pizza;
import exercises.spring.spring_la_mia_pizzeria_relazioni.repository.IngredientRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public String index(Model model) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        model.addAttribute("ingredient", ingredients);
        model.addAttribute("hasIngredients", !ingredients.isEmpty());
        return "ingredients/index";
    }

    @GetMapping("/searchByName")
    public String searchbyName(@RequestParam(name = "name") String name, Model model) {
        List<Ingredient> ingredients = ingredientRepository.findByNameContainingIgnoreCase(name);
        model.addAttribute("ingredient", ingredients);
        model.addAttribute("hasIngredients", !ingredients.isEmpty());
        return "ingredients/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredients/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("ingredient") Ingredient formIngredient, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "ingredients/create";
        }

        ingredientRepository.save(formIngredient);

        return "redirect:/ingredients";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("ingredient", ingredientRepository.findById(id).get());
        model.addAttribute("edit", true);
        return "ingredients/create";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("ingredient") Ingredient formIngredient, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "ingredients/create";
        }

        ingredientRepository.save(formIngredient);

        return "redirect:/ingredients";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Ingredient ingredientToDelete = ingredientRepository.findById(id).get();

        for (Pizza pizza : ingredientToDelete.getPizzas()) {
            pizza.getIngredients().remove(ingredientToDelete);
        }

        // ingredientRepository.delete(ingredient);

        return "redirect:/ingredients";
    }

}
