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
    
    public void setup(String name, int amount)
    {
        this.name = name;
        this.amount = amount;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAmount()
    {
        return amount;
    }
    
    public void pickedUp()
    {
        getWorld().removeObject(this);
    }
}
