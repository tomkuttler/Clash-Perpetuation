import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends World
{
    private static final GreenfootImage winScreen = new GreenfootImage("worlds/winScreen.png");
    
    public WinScreen()
    {    
        //Create a new world with 1361x915 cells with a cell size of 1x1 pixels.
        super(1361, 915, 1);        
        setBackground(winScreen);
    }
}
