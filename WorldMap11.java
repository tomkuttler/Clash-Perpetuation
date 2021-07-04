import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world after the start screen.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class WorldMap11 extends World
{
    //----- World Background -----
    private static final GreenfootImage map11 = new GreenfootImage("worlds/worldMap11.png");
    
    /**
     * WorldMap11 Constructor: Creates the world, sets the background and spawns all objects of the world.
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
    public WorldMap11(Player p, PlayerHealthBar bar, HitCooldownBar hitBar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map11);
        
        //Add Health bar
        addObject(bar, 186, 29);
        
        //Add hit cooldown bar
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Add Player
        addObject(p, 848, 809);
        
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Devil.maxHealth, Devil.maxHealth);
        bar1.barWidth = 80;
        bar1.barHeight = 8;
        addObject(bar1, 0, 0);
        addObject(new Devil(p, bar1, 3), 848, 347);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Skeleton(p, bar2, 3), 748, 347);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Skeleton(p, bar3, 3), 948, 347);
        
        //Add Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
        
        //Spawn Collider
        addObject(new Collider(160, 151, 0, 0), 709, 852);
        addObject(new Collider(150, 150, 0, 0), 991, 855);
        addObject(new Collider(130, 137, 0, 0), 1612, 493);
        addObject(new Collider(135, 137, 0, 0), 89, 490);
        addObject(new Collider(554, 128, 0, 0), 863, 148);
        
        Collider c1 = new Collider(550, 10, 0, 0);
        addObject(c1, 1308, 676);
        c1.setRotation(155);
        
        Collider c2 = new Collider(550, 10, 0, 0);
        addObject(c2, 366, 313);
        c2.setRotation(155);
        
        Collider c3 = new Collider(550, 10, 0, 0);
        addObject(c3, 390, 683);
        c3.setRotation(25);
        
        Collider c4 = new Collider(550, 10, 0, 0);
        addObject(c4, 1356, 311);
        c4.setRotation(25);
        
        //Spawn Tutorial manager, window and text
        TutorialText text = new TutorialText();
        TutorialWindow window = new TutorialWindow(text);
                        
        addObject(window, 848, 140);
        addObject(text, 848, 155);
        addObject(new Tutorial(window, false), 0, 0);
    }
}
