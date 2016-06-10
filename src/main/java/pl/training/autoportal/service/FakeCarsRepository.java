package pl.training.autoportal.service;


import pl.training.autoportal.entity.Car;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@Fake
@ApplicationScoped
public class FakeCarsRepository implements  CarsRepository {

    @Override
    public Car add(Car car) {
        return null;
    }

    @Override
    public Car get(Long id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Car car) {

    }

}
