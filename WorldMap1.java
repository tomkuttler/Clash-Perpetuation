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
        addObject(bar, 103, 19);
        addObject(new HealthBarUI(), 85, 30);
        
        //Store Inventory and Hotbar
        InventoryUI iUI = new InventoryUI();        
        Inventory inventory = new Inventory(iUI);        
        HotbarUI hUI = new HotbarUI();
        HotbarHighlight hH = new HotbarHighlight();
        Hotbar hotbar = new Hotbar(hUI, hH, inventory);
        
        //Spawn Player
        Player p = new Player(bar, inventory, hotbar);
        addObject(p, 300, 200);
        
        //Spawn Objects
        addObject(new TestTree(), 400, 100);
        
        addObject(new Potion("red", 1), 100, 300);
        addObject(new Potion("red", 10), 200, 300);
        addObject(new Potion("red", 50), 300, 300);
        addObject(new Potion("red", 32), 400, 300);
        addObject(new Potion("red", 32), 100, 350);
        addObject(new Potion("red", 32), 150, 350);
        addObject(new Potion("red", 32), 200, 350);
        addObject(new Potion("red", 32), 250, 350);
        addObject(new Potion("red", 32), 300, 350);
        addObject(new Potion("red", 32), 350, 350);
        
        addObject(new Sword("longsword"), 400, 350);
        
        //Spawn Enemys
        addObject(new Cyclope(p), 100, 100);
        
        //Spawn Inventory and Hotbar
        addObject(iUI, 300, 200);
        addObject(inventory, 0, 0);
        addObject(hUI, 300, 377);
        addObject(hH, 192, 384);
        addObject(hotbar, 0, 0);        
    }
}
