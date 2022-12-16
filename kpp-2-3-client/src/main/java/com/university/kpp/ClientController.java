package com.university.kpp;

import com.university.kpp.client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class ClientController {
    @FXML
    public CheckMenuItem panelVisibleItem;
    @FXML
    public RadioMenuItem panelFontWindowsItem;
    @FXML
    public RadioMenuItem panelFontRedItem;
    @FXML
    public RadioMenuItem panelFontBlueItem;
    @FXML
    public RadioMenuItem panelFontYellowItem;
    @FXML
    public CheckMenuItem panelTextItem;
    @FXML
    public MenuItem exitItem;

    @FXML
    void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();
        panelFontWindowsItem.setToggleGroup(toggleGroup);
        panelFontRedItem.setToggleGroup(toggleGroup);
        panelFontBlueItem.setToggleGroup(toggleGroup);
        panelFontYellowItem.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            RadioMenuItem selectedRadioMenuItem = (RadioMenuItem) toggleGroup.getSelectedToggle();
            String text = selectedRadioMenuItem.getId();
            Client.clientWorker.sendMessageToServer(text);
        });
        panelVisibleItem.selectedProperty().addListener((observable, oldVal, newVal) -> {
            String str = panelVisibleItem.getId() + (panelVisibleItem.selectedProperty().getValue() ? "Visible" : "Invisible");
            System.out.println(str);
            Client.clientWorker.sendMessageToServer(str);
        });
        panelTextItem.selectedProperty().addListener((observable, oldVal, newVal) -> {
            String str = panelTextItem.getId() + (panelTextItem.selectedProperty().getValue() ? "Enable" : "Disable");
            System.out.println(str);
            Client.clientWorker.sendMessageToServer(str);
        });
        exitItem.setOnAction(event -> {
            Client.clientWorker.sendMessageToServer("exitApp");
            System.exit(0);
        });

        Client.startClientApp();
    }
}