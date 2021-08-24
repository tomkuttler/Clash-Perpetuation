import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The TestWorld contains everything from this project.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class TestWorld extends World
{
    /**
     * TestWorld Constructor: Creates the world, sets the background and spawns all objects of the world.
     */
    public TestWorld()
    {    
        //Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        
        //Spawn Health bar
        PlayerHealthBar bar = new PlayerHealthBar(100, 100);
        addObject(bar, 186, 29);        
        
        //Spawn hit cooldown bar
        HitCooldownBar hitBar = new HitCooldownBar(100, 100);
        addObject(hitBar, 178, 49);
        addObject(new HealthBarUI(), 150, 50);
        
        //Store Inventory and Hotbar
        InventoryUI iUI = new InventoryUI();        
        Inventory inventory = new Inventory(iUI);        
        HotbarUI hUI = new HotbarUI();
        HotbarHighlight hH = new HotbarHighlight();
        Hotbar hotbar = new Hotbar(hUI, hH, inventory);
        
        //Spawn Player
        Player p = new Player(bar, hitBar, inventory, hotbar);
        addObject(p, 100, 800);
        
        //Spawn Objects        
        addObject(new Potion("green", 64), 100, 300);
        addObject(new Potion("red", 64), 200, 300);
        addObject(new Potion("blue", 64), 300, 300);
        addObject(new Potion("purple", 64), 400, 300);
        addObject(new Potion("white", 64), 500, 300);
                
        addObject(new Melee("dagger"), 100, 400);
        addObject(new Melee("axe"), 200, 400);
        addObject(new Melee("warhammer"), 300, 400);
        
        addObject(new Melee("longsword"), 400, 400);
        addObject(new Melee("flail"), 500, 400);
        addObject(new Melee("halberd"), 600, 400);
        addObject(new Melee("mace"), 700, 400);
        addObject(new Melee("rapier"), 800, 400);
        addObject(new Melee("saber"), 900, 400);
        addObject(new Melee("scythe"), 1000, 400);
        addObject(new Melee("waraxe"), 1100, 400);
        
        addObject(new Melee("cane"), 100, 500);
                
        addObject(new Melee("crystalRed"), 200, 500);
        addObject(new Melee("crystalYellow"), 300, 500);
        addObject(new Melee("dragonSpear"), 400, 500);
        addObject(new Melee("dragonSpearMetall"), 500, 500);
        addObject(new Melee("spear"), 600, 500);
        addObject(new Melee("spearMetall"), 700, 500);        
        addObject(new Melee("staffOrange"), 800, 500);        
        addObject(new Melee("tridentOrange"), 900, 500);
        addObject(new Melee("tridentYellow"), 1000, 500);
        
        addObject(new Bow("bow1"), 100, 600);
        
        addObject(new ArrowItem("arrow1", 5), 200, 600);
        
        addObject(new Chest(1, new String[] {"redPotion", "longsword", null, null, null, null, null, null, null, null}, new int[] {5, 1, 0, 0, 0, 0, 0, 0, 0, 0}), 100, 700);
        addObject(new Chest(2, new String[] {"redPotion", "longsword", null, null, null, null, null, null, null, null}, new int[] {5, 1, 0, 0, 0, 0, 0, 0, 0, 0}), 200, 700);
                
        //Spawn Enemys and health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Cyclope(p, bar1, 3), 100, 200);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Skeleton(p, bar2, 3), 200, 200);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Wolfman.maxHealth, Wolfman.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Wolfman(p, bar3, 3), 300, 200);
        
        EnemyHealthBar bar4 = new EnemyHealthBar(Devil.maxHealth, Devil.maxHealth);
        bar4.barWidth = 80;
        bar4.barHeight = 8;
        addObject(bar4, 0, 0);
        addObject(new Devil(p, bar4, 3), 400, 200);
        
        //Spawn Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
    }
}
