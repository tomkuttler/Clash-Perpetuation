import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldMap1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldMap1 extends World
{
    GreenfootImage map1 = new GreenfootImage("WorldMap1.png");
    
    public WorldMap1()
    {    
        // Create a new world with 1696x928 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        setBackground(map1);
        
        //Spawn Health bar: title, units used in bar, initial value, maximum value
        PlayerHealthBar bar = new PlayerHealthBar(100, 100);
        addObject(bar, 186, 29);
        addObject(new HealthBarUI(), 150, 50);
        
        //Store Inventory and Hotbar
        InventoryUI iUI = new InventoryUI();        
        Inventory inventory = new Inventory(iUI);        
        HotbarUI hUI = new HotbarUI();
        HotbarHighlight hH = new HotbarHighlight();
        Hotbar hotbar = new Hotbar(hUI, hH, inventory);
        
        //Spawn Player
        Player p = new Player(bar, inventory, hotbar);
        addObject(p, 300, 200);
        
        //Spawn Objects        
        addObject(new Potion("red", 1), 100, 300);
        addObject(new Potion("red", 10), 200, 300);
        addObject(new Potion("red", 50), 300, 300);
        addObject(new Potion("red", 32), 400, 300);
        addObject(new Potion("red", 32), 100, 350);
        addObject(new Potion("red", 32), 150, 350);
        addObject(new Potion("red", 32), 200, 350);
        addObject(new Potion("red", 32), 250, 350);
        addObject(new Potion("red", 32), 300, 350);
        addObject(new Potion("red", 32), 350, 350);
        
        addObject(new Sword("longsword"), 400, 350);
        addObject(new Bow("bow1"), 450, 350);
        
        addObject(new ArrowItem("arrow1", 5), 200, 700);
        
        addObject(new Chest(1, new String[] {"redPotion", "longsword", null, null, null, null, null, null, null, null}, new int[] {5, 1, 0, 0, 0, 0, 0, 0, 0, 0}), 200, 600);
        addObject(new Chest(2, new String[] {"redPotion", "longsword", null, null, null, null, null, null, null, null}, new int[] {5, 1, 0, 0, 0, 0, 0, 0, 0, 0}), 250, 600);
                
        //Spawn Enemys and health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Cyclope(p, bar1, 2), 100, 800);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Cyclope(p, bar2, 2), 200, 800);
        
        EnemyHealthBar bar3 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar3, 0, 0);
        addObject(new Cyclope(p, bar3, 2), 300, 800);
        
        EnemyHealthBar bar4 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar4, 0, 0);
        addObject(new Cyclope(p, bar4, 2), 400, 800);
        
        EnemyHealthBar bar5 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar5, 0, 0);
        addObject(new Cyclope(p, bar5, 2), 500, 800);
        
        EnemyHealthBar bar6 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar6, 0, 0);
        addObject(new Cyclope(p, bar6, 2), 600, 800);
        
        EnemyHealthBar bar7 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar7, 0, 0);
        addObject(new Cyclope(p, bar7, 2), 700, 800);
        
        EnemyHealthBar bar8 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar8, 0, 0);
        addObject(new Cyclope(p, bar8, 2), 800, 800);
        
        EnemyHealthBar bar9 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar9, 0, 0);
        addObject(new Skeleton(p, bar9, 3), 600, 400);
        
        //Spawn Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
        
        //Spawn Collider
        //Fence
        addObject(new Collider(7, 150, 0, 0), 367, 175);
        addObject(new Collider(7, 214, 0, 0), 975, 143);
        addObject(new Collider(615, 22, 0, 0), 672, 238);
        addObject(new Collider(551, 22, 0, 0), 703, 46);
        addObject(new Collider(39, 22, 0, 0), 416, 79);
    }
}
