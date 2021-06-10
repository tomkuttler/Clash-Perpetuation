import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bows here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bow extends Weapons
{
    private String name;
    private int amount = 1;
    
    //Object pictures
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
