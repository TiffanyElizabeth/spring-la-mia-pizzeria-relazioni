package exercises.spring.spring_la_mia_pizzeria_relazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import exercises.spring.spring_la_mia_pizzeria_relazioni.model.Ingredient;
import exercises.spring.spring_la_mia_pizzeria_relazioni.model.Pizza;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    public List<Ingredient> findByNameContainingIgnoreCase(String name);
}
