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
    
    private int damage; 
    private double hitCooldown; //Cooldown between hits
    
    //Object pictures
    GreenfootImage bow1 = new GreenfootImage("objects/weapons/bow1Icon.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage  = new GreenfootImage("objects/weapons/.png");
    
    public Bow(String name)
    {
        if(name == "bow1")
        {
            setImage(bow1);
            this.name = name;

            damage = 50;
            hitCooldown = 1000000000.0;
        }
        
        setup(name, amount);
    }    
}
