package com.university.kpp.client;

public final class Client {
    public static ClientWorker clientWorker;
    public static final String IP = "127.0.0.1";
    public static final int PORT = 8123;

    private Client() {}

    public static void startClientApp() {
        clientWorker = new ClientWorker(IP, PORT);
    }
}
