import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The HealthBarUI class is used to display a health bar image on top the "real" PlayerHealthBar. All functionality is located in the PlayerHealthBar class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBarUI extends UI
{
    //----- Object image -----
    private static final GreenfootImage bar = new GreenfootImage("ui/healthUI.png");
    
    /**
     * HealthBarUI Constructor: Sets the object image.
     */
    public HealthBarUI() 
    {
        setImage(bar);
    }
}
