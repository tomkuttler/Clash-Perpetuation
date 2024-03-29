import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The EnemyHealthBar class is used as a health bar to show the health points of the enemys over their heads.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class EnemyHealthBar extends UI
{
    public int barWidth = 40;                                           //The width of the color portion of the bar
    public int barHeight = 5;                                           //The height of the color portion of the bar
    private static final int breakValue = 20;                           //The amount at which the color of the bar changes
    
    private static final Color backgroundColor = new Color(0, 0, 0, 0); //The background color of the entire object (Transparent)
    private static final Color textColor = Color.BLACK;                 //The color of all text and the rectangle frame of the bar
    private static final Color safeColor = Color.GREEN;                 //The color of the bar while in the safe range
    private static final Color dangerColor = Color.RED;                 //The color of the bar while in the danger range
    
    private static final float fontSize = 18.0f;                        //The size of the text
    private int value = 0;                                              //The current value of the bar
    private int maximumValue;                                           //The maximum value of the bar
    private static final int minimumValue = 0;                          //The minimum value of the bar 

    /**
     * EnemyHealthBar Constructor: Saves the initial values that are brought in and creates the bar image through the 'add(initValue)' call,
     * which sets the initial value of the bar and calls the 'newImage' method to build and set a new image for the bar.
     *
     * @param 'initValue': the value the bar should be initially set to
     * @param 'maxValue': the highest value the bar is allowed to hold
     */
    public EnemyHealthBar(int initValue, int maxValue)
    {
        maximumValue = maxValue;
        add(initValue);
    }

    /**
     * Method 'newImage': Builds a new image for the bar, determined by the values set for it.
     */
    public void newImage()
    {
        int barValue = (int) (barWidth * (value - minimumValue) / (maximumValue - minimumValue));
        GreenfootImage leftImg = new GreenfootImage("", (int) fontSize, textColor, backgroundColor);
        GreenfootImage rightImg = new GreenfootImage(1, 1);
        int maxX = (leftImg.getWidth() > rightImg.getWidth()) ? leftImg.getWidth() : rightImg.getWidth();
        GreenfootImage barImg = new GreenfootImage(barWidth + 4, barHeight + 4);
        barImg.setColor(backgroundColor);
        barImg.fill();
        barImg.setColor(textColor);
        
        //Draw a rectangle around the health bar
        barImg.drawRect(0, 0, barImg.getWidth() - 1, barImg.getHeight() - 1);
        
        if (value > minimumValue)
        {            
            if (value > breakValue) 
            {
                barImg.setColor(safeColor);
            }
            else 
            {
                barImg.setColor(dangerColor);
            }

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
     * Method 'add': Add an amount to the value of the bar, checks to make sure the new value is between minimumValue and maximumValue,
     * then, calls 'newImage' to build and set the new image for the bar.
     *
     * @param 'amount': the amount to add (if positive) or subtract (if negative) to the current value of the bar
     */
    public void add(int amount)
    {
        value += amount;
        checkValue();
        newImage();
    }

    /**
     * Method 'subtract': Subtracts an amount from the value of the bar, checks to make sure the new value does not overstep its bounds,
     * then, calls 'newImage' to build and set the new image for the bar.
     *
     * @param 'amount': the amount to subtract (if positive) or add (if negative) to the current value of the bar
     */
    public void subtract(int amount)
    {
        value -= amount;
        checkValue();
        newImage();
    }

    /**
     * Method 'checkValue': Ensures that the new value in between the minimum value and the maximum value for the bar.
     */
    private void checkValue()
    {
        if (value < minimumValue) 
        {
            value = minimumValue;
        }

        if (value > maximumValue) 
        {
            value = maximumValue;
        }
    }

    /**
     * Method 'getValue': Returns the current value of the bar.
     *
     * @return: the current value of the bar
     */
    public int getValue() 
    { 
        return value;
    }

    /**
     * Method 'setValue': Sets a new value for the bar, if in bounds.
     *
     * @param 'value': the new value for the bar
     */
    public void setValue(int value)
    { 
        this.value = value; 
        checkValue(); 
        newImage(); 
    }     
}
