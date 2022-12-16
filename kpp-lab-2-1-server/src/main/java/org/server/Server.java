package org.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
    public static final int PORT = 8123;
    public static final List<ServerWorker> serverList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerWorker(socket));
                } catch (IOException e) {
                    e.printStackTrace();
                    socket.close();
                }
            }
        }
    }
}