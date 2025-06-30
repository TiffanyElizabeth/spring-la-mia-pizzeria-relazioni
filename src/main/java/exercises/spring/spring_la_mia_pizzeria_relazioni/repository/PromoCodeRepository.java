package exercises.spring.spring_la_mia_pizzeria_relazioni.repository;

import java.util.List;
import exercises.spring.spring_la_mia_pizzeria_relazioni.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Integer> {
    // public List<PromoCode> findByNameContainingIgnoreCase(String promoName);
}
