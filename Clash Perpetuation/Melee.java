import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Melee Class manages the melee weapon items that the player can pick up.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class Melee extends Weapons
{
    private String name;
    private int amount = 1;
    
    //----- Object images -----
    //----- Standart slash -----
    private static final GreenfootImage dagger = new GreenfootImage("objects/weapons/daggerIcon.png");
    private static final GreenfootImage axe = new GreenfootImage("objects/weapons/axeIcon.png");
    private static final GreenfootImage warhammer = new GreenfootImage("objects/weapons/warhammerIcon.png");
    
    //----- Oversize slash  -----
    private static final GreenfootImage longsword = new GreenfootImage("objects/weapons/longswordIcon.png");
    private static final GreenfootImage flail = new GreenfootImage("objects/weapons/flailIcon.png");
    private static final GreenfootImage halberd = new GreenfootImage("objects/weapons/halberdIcon.png");
    private static final GreenfootImage mace = new GreenfootImage("objects/weapons/maceIcon.png");
    private static final GreenfootImage rapier = new GreenfootImage("objects/weapons/rapierIcon.png");
    private static final GreenfootImage saber = new GreenfootImage("objects/weapons/saberIcon.png");
    private static final GreenfootImage scythe = new GreenfootImage("objects/weapons/scytheIcon.png");
    private static final GreenfootImage waraxe = new GreenfootImage("objects/weapons/waraxeIcon.png");
    
    //----- Standart thrust -----
    private static final GreenfootImage cane = new GreenfootImage("objects/weapons/caneIcon.png");
    
    //----- Oversize thrust -----    
    private static final GreenfootImage crystalRed = new GreenfootImage("objects/weapons/crystalRedIcon.png");
    private static final GreenfootImage crystalYellow = new GreenfootImage("objects/weapons/crystalYellowIcon.png");
    private static final GreenfootImage dragonSpear = new GreenfootImage("objects/weapons/dragonSpearIcon.png");
    private static final GreenfootImage dragonSpearMetall = new GreenfootImage("objects/weapons/dragonSpearMetallIcon.png");
    private static final GreenfootImage spear = new GreenfootImage("objects/weapons/spearIcon.png");
    private static final GreenfootImage spearMetall = new GreenfootImage("objects/weapons/spearMetallIcon.png");    
    private static final GreenfootImage staffOrange = new GreenfootImage("objects/weapons/staffOrangeIcon.png");        
    private static final GreenfootImage tridentOrange = new GreenfootImage("objects/weapons/tridentOrangeIcon.png");
    private static final GreenfootImage tridentYellow = new GreenfootImage("objects/weapons/tridentYellowIcon.png");
    
    /**
     * MeleeWeapon Constructor: Sets the right image and name and passes the variabes to the PickUpItems superclass.
     * 
     * @param 'name': Which melee wapon will be picked up
     */
    public Melee(String name)
    {        
        //----- Standart slash -----
        if(name == "dagger")
        {
            setImage(dagger);
            this.name = name;
        }
        else if(name == "axe")
        {
            setImage(axe);
            this.name = name;
        }
        else if(name == "warhammer")
        {
            setImage(warhammer);
            this.name = name;
        }
        
        //----- Oversize slash  -----
        else if(name == "longsword")
        {
            setImage(longsword);
            this.name = name;
        }
        else if(name == "flail")
        {
            setImage(flail);
            this.name = name;
        }
        else if(name == "halberd")
        {
            setImage(halberd);
            this.name = name;
        }
        else if(name == "mace")
        {
            setImage(mace);
            this.name = name;
        }
        else if(name == "rapier")
        {
            setImage(rapier);
            this.name = name;
        }
        else if(name == "saber")
        {
            setImage(saber);
            this.name = name;
        }
        else if(name == "scythe")
        {
            setImage(scythe);
            this.name = name;
        }
        else if(name == "waraxe")
        {
            setImage(waraxe);
            this.name = name;
        }
        
        //----- Standart thrust -----
        else if(name == "cane")
        {
            setImage(cane);
            this.name = name;
        }
        
        //----- Oversize thrust -----
        else if(name == "crystalRed")
        {
            setImage(crystalRed);
            this.name = name;
        }
        else if(name == "crystalYellow")
        {
            setImage(crystalYellow);
            this.name = name;
        }
        else if(name == "dragonSpear")
        {
            setImage(dragonSpear);
            this.name = name;
        }
        else if(name == "dragonSpearMetall")
        {
            setImage(dragonSpearMetall);
            this.name = name;
        }
        else if(name == "spear")
        {
            setImage(spear);
            this.name = name;
        }
        else if(name == "spearMetall")
        {
            setImage(spearMetall);
            this.name = name;
        }
        else if(name == "staffOrange")
        {
            setImage(staffOrange);
            this.name = name;
        }        
        else if(name == "tridentOrange")
        {
            setImage(tridentOrange);
            this.name = name;
        }
        else if(name == "tridentYellow")
        {
            setImage(tridentYellow);
            this.name = name;
        }
        
        setup(name, amount);
    }
}
