import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chest extends Objects
{
    private boolean isClosed = true;
    
    private int maxSlots = 10;                       //Max slots the chest can hold
    
    private String[] items = new String[maxSlots];   //Saves the chest items
    private int[] amount = new int[maxSlots];        //Saves the amount of the chest items
    
    //Object pictures
    GreenfootImage chestClosed;
    GreenfootImage chestOpened;
    
    public Chest(int chestNumber, String[] items, int[] amount)
    {
        if(chestNumber == 1)
        {
            chestClosed = new GreenfootImage("objects/chests/chestClosed1.png");
            chestOpened = new GreenfootImage("objects/chests/chestOpened1.png");
        }
        else if(chestNumber == 2)
        {
            chestClosed = new GreenfootImage("objects/chests/chestClosed2.png");
            chestOpened = new GreenfootImage("objects/chests/chestOpened2.png");
        }
        
        setImage(chestClosed);
        
        for(int i = 0; i < maxSlots; i++)
        {
            this.items[i] = items[i]; 
        }
        
        for(int i = 0; i < maxSlots; i++)
        {
            this.amount[i] = amount[i]; 
        }
    }

    public int getMaxSlots()
    {
        return maxSlots;
    }
    
    public String[] getItems()
    {
        return items;
    }
    
    public int[] getAmount()
    {
        return amount;
    }
    
    public boolean isClosed()
    {
        return isClosed;
    }
    
    public void open()
    {
        isClosed = false;
        
        setImage(chestOpened);
    }
}
