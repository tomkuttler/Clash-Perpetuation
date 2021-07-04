import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world after the start screen.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class WorldMap9 extends World
{
    //----- World Background -----
    private static final GreenfootImage map9 = new GreenfootImage("worlds/worldMap9.png");
    
    /**
     * WorldMap9 Constructor: Creates the world, sets the background and spawns all objects of the world.
     * 
     * @param 'p': Reference to the player of the last world
     * @param 'bar': Reference to the player health bar of the last world
     * @param 'hitBar': Reference to the hit bar of the last world
     * @param 'inventory': Reference to the inventory manager of the last world
     * @param 'iUI': Reference to the inventory UI of the last world
     * @param 'hotbar': Reference to the hotbar manager of the last world
     * @param 'hUI': Reference to the hotbar UI of the last world
     * @param 'hH': Reference to the hotbar highlight of the last world
     */
    public WorldMap9(Player p, PlayerHealthBar bar, HitCooldownBar hitBar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map9);
        
        //Add Health bar
        addObject(bar, 186, 29);
        
        //Add hit cooldown bar
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Add Player
        addObject(p, 845, 829);
        
        //Spawn Objects
        addObject(new Potion("purple", 3), 528, 484);
        addObject(new Potion("purple", 3), 173, 222);
        
        addObject(new Chest(2, new String[] {"bluePotion", "purplePotion", "rapier", "arrow1", null, null, null, null, null, null}, new int[] {9, 4, 1, 7, 0, 0, 0, 0, 0, 0}), 1555, 396);
        
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Reptile.maxHealth, Reptile.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Reptile(p, bar1, 1), 1222, 563);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Reptile.maxHealth, Reptile.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Reptile(p, bar2, 3), 1082, 350);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Reptile.maxHealth, Reptile.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Reptile(p, bar3, 3), 350, 526);
        
        EnemyHealthBar bar4 = new EnemyHealthBar(Reptile.maxHealth, Reptile.maxHealth);
        addObject(bar4, 0, 0);
        addObject(new Reptile(p, bar4, 0), 733, 436);
        
        //Add Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
        
        //Spawn Collider
        addObject(new Collider(116, 89, 0, 0), 611, 812);
        addObject(new Collider(125, 125, 0, 0), 1151, 764);
        addObject(new Collider(125, 125, 0, 0), 1567, 652);
        addObject(new Collider(125, 125, 0, 0), 1476, 501);
        addObject(new Collider(125, 125, 0, 0), 1219, 443);
        addObject(new Collider(125, 125, 0, 0), 1618, 326);
        addObject(new Collider(125, 125, 0, 0), 1315, 636);
        addObject(new Collider(125, 125, 0, 0), 195, 749);
        addObject(new Collider(125, 125, 0, 0), 129, 322);
        addObject(new Collider(125, 125, 0, 0), 370, 199);
        addObject(new Collider(125, 125, 0, 0), 206, 117);
        addObject(new Collider(64, 64, 0, 0), 1120, 638);
        addObject(new Collider(64, 64, 0, 0), 1441, 633);
        addObject(new Collider(64, 64, 0, 0), 1344, 802);
        addObject(new Collider(64, 64, 0, 0), 1472, 827);
        addObject(new Collider(64, 64, 0, 0), 1407, 374);
        addObject(new Collider(64, 64, 0, 0), 447, 283);
        addObject(new Collider(64, 64, 0, 0), 96, 154);
        addObject(new Collider(64, 64, 0, 0), 32, 60);
        addObject(new Collider(645, 328, 0, 0), 1374, 161);
        addObject(new Collider(791, 332, 0, 0), 602, 165);
        addObject(new Collider(58, 16, 0, 0), 1021, 263);
        addObject(new Collider(609, 147, 0, 0), 394, 431);
        addObject(new Collider(609, 158, 0, 0), 399, 664);
        addObject(new Collider(32, 218, 0, 0), 111, 560);
        
        //Spawn Tutorial manager, window and text
        TutorialText text = new TutorialText();
        TutorialWindow window = new TutorialWindow(text);
                        
        addObject(window, 848, 140);
        addObject(text, 848, 155);
        addObject(new Tutorial(window, false), 0, 0);
    }
}
