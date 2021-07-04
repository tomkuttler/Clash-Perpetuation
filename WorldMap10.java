import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world after the start screen.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldMap10 extends World
{
    //----- World Background -----
    private static final GreenfootImage map10 = new GreenfootImage("worlds/worldMap10.png");
    
    /**
     * WorldMap10 Constructor: Creates the world, sets the background and spawns all objects of the world.
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
    public WorldMap10(Player p, PlayerHealthBar bar, HitCooldownBar hitBar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map10);
        
        //Add Health bar
        addObject(bar, 186, 29);
        
        //Add hit cooldown bar
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Add Player
        addObject(p, 848, 809);
        
        //Spawn Objects
        addObject(new Potion("white", 2), 189, 456);
        addObject(new Potion("white", 2), 513, 845);
        
        addObject(new Chest(1, new String[] {"greenPotion", "redPotion", "bluePotion", "purplePotion", "whitePotion", "arrow1", null, null, null, null}, new int[] {15, 6, 3, 2, 1, 15, 0, 0, 0, 0}), 1529, 117);
        
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Skeleton(p, bar1, 1), 1400, 275);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Skeleton(p, bar2, 3), 1070, 617);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Skeleton(p, bar3, 1), 1403, 723);
        
        EnemyHealthBar bar4 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar4, 0, 0);
        addObject(new Skeleton(p, bar4, 3), 590, 250);
        
        EnemyHealthBar bar5 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar5, 0, 0);
        addObject(new Skeleton(p, bar5, 3), 380, 250);
        
        //Add Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
        
        //Spawn Tutorial manager, window and text
        TutorialText text = new TutorialText();
        TutorialWindow window = new TutorialWindow(text);
                        
        addObject(window, 848, 140);
        addObject(text, 848, 155);
        addObject(new Tutorial(window, false), 0, 0);
    }
}
