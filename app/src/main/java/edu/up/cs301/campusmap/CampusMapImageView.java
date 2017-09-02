package edu.up.cs301.campusmap;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.ArrayList;

/**
 * <!-- class CampusMapImageView -->
 *
 * This class displays the campus map.
 *
 * @author Steven R. Vegdahl
 * @author Chelle Plaisted
 * @version September 2017
 */
public class CampusMapImageView extends ImageView {

    // instance variable to keep track of tokens
    private ArrayList<SimpleMapToken> tokens;

    /**
     * adds to new token to the list
     * @param tok the new token
     */
    public void setToken(SimpleMapToken tok) {
        // set the current and previous tokens, based on the new
        // token that has been given to us
        tokens.add(tok);
    }

    /**
     * two-argument version of the constructor
     *
     * @param context Context object
     * @param attrs AttributeSet object
     */
    public CampusMapImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // perform the common constructor operations
        init();
    }

    /**
     * one-argument version of the constructor
     *
     * @param context Context object
     */
    public CampusMapImageView(Context context) {
        super(context);
        // perform the common constructor operations
        init();
    }

    /**
     * performs initialization common to both constructors
     */
    private void init() {
        tokens = new ArrayList<SimpleMapToken>();
    }

    /**
     * draws the maps and tokens
     * @param g Canvas
     */
    @Override
    protected void onDraw(Canvas g) {
        super.onDraw(g);
        for(SimpleMapToken t : tokens) {
           t.drawOn(g);
        }
    }
}


