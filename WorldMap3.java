import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the third world after the start screen.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class WorldMap3 extends World
{
    //----- World Background -----
    private static final GreenfootImage map3 = new GreenfootImage("worlds/worldMap3.png");
    
    /**
     * WorldMap3 Constructor: Creates the world, sets the background and spawns all objects of the world.
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
    public WorldMap3(Player p, PlayerHealthBar bar, HitCooldownBar hitBar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map3);
        
        //Add Health bar
        addObject(bar, 186, 29);
        
        //Add hit cooldown bar
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Add Player
        addObject(p, 769, 15);
        
        //Spawn Objects
        addObject(new Potion("green", 3), 349, 63);
        addObject(new Potion("red", 2), 560, 454);
        addObject(new Potion("red", 3), 1490, 255);
        
        addObject(new Chest(1, new String[] {"greenPotion", "redPotion", "waraxe", null, null, null, null, null, null, null}, new int[] {6, 3, 1, 0, 0, 0, 0, 0, 0, 0}), 921, 510);
        
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Cyclope(p, bar1, 3), 319, 551);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Cyclope(p, bar2, 3), 324, 244);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Cyclope(p, bar3, 3), 379, 755);
        
        EnemyHealthBar bar4 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar4, 0, 0);
        addObject(new Cyclope(p, bar4, 3), 1160, 546);
        
        EnemyHealthBar bar5 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar5, 0, 0);
        addObject(new Cyclope(p, bar5, 3), 1453, 754);
        
        //Add Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
        
        //Spawn Collider
        addObject(new Collider(350, 35, 0, 0), 687, 732);
        addObject(new Collider(200, 10, 0, 0), 740, 643);        
        
        Collider c1 = new Collider(500, 10, 0, 0);
        addObject(c1, 132, 862);
        c1.setRotation(40);
        
        Collider c2 = new Collider(500, 10, 0, 0);
        addObject(c2, 1193, 22);
        c2.setRotation(-55);
        
        Collider c3 = new Collider(800, 10, 0, 0);
        addObject(c3, 902, 340);
        c3.setRotation(-50);
        
        Collider c4 = new Collider(800, 10, 0, 0);
        addObject(c4, 1086, 342);
        c4.setRotation(-50);
        
        Collider c5 = new Collider(300, 10, 0, 0);
        addObject(c5, 476, 850);
        c5.setRotation(-50);
        
        Collider c6 = new Collider(300, 10, 0, 0);
        addObject(c6, 703, 849);
        c6.setRotation(-50);
        
        Collider c7 = new Collider(800, 10, 0, 0);
        addObject(c7, 1410, 177);
        c7.setRotation(-10);
        
        Collider c8 = new Collider(800, 10, 0, 0);
        addObject(c8, 147, 300);
        c8.setRotation(-50);
        
        //Spawn Tutorial manager, window and text
        TutorialText text = new TutorialText();
        TutorialWindow window = new TutorialWindow(text);
                        
        addObject(window, 848, 140);
        addObject(text, 848, 155);
        addObject(new Tutorial(window, false), 0, 0);
    }
}
