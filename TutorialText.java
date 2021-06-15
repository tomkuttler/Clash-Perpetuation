import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The TutorialText class displays the tutorial text messages.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialText extends UI
{
    private int counter = 0;
    private int speed = 3;
    
    private boolean fade = false;
    
    //----- Object images -----
    private static final GreenfootImage tutorialText1 = new GreenfootImage("ui/tutorialText/tutorialText1.png");
    private static final GreenfootImage tutorialText2 = new GreenfootImage("ui/tutorialText/tutorialText1.png");
    
    /**
     * TutorialText Constructor: Sets the image to null.
     */
    public TutorialText()
    {
        setImage((GreenfootImage)null);
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
     * If the fade boolean is set to true the text will fade in or out (corresponding to the speed variable set in the 'fadeIn' / 'fadeOut' method).
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
            } 
            
            if(counter <= 0)
            {
                fade = false;
                
                TutorialWindow window = getWorld().getObjects(TutorialWindow.class).get(0);
                window.fadeOutCalledInTutorialText();
            }
        }
    }
    
    /**
     * Method 'fadeIn': Is called in the TutorialWindow class.
     * The text will start fading in.
     */
    public void fadeIn()
    {        
        speed = 3;       
        
        fade = true;
    }
    
    /**
     * Method 'fadeOut': Is called in the TutorialWindow class.
     * The text will start fading out.
     */
    public void fadeOut()
    {        
        speed = -3;        
        
        fade = true;
    }
    
    /**
     * Method 'updateText': Is called in the TutorialWindow class.
     * The correct image will be set.
     */
    public void updateText(String text)
    {
        if(text == "tutorialText1")
        {
            setImage(tutorialText1);
            getImage().setTransparency(0);
        }
        else if(text == "tutorialText2")
        {
            setImage(tutorialText2);
            getImage().setTransparency(0);
        }
    }
}
