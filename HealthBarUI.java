import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBarUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBarUI extends UI
{
    //Object picture:
    GreenfootImage bar = new GreenfootImage("ui/healthUI.png");
    
    public HealthBarUI() 
    {
        bar.scale(bar.getWidth() * 2, bar.getHeight() * 2);
        setImage(bar);
    }
}
