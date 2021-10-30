package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class Cursor extends Position {

    private ArrayList<String> posList = new ArrayList<>();
    private boolean isPlaying;

    private String lastPlay;

    public Cursor(int x, int y, int witdh, int heigth) {
        super(x, y, witdh, heigth);

        rectangle.fill();
        new GameKeyboard(this);
    }

    public void moveUp() {
        if (rectangle.getY() > Field.PADDING) {
            rectangle.translate(0, -rectangle.getHeight());
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

    public void makeMove() {

        for (String pos : posList) {
            if ((rectangle.getX() + "#" + rectangle.getY()).equals(pos)) {
                System.out.println("nope, already filled");
                setPlaying(true);
                return;
            }
        }

        Rectangle teste = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        teste.setColor(Color.BLUE);
        teste.fill();

        lastPlay = teste.getX() + "#" + teste.getY();
        addPlayToList(lastPlay);
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void addPlayToList(String play) {
        posList.add(play);
    }

    public void addOpponentPlayToList(String opponentPlay){
        System.out.println(opponentPlay);
        posList.add(opponentPlay);
        String[] coordinates = opponentPlay.split("#");
        Rectangle teste = new Rectangle(parseDouble(coordinates[0]), parseDouble(coordinates[1]), rectangle.getWidth(), rectangle.getHeight());
        System.out.println("coordinates: " + coordinates[0] + coordinates[1]);
        teste.setColor(Color.RED);
        teste.fill();
    }

    public String getLastPlay() {
        return lastPlay;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public void nullLastPlay() {
        lastPlay = null;
    }
}
