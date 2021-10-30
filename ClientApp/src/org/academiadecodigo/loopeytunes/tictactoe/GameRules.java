package org.academiadecodigo.loopeytunes.tictactoe;

import java.util.ArrayList;

public class GameRules {

    public void checkWin(ArrayList<String> playsList) {

        for (String[] posArray : winPositions()) {
            if (playsList.contains(posArray[0]) && playsList.contains(posArray[1]) && playsList.contains(posArray[2])) {
                gameOver("Win");
            }
        }
    }

    public void checkLoss(ArrayList<String> opponentPosList) {

        for (String[] posArray : winPositions()) {
            if (opponentPosList.contains(posArray[0]) && opponentPosList.contains(posArray[1]) && opponentPosList.contains(posArray[2])) {
                gameOver("Loss");

            }
        }
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

    public void checkTie(ArrayList<String> posList) {
        if (posList.size() == 9) {
            gameOver("Tie");
        }
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
