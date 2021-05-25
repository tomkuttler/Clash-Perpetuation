import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowInventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrowItem extends Weapons
{
    private String name;
    private int amount;
    
    //Object pictures
    GreenfootImage arrow1 = new GreenfootImage("objects/arrows/arrow1.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    
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
