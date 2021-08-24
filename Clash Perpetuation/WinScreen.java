import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world that will appear if you win.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class WinScreen extends World
{
    private static final double worldUpdateCooldown = 5000000000.0; //Cooldown of 5 bilion nanosec (5sec) after the win screen was displayed
    private double winScreenDisplayedTime;                          //Stores the time when the win screen was displayed
    
    //----- World Background -----
    private static final GreenfootImage winScreen = new GreenfootImage("worlds/winScreen.png");
    
    /**
     * WinScreen Constructor: Creates the world, sets the background and saves the time when the win screen was displayed.
     */
    public WinScreen()
    {    
        //Create a new world with 1361x915 cells with a cell size of 1x1 pixels.
        super(1361, 915, 1);        
        setBackground(winScreen);
        
        winScreenDisplayedTime = System.nanoTime();
    }
    
    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It sets the world to the cast screen 5 sec after the win screen was displayed.
     */
    public void act()
    {
        double t = System.nanoTime();
        if(t - winScreenDisplayedTime > worldUpdateCooldown)
        {
            Greenfoot.setWorld(new Cast());
        }
    }
}
