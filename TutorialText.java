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
     * TutorialText Constructor: Sets the correct text image.
     * 
     * @param 'text': The name of the text that should be displayed
     */
    public TutorialText()
    {
        setImage((GreenfootImage)null);
    }
    
    /**
     * Act - do whatever the TutorialText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
            } 
            
            if(counter <= 0)
            {
                fade = false;
                
                TutorialWindow window = getWorld().getObjects(TutorialWindow.class).get(0);
                window.fadeOut();
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
