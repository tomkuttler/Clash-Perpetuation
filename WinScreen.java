import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends World
{
    private static final double worldUpdateCooldown = 5000000000.0;   //Cooldown of 5 bilion nanosec (5sec) after the win screen was displayed
    private double winScreenDisplayedTime;                           //Stores the time when the win screen was displayed
    
    private static final GreenfootImage winScreen = new GreenfootImage("worlds/winScreen.png");
    
    public WinScreen()
    {    
        //Create a new world with 1361x915 cells with a cell size of 1x1 pixels.
        super(1361, 915, 1);        
        setBackground(winScreen);
        
        winScreenDisplayedTime = System.nanoTime();
    }
    
    public void act()
    {
        double t = System.nanoTime();
        if(t - winScreenDisplayedTime > worldUpdateCooldown)
        {
            Greenfoot.setWorld(new Cast());
        }
    }
}
