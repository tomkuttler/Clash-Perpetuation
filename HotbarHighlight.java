import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HotbarHighlight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HotbarHighlight extends UI
{
    //Object picture:
    GreenfootImage hotbarHighlight = new GreenfootImage("ui/hotbarHighlight.png");
    
    public HotbarHighlight()
    {
        setImage(hotbarHighlight);
    }
    
    public void updatePosition(int slotNumber)
    {
        setLocation(192 + slotNumber * 24, 384);
    }
}
