import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the arrow item that can be picked up and NOT the flying arrow.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class ArrowItem extends Weapons
{
    private String name;
    private int amount;
    
    //----- Object image -----
    private static final GreenfootImage arrow1 = new GreenfootImage("objects/arrows/arrow1.png");
    
    public ArrowItem(String name, int amount)
    {
        if(name == "arrow1")
        {
            setImage(arrow1);
            
            this.name = name;
        }
        
        this.amount = amount;
        
        setup(name, amount);
    }    
}
