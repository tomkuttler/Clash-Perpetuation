import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventoryUI extends UI
{
    //Object picture:
    GreenfootImage inventory = new GreenfootImage("ui/inventory.png");
    
    public InventoryUI()
    {
        inventory.scale(inventory.getWidth() * 2, inventory.getHeight() * 2);
        setImage((GreenfootImage)null);
    }
    
    public void setImageVisible()
    {
        setImage(inventory);
    }
}
