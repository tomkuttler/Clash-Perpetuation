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
    GreenfootImage longsword = new GreenfootImage("objects/weapons/longswordIcon.png");
    GreenfootImage dagger = new GreenfootImage("objects/weapons/daggerIcon.png");
    GreenfootImage axe = new GreenfootImage("objects/weapons/axeIcon.png");
    GreenfootImage warhammer = new GreenfootImage("objects/weapons/warhammerIcon.png");
    
    /**
     * MeleeWeapon Constructor: Scales the image to the right size, sets the right image and name and passes the variabes to the PickUpItems superclass.
     * 
     * @param 'name': Which melee wapon will be picked up
     */
    public MeleeWeapon(String name)
    {
        dagger.scale(dagger.getWidth() * 2, dagger.getHeight() * 2);
        
        if(name == "longsword")
        {
            setImage(longsword);
            this.name = name;
        }
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
        
        setup(name, amount);
    }
}
