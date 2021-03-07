package github.KarolXX.demo.model.projection;

import github.KarolXX.demo.model.Car;

import java.time.LocalDateTime;

public class BrandCarWriteModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car toCar(LocalDateTime productionBrandYear) {
        return new Car(name, productionBrandYear);
    }
}
