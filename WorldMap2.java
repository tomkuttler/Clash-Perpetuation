import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldMap2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldMap2 extends World
{
    GreenfootImage map1 = new GreenfootImage("WorldMap2.png");
    
    public WorldMap2(Player p, HealthBar bar, Inventory inventory, InventoryUI iUI)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground(map1);
        
        //Add Health bar
        addObject(bar, 150, 40);
        addObject(new HealthBarUI(), 85, 30);
               
        //Add Player
        addObject(p, 30, 200);
        
        //Spawn Enemys
        addObject(new Cyclope(p), 100, 100);
        
        //Add Inventory
        addObject(iUI, 300, 200);
        addObject(inventory, 300, 200);        
    }
}
