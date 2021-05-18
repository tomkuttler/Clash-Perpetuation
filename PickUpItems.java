import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PickUpItems here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PickUpItems extends Objects
{
    private String name;
    private int amount;
    private int maxStackSize;
    
    public void setup(String name, int amount, int maxStackSize)
    {
        this.name = name;
        this.amount = amount;
        this.maxStackSize = maxStackSize;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAmount()
    {
        return amount;
    }
    
    public int getMaxStackSize()
    {
        return maxStackSize;
    }
    
    public void pickedUp()
    {
        getWorld().removeObject(this);
    }
}
