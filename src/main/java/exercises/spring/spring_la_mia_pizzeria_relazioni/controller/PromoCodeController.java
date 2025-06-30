package exercises.spring.spring_la_mia_pizzeria_relazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import exercises.spring.spring_la_mia_pizzeria_relazioni.model.PromoCode;
import exercises.spring.spring_la_mia_pizzeria_relazioni.repository.PromoCodeRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/promos")
public class PromoCodeController {

    @Autowired
    private PromoCodeRepository repository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("promoCode") PromoCode formPromoCode, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "promo_codes/create";
        }

        repository.save(formPromoCode);

        return "redirect:/pizzas";
    }

}
