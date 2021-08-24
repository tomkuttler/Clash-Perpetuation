import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The HotbarUI class is used to display a hotbar image under the hotbar slots. All functionality is located in the Hotbar class and the HotbarSlot class.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class HotbarUI extends UI
{
    //----- Object image -----
    private static final GreenfootImage hotbar = new GreenfootImage("ui/hotbar.png");
    
    /**
     * HotbarUI Constructor: Sets the object image.
     */
    public HotbarUI()
    {
        setImage(hotbar);
    }
}
