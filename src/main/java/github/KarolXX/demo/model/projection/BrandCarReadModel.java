package github.KarolXX.demo.model.projection;

import github.KarolXX.demo.model.Car;

public class BrandCarReadModel {
    private String name;

    public BrandCarReadModel(Car source) {
        this.name = source.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
