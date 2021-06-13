import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Tutorial class manages the tutorial window and the tutorial text.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends UI
{
    private boolean tutorialFinished = false;                  //True if the tutorial was finished

    private String textToDisplayNext = "tutorialText1";        //The name of the text which should be displayed next
    private String checkPlayer;                                //The action the player has to do

    private String changeVariableTo;                           //The name to which the textToDisplayNext String should be set after the cooldown
    
    private static final double updateCooldown = 5000000000.0; //Cooldown after the player fullfilled the tutorial message
    private double lastActionTime;                             //Time when the player fullfilled the tutorial message

    //----- Reference -----
    private TutorialWindow window;                             //Reference to the tutorial window

    /**
     * Tutorial Constructor: Sets the image to null and sets the reference to the window.
     */
    public Tutorial(TutorialWindow newWindow)
    {
        setImage((GreenfootImage)null);

        window = newWindow;
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'updateTutorialText' method, the 'checkPlayer' method and the 'changeText' method.
     */
    public void act() 
    {
        updateTutorialText();

        checkPlayer();
        
        changeText();
    }

    /**
     * Method 'updateTutorialText': Is called every tick by the 'act' method.
     * It calls the 'updateText' method and the 'fadeIn' method or 'fadeOutIn' method in TutorialWindow class to start the fading of the window.
     * It sets the checkPlayer variable to the action that the player has to do.
     */ 
    public void updateTutorialText()
    {
        if(!tutorialFinished)
        {
            if(textToDisplayNext == "tutorialText1")
            {
                window.updateText(textToDisplayNext);
                window.fadeIn();

                checkPlayer = "walk";
                textToDisplayNext = "";
            }
            else if(textToDisplayNext == "tutorialText2")
            {
                window.updateText(textToDisplayNext);
                window.fadeOutIn();

                textToDisplayNext = "";
            }
        }
    }

    /**
     * Method 'checkPlayer': Is called every tick by the 'act' method.
     * It checks if the Player has completed the action that the tutorial text showed.
     * If the player completed the action, the changeVariableTo variable will be changed to the name of the next tutorial text.
     * The current time will be saved and the checkPlayer variable will be cleared.
     */
    public void checkPlayer()
    {
        if(checkPlayer == "walk")
        {
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("d"))
            {
                changeVariableTo = "tutorialText2";
                
                lastActionTime = System.nanoTime();
                
                checkPlayer = "";
            }
        }
    }

    /**
     * Method 'changeText': Is called every tick by the 'act' method.
     * If the changeVariableTo variable was changed to the name of the next tutorial text in the 'checkPlayer' method, 
     * the textToDisplayNext variable will be changed to the name of the next tutorial text after the updateCooldown.
     */
    public void changeText()
    {
        double t = System.nanoTime();
        if(t - lastActionTime >= updateCooldown)
        {
            if(changeVariableTo == "tutorialText2")
            {
                textToDisplayNext = "tutorialText2";
                changeVariableTo = "";
            }
        }
    }
}
