package com.university.kpp.server;

import com.university.kpp.ServerApplication;
import com.university.kpp.util.ClientServerEvents;
import javafx.application.Platform;

import java.io.*;
import java.net.Socket;

public class ServerWorker extends Thread {
    private final BufferedReader in;

    public ServerWorker(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        start(); // call run()
    }

    @Override
    public void run() {
        String word;
        try {
            while (true) {
                word = in.readLine();
                System.out.println("Server received: " + word);
                ClientServerEvents event = ClientServerEvents.getEvent(word);
                if (event != null) {
                    switch (event) {
                        case LABEL_DISABLE ->
                                Platform.runLater(() -> ServerApplication.controller.label.setDisable(true));
                        case LABEL_ENABLE ->
                                Platform.runLater(() -> ServerApplication.controller.label.setDisable(false));
                        case PANEL_VISIBLE ->
                                Platform.runLater(() -> ServerApplication.controller.panel.setVisible(true));
                        case PANEL_INVISIBLE ->
                                Platform.runLater(() -> ServerApplication.controller.panel.setVisible(false));
                        case PANEL_RED ->
                                Platform.runLater(() -> ServerApplication.controller.panel.setStyle("-fx-background-color: red"));
                        case PANEL_BLUE ->
                                Platform.runLater(() -> ServerApplication.controller.panel.setStyle("-fx-background-color: blue"));
                        case PANEL_STANDARD ->
                                Platform.runLater(() -> ServerApplication.controller.panel.setStyle("-fx-background-color: #ffffff"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
