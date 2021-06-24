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

    private static final double updateCooldown = 3000000000.0; //Cooldown after the player fullfilled the tutorial message
    private double lastActionTime;                             //Time when the player fullfilled the tutorial message

    private boolean killAllEnemysText = false;                 //True if the kill all enemy text is currently being displayed
    private static final double removeCooldown = 5000000000.0; //Cooldown after the kill all enemy text was displayed
    private double lastKillAllEnemysTextTime;                  //Time when the kill all enemy text was displayed

    //----- Reference -----
    private TutorialWindow window;                             //Reference to the tutorial window

    /**
     * Tutorial Constructor: Sets the image to null and sets the reference to the window.
     * 
     * @param 'newWindow': Reference to the tutorial window
     * @param 'showTutorial': Only true in the first world to show the tutorial only once.
     */
    public Tutorial(TutorialWindow newWindow, boolean showTutorial)
    {
        setImage((GreenfootImage)null);

        tutorialFinished = !showTutorial;
        window = newWindow;
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'updateTutorialText' method, the 'checkPlayer' method, the 'changeText' method and the 'removeKillAllEnemysText' method.
     */
    public void act() 
    {
        updateTutorialText();

        checkPlayer();

        changeText();

        removeKillAllEnemysText();
    }

    /**
     * Method 'updateTutorialText': Is called every tick by the 'act' method.
     * If the textToDisplayNext variable was updated in the 'changeText' method, the text will be updated and the window will fade in (out and in again / out).
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

                checkPlayer = "pickUpPotion";
                textToDisplayNext = "";
            }
            else if(textToDisplayNext == "tutorialText3")
            {
                window.updateText(textToDisplayNext);
                window.fadeOutIn();

                checkPlayer = "openInventory";
                textToDisplayNext = "";
            }
            else if(textToDisplayNext == "tutorialText4")
            {
                window.updateText(textToDisplayNext);
                window.fadeOutIn();

                checkPlayer = "dragPotion";
                textToDisplayNext = "";
            }
            else if(textToDisplayNext == "tutorialFinished")
            {
                window.fadeOut();

                checkPlayer = "";
                textToDisplayNext = "";

                tutorialFinished = true;
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
        else if(checkPlayer == "pickUpPotion")
        {
            if(getWorld().getObjects(Potion.class).isEmpty())
            {
                changeVariableTo = "tutorialText3";

                lastActionTime = System.nanoTime();

                checkPlayer = "";
            }
        }
        else if(checkPlayer == "openInventory")
        {
            if(Greenfoot.isKeyDown("i"))
            {
                changeVariableTo = "tutorialText4";

                lastActionTime = System.nanoTime();

                checkPlayer = "";
            }
        }
        else if(checkPlayer == "dragPotion")
        {
            if(getWorld().getObjects(Hotbar.class).get(0).isInHotbar("redPotion"))
            {
                changeVariableTo = "tutorialFinished";

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
            textToDisplayNext = changeVariableTo;
            changeVariableTo = "";
        }
    }

    public void removeKillAllEnemysText()
    {
        if(killAllEnemysText)
        {
            double t = System.nanoTime();
            if(t - lastKillAllEnemysTextTime >= removeCooldown)
            {
                window.fadeOut();

                killAllEnemysText = false;
            }
        }
    }

    public void killAllEnemysText()
    {
        lastKillAllEnemysTextTime = System.nanoTime();

        killAllEnemysText = true;

        window.updateText("killAllEnemysText");
        window.fadeIn();
    }
}
