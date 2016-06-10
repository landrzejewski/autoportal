package pl.training.autoportal.service;

import pl.training.autoportal.entity.Car;

import java.util.List;

public interface CarsRepository {

    Car add(Car car);

    Car get(Long id);

    List<Car> getAll();

    void delete(Long id);

    void update(Car car);

}
