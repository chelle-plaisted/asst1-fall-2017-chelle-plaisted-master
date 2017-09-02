package edu.up.cs301.campusmap;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Matrix;
import android.graphics.RectF;

/**
 * <!-- class SimpleMapToken -->
 *
 * This class represents a single map token that can be drawn on a canvas
 *
 * @author Andrew M. Nuxoll
 * @author Steven R. Vegdahl
 * @author <your name here>
 * @version August 2017
 */
public class SpecialToken extends SimpleMapToken {

    /**
     * Constructor
     * @param xCoord the x-coordinate
     * @param yCoord the y-coordinate
     */
    public SpecialToken(float xCoord, float yCoord) {
        super(xCoord, yCoord);
    }//constructor

    /**
     * this token can paint itself on a given canvas
     * @param canvas the canvas on which to draw
     */
    @Override
    public void drawOn(Canvas canvas) {
        // set up points to draw original triangle (each vertex is 2 * radius from center
        int r = (int) (2 * radius);
        Point point1_draw = new Point((int) (x - r / 2), (int)(y + r / 2));
        Point point2_draw = new Point((int) (x + r / 2), (int) (y + r / 2));
        Point point3_draw = new Point((int) x, (int) (y - r / 2));

        // set-up outline of triangle for Path object
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(point1_draw.x,point1_draw.y);
        path.lineTo(point2_draw.x,point2_draw.y);
        path.lineTo(point3_draw.x,point3_draw.y);
        path.lineTo(point1_draw.x,point1_draw.y);
        path.close();

        // draw original triangle
        canvas.drawPath(path, paint);

        // rotate Path by 180
        float angle = 180;
        Matrix mMatrix = new Matrix();
        RectF bounds = new RectF();
        path.computeBounds(bounds, true);
        mMatrix.postRotate(angle, bounds.centerX(), bounds.centerY());
        path.transform(mMatrix);

        // draw rotated Path for hourglass-like shape
        canvas.drawPath(path, paint);
    }//drawOn

}
