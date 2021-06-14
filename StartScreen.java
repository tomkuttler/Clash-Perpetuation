import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    private static final GreenfootImage startScreen = new GreenfootImage("worlds/startScreen.png");
    
    public StartScreen()
    {    
        //Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);        
        setBackground(startScreen);
        
        addObject(new StartScreenText(), 848, 580);
    }
}
