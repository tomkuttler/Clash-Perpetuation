import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseScreen extends World
{
    private static final GreenfootImage loseScreen = new GreenfootImage("worlds/loseScreen.png");
    
    public LoseScreen()
    {    
        //Create a new world with 1463x915 cells with a cell size of 1x1 pixels.
        super(1463, 915, 1);        
        setBackground(loseScreen);
    }
}
