package com.university.kpp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server extends Thread {
    public static final int PORT = 8123;
    protected static final List<ServerWorker> serverList = new LinkedList<>();

    public static void startServerApp() {
        new Server().start();
    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started");
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerWorker(socket));
                } catch (IOException e) {
                    e.printStackTrace();
                    socket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Server failed");
            e.printStackTrace();
        }
    }
}