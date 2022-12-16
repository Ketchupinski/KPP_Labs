package com.university.kpp.server;

import com.university.kpp.ServerApplication;
import com.university.kpp.util.ClientServerEvents;
import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
                        case PANEL_FONT_BLUE ->
                                Platform.runLater(() -> ServerApplication.serverController.panelLabel.setStyle("-fx-text-fill: blue"));
                        case PANEL_FONT_RED ->
                                Platform.runLater(() -> ServerApplication.serverController.panelLabel.setStyle("-fx-text-fill: red"));
                        case PANEL_FONT_YELLOW ->
                                Platform.runLater(() -> ServerApplication.serverController.panelLabel.setStyle("-fx-text-fill: yellow"));
                        case PANEL_FONT_WINDOWS ->
                                Platform.runLater(() -> ServerApplication.serverController.panelLabel.setStyle("-fx-text-fill: black"));
                        case PANEL_VISIBLE -> Platform.runLater(() -> ServerApplication.serverController.panel.setVisible(true));
                        case PANEL_INVISIBLE -> Platform.runLater(() -> ServerApplication.serverController.panel.setVisible(false));
                        case PANEL_TEXT_VISIBLE -> Platform.runLater(() -> ServerApplication.serverController.panelLabel.setVisible(true));
                        case PANEL_TEXT_INVISIBLE -> Platform.runLater(() -> ServerApplication.serverController.panelLabel.setVisible(false));
                        case EXIT_APP -> Platform.exit();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
