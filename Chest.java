import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The chest class manages all chests.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chest extends Objects
{
    private int chestNumber;                         //Determines the image of the chest
    
    private boolean isClosed = true;                 //True if the chest can be opened, false if the chest was already opened
    
    private static final int maxSlots = 10;          //Max slots the chest can hold
    
    private String[] items = new String[maxSlots];   //Saves the chest items
    private int[] amount = new int[maxSlots];        //Saves the amount of the chest items
    
    //----- Object images -----
    private static final GreenfootImage chestClosed1 = new GreenfootImage("objects/chests/chestClosed1.png");
    private static final GreenfootImage chestOpened1 = new GreenfootImage("objects/chests/chestOpened1.png");
    private static final GreenfootImage chestClosed2 = new GreenfootImage("objects/chests/chestClosed2.png");
    private static final GreenfootImage chestOpened2 = new GreenfootImage("objects/chests/chestOpened2.png");
    
    /**
     * Chest Constructor: Sets the correct chest images and arrays.
     * 
     * @param 'chestNumber': The number of the chest image
     * @param 'items': The array that contains the name of the items that should be in the chest
     * @param 'amount': The array that contains the amount of the items that should be in the chest
     */
    public Chest(int chestNumber, String[] items, int[] amount)
    {
        this.chestNumber = chestNumber;
        
        if(chestNumber == 1)
        {
            setImage(chestClosed1);
        }
        else if(chestNumber == 2)
        {
            setImage(chestClosed2);
        }                
        
        for(int i = 0; i < maxSlots; i++)
        {
            this.items[i] = items[i]; 
        }
        
        for(int i = 0; i < maxSlots; i++)
        {
            this.amount[i] = amount[i]; 
        }
    }

    /**
     * Method 'getMaxSlots': Is called in the 'checkPickUp' method in Player class to get the max amount of slots of the chest.
     * 
     * @return: The max amount of slots of the chest
     */
    public int getMaxSlots()
    {
        return maxSlots;
    }
    
    /**
     * Method 'getItems': Is called in the 'checkPickUp' method in Player class to get the names of the items in the chest.
     * 
     * @return: The names of the items in the chest
     */
    public String[] getItems()
    {
        return items;
    }
    
    /**
     * Method 'getAmount': Is called in the 'checkPickUp' method in Player class to get the amount of the items in the chest.
     * 
     * @return: The amount of the items in the chest
     */
    public int[] getAmount()
    {
        return amount;
    }
    
    /**
     * Method 'isClosed': Is called in the 'checkPickUp' method in Player class to check if the chest was already opened.
     * 
     * @return: True if the chest can be opened, false if the chest was already opened
     */
    public boolean isClosed()
    {
        return isClosed;
    }
    
    /**
     * Method 'open': Is called in the 'checkPickUp' method in Player class, if the player opened this chest. 
     * The isCloed boolean will be set to false and the open image of the chest will be displayed.
     */
    public void open()
    {
        isClosed = false;
        
        if(chestNumber == 1)
        {
            setImage(chestOpened1);
        }
        else if(chestNumber == 2)
        {
            setImage(chestOpened2);
        }
    }
}
