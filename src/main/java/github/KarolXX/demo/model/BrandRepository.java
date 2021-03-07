package github.KarolXX.demo.model;

import java.util.List;

public interface BrandRepository {
    List<Brand> findAll();

    Brand save(Brand entity);
}
