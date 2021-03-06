package github.KarolXX.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(generator = "i")
    @GenericGenerator(name = "i", strategy = "increment")
    private int id;
    @NotBlank(message = "brand name`s must be not empty")
    private String name;
    private LocalDateTime productionBrandYear;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Car> cars;

    @ManyToOne
    @JoinColumn(name = "factory_id")
    private Factory factory;

    public Brand() {
    }

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

    public LocalDateTime getProductionBrandYear() {
        return productionBrandYear;
    }

    public void setProductionBrandYear(LocalDateTime productionBrandYear) {
        this.productionBrandYear = productionBrandYear;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
