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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // @GetMapping("/edit/{id}")
    // public String edit(@PathVariable("id") Integer id, Model model) {
    // PromoCode promoCode = repository.findById(id)
    // .orElseThrow(() -> new IllegalArgumentException("Invalid promo code ID: " +
    // id));

    // model.addAttribute("promoCode", promoCode);
    // model.addAttribute("edit", true);
    // return "promo_codes/create";
    // }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("promoCode", repository.findById(id).get());
        model.addAttribute("edit", true);
        return "promo_codes/create";
    }

    // @PostMapping("/edit/{id}")
    // public String update(@PathVariable("id") Integer id, @Valid
    // @ModelAttribute("promoCode") PromoCode formPromoCode,
    // BindingResult bindingResult,
    // Model model) {
    // if (bindingResult.hasErrors()) {
    // return "promo_codes/create";
    // }

    // //formPromoCode.setId(id);
    // repository.save(formPromoCode);

    // return "redirect:/pizzas";
    // }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("promoCode") PromoCode formPromoCode,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "promo_codes/create";
        }

        repository.save(formPromoCode);

        return "redirect:/pizzas";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        PromoCode promoCode = repository.findById(id).get();

        repository.delete(promoCode);

        return "redirect:/pizzas";
    }

}
