package pl.training.autoportal.service;

import pl.training.autoportal.entity.Car;

import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ResourceBundle;

@Named
@ViewScoped
public class CarRegistration implements Serializable {

    @Fake
    @Inject
    private CarsRepository carsRepository;

    @Inject
    private Event<Message> eventPublisher;

    @Inject
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Timer
    public String save() {
        carsRepository.add(car);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("pl.training.autoportal.text");
        FacesMessage successMessage = new FacesMessage(resourceBundle.getString("car_successMsg"));
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        facesContext.addMessage(null, successMessage);
        Message message = new Message();
        message.setText("Dodano samochód:" + car.getModel());
        eventPublisher.fire(message);
        return "index?faces-redirect=true";
    }

}
