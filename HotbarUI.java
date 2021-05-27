import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The HotbarUI class is used to display a hotbar image under the hotbar slots. All functionality is located in the Hotbar class and the HotbarSlot class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HotbarUI extends UI
{
    //----- Object image -----
    GreenfootImage hotbar = new GreenfootImage("ui/hotbar.png");
    
    /**
     * HotbarUI Constructor: Makes the image 2 times bigger and sets it.
     */
    public HotbarUI()
    {
        hotbar.scale(hotbar.getWidth() * 2, hotbar.getHeight() * 2);
        setImage(hotbar);
    }
}
