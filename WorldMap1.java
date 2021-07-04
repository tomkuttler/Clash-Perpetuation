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
        addObject(new Collider(200, 120, 0, 0), 850, 290);
        addObject(new Collider(80, 30, 0, 0), 684, 308);
        addObject(new Collider(55, 23, 0, 0), 574, 300);
        addObject(new Collider(55, 23, 0, 0), 478, 362);
        addObject(new Collider(55, 23, 0, 0), 446, 618);
        addObject(new Collider(144, 133, 0, 0), 317, 421);
        addObject(new Collider(121, 63, 0, 0), 476, 235);
        addObject(new Collider(26, 20, 0, 0), 624, 246);
        addObject(new Collider(30, 30, 0, 0), 221, 314);
        addObject(new Collider(30, 30, 0, 0), 304, 287);
        addObject(new Collider(285, 20, 0, 0), 273, 233);
        addObject(new Collider(30, 350, 0, 0), 144, 405);
        addObject(new Collider(30, 100, 0, 0), 174, 591);
        addObject(new Collider(100, 30, 0, 0), 238, 624);
        addObject(new Collider(130, 30, 0, 0), 319, 656);
        addObject(new Collider(280, 30, 0, 0), 531, 689);
        addObject(new Collider(150, 30, 0, 0), 725, 722);
        addObject(new Collider(230, 30, 0, 0), 879, 753);
        addObject(new Collider(190, 30, 0, 0), 1055, 785);
        addObject(new Collider(60, 30, 0, 0), 1153, 815);
        addObject(new Collider(515, 30, 0, 0), 1436, 850);
        addObject(new Collider(505, 71, 0, 0), 1444, 535);
        addObject(new Collider(30, 100, 0, 0), 848, 526);
        addObject(new Collider(20, 20, 0, 0), 784, 530);
        addObject(new Collider(20, 20, 0, 0), 912, 530);        
        
        Collider c1 = new Collider(400, 10, 0, 0);
        addObject(c1, 1082, 412);
        c1.setRotation(40);
        
        //Spawn Tutorial manager, window and text
        TutorialText text = new TutorialText();
        TutorialWindow window = new TutorialWindow(text);
                        
        addObject(window, 848, 140);
        addObject(text, 848, 155);
        addObject(new Tutorial(window, true), 0, 0);        
    }
}
