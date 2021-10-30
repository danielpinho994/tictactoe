package org.academiadecodigo.loopeytunes.tictactoe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final int port = 9900;
    private ServerSocket serverSocket;
    private ExecutorService cachedPool;
    private HashMap<Integer, ServerConnection> hashMap;
    private int connectionCounter = 0;

    public Server() {
        try {
            setupConnection();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                connectionCounter++;
                ServerConnection serverConnection = new ServerConnection(clientSocket,this);
                cachedPool.submit(serverConnection);
                hashMap.put(connectionCounter, serverConnection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setupConnection() throws IOException {
        serverSocket = new ServerSocket(port);
        cachedPool = Executors.newCachedThreadPool();
        hashMap = new HashMap<>();
    }

    public void broadcast(String message, ServerConnection sender){

        for (ServerConnection serverConnection : hashMap.values()){
            if(!serverConnection.equals(sender)) {
                serverConnection.respond(message);
            }
        }
    }

    public int getConnectionCounter() {
        return connectionCounter;
    }

    public static void main(String[] args) {
        new Server();
    }
}
