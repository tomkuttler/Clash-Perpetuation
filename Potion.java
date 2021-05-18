import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Potion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion extends HealingItems
{
    private String name;
    private int amount;
    private int maxStackSize = 64;
    
    private int healthPoints; //Number of health points that will be restored
    
    //Object pictures
    GreenfootImage greenPotion = new GreenfootImage("objects/healingItems/greenPotion.png");
    GreenfootImage redPotion = new GreenfootImage("objects/healingItems/redPotion.png");
    GreenfootImage bluePotion = new GreenfootImage("objects/healingItems/bluePotion.png");
    GreenfootImage purplePotion = new GreenfootImage("objects/healingItems/purplePotion.png");
    GreenfootImage whitePotion = new GreenfootImage("objects/healingItems/whitePotion.png");

    public Potion(String color, int amount) 
    {
        if(color == "green")
        {
            setImage(greenPotion);
            healthPoints = 10;
            name = "greenPotion";
         }
        if(color == "red")
        {
            setImage(redPotion);
            healthPoints = 20;
            name = "redPotion";
        }
        if(color == "blue")
        {
            setImage(bluePotion);
            healthPoints = 30;
            name = "bluePotion";
        }
        if(color == "purple")
        {
            setImage(purplePotion);
            healthPoints = 40;
            name = "purplePotion";
        }
        if(color == "white")
        {
            setImage(whitePotion);
            healthPoints = 50;
            name = "whitePotion";
        }
        
        this.amount = amount;
        
        setup(name, amount, maxStackSize);
    }    
}
