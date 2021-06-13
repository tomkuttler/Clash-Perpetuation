import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The TutorialWindow class displays the tutorial window.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialWindow extends UI
{    
    private String text;
    
    private int counter = 0;
    private int speed = 3;
    
    private boolean fade = false;
    private boolean fadeOutIn = false;
    
    //----- Reference -----
    private TutorialText tutorialText;
    
    //----- Object image -----
    private static final GreenfootImage window = new GreenfootImage("ui/window.png");

    /**
     * TutorialWindow Constructor:
     */
    public TutorialWindow(TutorialText newText)
    {
        setImage(window);
        getImage().setTransparency(0);
        
        tutorialText = newText;
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * 
     */
    public void act() 
    {
        fade();
    }

    public void fade()
    {
        if(fade)
        {                        
            if(counter >= 0 && counter <= 255)
            {                
                getImage().setTransparency(counter);
            }    
                
            counter += speed;
            
            if(counter >= 255)
            {                
                fade = false;
                
                tutorialText.updateText(text);
                tutorialText.fadeIn();
            }
            
            if(counter <= 0)
            {
                fade = false;
                
                if(fadeOutIn)
                {
                    speed = 3;
                    
                    fade = true;
                    
                    fadeOutIn = false;
                }                                
            }
        }
    }
    
    public void fadeIn()
    {                
        speed = 3;        
        
        fade = true;
    }
    
    public void fadeOut()
    {        
        speed = -3;
        
        fade = true;
    }
    
    public void fadeOutIn()
    {
        tutorialText.fadeOut();
        
        fadeOutIn = true;
    }
    
    public void updateText(String text)
    {
        this.text = text;
    }
}
