package com.university.kpp;

import com.university.kpp.server.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ServerController {
    @FXML
    public Label label;
    @FXML
    public AnchorPane panel;

    public void initialize() {
        ServerApplication.controller = this;
        Server.startServerApp();
    }
}