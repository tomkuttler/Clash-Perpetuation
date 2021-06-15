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
     * TutorialWindow Constructor: Sets the window image transparent and sets the reference.
     * 
     * @param 'newText': The reference to the TutorialText
     */
    public TutorialWindow(TutorialText newText)
    {
        setImage(window);
        getImage().setTransparency(0);
        
        tutorialText = newText;
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'fade' method.
     */
    public void act() 
    {
        fade();
    }

    /**
     * Method 'fade': Is called every tick by the 'act' method.
     * If the fade boolean is set to true the window will fade in or out (corresponding to the speed variable set in the 'fadeIn' / 'fadeOut' method).
     */
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
    
    /**
     * Method 'fadeIn': Is called in the Tutorial class.
     * The window will start fading in.
     */
    public void fadeIn()
    {                
        speed = 3;        
        
        fade = true;
    }    
    
    /**
     * Method 'fadeOutIn': Is called in the Tutorial class.
     * The window will start fading out and in again.
     */
    public void fadeOutIn()
    {
        tutorialText.fadeOut();
        
        fadeOutIn = true;
    }
    
    /**
     * Method 'fadeOut': Is called in the Tutorial class.
     * The window will start fading out.
     */
    public void fadeOut()
    {                        
        tutorialText.fadeOut();                
    }
    
    /**
     * Method 'fadeOutCalledInTutorialText': Is called in the Tutorial Text class.
     * The window will start fading out and in again.
     */
    public void fadeOutCalledInTutorialText()
    {        
        speed = -3;
        
        fade = true;
    }
    
    /**
     * Method 'updateText': Is called in the Tutorial class.
     * It updates the name of the text that should be displayed next.
     * 
     * @param 'text': The name of the text that should be displayed next.
     */
    public void updateText(String text)
    {
        this.text = text;
    }
}
