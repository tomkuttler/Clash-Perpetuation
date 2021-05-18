import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Weapons
{
    private String name;
    private int amount = 1;
    private int maxStackSize = 1;
    
    private int damage; 
    private double hitCooldown; //Cooldown between hits
    
    //Object pictures
    GreenfootImage longsword = new GreenfootImage("objects/weapons/longswordIcon.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    
    public Sword(String name)
    {
        if(name == "longsword")
        {
            setImage(longsword);
            this.name = name;
            
            damage = 30;
            hitCooldown = 1000000000.0;
        }
        
        setup(0, name, amount, maxStackSize);
    }
}
