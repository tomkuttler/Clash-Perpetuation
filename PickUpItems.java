import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PickUpItems here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PickUpItems extends Objects
{
    private int healthPoints;
    
    public void setup(int healthPoints)
    {
        this.healthPoints = healthPoints;
    }
    
    public int getHealthPoints()
    {
        return healthPoints;
    }
    
    public void pickedUp()
    {
        getWorld().removeObject(this);
    }
}
