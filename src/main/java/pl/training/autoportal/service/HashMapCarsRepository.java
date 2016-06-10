package pl.training.autoportal.service;

import pl.training.autoportal.entity.Car;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class HashMapCarsRepository implements Serializable, CarsRepository {

    private AtomicLong counter = new AtomicLong();
    private Map<Long, Car> cars = new HashMap<>();

    @PostConstruct
    public void init() {
        Car car = new Car();
        car.setMake("Fiat");
        car.setModel("Panda");
        add(car);
        car = new Car();
        car.setMake("Polonez");
        car.setModel("Caro");
        add(car);
    }

    @Override
    public Car add(Car car) {
        car.setId(counter.incrementAndGet());
        cars.put(car.getId(), car);
        return car;
    }

    @Override
    public Car get(Long id) {
        return cars.get(id);
    }

    @Override
    public List<Car> getAll() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public void delete(Long id) {
        cars.remove(id);
    }

    @Override
    public void update(Car car) {
        cars.put(car.getId(), car);
    }

}
