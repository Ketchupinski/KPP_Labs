package org.server;

import java.io.*;
import java.net.Socket;

public class ServerWorker extends Thread {

    private final Socket socket;

    private final BufferedReader in;
    private final BufferedWriter out;

    public ServerWorker(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start(); // call run()
    }
    @Override
    public void run() {
        String word;
        try {
            while (true) {
                word = in.readLine();
                System.out.println(word);
                for (ServerWorker vr : Server.serverList) {
                    if (vr == this) {
                        vr.send(word); // send to client
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(String msg) {
        try {
            msg = prepareAnswer(msg);
            out.write(msg + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String prepareAnswer(String msg) {
        StringBuilder sb = new StringBuilder();
        char[] chars = msg.toCharArray();
        sb.append(chars[0]);
        sb.append(chars[chars.length - 1]);
        return sb.toString();
    }
}
