import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The HealthBarUI class is used to display a health bar image on top the "real" PlayerHealthBar. All functionality is located in the PlayerHealthBar class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBarUI extends UI
{
    //Object image
    GreenfootImage bar = new GreenfootImage("ui/healthUI.png");
    
    /**
     * HealthBarUI Constructor: Makes the image 2 times bigger and sets it.
     */
    public HealthBarUI() 
    {
        bar.scale(bar.getWidth() * 2, bar.getHeight() * 2);
        setImage(bar);
    }
}
