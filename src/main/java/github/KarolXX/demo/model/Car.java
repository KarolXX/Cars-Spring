package github.KarolXX.demo.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    @NotBlank(message = "car name`s must be not empty")
    private String name;
    private LocalDateTime productionYear;
    private boolean tested;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Car() {
    }

    public Car(@NotBlank(message = "car name`s must be not empty") String name, LocalDateTime productionYear) {
        this.name = name;
        this.productionYear = productionYear;
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

    public LocalDateTime getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDateTime productionYear) {
        this.productionYear = productionYear;
    }

    public boolean isTested() {
        return tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }

    public Brand getBrand() {
        return brand;
    }

    //(maybe be wrong) - cannot set brand! (all the cars in brand have the same produtionYear, models no)
    void setBrand(Brand brand) {
        this.brand = brand;
    }
}
