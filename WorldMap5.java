import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world after the start screen.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldMap5 extends World
{
    //----- World Background -----
    private static final GreenfootImage map5 = new GreenfootImage("worlds/worldMap5.png");
    
    /**
     * WorldMap5 Constructor: Creates the world, sets the background and spawns all objects of the world.
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
    public WorldMap5(Player p, PlayerHealthBar bar, HitCooldownBar hitBar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map5);
        
        //Add Health bar
        addObject(bar, 186, 29);
        
        //Add hit cooldown bar
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Add Player
        addObject(p, 1163, 904);
        
        //Spawn Objects
        addObject(new Potion("red", 3), 459, 732);
        addObject(new Potion("blue", 3), 1166, 228);
        
        addObject(new Chest(2, new String[] {"redPotion", "bluePotion", "spear", "bow1", "arrow1", null, null, null, null, null}, new int[] {7, 4, 1, 1, 7, 0, 0, 0, 0, 0}), 491, 304);
        
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Bandit.maxHealth, Bandit.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Bandit(p, bar1, 2), 301, 310);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Bandit.maxHealth, Bandit.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Bandit(p, bar2, 3), 576, 350);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Bandit.maxHealth, Bandit.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Bandit(p, bar3, 0), 440, 764);
        
        EnemyHealthBar bar4 = new EnemyHealthBar(Bandit.maxHealth, Bandit.maxHealth);
        addObject(bar4, 0, 0);
        addObject(new Bandit(p, bar4, 3), 1119, 508);
        
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
