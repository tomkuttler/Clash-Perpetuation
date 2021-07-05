import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the first world.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class StartScreen extends World
{
    //----- World Background -----
    private static final GreenfootImage startScreen = new GreenfootImage("worlds/startScreen.png");
    
    /**
     * StartScreen Constructor: Creates the world, sets the background and adds the start screen text.
     */
    public StartScreen()
    {    
        //Create a new world with 1392x928 cells with a cell size of 1x1 pixels.
        super(1392, 928, 1);        
        setBackground(startScreen);
        
        addObject(new StartScreenText(), 696, 580);
        
        Greenfoot.start();
    }
}
