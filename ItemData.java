/**
 * Write a description of class ItemData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemData  
{
    //----- MELEE WEAPONS -----
    //----- longsword -----
    private int longswordDamage = 30;
    private double longswordUseCooldown = 1000000000.0;
    private int longswordStackSize = 1;
    
    //----- RANGED WEAPONS -----
    //----- bow1 -----
    private int bow1Damage = 30;
    private double bow1UseCooldown = 1000000000.0;
    private int bow1StackSize = 1;
    private int bow1Range = 200;
    private int bow1Speed = 3;
    
    //----- HEALING ITEMS -----
    //----- redPotion -----
    private int redPotionHealthPoints = 10;
    private double redPotionUseCooldown = 1000000000.0;
    
    public int getDamage(String item)
    {
        if(item == "longsword")
        {
            return longswordDamage;
        }
        else if(item == "bow1")
        {
            return bow1Damage;
        }
        else
        {
            return 0;
        }
    }
    
    public double getUseCooldown(String item)
    {
        if(item == "longsword")
        {
            return longswordUseCooldown;
        }
        else if(item == "bow1")
        {
            return bow1UseCooldown;
        }
        else if(item == "redPotion")
        {
            return redPotionUseCooldown;
        }
        else
        {
            return 0;
        }
    }
    
    public int getStackSize(String item)
    {
        if(item == "longsword")
        {
            return longswordStackSize;
        }
        else if(item == "bow1")
        {
            return bow1StackSize;
        }
        else
        {
            return 0;
        }
    }
    
    public int getRange(String item)
    {
        if(item == "bow1")
        {
            return bow1Range;
        }
        else
        {
            return 0;
        }
    }
    
    public int getSpeed(String item)
    {
        if(item == "bow1")
        {
            return bow1Speed;
        }
        else
        {
            return 0;
        }
    }
    
    public int getHealthPoints(String item)
    {
        if(item == "redPotion")
        {
            return redPotionHealthPoints;
        }
        else
        {
            return 0;
        }
    }
}
