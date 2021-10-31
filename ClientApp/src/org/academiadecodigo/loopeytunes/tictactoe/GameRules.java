package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;

import java.util.ArrayList;

public class GameRules {
    private boolean gameOver;

    public boolean checkWin(ArrayList<String> playsList) {

        for (String[] posArray : winPositions()) {
            if (playsList.contains(posArray[0]) && playsList.contains(posArray[1]) && playsList.contains(posArray[2])) {

                /*int initialX = Integer.parseInt(posArray[0].split("#")[0]);
                int finalX = Integer.parseInt(posArray[2].split("#")[0]);

                int initialY = Integer.parseInt(posArray[0].split("#")[1]);
                int finalY = Integer.parseInt(posArray[2].split("#")[1]);

                Line line = new Line(initialX + 100, initialY + 100, finalX + 100, finalY + 100);
                line.setColor(Color.BLACK);
                line.grow(100, 100);
                line.draw();*/

                gameOver("Win");
                gameOver = true;

                return gameOver;

            }
        }

        return gameOver;
    }

    public boolean checkLoss(ArrayList<String> opponentPosList) {

        for (String[] posArray : winPositions()) {
            if (opponentPosList.contains(posArray[0]) && opponentPosList.contains(posArray[1]) && opponentPosList.contains(posArray[2])) {
                gameOver("Loss");
                gameOver = true;
                return gameOver;

            }
        }

        return gameOver;
    }

    public boolean checkTie(ArrayList<String> posList) {
        if (posList.size() == 9) {
            gameOver("Tie");
            gameOver = true;
            return gameOver;
        }

        return gameOver;
    }

    public String[][] winPositions() {
        return new String[][] {
                {"10#10", "210#10", "410#10"},
                {"10#210", "210#210", "410#10"},
                {"10#410", "210#410", "410#410"},
                {"10#10", "10#210", "10#410"},
                {"210#10", "210#210", "210#410"},
                {"410#10", "410#210", "410#410"},
                {"10#10", "210#210", "410#410"},
                {"10#410", "210#210", "410#10"}};
    }

    public void gameOver(String outcome) {
        switch (outcome) {
            case "Tie":
                System.out.println("It's a tie!");
                break;
            case "Win":
                System.out.println("You win!");
                break;
            case "Loss":
                System.out.println("You lose!");
                break;
        }

    }

}
