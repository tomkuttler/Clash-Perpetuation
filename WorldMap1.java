import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the first world after the start screen.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class WorldMap1 extends World
{
    //----- World Background -----
    private static final GreenfootImage map1 = new GreenfootImage("worlds/worldMap1.png");
        
    /**
     * WorldMap1 Constructor: Creates the world, sets the background and spawns all objects of the world.
     */
    public WorldMap1()
    {    
        //Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map1);
        
        //Spawn player health bar
        PlayerHealthBar bar = new PlayerHealthBar(100, 100);
        addObject(bar, 186, 29);        
        
        //Spawn hit cooldown bar
        HitCooldownBar hitBar = new HitCooldownBar(100, 100);
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Store Inventory and Hotbar
        InventoryUI iUI = new InventoryUI();        
        Inventory inventory = new Inventory(iUI);        
        HotbarUI hUI = new HotbarUI();
        HotbarHighlight hH = new HotbarHighlight();
        Hotbar hotbar = new Hotbar(hUI, hH, inventory);
        
        //Spawn Player
        Player p = new Player(bar, hitBar, inventory, hotbar);
        addObject(p, 848, 384);
        
        //Spawn Objects        
        addObject(new Potion("red", 1), 753, 439);
        
        addObject(new Melee("saber"), 1028, 537);                
                
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Wolfman.maxHealth, Wolfman.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Wolfman(p, bar1, 3), 1348, 646);
        
        //Spawn Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
        
        //Spawn Collider
        addObject(new Collider(7, 150, 0, 0), 367, 175);
        addObject(new Collider(7, 214, 0, 0), 975, 143);
        addObject(new Collider(615, 22, 0, 0), 672, 238);
        addObject(new Collider(551, 22, 0, 0), 703, 46);
        addObject(new Collider(39, 22, 0, 0), 416, 79);
        
        //Spawn Tutorial manager, window and text
        TutorialText text = new TutorialText();
        TutorialWindow window = new TutorialWindow(text);
                        
        addObject(window, 848, 140);
        addObject(text, 848, 155);
        addObject(new Tutorial(window, true), 0, 0);        
    }
}
