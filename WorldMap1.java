import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldMap1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldMap1 extends World
{
    GreenfootImage map1 = new GreenfootImage("WorldMap1.png");
    
    public WorldMap1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground(map1);
        
        //Spawn Health bar: title, units used in bar, initial value, maximum value
        HealthBar bar = new HealthBar("", "HP", 100, 100);
        addObject(bar, 150, 40);
        
        //Spawn Player
        Player p = new Player(bar);
        addObject(p, 300, 200);
        
        //Spawn Objects
        addObject(new TestTree(), 400, 100);
        
        addObject(new Potion("red"), 100, 300);
        
        //Spawn Enemys
        addObject(new Cyclope(p), 100, 100);

    }
}
