package exercises.spring.spring_la_mia_pizzeria_relazioni.model;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "promo_codes")
public class PromoCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

    @NotNull(message = "the promo must have a name")
    @Size(min = 4, message = "the name must have at least four characters")
    private String promoName;

    @NotNull(message = "the start date of the promo must be specified")
    private LocalDate startDate;

    private LocalDate endDate;

    // empty constructor:
    public PromoCode() {
    }

    // constructor:
    public PromoCode(Integer id, String promoName, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.promoName = promoName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // getters and setters :

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getPromoName() {
        return this.promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // toString:
    public String toString() {
        return String.format("%d- %s (%s)", id, promoName, pizza.getName());
    }

}
