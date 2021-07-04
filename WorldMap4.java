import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world after the start screen.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class WorldMap4 extends World
{
    //----- World Background -----
    private static final GreenfootImage map4 = new GreenfootImage("worlds/worldMap4.png");
    
    /**
     * WorldMap4 Constructor: Creates the world, sets the background and spawns all objects of the world.
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
    public WorldMap4(Player p, PlayerHealthBar bar, HitCooldownBar hitBar, Inventory inventory, InventoryUI iUI, Hotbar hotbar, HotbarUI hUI, HotbarHighlight hH)
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map4);
        
        //Add Health bar
        addObject(bar, 186, 29);
        
        //Add hit cooldown bar
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Add Player
        addObject(p, 16, 427);
        
        //Spawn Objects
        addObject(new Potion("red", 3), 991, 490);
        addObject(new Potion("red", 3), 320, 686);
        
        addObject(new Melee("axe"), 1600, 720);
        addObject(new Melee("warhammer"), 827, 95);
        
        addObject(new Chest(1, new String[] {"greenPotion", "redPotion", "tridentOrange", null, null, null, null, null, null, null}, new int[] {7, 4, 1, 0, 0, 0, 0, 0, 0, 0}), 921, 510);
        addObject(new Chest(1, new String[] {"greenPotion", "redPotion", "tridentYellow", null, null, null, null, null, null, null}, new int[] {8, 3, 1, 0, 0, 0, 0, 0, 0, 0}), 1139, 816);
        
        //Spawn Enemys and enemy health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Cyclope(p, bar1, 2), 418, 472);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Cyclope(p, bar2, 3), 686, 773);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Cyclope(p, bar3, 1), 1273, 573);
        
        EnemyHealthBar bar4 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar4, 0, 0);
        addObject(new Cyclope(p, bar4, 0), 1473, 734);
        
        EnemyHealthBar bar5 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar5, 0, 0);
        addObject(new Cyclope(p, bar5, 0), 1113, 283);
        
        //Add Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
        
        //Spawn Collider
        addObject(new Collider(186, 83, 0, 0), 382, 391);
        addObject(new Collider(128, 109, 0, 0), 703, 438);
        addObject(new Collider(95, 206, 0, 0), 849, 462);
        addObject(new Collider(208, 103, 0, 0), 1000, 372);
        addObject(new Collider(60, 45, 0, 0), 960, 544);
        addObject(new Collider(112, 177, 0, 0), 1252, 438);
        addObject(new Collider(100, 120, 0, 0), 1202, 540);
        addObject(new Collider(180, 100, 0, 0), 1077, 786);
        addObject(new Collider(50, 60, 0, 0), 1480, 671);
        addObject(new Collider(120, 120, 0, 0), 1565, 700);
        addObject(new Collider(863, 251, 0, 0), 430, 125);
        addObject(new Collider(63, 73, 0, 0), 1040, 36);
        addObject(new Collider(63, 73, 0, 0), 944, 68);
        addObject(new Collider(63, 73, 0, 0), 1008, 132);
        addObject(new Collider(60, 34, 0, 0), 765, 690);
        addObject(new Collider(60, 34, 0, 0), 558, 846);
        addObject(new Collider(60, 34, 0, 0), 385, 782);
        addObject(new Collider(60, 34, 0, 0), 242, 717);
        addObject(new Collider(95, 28, 0, 0), 690, 820);
        addObject(new Collider(100, 80, 0, 0), 463, 572);        
        
        Collider c1 = new Collider(800, 10, 0, 0);
        addObject(c1, 1435, 308);
        c1.setRotation(50);
        
        //Spawn Tutorial manager, window and text
        TutorialText text = new TutorialText();
        TutorialWindow window = new TutorialWindow(text);
                        
        addObject(window, 848, 140);
        addObject(text, 848, 155);
        addObject(new Tutorial(window, false), 0, 0);
    }
}
