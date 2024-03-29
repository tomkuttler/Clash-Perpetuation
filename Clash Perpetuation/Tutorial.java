import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Tutorial class manages the tutorial window and the tutorial text.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class Tutorial extends UI
{
    private boolean tutorialFinished = false;                   //True if the tutorial was finished

    private String textToDisplayNext = "tutorialText1";         //The name of the text which should be displayed next
    private String checkPlayer;                                 //The action the player has to do

    private String changeVariableTo;                            //The name to which the textToDisplayNext String should be set after the cooldown

    private static final double updateCooldown = 3000000000.0;  //Cooldown after the player fullfilled the tutorial message
    private double lastActionTime;                              //Time when the player fullfilled the tutorial message

    private static final double remTutCooldown = 10000000000.0; //Cooldown after the last tutorial message was displayed (Tutorial will be finished after cooldown)
    private double lastMessageDisplayedTime;                    //Time when the last tutorial message was displayed
    
    private boolean killAllEnemysText = false;                  //True if the kill all enemy text is currently being displayed
    private static final double removeCooldown = 5000000000.0;  //Cooldown after the kill all enemy text was displayed
    private double lastKillAllEnemysTextTime;                   //Time when the kill all enemy text was displayed

    //----- Reference -----
    private TutorialWindow window;                              //Reference to the tutorial window

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
            else if(textToDisplayNext == "tutorialText5")
            {
                window.updateText(textToDisplayNext);
                window.fadeOutIn();

                checkPlayer = "pickUpSword";
                textToDisplayNext = "";
            }
            else if(textToDisplayNext == "tutorialText6")
            {
                window.updateText(textToDisplayNext);
                window.fadeOutIn();

                checkPlayer = "killEnemy";
                textToDisplayNext = "";
            }
            else if(textToDisplayNext == "tutorialText7")
            {
                window.updateText(textToDisplayNext);
                window.fadeOutIn();

                checkPlayer = "takePotion";
                textToDisplayNext = "";
            }
            else if(textToDisplayNext == "tutorialText8")
            {
                window.updateText(textToDisplayNext);
                window.fadeOutIn();

                checkPlayer = "nextStage";
                textToDisplayNext = "";
                
                lastMessageDisplayedTime = System.nanoTime();
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
                changeVariableTo = "tutorialText5";

                lastActionTime = System.nanoTime();

                checkPlayer = "";
            }
        }
        else if(checkPlayer == "pickUpSword")
        {
            if(getWorld().getObjects(Hotbar.class).get(0).getCurrentSlotItem() == "saber")
            {
                changeVariableTo = "tutorialText6";

                lastActionTime = System.nanoTime();

                checkPlayer = "";
            }
        }
        else if(checkPlayer == "killEnemy")
        {
            if(getWorld().getObjects(Enemy.class).isEmpty())
            {
                changeVariableTo = "tutorialText7";

                lastActionTime = System.nanoTime();

                checkPlayer = "";
            }
        }
        else if(checkPlayer == "takePotion")
        {
            if(!getWorld().getObjects(Hotbar.class).get(0).isInHotbar("redPotion"))
            {
                changeVariableTo = "tutorialText8";

                lastActionTime = System.nanoTime();

                checkPlayer = "";
            }
        }
        else if(checkPlayer == "nextStage")
        {
            double t = System.nanoTime();
            if(t - lastMessageDisplayedTime >= remTutCooldown)
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
    
    /**
     * Method 'removeKillAllEnemysText': Is called every tick by the 'act' method.
     * If the kill all enemys text is currently displayed and enough time passed since the display time, the text will be removed again.
     */
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
    
    /**
     * Method 'killAllEnemysText': Is called by the 'checkChangeMap' method in Player class if the player wants to advance to the next stage, but there are still enemys in the world of the player.
     * The kill all enemys text will be displayed and time will be stored.
     */
    public void killAllEnemysText()
    {
        lastKillAllEnemysTextTime = System.nanoTime();

        killAllEnemysText = true;

        window.updateText("killAllEnemysText");
        window.fadeIn();
    }
}
