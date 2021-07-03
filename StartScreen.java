import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the first world.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        //Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);        
        setBackground(startScreen);
        
        addObject(new StartScreenText(), 848, 580);
    }
}
