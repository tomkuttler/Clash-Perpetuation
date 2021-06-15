import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The StartScreenText is the 'Press enter to continue' text that fades in and out until the player begins the game.
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
    
    /**
     * StartScreenText Constructor: Sets the image completly transparent.
     */
    public StartScreenText()
    {
        setImage(text);
        getImage().setTransparency(0);
    }
    
    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It sets the transparency of the image to the counter variable and calls the 'appear' method and the 'checkStart' method.
     */
    public void act()
    {
        getImage().setTransparency(counter);
        appear();
        checkStart();
    }
    
    /**
     * Method 'appear': Is called every tick by the 'act' method.
     * It adds the speed to the counter. 
     * If the counter reaches 252 the speed will be set to a negative value.
     * If the counter reaches 0 the speed will be set to a positive value.
     * This will create the fade in and out animation.
     */
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
    
    /**
     * Method 'checkStart': Is called every tick by the 'act' method.
     * If the player pressed 'enter' the first world will be created.
     */
    public void checkStart()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new WorldMap1());
        }
    }   
}
