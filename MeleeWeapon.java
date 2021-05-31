import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeleeWeapon extends Weapons
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
    
    /**
     * MeleeWeapon Constructor: Scales the image to the right size, sets the right image and name and passes the variabes to the PickUpItems superclass.
     * 
     * @param 'name': Which melee wapon will be picked up
     */
    public MeleeWeapon(String name)
    {
        dagger.scale(dagger.getWidth() * 2, dagger.getHeight() * 2);
        mace.scale(mace.getWidth() * 2, mace.getHeight() * 2);
                
        if(name == "dagger")
        {
            setImage(dagger);
            this.name = name;
        }
        if(name == "axe")
        {
            setImage(axe);
            this.name = name;
        }
        if(name == "warhammer")
        {
            setImage(warhammer);
            this.name = name;
        }
        
        if(name == "longsword")
        {
            setImage(longsword);
            this.name = name;
        }
        if(name == "flail")
        {
            setImage(flail);
            this.name = name;
        }
        if(name == "halberd")
        {
            setImage(halberd);
            this.name = name;
        }
        if(name == "mace")
        {
            setImage(mace);
            this.name = name;
        }
        if(name == "rapier")
        {
            setImage(rapier);
            this.name = name;
        }
        if(name == "saber")
        {
            setImage(saber);
            this.name = name;
        }
        if(name == "scythe")
        {
            setImage(scythe);
            this.name = name;
        }
        if(name == "waraxe")
        {
            setImage(waraxe);
            this.name = name;
        }
        
        if(name == "cane")
        {
            setImage(cane);
            this.name = name;
        }
        
        setup(name, amount);
    }
}
