package com.university.kpp;

import com.university.kpp.client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ClientController {
    StringBuilder stringBuilder;
    @FXML
    public CheckBox labelCheckBox;
    @FXML
    public CheckBox panelCheckBox;
    @FXML
    public RadioButton redPanelRadioButton;
    @FXML
    public RadioButton standardPanelRadioButton;
    @FXML
    public RadioButton bluePanelRadioButton;

    @FXML
    ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    private void initialize() {
        stringBuilder = new StringBuilder();
        toggleGroup.getToggles().addAll(redPanelRadioButton, standardPanelRadioButton, bluePanelRadioButton);
        redPanelRadioButton.setToggleGroup(toggleGroup);
        standardPanelRadioButton.setToggleGroup(toggleGroup);
        bluePanelRadioButton.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            String text = selectedRadioButton.getId();
            Client.clientWorker.sendMessageToServer(text);
        });
        labelCheckBox.selectedProperty().addListener((observable, oldVal, newVal) -> {
            stringBuilder.setLength(0); // clear stringBuilder
            stringBuilder.append(labelCheckBox.getId());
            stringBuilder.append(labelCheckBox.selectedProperty().getValue() ? "Disable" : "Enable");
            String str = stringBuilder.toString();
            Client.clientWorker.sendMessageToServer(str);
        });
        panelCheckBox.selectedProperty().addListener((observable, oldVal, newVal) -> {
            stringBuilder.setLength(0); // clear stringBuilder
            stringBuilder.append(panelCheckBox.getId());
            stringBuilder.append(panelCheckBox.selectedProperty().getValue() ? "Visible" : "Invisible");
            String str = stringBuilder.toString();
            Client.clientWorker.sendMessageToServer(str);
        });
        Client.startClientApp();
    }
}