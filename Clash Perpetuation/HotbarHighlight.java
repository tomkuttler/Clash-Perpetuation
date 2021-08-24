import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The HotbarHighlight class is used to show the player which hotbar slot is currently selected. This is an image which will be displayed over the currently selected hotbar slot.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class HotbarHighlight extends UI
{
    //----- Object image -----
    private static final GreenfootImage hotbarHighlight = new GreenfootImage("ui/hotbarHighlight.png");
    
    /**
     * HotbarHighlight Constructor: Sets the object image.
     */    
    public HotbarHighlight()
    {
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
