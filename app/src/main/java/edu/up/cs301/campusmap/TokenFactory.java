package edu.up.cs301.campusmap;

/**
 * <!-- class TokenFactory -->
 *
 * This class is used to create map tokens.
 *
 * @author Andrew M. Nuxoll
 * @author Steven R. Vegdahl
 * @author Chelle Plaisted
 * @version September 2017
 */

public class TokenFactory {
    /**
     * createMapToken
     *
     * creates a new object whose type is SimpleMapToken or some subclass
     * thereof and returns it to the caller
     *
     * @param x x-coordinate of the token
     * @param y y-coordinate of the token
     * @param type which type of token to draw (0, 1 or 2)
     */
    public static SimpleMapToken createMapToken(float x, float y, int type)
    {
        //For now, only one type of map token exists
        switch(type)
        {
            case 0:
                return new SimpleMapToken(x,y);
            case 1:
                return new SquareToken(x,y);
            case 2:
                return new SpecialToken(x,y);
            default:
                return new SimpleMapToken(x,y);
        }
    }//createMapToken

}//class TokenFactory
