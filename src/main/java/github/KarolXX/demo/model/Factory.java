package github.KarolXX.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "factories")
public class Factory {
    @Id
    @GeneratedValue(generator = "incre")
    @GenericGenerator(name = "incre", strategy = "increment")
    private int id;
    @NotBlank(message = "factory name must be not empty")
    private String name;
    private LocalDateTime establishmentYear;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factory")
    private Set<FactoryCar> cars;
    @OneToMany(mappedBy = "factory")
    private Set<Brand> brands;

    Factory() {
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

    void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEstablishmentYear() {
        return establishmentYear;
    }

    void setEstablishmentYear(LocalDateTime establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public Set<FactoryCar> getCars() {
        return cars;
    }

    void setCars(Set<FactoryCar> cars) {
        this.cars = cars;
    }
}
