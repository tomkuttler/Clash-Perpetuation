import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world after the start screen.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
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
        
        //Spawn Collider
        addObject(new Collider(400, 10, 0, 0), 1367, 894);
        addObject(new Collider(400, 10, 0, 0), 636, 84);
        addObject(new Collider(400, 10, 0, 0), 1093, 83);
        addObject(new Collider(400, 10, 0, 0), 859, 41);
        addObject(new Collider(10, 400, 0, 0), 1496, 316);
        addObject(new Collider(500, 10, 0, 0), 964, 443);
        addObject(new Collider(800, 10, 0, 0), 1066, 542);
        addObject(new Collider(10, 300, 0, 0), 1569, 315);
        addObject(new Collider(22, 122, 0, 0), 675, 495);
        addObject(new Collider(112, 45, 0, 0), 1175, 904);
        
        Collider c1 = new Collider(400, 10, 0, 0);
        addObject(c1, 1559, 736);
        c1.setRotation(135);
        
        Collider c2 = new Collider(400, 10, 0, 0);
        addObject(c2, 376, 857);
        c2.setRotation(15);
        
        Collider c3 = new Collider(400, 10, 0, 0);
        addObject(c3, 132, 592);
        c3.setRotation(80);
        
        Collider c4 = new Collider(400, 10, 0, 0);
        addObject(c4, 156, 314);
        c4.setRotation(120);
        
        Collider c5 = new Collider(400, 10, 0, 0);
        addObject(c5, 443, 159);
        c5.setRotation(160);
        
        Collider c6 = new Collider(400, 10, 0, 0);
        addObject(c6, 1296, 172);
        c6.setRotation(27);
        
        Collider c7 = new Collider(400, 10, 0, 0);
        addObject(c7, 1313, 404);
        c7.setRotation(170);
        
        Collider c8 = new Collider(400, 10, 0, 0);
        addObject(c8, 1415, 484);
        c8.setRotation(160);
        
        Collider c9 = new Collider(400, 10, 0, 0);
        addObject(c9, 1422, 109);
        c9.setRotation(30);
        
        //Spawn Tutorial manager, window and text
        TutorialText text = new TutorialText();
        TutorialWindow window = new TutorialWindow(text);
                        
        addObject(window, 848, 140);
        addObject(text, 848, 155);
        addObject(new Tutorial(window, false), 0, 0);
    }
}
