package exercises.spring.spring_la_mia_pizzeria_relazioni.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name must be specified")
    @Size(min = 2, message = "name must have at least 2 characters")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private List<Pizza> pizzas;

    // empty constructor
    public Ingredient() {
    }

    // constructor

    public Ingredient(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters and setters

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pizza> getPizzas() {
        return this.pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    // toString

    @Override
    public String toString() {
        return String.format("%d- %s", id, name);
    }

}
