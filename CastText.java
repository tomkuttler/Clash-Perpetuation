import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CastText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CastText extends UI
{
    private static final int speed = 2;
    
    //----- Object images -----
    private static final GreenfootImage castText = new GreenfootImage("ui/castText.png");
    
    public CastText()
    {
        setImage(castText);
    }
    
    /**
     * Act - do whatever the CastText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }
    
    public void move()
    {
        setLocation(getX(), getY() - speed);
    }
}
