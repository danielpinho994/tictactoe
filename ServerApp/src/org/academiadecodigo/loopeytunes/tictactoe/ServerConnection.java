package org.academiadecodigo.loopeytunes.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection implements Runnable {

    private final Socket clientSocket;
    private  final Server server;
    private BufferedReader in;
    private PrintWriter out;
    private String message = "";

    public ServerConnection(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;

        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            if (server.getConnectionCounter() % 2 != 0) {
                out.println("a");
            } else {
                out.println("b");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void start() {
        try {
            message = in.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(message != null) {
            server.broadcast(message, this);
        }
    }

    public void respond(String message){
        out.println(message);

        System.out.println("Server is OK. Position sent: " + message);
    }

    @Override
    public void run() {
        while (!message.equals("/q")) {
            start();
        }

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
