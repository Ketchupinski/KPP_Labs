package com.university.kpp;

import com.university.kpp.entities.Toy;
import com.university.kpp.util.FileManager;
import com.university.kpp.util.ToysManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MainController {
    @FXML
    public Button allToysButton;

    @FXML
    public Button cheapestToys;
    @FXML
    public TableView<Toy> toysTable;
    @FXML
    public TableColumn<Toy, String> tableName;
    @FXML
    public TableColumn<Toy, Integer> tableCost;
    @FXML
    public TableColumn<Toy, Integer> tableFrom;
    @FXML
    public TableColumn<Toy, Integer> tableTo;
    @FXML
    public TableColumn<Toy, String> tableAdditionalInfo;
    @FXML
    public TableColumn<Toy, Integer> tableAdditionalInfoNumber;

    @FXML
    public void initialize() {
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tableFrom.setCellValueFactory(new PropertyValueFactory<>("minAge"));
        tableTo.setCellValueFactory(new PropertyValueFactory<>("maxAge"));
        tableAdditionalInfo.setCellValueFactory(new PropertyValueFactory<>("additionalInfo"));
        tableAdditionalInfoNumber.setCellValueFactory(new PropertyValueFactory<>("additionalNumber"));
        toysTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }


    public void onAllToysClick(ActionEvent actionEvent) {
        toysTable.getItems().clear();
        List<Toy> toys = FileManager.getToysInfo();
        toysTable.getItems().addAll(toys);
    }

    public void onCheapestToysClick(ActionEvent actionEvent) {
        toysTable.getItems().clear();
        List<Toy> toys = FileManager.getToysInfo();
        List<Toy> cheapToys = ToysManager.getCheapestToys(toys);
        toysTable.getItems().addAll(cheapToys);
    }
}