package com.university.kpp;

import com.university.kpp.server.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ServerController {

    @FXML
    public AnchorPane panel;
    @FXML
    public Label panelLabel;
    @FXML
    public Label label;

    @FXML
    public void initialize() {
        ServerApplication.serverController = this;
        Server.startServerApp();
    }
}