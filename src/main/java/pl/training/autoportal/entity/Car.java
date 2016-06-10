package pl.training.autoportal.entity;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {

    public enum EngineType {

        PETROL, DIESEL, ELECTRIC

    }

    private Long id;
    private String make;
    private String model;
    private int productionYear;
    private Date firstRegistration = new Date();
    private boolean damaged;
    private EngineType engineType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public Date getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(Date firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        if (productionYear != car.productionYear) return false;
        if (damaged != car.damaged) return false;
        if (make != null ? !make.equals(car.make) : car.make != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (firstRegistration != null ? !firstRegistration.equals(car.firstRegistration) : car.firstRegistration != null)
            return false;
        return engineType == car.engineType;
    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + productionYear;
        result = 31 * result + (firstRegistration != null ? firstRegistration.hashCode() : 0);
        result = 31 * result + (damaged ? 1 : 0);
        result = 31 * result + (engineType != null ? engineType.hashCode() : 0);
        return result;
    }

}
