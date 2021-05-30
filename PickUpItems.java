import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PickUpItems is the superclass of all items that can be picked up.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PickUpItems extends Objects
{
    private String name;
    private int amount;
    
    /**
     * Method 'setup': Is called in the constructor in every PickUpItems subclass, to pass the important variables.
     * 
     * @param 'name': The name of the item that can be picked up
     * @param 'amount': The amount of items that can be picked up
     */
    public void setup(String name, int amount)
    {
        this.name = name;
        this.amount = amount;
    }
    
    /**
     * Method 'getName': Is called in the 'addItem' method in inventory class, to add the correct item to the inventory, if the item was picked up.
     * 
     * @return: The name of the item that was picked up
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method 'getAmount': Is called in the 'addItem' method in inventory class, to add the correct amount to the inventory, if the item was picked up.
     * 
     * @return: The amount of the item that was picked up
     */
    public int getAmount()
    {
        return amount;
    }
    
    /**
     * Method 'pickedUp': Is called in the 'checkPickUp' method in player class, to remove the item from the world, if the item was picked up.
     */
    public void pickedUp()
    {
        getWorld().removeObject(this);
    }
}
