import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Potion class manages the potion item that the player can pick up.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion extends HealingItems
{
    private String name;
    private int amount;
    
    //----- Object images -----
    GreenfootImage greenPotion = new GreenfootImage("objects/healingItems/greenPotion.png");
    GreenfootImage redPotion = new GreenfootImage("objects/healingItems/redPotion.png");
    GreenfootImage bluePotion = new GreenfootImage("objects/healingItems/bluePotion.png");
    GreenfootImage purplePotion = new GreenfootImage("objects/healingItems/purplePotion.png");
    GreenfootImage whitePotion = new GreenfootImage("objects/healingItems/whitePotion.png");

    /**
     * Potion Constructor: Scales the image to the right size, sets the right image, name and amount and passes the variabes to the PickUpItems superclass.
     * 
     * @param 'color': Which color should the potion have ("green" heals 5 HP, "red" heals 10 HP, "blue" heals 15 HP, "purple" heals 20 HP, "white" heals 25 HP)
     * @param 'amount': How many potions will be picked up
     */ 
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
