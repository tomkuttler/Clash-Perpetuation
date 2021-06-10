import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The HitCooldownBar class is used as a cooldown bar to show how long the player has to wait until he can use an item again.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitCooldownBar extends UI
{
    private static final int barWidth = 184;                            //The width of the color portion of the bar
    private static final int barHeight = 10;                            //The height of the color portion of the bar

    private static final Color backgroundColor = new Color(0, 0, 0, 0); //The background color of the entire object (Transparent)
    private static final Color textColor = Color.BLACK;                 //The color of all text
    private static final Color barColor = Color.BLUE;                   //The color of the bar

    private static final float fontSize = 18.0f;                        //The size of the text
    private int value = 0;                                              //The current value of the bar
    private int maximumValue;                                           //The maximum value of the bar (Here useCooldown)
    private static final int minimumValue = 0;                          //The minimum value of the bar
    private static final String unitOfMeasure = "";                     //The unit of measure of the bar (will apear right next to the bar)
    private static final boolean showTextualUnits = false;              //Determines whether or not the textual quantity of the bar is to show

    private double lastTickTime;                                        //Stores the time of the tick 
    private boolean decrease = false;                                   //True if an item was used and the value of the bar is currently decreasing

    /**
     * HitCooldownBar Constructor: Saves the initial values that are brought in and creates the bar image.
     *
     * @param 'initValue': the value the bar should be initially set to
     * @param 'maxValue': the highest value the bar is allowed to hold
     */
    public HitCooldownBar(int initValue, int maxValue)
    {
        maximumValue = maxValue;
        value = initValue;
        newImage();
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'checkDecrese' method to decrease the value if neccesary.
     */
    public void act()
    {
        checkDecrease();
    }

    /**
     * Method 'newImage': Builds a new image for the bar, determined by the values set for it.
     */
    private void newImage()
    {
        int barValue = (int) (barWidth * (value - minimumValue) / (maximumValue - minimumValue));
        GreenfootImage leftImg = new GreenfootImage("", (int) fontSize, textColor, backgroundColor);
        GreenfootImage rightImg = (showTextualUnits) ? new GreenfootImage(" " + value + " " + unitOfMeasure, (int) fontSize, textColor, backgroundColor) : new GreenfootImage(1, 1);
        int maxX = (leftImg.getWidth() > rightImg.getWidth()) ? leftImg.getWidth() : rightImg.getWidth();
        GreenfootImage barImg = new GreenfootImage(barWidth + 4, barHeight + 4);
        barImg.setColor(backgroundColor);
        barImg.fill();
        barImg.setColor(textColor);

        if (value > minimumValue)
        {            
            barImg.setColor(barColor);

            barImg.fillRect(2, 2, barValue, barHeight);
        }

        int sumX = 2 * maxX + barImg.getWidth();
        int maxY = 0;

        if (leftImg.getHeight() > maxY)
        {
            maxY = leftImg.getHeight();
        }
        if (barImg.getHeight() > maxY)
        {
            maxY = barImg.getHeight();
        }
        if (rightImg.getHeight() > maxY)
        {
            maxY = rightImg.getHeight();
        }

        GreenfootImage image = new GreenfootImage(sumX, maxY);
        image.setColor(backgroundColor);
        image.fill();
        image.drawImage(leftImg, maxX - leftImg.getWidth(), (image.getHeight() - leftImg.getHeight()) / 2);
        image.drawImage(barImg, maxX, (image.getHeight() - barImg.getHeight()) / 2);
        image.drawImage(rightImg, maxX + barImg.getWidth(), (image.getHeight() - rightImg.getHeight()) / 2);

        setImage(image);
    }

    /**
     * Method 'itemUsed': Is called in the 'useItem' method in player class, if an item was used.
     * It sets the maximum value and the value to the use cooldown of the currently used item (in millisecons (ms) NOT in nanoseconds).
     * It updates the image and saves the time of the current tick and sets the cecrease boolean to true.
     *
     * @param 'useCooldown': The use cooldown of the currently used item
     */
    public void itemUsed(double useCooldown)
    {
        maximumValue = (int) useCooldown / 1000;
        value = (int) useCooldown / 1000;
        newImage();

        lastTickTime = System.nanoTime();
        decrease = true;
    }

    /**
     * Method 'checkDecrease': Is called every tick by the 'act' method.
     * If an item was used and the bar value should decrease now, the delta time (in millisecons (ms) NOT in nanoseconds) between now and the last tick will be calculated.
     * The delta time will be subtracted from the current value and the image will be updated.
     * If the value is <= 0, the value will be set to the maximum value again.
     */
    public void checkDecrease()
    {
        if(decrease)
        {
            //Find elapsed time since last tick in milliseconds (ms)
            double dt = (System.nanoTime() - lastTickTime) / 1000.0;

            value -= dt;

            if(value <= 0)
            {
                value = maximumValue;
                decrease = false;
            }

            newImage();

            lastTickTime = System.nanoTime();
        }
    }
}
