package github.KarolXX.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlBrandRepository extends BrandRepository, JpaRepository<Brand, Integer> {
}
