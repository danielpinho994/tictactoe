package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    public final static int PADDING = 10;
    public static Rectangle field;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    public Field() {
        field = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        field.draw();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                new Position(i * WIDTH / 3 + PADDING, j * HEIGHT / 3 + PADDING, WIDTH / 3, HEIGHT / 3);
            }
        }
    }
}
