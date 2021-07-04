import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bow class manages the bow item that the player can pick up.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class Bow extends Weapons
{
    private String name;
    private int amount = 1;
    
    //----- Object image -----
    private static final GreenfootImage bow1 = new GreenfootImage("objects/weapons/bow1Icon.png");
    
    public Bow(String name)
    {
        if(name == "bow1")
        {
            setImage(bow1);
            
            this.name = name;
        }
        
        setup(name, amount);
    }    
}
