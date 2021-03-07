package github.KarolXX.demo.logic;

import github.KarolXX.demo.model.BrandRepository;
import github.KarolXX.demo.model.SqlBrandRepository;
import github.KarolXX.demo.model.projection.BrandReadModel;
import github.KarolXX.demo.model.projection.BrandWriteModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private BrandRepository repository;

    public BrandService(SqlBrandRepository repository) {
        this.repository = repository;
    }

    public List<BrandReadModel> readAll() {
        return repository.findAll().stream()
                .map(BrandReadModel::new)
                .collect(Collectors.toList());
    }

    public BrandReadModel createBrand(BrandWriteModel newBrand) {
        var result = repository.save(newBrand.toBrand());
        return new BrandReadModel(result);
    }
}
