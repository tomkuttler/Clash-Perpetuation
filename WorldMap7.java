import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world after the start screen.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class WorldMap7 extends World
{
    //----- World Background -----
    private static final GreenfootImage map7 = new GreenfootImage("worlds/worldMap7.png");
    
    /**
     * WorldMap7 Constructor: Creates the world, sets the background and spawns all objects of the world.
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
    public WorldMap7(Player p, PlayerHealthBar bar, HitCooldownBar hitBar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map7);
        
        //Add Health bar
        addObject(bar, 186, 29);
        
        //Add hit cooldown bar
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Add Player
        addObject(p, 848, 800);
        
        //Spawn Objects
        addObject(new Potion("blue", 3), 481, 377);
        addObject(new Potion("blue", 3), 1551, 664);
        
        addObject(new Melee("cane"), 367, 145);
        
        addObject(new Chest(1, new String[] {"redPotion", "bluePotion", "longsword", "arrow1", null, null, null, null, null, null}, new int[] {9, 4, 1, 7, 0, 0, 0, 0, 0, 0}), 1071, 238);
        addObject(new Chest(1, new String[] {"redPotion", "bluePotion", "purplePotion", null, null, null, null, null, null, null}, new int[] {10, 4, 2, 0, 0, 0, 0, 0, 0, 0}), 554, 770);
        
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Legionnaire.maxHealth, Legionnaire.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Legionnaire(p, bar1, 3), 287, 300);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Legionnaire.maxHealth, Legionnaire.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Legionnaire(p, bar2, 1), 920, 245);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Legionnaire.maxHealth, Legionnaire.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Legionnaire(p, bar3, 0), 785, 245);
        
        EnemyHealthBar bar4 = new EnemyHealthBar(Legionnaire.maxHealth, Legionnaire.maxHealth);
        addObject(bar4, 0, 0);
        addObject(new Legionnaire(p, bar4, 0), 196, 640);
        
        EnemyHealthBar bar5 = new EnemyHealthBar(Legionnaire.maxHealth, Legionnaire.maxHealth);
        addObject(bar5, 0, 0);
        addObject(new Legionnaire(p, bar5, 3), 1461, 290);
        
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
