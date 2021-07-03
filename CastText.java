import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Text that will be displayed on the cast screen.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CastText extends UI
{
    private static final int speed = 2; //The speed of the text in y direction
    
    //----- Object images -----
    private static final GreenfootImage castText = new GreenfootImage("ui/castText.png");
    
    /**
     * CastText Constructor: Sets the object image.
     */
    public CastText()
    {
        setImage(castText);
    }
    
    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'move' method.
     */
    public void act() 
    {
        move();
    }
    
    /**
     * Method 'move': Is called every tick by the 'act' method.
     * It moves the text in negative y direction.
     */
    public void move()
    {
        setLocation(getX(), getY() - speed);
    }
}
