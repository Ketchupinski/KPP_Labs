package com.university.kpp.client;

import com.university.kpp.ClientApplication;
import javafx.application.Platform;

import java.io.*;
import java.net.Socket;

public class ClientWorker {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ClientWorker(String addr, int port) {
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
            e.printStackTrace();
        }
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            new ReadMsg().start();
        } catch (IOException e) {
            e.printStackTrace();
            ClientWorker.this.downService();
        }
    }

    public void sendMessageToServer(String text) {
        try {
            out.write(text + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            ClientWorker.this.downService();
        }

    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = in.readLine();
                    System.out.println(str);
                    String finalStr = str; // effectively final
                    Platform.runLater(() -> ClientApplication.mainController.textLabel.setText(finalStr));
                }
            } catch (IOException e) {
                e.printStackTrace();
                ClientWorker.this.downService();
            }
        }
    }
}
