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
    
    //Object pictures
    GreenfootImage greenPotion = new GreenfootImage("objects/healingItems/greenPotion.png");
    GreenfootImage redPotion = new GreenfootImage("objects/healingItems/redPotion.png");
    GreenfootImage bluePotion = new GreenfootImage("objects/healingItems/bluePotion.png");
    GreenfootImage purplePotion = new GreenfootImage("objects/healingItems/purplePotion.png");
    GreenfootImage whitePotion = new GreenfootImage("objects/healingItems/whitePotion.png");

    public Potion(String color, int amount) 
    {
        greenPotion.scale(greenPotion.getWidth() * 2, greenPotion.getHeight() * 2);
        redPotion.scale(redPotion.getWidth() * 2, redPotion.getHeight() * 2);
        bluePotion.scale(bluePotion.getWidth() * 2, bluePotion.getHeight() * 2);
        purplePotion.scale(purplePotion.getWidth() * 2, purplePotion.getHeight() * 2);
        whitePotion.scale(whitePotion.getWidth() * 2, whitePotion.getHeight() * 2);
        
        if(color == "green")
        {
            setImage(greenPotion);
            name = "greenPotion";
         }
        if(color == "red")
        {
            setImage(redPotion);
            name = "redPotion";
        }
        if(color == "blue")
        {
            setImage(bluePotion);
            name = "bluePotion";
        }
        if(color == "purple")
        {
            setImage(purplePotion);
            name = "purplePotion";
        }
        if(color == "white")
        {
            setImage(whitePotion);
            name = "whitePotion";
        }
        
        this.amount = amount;
        
        setup(name, amount);
    }    
}
