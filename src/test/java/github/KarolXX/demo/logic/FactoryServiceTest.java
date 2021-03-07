package github.KarolXX.demo.logic;

import github.KarolXX.demo.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FactoryServiceTest {

    //TODO: first test which throws IllegalArgumentException

    @Test
    @DisplayName("should create new brand from factory")
    void createBrand_existingFactory_createsAndSavesBrand() {
        //given
        var factory = factory("bar", LocalDate.now().atStartOfDay(), Set.of(1, 2));
        var mockFactoryRepository = mock(FactoryRepository.class);
        when(mockFactoryRepository.findById(anyInt()))
                .thenReturn(Optional.of(factory));
        //and
        inMemoryBrandRepository inMemoryBrandRepo = inMemoryBrandRepository();
        int countBeforeCreate = inMemoryBrandRepo.getCount();
        //system under test
        var toTest = new FactoryService(mockFactoryRepository, inMemoryBrandRepo);

        //when
        var result = toTest.createBrand(1);
        //then
        assertThat(result.getName()).isEqualTo("bar");
        assertThat(result.getCars()).allMatch(car -> car.getName().equals("foo"));
        assertThat(countBeforeCreate + 1).isEqualTo(inMemoryBrandRepo.getCount());
    }

    private Factory factory(String name, LocalDateTime establishmentYear, Set<Integer> passedYearsSet) {
        Set<FactoryCar> factoryCars = passedYearsSet.stream()
                .map(passedYears -> {
                    var factoryCar = mock(FactoryCar.class);
                    when(factoryCar.getName()).thenReturn("foo");
                    when(factoryCar.getPassedYears()).thenReturn(passedYears);
                    return factoryCar;
                }).collect(Collectors.toSet());

        var result = mock(Factory.class);
        when(result.getName()).thenReturn(name);
        when(result.getEstablishmentYear()).thenReturn(establishmentYear);
        when(result.getCars()).thenReturn(factoryCars);
        return result;
    }

    private inMemoryBrandRepository inMemoryBrandRepository() {
        return new inMemoryBrandRepository();
    }

    static class inMemoryBrandRepository implements BrandRepository {
            private int index = 0;
            private Map<Integer, Brand> map = new HashMap<>();

            public int getCount() {
                return map.values().size();
            }

            @Override
            public List<Brand> findAll() {
                return new ArrayList<>(map.values());
            }

            @Override
            public Brand save(final Brand entity) {
                try {
                    var field = Brand.class.getDeclaredField("id");
                    field.setAccessible(true);
                    field.set(entity, ++index);
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
                map.put(entity.getId(), entity);
                return map.get(index);
            }
    }
}