package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

   protected Rectangle rectangle;

   private int witdh;
   private int heigth;
   private int x;
   private int y;

    public Position(int x, int y, int witdh, int heigth ) {

        rectangle = new Rectangle(x, y, witdh, heigth);
        rectangle.draw();
    }
}
