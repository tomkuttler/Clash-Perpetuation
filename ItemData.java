/**
 * Write a description of class ItemData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemData  
{
    //----- longsword -----
    private int longswordDamage = 30;
    private double longswordHitCooldown = 1000000000.0;
    private int longswordStackSize = 1;

    //----- bow1 -----
    private int bow1Damage = 30;
    private double bow1HitCooldown = 1000000000.0;
    private int bow1StackSize = 1;
    private int bow1Range = 200;
    private int bow1Speed = 3;
    
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
    
    public double getHitCooldown(String item)
    {
        if(item == "longsword")
        {
            return longswordHitCooldown;
        }
        else if(item == "bow1")
        {
            return bow1HitCooldown;
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
}
