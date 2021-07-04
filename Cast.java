import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The last World. Shows credits.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class Cast extends World
{   
    //----- World Background -----
    private static final GreenfootImage cast = new GreenfootImage("worlds/cast.png");

    /**
     * Cast Constructor: Creates the world, sets the background and adds the cast text.
     */
    public Cast()
    {    
        //Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(cast);

        addObject(new CastText(), 848, 2000);
    }    
}
