import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world after the start screen.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class WorldMap6 extends World
{
    //----- World Background -----
    private static final GreenfootImage map6 = new GreenfootImage("worlds/worldMap6.png");
    
    /**
     * WorldMap6 Constructor: Creates the world, sets the background and spawns all objects of the world.
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
    public WorldMap6(Player p, PlayerHealthBar bar, HitCooldownBar hitBar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map6);
        
        //Add Health bar
        addObject(bar, 186, 29);
        
        //Add hit cooldown bar
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Add Player
        addObject(p, 860, 860);
        
        //Spawn Objects                
        addObject(new Chest(1, new String[] {"redPotion", "bluePotion", "longsword", "arrow1", null, null, null, null, null, null}, new int[] {9, 4, 1, 9, 0, 0, 0, 0, 0, 0}), 480, 656);
        addObject(new Chest(1, new String[] {"greenPotion", "redPotion", "bluePotion", null, null, null, null, null, null, null}, new int[] {15, 6, 2, 0, 0, 0, 0, 0, 0, 0}), 1247, 656);
        
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(DarkKnight.maxHealth, DarkKnight.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new DarkKnight(p, bar1, 3), 768, 637);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(DarkKnight.maxHealth, DarkKnight.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new DarkKnight(p, bar2, 3), 960, 637);
        
        //Add Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
        
        //Spawn Collider
        addObject(new Collider(129, 172, 0, 0), 670, 810);
        addObject(new Collider(129, 172, 0, 0), 1055, 810);
        addObject(new Collider(415, 641, 0, 0), 496, 320);
        addObject(new Collider(415, 641, 0, 0), 1246, 320);
        addObject(new Collider(319, 81, 0, 0), 864, 482);
        addObject(new Collider(131, 95, 0, 0), 770, 563);
        addObject(new Collider(131, 95, 0, 0), 962, 563);        
        
        //Spawn Tutorial manager, window and text
        TutorialText text = new TutorialText();
        TutorialWindow window = new TutorialWindow(text);
                        
        addObject(window, 848, 140);
        addObject(text, 848, 155);
        addObject(new Tutorial(window, false), 0, 0);
    }
}
