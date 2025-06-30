package exercises.spring.spring_la_mia_pizzeria_relazioni.repository;

import java.util.List;
import java.util.Optional;
import exercises.spring.spring_la_mia_pizzeria_relazioni.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    public List<Pizza> findByNameContainingIgnoreCase(String name);

}
