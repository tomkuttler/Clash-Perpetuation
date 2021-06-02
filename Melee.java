
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Melee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Melee extends Weapons
{
    private String name;
    private int amount = 1;
    
    //----- Object images -----
    //----- Standart slash -----
    GreenfootImage dagger = new GreenfootImage("objects/weapons/daggerIcon.png");
    GreenfootImage axe = new GreenfootImage("objects/weapons/axeIcon.png");
    GreenfootImage warhammer = new GreenfootImage("objects/weapons/warhammerIcon.png");
    
    //----- Oversize slash  -----
    GreenfootImage longsword = new GreenfootImage("objects/weapons/longswordIcon.png");
    GreenfootImage flail = new GreenfootImage("objects/weapons/flailIcon.png");
    GreenfootImage halberd = new GreenfootImage("objects/weapons/halberdIcon.png");
    GreenfootImage mace = new GreenfootImage("objects/weapons/maceIcon.png");
    GreenfootImage rapier = new GreenfootImage("objects/weapons/rapierIcon.png");
    GreenfootImage saber = new GreenfootImage("objects/weapons/saberIcon.png");
    GreenfootImage scythe = new GreenfootImage("objects/weapons/scytheIcon.png");
    GreenfootImage waraxe = new GreenfootImage("objects/weapons/waraxeIcon.png");
    
    //----- Standart thrust -----
    GreenfootImage cane = new GreenfootImage("objects/weapons/caneIcon.png");
    
    //----- Oversize thrust -----
    GreenfootImage crystalBlue = new GreenfootImage("objects/weapons/crystalBlueIcon.png");
    GreenfootImage crystalPink = new GreenfootImage("objects/weapons/crystalPinkIcon.png");
    GreenfootImage crystalRed = new GreenfootImage("objects/weapons/crystalRedIcon.png");
    GreenfootImage crystalYellow = new GreenfootImage("objects/weapons/crystalYellowIcon.png");
    GreenfootImage dragonSpear = new GreenfootImage("objects/weapons/dragonSpearIcon.png");
    GreenfootImage dragonSpearMetall = new GreenfootImage("objects/weapons/dragonSpearMetallIcon.png");
    GreenfootImage spear = new GreenfootImage("objects/weapons/spearIcon.png");
    GreenfootImage spearMetall = new GreenfootImage("objects/weapons/spearMetallIcon.png");
    GreenfootImage staffBlue = new GreenfootImage("objects/weapons/staffBlueIcon.png");
    GreenfootImage staffOrange = new GreenfootImage("objects/weapons/staffOrangeIcon.png");
    GreenfootImage staffPink = new GreenfootImage("objects/weapons/staffPinkIcon.png");
    GreenfootImage staffYellow = new GreenfootImage("objects/weapons/staffYellowIcon.png");
    GreenfootImage trident = new GreenfootImage("objects/weapons/tridentIcon.png");
    GreenfootImage tridentMetall = new GreenfootImage("objects/weapons/tridentMetallIcon.png");
    GreenfootImage tridentOrange = new GreenfootImage("objects/weapons/tridentOrangeIcon.png");
    GreenfootImage tridentYellow = new GreenfootImage("objects/weapons/tridentYellowIcon.png");
    
    /**
     * MeleeWeapon Constructor: Scales the image to the right size, sets the right image and name and passes the variabes to the PickUpItems superclass.
     * 
     * @param 'name': Which melee wapon will be picked up
     */
    public Melee(String name)
    {
        dagger.scale(dagger.getWidth() * 2, dagger.getHeight() * 2);
        mace.scale(mace.getWidth() * 2, mace.getHeight() * 2);
        
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
        else if(name == "crystalBlue")
        {
            setImage(crystalBlue);
            this.name = name;
        }
        else if(name == "crystalPink")
        {
            setImage(crystalPink);
            this.name = name;
        }
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
        else if(name == "staffBlue")
        {
            setImage(staffBlue);
            this.name = name;
        }
        else if(name == "staffOrange")
        {
            setImage(staffOrange);
            this.name = name;
        }
        else if(name == "staffPink")
        {
            setImage(staffPink);
            this.name = name;
        }
        else if(name == "staffYellow")
        {
            setImage(staffYellow);
            this.name = name;
        }
        else if(name == "trident")
        {
            setImage(trident);
            this.name = name;
        }
        else if(name == "tridentMetall")
        {
            setImage(tridentMetall);
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
