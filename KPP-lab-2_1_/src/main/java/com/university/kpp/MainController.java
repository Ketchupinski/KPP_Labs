package com.university.kpp;

import com.university.kpp.client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    public Label textLabel;
    @FXML
    public TextField textField;

    @FXML
    private void initialize() {
        ClientApplication.setMainController(this);
        Client.startClientApp();
        textLabel.setText("Text");
    }

    @FXML
    public void sendToServer(ActionEvent actionEvent) {
        String text = textField.getText();
        if (text != null && !text.isEmpty() && text.matches("^[a-zA-Z]+$")) {
            Client.clientWorker.sendMessageToServer(text);
        }
    }
    @FXML
    public void appendText(String str) {
        if (str != null && !str.isEmpty()) {
            textLabel.setText(textLabel.getText());
        }
    }
}