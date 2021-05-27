import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The HotbarHighlight class is used to show the player which hotbar slot is currently selected. This is an image which will be displayed over the currently selected hotbar slot.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HotbarHighlight extends UI
{
    //----- Object image -----
    GreenfootImage hotbarHighlight = new GreenfootImage("ui/hotbarHighlight.png");
    
    /**
     * HotbarHighlight Constructor: Makes the object image 2 times bigger and sets it.
     */    
    public HotbarHighlight()
    {
        hotbarHighlight.scale(hotbarHighlight.getWidth() * 2, hotbarHighlight.getHeight() * 2);
        setImage(hotbarHighlight);
    }
    
    /**
     * Method 'updatePosition': Is called by 'updateCurrentSlot' in Hotbar class if player pressed the right or left key to scroll through the hotbar.
     * It sets the location of the hotbarHighlight image over the currently selected hotbar slot.
     * 
     * @param 'slotNumber': The number of the currently selected slot (must be 0 - 9)
     */
    public void updatePosition(int slotNumber)
    {
        setLocation(632 + slotNumber * 48, 897); 
    }
}
