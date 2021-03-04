package github.KarolXX.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "factory_cars")
public class FactoryCar {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    @NotBlank(message = "factory car name`s must be not empty")
    private String name;
    private int passedYears;

    @ManyToOne
    @JoinColumn(name = "factory_id")
    private Factory factory;

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassedYears() {
        return passedYears;
    }

    void setPassedYears(int passedYears) {
        this.passedYears = passedYears;
    }

    public Factory getFactory() {
        return factory;
    }

    void setFactory(Factory factory) {
        this.factory = factory;
    }
}
