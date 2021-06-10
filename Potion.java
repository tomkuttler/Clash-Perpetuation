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
    private static final GreenfootImage greenPotion = new GreenfootImage("objects/healingItems/greenPotion.png");
    private static final GreenfootImage redPotion = new GreenfootImage("objects/healingItems/redPotion.png");
    private static final GreenfootImage bluePotion = new GreenfootImage("objects/healingItems/bluePotion.png");
    private static final GreenfootImage purplePotion = new GreenfootImage("objects/healingItems/purplePotion.png");
    private static final GreenfootImage whitePotion = new GreenfootImage("objects/healingItems/whitePotion.png");

    /**
     * Potion Constructor: Sets the right image, name and amount and passes the variabes to the PickUpItems superclass.
     * 
     * @param 'color': Which color should the potion have ("green" heals 5 HP, "red" heals 10 HP, "blue" heals 15 HP, "purple" heals 20 HP, "white" heals 25 HP)
     * @param 'amount': How many potions will be picked up
     */ 
    public Potion(String color, int amount) 
    {        
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
