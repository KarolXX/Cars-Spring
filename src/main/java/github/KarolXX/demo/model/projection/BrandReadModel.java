package github.KarolXX.demo.model.projection;

import github.KarolXX.demo.model.Brand;

import java.util.Set;
import java.util.stream.Collectors;

public class BrandReadModel {
    private String name;
    private Set<BrandCarReadModel> cars;

    public BrandReadModel(Brand source) {
        this.name = source.getName();
        this.cars = source.getCars().stream()
                .map(BrandCarReadModel::new)
                .collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BrandCarReadModel> getCars() {
        return cars;
    }

    public void setCars(Set<BrandCarReadModel> cars) {
        this.cars = cars;
    }
}
