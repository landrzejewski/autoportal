package pl.training.autoportal.service;

import pl.training.autoportal.view.CarTableRow;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class CarsManager implements Serializable {

    @Inject
    private CarsRepository carsRepository;
    private List<CarTableRow> tableRows = new ArrayList<>();
    private boolean editMode;
    private String filterType = "make";
    private String filterValue = "";

    @PostConstruct
    public void init() {
        carsRepository.getAll().forEach(car -> tableRows.add(new CarTableRow(car)));
    }

    public void changeFilterType(ValueChangeEvent event) {
        filterType = (String) event.getNewValue();
        filterValue = "";
    }

    public void changeFilterValue(ValueChangeEvent event) {
        filterValue = (String) event.getNewValue();
    }

    public void filter() {
         tableRows = carsRepository.getAll()
                 .parallelStream()
                 .filter(car -> {
                     boolean result = false;
                     switch (filterType) {
                         case "make":
                             result = car.getMake().startsWith(filterValue);
                             break;
                         case "model":
                             result = car.getModel().startsWith(filterValue);
                             break;
                         case "productionYear":
                             if (filterValue.matches("\\d+")) {
                                 result = car.getProductionYear() == Integer.parseInt(filterValue);
                             }
                             break;
                     }
                     return result;
                 })
                 .map(CarTableRow::new)
                 .collect(Collectors.toList());
    }

    public void deleteRow(CarTableRow tableRow) {
        tableRows.remove(tableRow);
        carsRepository.delete(tableRow.getCar().getId());
    }

    public void editRow(CarTableRow tableRow) {
        tableRow.setEdited(true);
        editMode = true;
    }

    public void save() {
        tableRows.parallelStream()
                .filter(tableRow -> tableRow.isEdited())
                .forEach(tableRow -> {
                    carsRepository.update(tableRow.getCar());
                    tableRow.setEdited(false);
                });
        editMode = false;
    }

    public List<CarTableRow> getTableRows() {
        return tableRows;
    }

    public void setTableRows(List<CarTableRow> tableRows) {
        this.tableRows = tableRows;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

}
