import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{
    public TestWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1696, 928, 1);
        
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
        addObject(p, 100, 800);
        
        //Spawn Objects        
        addObject(new Potion("green", 64), 100, 300);
        addObject(new Potion("red", 64), 200, 300);
        addObject(new Potion("blue", 64), 300, 300);
        addObject(new Potion("purple", 64), 400, 300);
        addObject(new Potion("white", 64), 500, 300);
        
        addObject(new MeleeWeapon("longsword"), 100, 400);
        addObject(new MeleeWeapon("dagger"), 200, 400);
        addObject(new MeleeWeapon("axe"), 300, 400);
        addObject(new MeleeWeapon("warhammer"), 400, 400);
        
        addObject(new Bow("bow1"), 500, 400);
        
        addObject(new ArrowItem("arrow1", 5), 600, 400);
        
        addObject(new Chest(1, new String[] {"redPotion", "longsword", null, null, null, null, null, null, null, null}, new int[] {5, 1, 0, 0, 0, 0, 0, 0, 0, 0}), 100, 500);
        addObject(new Chest(2, new String[] {"redPotion", "longsword", null, null, null, null, null, null, null, null}, new int[] {5, 1, 0, 0, 0, 0, 0, 0, 0, 0}), 200, 500);
                
        //Spawn Enemys and health bars 
        EnemyHealthBar bar1 = new EnemyHealthBar(Cyclope.maxHealth, Cyclope.maxHealth);
        addObject(bar1, 0, 0);
        addObject(new Cyclope(p, bar1, 3), 100, 200);
        
        EnemyHealthBar bar2 = new EnemyHealthBar(Skeleton.maxHealth, Skeleton.maxHealth);
        addObject(bar2, 0, 0);
        addObject(new Skeleton(p, bar2, 3), 200, 200);
        
        //Spawn Inventory and Hotbar
        addObject(iUI, 848, 464);
        addObject(inventory, 0, 0);
        addObject(hUI, 848, 882);
        addObject(hH, 632, 897);
        addObject(hotbar, 0, 0);
    }
}
