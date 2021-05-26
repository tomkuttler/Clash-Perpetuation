import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HotbarUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HotbarUI extends UI
{
    //Object image
    GreenfootImage hotbar = new GreenfootImage("ui/hotbar.png");
    
    public HotbarUI()
    {
        hotbar.scale(hotbar.getWidth() * 2, hotbar.getHeight() * 2);
        setImage(hotbar);
    }
}
