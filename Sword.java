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
    
    private int damage; //Number of health points that will be restored
    private double hitCooldown; //Cooldown between hits
    
    //Object pictures
    GreenfootImage longsword = new GreenfootImage("objects/weapons/longswordIcon.png");
    //GreenfootImage redPotion = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage bluePotion = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage purplePotion = new GreenfootImage("objects/weapons/.png");
    //GreenfootImage whitePotion = new GreenfootImage("objects/weapons/.png");
    
    public Sword(String name)
    {
        if(name == "longsword")
        {
            this.name = name;
            
            damage = 30;
            hitCooldown = 1000000000.0;
        }
    }
}
