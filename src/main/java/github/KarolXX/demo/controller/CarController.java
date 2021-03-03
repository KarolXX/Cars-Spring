package github.KarolXX.demo.controller;

import github.KarolXX.demo.model.Car;
import github.KarolXX.demo.model.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CarController {
    private Logger logger = LoggerFactory.getLogger(CarController.class);
    private CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/cars")
    ResponseEntity<Car> createCar(@RequestBody @Valid Car newCar) {
        logger.info("Creating new car");
        var result = repository.save(newCar);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/cars")
    ResponseEntity<List<Car>> readAll() {
        logger.warn("Exposing all the cars");
        return ResponseEntity.ok(repository.findAll());
    }
}
