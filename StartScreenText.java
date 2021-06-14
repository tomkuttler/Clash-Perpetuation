import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreenText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreenText extends UI
{
    private int counter = 0;
    private int speed;
    
    //----- Object image -----
    private static final GreenfootImage text = new GreenfootImage("ui/startScreen/enterText.png");
    
    public StartScreenText()
    {
        setImage(text);
        getImage().setTransparency(0);
    }
    
    public void act()
    {
        getImage().setTransparency(counter);
        appear();
        checkStart();
    }
    
    public void appear()
    {
        counter += speed;
        
        if(counter == 252)
        {
            speed = -3;
        }
        
        if(counter == 0)
        {
            speed = 3;
        }
    }
    
    public void checkStart()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new WorldMap1());
        }
    }   
}
