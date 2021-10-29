package org.academiadecodigo.loopeytunes.tictactoe;

import java.io.*;
import java.net.Socket;

public class Game {
    private Field field;
    private Cursor cursor;
    private final String host;
    private final int port;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private int cursorNumber = 0;


    public Game(String host, int port) {
        cursorNumber++;
        if (cursorNumber == 3) {
            cursorNumber = 1;
        }

        field = new Field();
        cursor = new Cursor(Field.PADDING, Field.PADDING, Field.WIDTH / 3, Field.HEIGHT / 3);
        this.host = host;
        this.port = port;
        setupConnection(host, port);
        listen();
    }

    public void setupConnection(String host, int port){
        try {
            clientSocket = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen(){
        if(cursorNumber == 1){
            sendPlay();
        }

        while (true) {
            String play = null;
            try {
                play = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            cursor.addOpponentPlay(play);

            sendPlay();
            System.out.println(play);
        }
    }

    private void sendPlay(){
        String play = cursor.makeMove();
        out.println(play);
    }
}
