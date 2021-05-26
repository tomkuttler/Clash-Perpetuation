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
    
    public WorldMap2(Player p, PlayerHealthBar bar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map1);
        
        //Add Health bar
        addObject(bar, 186, 29);
        addObject(new HealthBarUI(), 150, 50);
               
        //Add Player
        addObject(p, 30, 200);
        
        //Spawn Enemys
        addObject(new Cyclope(p), 100, 100);
        
        //Add Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
    }
}
