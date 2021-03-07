package github.KarolXX.demo.logic;

import github.KarolXX.demo.model.*;
import github.KarolXX.demo.model.projection.BrandReadModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactoryService {
    private FactoryRepository repository;
    private BrandRepository brandRepository;

    public FactoryService(FactoryRepository repository, BrandRepository brandRepository) {
        this.repository = repository;
        this.brandRepository = brandRepository;
    }

    public Factory create(Factory factory) {
        return repository.save(factory);
    }

    public List<Factory> readAll() {
        return repository.findAll();
    }

    public BrandReadModel createBrand(int factoryId) {
        var factory = repository.findById(factoryId).orElseThrow(() -> new IllegalArgumentException("Factory with given id not found"));

        Brand brand = new Brand();
        brand.setName(factory.getName());
        brand.setProductionBrandYear(factory.getEstablishmentYear());
        brand.setCars(factory.getCars().stream()
                .map(factoryCar -> {
                    Car car = new Car();
                    car.setName(factoryCar.getName());
                    car.setProductionYear(factory.getEstablishmentYear()
                            .plusYears(factoryCar.getPassedYears())
                    );
                    return car;
                }).collect(Collectors.toSet()));
        brand.setFactory(factory);
        var result = brandRepository.save(brand);

        return new BrandReadModel(result);
    }
}
