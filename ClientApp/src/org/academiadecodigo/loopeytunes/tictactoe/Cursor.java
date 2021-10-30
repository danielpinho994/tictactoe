package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.util.ArrayList;
import static java.lang.Double.parseDouble;

public class Cursor extends Position {

    private final ArrayList<String> posList = new ArrayList<>();
    private final ArrayList<String> myPosList = new ArrayList<>();
    private final ArrayList<String> opponentPosList = new ArrayList<>();
    private boolean isPlaying;
    private final GameRules gameRules;
    private String lastPlay;

    public Cursor(int x, int y, int width, int height) {
        super(x, y, width, height);

        rectangle.fill();
        new GameKeyboard(this);
        gameRules = new GameRules();
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
        gameRules.checkWin(myPosList);
        gameRules.checkTie(posList);
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void addPlayToList(String play) {
        posList.add(play);
        myPosList.add(play);
    }

    public void addOpponentPlayToList(String opponentPlay){
        System.out.println(opponentPlay);
        posList.add(opponentPlay);
        opponentPosList.add(opponentPlay);
        String[] coordinates = opponentPlay.split("#");
        Rectangle teste = new Rectangle(parseDouble(coordinates[0]), parseDouble(coordinates[1]), rectangle.getWidth(), rectangle.getHeight());
        System.out.println("coordinates: " + coordinates[0] + coordinates[1]);
        teste.setColor(Color.RED);
        teste.fill();
        gameRules.checkLoss(opponentPosList);
        gameRules.checkTie(posList);
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
