import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world after the start screen.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class WorldMap2 extends World
{
    //----- World Background -----
    private static final GreenfootImage map2 = new GreenfootImage("worlds/worldMap2.png");
    
    /**
     * WorldMap2 Constructor: Creates the world, sets the background and spawns all objects of the world.
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
    public WorldMap2(Player p, PlayerHealthBar bar, HitCooldownBar hitBar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map2);
        
        //Add Health bar
        addObject(bar, 186, 29);
        
        //Add hit cooldown bar
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Add Player
        addObject(p, 10, 733);
        
        //Spawn Objects
        addObject(new Potion("green", 3), 1362, 300);
        addObject(new Potion("red", 1), 141, 453);
        
        addObject(new Chest(1, new String[] {"redPotion", "dagger", null, null, null, null, null, null, null, null}, new int[] {3, 1, 0, 0, 0, 0, 0, 0, 0, 0}), 1294, 195);
        addObject(new Chest(1, new String[] {"greenPotion", "redPotion", null, null, null, null, null, null, null, null}, new int[] {5, 2, 0, 0, 0, 0, 0, 0, 0, 0}), 846, 565);
        
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Wolfman.maxHealth, Wolfman.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Wolfman(p, bar1, 3), 736, 516);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Wolfman.maxHealth, Wolfman.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Wolfman(p, bar2, 3), 461, 154);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Wolfman.maxHealth, Wolfman.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Wolfman(p, bar3, 1), 1270, 581);
        
        EnemyHealthBar bar4 = new EnemyHealthBar(Wolfman.maxHealth, Wolfman.maxHealth);
        addObject(bar4, 0, 0);
        addObject(new Wolfman(p, bar4, 1), 1472, 202);        
        
        //Spawn Collider
        addObject(new Collider(220, 30, 0, 0), 110, 847);
        addObject(new Collider(220, 30, 0, 0), 114, 591);
        addObject(new Collider(30, 30, 0, 0), 207, 620);
        addObject(new Collider(30, 60, 0, 0), 209, 800);
        addObject(new Collider(150, 150, 0, 0), 485, 786);
        addObject(new Collider(150, 150, 0, 0), 603, 419);
        addObject(new Collider(150, 150, 0, 0), 754, 421);
        addObject(new Collider(150, 150, 0, 0), 960, 569);
        addObject(new Collider(150, 150, 0, 0), 145, 142);
        addObject(new Collider(150, 150, 0, 0), 246, 1);
        addObject(new Collider(150, 150, 0, 0), 1691, 800);
        addObject(new Collider(150, 150, 0, 0), 1251, 915);
        addObject(new Collider(150, 150, 0, 0), 1426, 796);
        addObject(new Collider(150, 150, 0, 0), 1694, 499);
        addObject(new Collider(150, 150, 0, 0), 1536, 367);
        addObject(new Collider(150, 150, 0, 0), 1064, 8);
        addObject(new Collider(150, 150, 0, 0), 397, 64);
        addObject(new Collider(150, 150, 0, 0), 40, 432);
        addObject(new Collider(64, 82, 0, 0), 606, 776);
        addObject(new Collider(100, 100, 0, 0), 1377, 205);
        addObject(new Collider(100, 100, 0, 0), 1617, 142);
        addObject(new Collider(100, 100, 0, 0), 1643, 279);
        addObject(new Collider(100, 100, 0, 0), 1339, 491);
        addObject(new Collider(100, 100, 0, 0), 1265, 373);
        addObject(new Collider(100, 100, 0, 0), 1135, 147);
        addObject(new Collider(50, 50, 0, 0), 1325, 125);
        addObject(new Collider(50, 50, 0, 0), 1569, 697);
        addObject(new Collider(50, 50, 0, 0), 1474, 570);
        addObject(new Collider(50, 50, 0, 0), 1248, 764);
        addObject(new Collider(50, 50, 0, 0), 865, 92);
        addObject(new Collider(50, 50, 0, 0), 766, 42);
        addObject(new Collider(50, 50, 0, 0), 113, 315);
        addObject(new Collider(50, 50, 0, 0), 672, 30);
        addObject(new Collider(50, 50, 0, 0), 131, 255);
        addObject(new Collider(426, 64, 0, 0), 1373, 30);
        addObject(new Collider(60, 124, 0, 0), 191, 342);
        addObject(new Collider(70, 25, 0, 0), 800, 688);
        addObject(new Collider(70, 25, 0, 0), 815, 614);
        addObject(new Collider(70, 25, 0, 0), 687, 652);        
        
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
