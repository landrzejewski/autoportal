package pl.training.autoportal.view;

import pl.training.autoportal.entity.Car;

import java.io.Serializable;

public class CarTableRow implements Serializable {

    private Car car;
    private boolean edited;

    public CarTableRow(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

}
