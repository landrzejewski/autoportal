package pl.training.autoportal.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Calendar;

@Named
@ApplicationScoped
public class Configuration implements Serializable {

    private static final int MIN_PRODUCTION_YEAR = 1920;
    private static final String DATE_PATTERN = "dd-MM-yy";

    public int getMinCarProductionYear() {
        return MIN_PRODUCTION_YEAR;
    }

    public int getMaxCarProductionYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public String getDatePattern() {
        return DATE_PATTERN;
    }

    public void logNewCarRegistration(@Observes Message message) {
        System.out.println(message.getText());
    }

}
