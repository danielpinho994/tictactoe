package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cursor extends Position {

    private ArrayList<String> posList = new ArrayList<>();

    public Cursor(int x, int y, int witdh, int heigth) {
        super(x, y, witdh, heigth);
        rectangle.fill();
        new GameKeyboard(this);
    }

    public void moveUp() {
        if (rectangle.getY() > Field.PADDING) {
            rectangle.translate(0,-rectangle.getHeight());
        }
    }

    public void moveDown() {
        if (rectangle.getY() < Field.HEIGHT - rectangle.getHeight() - Field.PADDING) {
            rectangle.translate(0, rectangle.getHeight());
        }
    }

    public void moveLeft() {
        if (rectangle.getX() > Field.PADDING) {
            rectangle.translate(-rectangle.getWidth(), 0);
        }
    }

    public void moveRight() {
        if (rectangle.getX() < Field.WIDTH - rectangle.getWidth() - Field.PADDING) {
            rectangle.translate(rectangle.getWidth(), 0);
        }
    }

    public String makeMove() {
        readSelection();

        for (String pos : posList) {
            if ((rectangle.getX() + "|" + rectangle.getY()).equals(pos)) {
                System.out.println("nope, already filled");
                readSelection();
                return null;
            }
        }

        Rectangle teste = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        teste.setColor(Color.BLUE);
        teste.fill();
        posList.add(teste.getX() + "|" + teste.getY());

        return teste.getX() + "|" + teste.getY();
    }

    public void addOpponentPlay(String play){
        this.posList.add(play);
    }

    public void readSelection(){
        //fica à escuta de uma mensagem que só é enviada depois de se carregar no enter. Enter passa a ser a tecla para escolher jogada

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
