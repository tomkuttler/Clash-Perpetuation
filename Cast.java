import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cast here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cast extends World
{   
    private static final GreenfootImage cast = new GreenfootImage("worlds/cast.png");

    public Cast()
    {    
        //Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(cast);

        addObject(new CastText(), 848, 2000);
    }    
}
