package edu.up.cs301.campusmap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * <!-- class SimpleMapToken -->
 *
 * This class represents a single map token that can be drawn on a canvas
 *
 * @author Chelle Plaisted
 * @version September 2017
 */
public class SquareToken extends SimpleMapToken {


    /**
     * Constructor : calls super to instantiate
     * @param xCoord the x-coordinate
     * @param yCoord the y-coordinate
     */
    public SquareToken(float xCoord, float yCoord) {
        super(xCoord, yCoord);
    }//constructor

    /**
     * this token can paint itself on a given canvas
     * Overrides the super to draw square instead of circle
     * @param canvas the canvas on which to draw
     */
    @Override
    public void drawOn(Canvas canvas) {
        // paint the dot on the canvas
        canvas.drawRect(x,y, x+ radius * 2, y + radius * 2, paint);
    }//drawOn

}
