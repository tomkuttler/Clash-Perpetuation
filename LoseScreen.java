import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world that will appear if you lose.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseScreen extends World
{
    //----- World Background -----
    private static final GreenfootImage loseScreen = new GreenfootImage("worlds/loseScreen.png");

    /**
     * LoseScreen Constructor: Creates the world and sets the background.
     */
    public LoseScreen()
    {    
        //Create a new world with 1463x915 cells with a cell size of 1x1 pixels.
        super(1463, 915, 1);        
        setBackground(loseScreen);
    }
}
