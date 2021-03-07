package github.KarolXX.demo.model.projection;

import github.KarolXX.demo.model.Brand;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class BrandWriteModel {
    private String name;
    private LocalDateTime productionBrandYear;
    private Set<BrandCarWriteModel> cars;

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

    public Set<BrandCarWriteModel> getCars() {
        return cars;
    }

    public void setCars(Set<BrandCarWriteModel> cars) {
        this.cars = cars;
    }

    public Brand toBrand() {
        Brand result = new Brand();
        result.setCars(cars.stream()
                .map(car -> car.toCar(productionBrandYear))
                .collect(Collectors.toSet()));
        result.setName(name);
        result.setProductionBrandYear(productionBrandYear);
        return result;
    }
}
