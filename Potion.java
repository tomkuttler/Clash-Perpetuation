import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Potion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion extends HealingItems
{
    public int healthPoints; //Number of health points that will be restored
    
    //Object pictures
    GreenfootImage greenPotion = new GreenfootImage("objects/healingItems/greenPotion.png");
    GreenfootImage redPotion = new GreenfootImage("objects/healingItems/redPotion.png");
    GreenfootImage bluePotion = new GreenfootImage("objects/healingItems/bluePotion.png");
    GreenfootImage purplePotion = new GreenfootImage("objects/healingItems/purplePotion.png");
    GreenfootImage whitePotion = new GreenfootImage("objects/healingItems/whitePotion.png");

    public Potion(String color) 
    {
        if(color == "green")
        {
            setImage(greenPotion);
            healthPoints = 10;
         }
        if(color == "red")
        {
            setImage(redPotion);
            healthPoints = 20;
        }
        if(color == "blue")
        {
            setImage(bluePotion);
            healthPoints = 30;
        }
        if(color == "purple")
        {
            setImage(purplePotion);
            healthPoints = 40;
        }
        if(color == "white")
        {
            setImage(whitePotion);
            healthPoints = 50;
        }
        
        setup(healthPoints);
    }    
}
