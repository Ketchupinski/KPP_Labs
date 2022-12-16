package com.university.kpp;

import com.university.kpp.entities.Career;
import com.university.kpp.entities.Characteristic;
import com.university.kpp.entities.PassportInfo;
import com.university.kpp.entities.Worker;
import com.university.kpp.util.Container;
import com.university.kpp.util.Utilities;
import com.university.kpp.util.WorkerManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    @FXML
    public TableView<PassportInfo> passTable;

    @FXML
    public TableView<Worker> workerTable;
    @FXML
    public TableColumn<Worker, String> firstNameColumn;
    @FXML
    public TableColumn<Worker, String> lastNameColumn;
    @FXML
    public TableColumn<Worker, Integer> salaryColumn;
    @FXML
    public TableColumn<Worker, String> educationColumn;
    @FXML
    public TableColumn<PassportInfo, String> seriesColumn;
    @FXML
    public TableColumn<PassportInfo, Integer> numberColumn;
    @FXML
    public TableView<Career> careerTable;
    @FXML
    public TableColumn<Career, String> startDateColumn;
    @FXML
    public TableColumn<Career, String> endDateColumn;
    @FXML
    public TableColumn<Career, String> positionColumn;
    @FXML
    public TableColumn<Career, String> departmentColumn;
    @FXML
    public TableView<Characteristic> charTable;
    @FXML
    public TableColumn<Characteristic, String> charColumn;
    @FXML
    public TableColumn<Characteristic, String> markColumn;
    @FXML
    public TextField firstNameField;
    @FXML
    public TextField lastNameField;
    @FXML
    public TextField passSeriesField;
    @FXML
    public TextField passNumberField;
    @FXML
    public TextField salaryField;
    @FXML
    public TextField eduField;
    @FXML
    public DatePicker startDateOneField;
    @FXML
    public DatePicker endDateOneField;
    @FXML
    public TextField positionOneField;
    @FXML
    public TextField departmentOneField;
    @FXML
    public DatePicker startDateTwoField;
    @FXML
    public TextField positionTwoField;
    @FXML
    public DatePicker endDateTwoField;
    @FXML
    public TextField departmentTwoField;
    @FXML
    public TextField charOneField;
    @FXML
    public TextField markOneField;
    @FXML
    public TextField charTwoField;
    @FXML
    public TextField markTwoField;
    @FXML
    public TextField charThreeField;
    @FXML
    public TextField markThreeField;
    @FXML
    public TextField seriesFindContainsField;

    List<Worker> workers = WorkerManager.createWorkers();

    @FXML
    public void initialize() {
        workers = DepartmentApplication.isAutoMode ? WorkerManager.createWorkers() : new Container<>();
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        educationColumn.setCellValueFactory(new PropertyValueFactory<>("education"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        charColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        markColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        workerTable.getItems().addAll(workers);
        workerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        passTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        careerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        charTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableView.TableViewSelectionModel<Worker> selectionModel =
                workerTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void displaySelected(MouseEvent mouseEvent) {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        if (worker != null) {
            passTable.getItems().clear();
            careerTable.getItems().clear();
            charTable.getItems().clear();
            passTable.getItems().add(worker.getPassportInfo());
            careerTable.getItems().addAll(worker.getCareer());
            charTable.getItems().addAll(worker.getCharacteristics());
        }
    }

    @FXML
    public void sortByPassportSeries(ActionEvent actionEvent) {
        Utilities.sortByPassportSeries(workers);
        clearAllTables();
        workerTable.getItems().addAll(workers);
    }

    @FXML
    public void sortByPassportNumber(ActionEvent actionEvent) {
        Utilities.sortByPassportNumber(workers);
        clearAllTables();
        workerTable.getItems().addAll(workers);
    }

    @FXML
    public void sortBySalary(ActionEvent actionEvent) {
        Utilities.sortBySalary(workers);
        clearAllTables();
        workerTable.getItems().addAll(workers);
    }

    public void sortByAvgMark(ActionEvent actionEvent) {
        Utilities.sortByAverageMark(workers);
        clearAllTables();
        workerTable.getItems().addAll(workers);
    }

    private void clearAllTables() {
        workerTable.getItems().clear();
        passTable.getItems().clear();
        careerTable.getItems().clear();
        charTable.getItems().clear();
    }

    public void removeWorker(ActionEvent actionEvent) {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        if (worker != null) {
            workers.remove(worker);
            clearAllTables();
            workerTable.getItems().addAll(workers);
        }
    }

    public void addWorker(ActionEvent actionEvent) {
        if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() ||
                passSeriesField.getText().isEmpty() || passNumberField.getText().isEmpty() ||
                salaryField.getText().isEmpty() || eduField.getText().isEmpty() ||
                positionOneField.getText().isEmpty() || departmentOneField.getText().isEmpty() ||
                positionTwoField.getText().isEmpty() || departmentTwoField.getText().isEmpty() ||
                charOneField.getText().isEmpty() || markOneField.getText().isEmpty() || !markOneField.getText().matches("\\d+") ||
                charTwoField.getText().isEmpty() || markTwoField.getText().isEmpty() || !markTwoField.getText().matches("\\d+") ||
                charThreeField.getText().isEmpty() || markThreeField.getText().isEmpty() || !markThreeField.getText().matches("\\d+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty fields");
            alert.setContentText("Please fill all fields");
            alert.showAndWait();
        } else {
            Worker worker = new Worker();
            worker.setFirstName(firstNameField.getText());
            worker.setLastName(lastNameField.getText());
            worker.setPassportInfo(new PassportInfo(passSeriesField.getText(), Integer.parseInt(passNumberField.getText())));
            worker.setSalary(Integer.parseInt(salaryField.getText()));
            worker.setEducation(eduField.getText());
            String startDateOne = startDateOneField.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            String endDateOne = endDateOneField.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            Career careerOne = new Career(startDateOne, endDateOne, positionOneField.getText(), departmentOneField.getText());
            String startDateTwo = startDateTwoField.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            String endDateTwo = endDateTwoField.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            Career careerTwo = new Career(startDateTwo, endDateTwo, positionTwoField.getText(), departmentTwoField.getText());
            worker.setCareer(new ArrayList<>(Arrays.asList(careerOne, careerTwo)));
            Characteristic characteristicOne = new Characteristic(charOneField.getText(), Integer.parseInt(markOneField.getText()));
            Characteristic characteristicTwo = new Characteristic(charTwoField.getText(), Integer.parseInt(markTwoField.getText()));
            Characteristic characteristicThree = new Characteristic(charThreeField.getText(), Integer.parseInt(markThreeField.getText()));
            worker.setCharacteristics(new ArrayList<>(Arrays.asList(characteristicOne, characteristicTwo, characteristicThree)));
            workers.add(worker);
            clearAllTables();
            workerTable.getItems().addAll(workers);
        }
    }

    public void deserializeWorkers(ActionEvent actionEvent) {
        List<Worker> deserializeWorkers = Utilities.deserializeWorkers();
        if (deserializeWorkers != null) {
            workers.clear();
            workers.addAll(deserializeWorkers);
            clearAllTables();
            workerTable.getItems().addAll(workers);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("File not found");
            alert.setContentText("Please check if file exists");
            alert.showAndWait();
        }
    }

    public void serializeWorkers(ActionEvent actionEvent) {
        if (!workers.isEmpty()) {
            Utilities.serializeWorkers(workers);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Serialization");
            alert.setContentText("Workers have been serialized");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No workers");
            alert.setContentText("Please add workers");
            alert.showAndWait();
        }
    }

    public void findWorkers(ActionEvent actionEvent) {
        if (workers.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Workers not found");
            alert.setContentText("Please check if any worker was created");
            alert.showAndWait();
        } else {
            List<Worker> foundWorkers = findWorkers();
            if (foundWorkers.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Workers not found");
                alert.setContentText("Please check if any worker was found");
                alert.showAndWait();
            } else {
                clearAllTables();
                workerTable.getItems().addAll(foundWorkers);
            }
        }
    }

    private List<Worker> findWorkers() {
        List<Worker> foundWorkers = new Container<>();
        if (seriesFindContainsField.getText().isEmpty()) {
            for (Worker worker : workers) {
                if (Utilities.checkIfLastNameCorrect(worker.getLastName())
                        && Utilities.checkIfPassSeriesCorrect(worker.getPassportInfo().getSeries())
                        && Utilities.checkIfPassNumberCorrect(worker.getPassportInfo().getNumber())) {
                    foundWorkers.add(worker);
                }
            }
        } else {
            for (Worker worker : workers) {
                if (Utilities.checkIfLastNameCorrect(worker.getLastName())
                        && Utilities.checkIfPassSeriesCorrect(worker.getPassportInfo().getSeries(), seriesFindContainsField.getText())
                        && Utilities.checkIfPassNumberCorrect(worker.getPassportInfo().getNumber())) {
                    foundWorkers.add(worker);
                }
            }
        }
        return foundWorkers;
    }
}