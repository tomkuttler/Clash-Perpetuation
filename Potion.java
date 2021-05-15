import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Potion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion extends HealingItems
{
    //Object picture:
    GreenfootImage greenPotion = new GreenfootImage("objects/healingItems/greenPotion.png");
    GreenfootImage redPotion = new GreenfootImage("objects/healingItems/redPotion.png");
    GreenfootImage bluePotion = new GreenfootImage("objects/healingItems/bluePotion.png");
    GreenfootImage purplePotion = new GreenfootImage("objects/healingItems/purplePotion.png");
    GreenfootImage whitePotion = new GreenfootImage("objects/healingItems/whitePotion.png");
    
    public Potion() 
    {
        setImage(greenPotion);
    }   
}
