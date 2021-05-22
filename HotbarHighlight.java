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
        hotbarHighlight.scale(hotbarHighlight.getWidth() * 2, hotbarHighlight.getHeight() * 2);
        setImage(hotbarHighlight);
    }
    
    public void updatePosition(int slotNumber)
    {
        setLocation(632 + slotNumber * 48, 897); 
    }
}
