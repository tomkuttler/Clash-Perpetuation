import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldMap1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldMap1 extends World
{
    private static final GreenfootImage map1 = new GreenfootImage("worlds/worldMap1.png");
    
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
        
        addObject(new Melee("longsword"), 1028, 537);
        
        addObject(new Chest(1, new String[] {"redPotion", "longsword", null, null, null, null, null, null, null, null}, new int[] {5, 1, 0, 0, 0, 0, 0, 0, 0, 0}), 639, 392);
                
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Cyclope(p, bar1, 3), 1348, 646);
        
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
