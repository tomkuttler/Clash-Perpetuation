import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ItemData class stores all important item attributes, that can be accessed by other objects.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemData  
{
    //----- MELEE WEAPONS -----
    //----- longsword -----
    private String longswordItemType = "meleeWeapon";
    private int longswordDamage = 100;
    private double longswordUseCooldown = 750000000.0;
    private int longswordMaxStackSize = 1;
    private GreenfootImage longswordIcon = new GreenfootImage("objects/weapons/longswordIcon.png");

    //----- RANGED WEAPONS -----
    //----- bow1 -----
    private String bow1ItemType = "bow";
    private int bow1Damage = 30;
    private double bow1UseCooldown = 1000000000.0;
    private int bow1MaxStackSize = 1;
    private int bow1Range = 200;
    private int bow1Speed = 3;
    private GreenfootImage bow1Icon = new GreenfootImage("objects/weapons/bow1Icon.png");

    //----- HEALING ITEMS -----
    //----- redPotion -----
    private String redPotionItemType = "healingItem";
    private int redPotionMaxStackSize = 64;
    private int redPotionHealthPoints = 10;
    private double redPotionUseCooldown = 1000000000.0;
    private GreenfootImage redPotionIcon = new GreenfootImage("objects/healingItems/redPotion.png");

    //----- ARROWS -----
    //----- arrow1 -----
    private String arrow1ItemType = "arrow";
    private int arrow1MaxStackSize = 64;
    private GreenfootImage arrow1Icon = new GreenfootImage("objects/arrows/arrow1.png");
    
    /**
     * ItemData Constructor: Scales all item icons to the right size.
     */
    public ItemData()
    {
        redPotionIcon.scale(redPotionIcon.getWidth() * 2, redPotionIcon.getHeight() * 2);
    }
    
    /**
     * Method 'getItemType': Is called by an object, which wants to know the type of an item.
     * 
     * @param 'item': The name of the item
     * 
     * @return: The type of the item
     */
    public String getItemType(String item)
    {
        if(item == "longsword")
        {
            return longswordItemType;
        }
        else if(item == "bow1")
        {
            return bow1ItemType;
        }
        else if(item == "redPotion")
        {
            return redPotionItemType;
        }
        else if(item == "arrow1")
        {
            return arrow1ItemType;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Method 'getDamage': Is called by an object, which wants to know the damage of an item.
     * 
     * @param 'item': The name of the item
     * 
     * @return: The damage of the item
     */
    public int getDamage(String item)
    {
        if(item == "longsword")
        {
            return longswordDamage;
        }
        else if(item == "bow1")
        {
            return bow1Damage;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Method 'getUseCooldown': Is called by an object, which wants to know the UseCooldown of an item.
     * 
     * @param 'item': The name of the item
     * 
     * @return: The UseCooldown of the item
     */
    public double getUseCooldown(String item)
    {
        if(item == "longsword")
        {
            return longswordUseCooldown;
        }
        else if(item == "bow1")
        {
            return bow1UseCooldown;
        }
        else if(item == "redPotion")
        {
            return redPotionUseCooldown;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Method 'getMaxStackSize': Is called by an object, which wants to know the MaxStackSize of an item.
     * 
     * @param 'item': The name of the item
     * 
     * @return: The MaxStackSize of the item
     */
    public int getMaxStackSize(String item)
    {
        if(item == "longsword")
        {
            return longswordMaxStackSize;
        }
        else if(item == "bow1")
        {
            return bow1MaxStackSize;
        }
        else if(item == "redPotion")
        {
            return redPotionMaxStackSize;
        }
        else if(item == "arrow1")
        {
            return arrow1MaxStackSize;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Method 'getRange': Is called by an object, which wants to know the Range of an item.
     * 
     * @param 'item': The name of the item
     * 
     * @return: The Range of the item
     */
    public int getRange(String item)
    {
        if(item == "bow1")
        {
            return bow1Range;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Method 'getSpeed': Is called by an object, which wants to know the Speed of an item.
     * 
     * @param 'item': The name of the item
     * 
     * @return: The Speed of the item
     */
    public int getSpeed(String item)
    {
        if(item == "bow1")
        {
            return bow1Speed;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Method 'getHealthPoints': Is called by an object, which wants to know the HealthPoints of an item.
     * 
     * @param 'item': The name of the item
     * 
     * @return: The HealthPoints of the item
     */
    public int getHealthPoints(String item)
    {
        if(item == "redPotion")
        {
            return redPotionHealthPoints;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Method 'getIcon': Is called by an object, which wants to know the Icon of an item.
     * 
     * @param 'item': The name of the item
     * 
     * @return: The Icon of the item
     */
    public GreenfootImage getIcon(String item)
    {
        if(item == "longsword")
        {
            return longswordIcon;
        }
        else if(item == "bow1")
        {
            return bow1Icon;
        }
        else if(item == "redPotion")
        {
            return redPotionIcon;
        }
        else if(item == "arrow1")
        {
            return arrow1Icon;
        }
        else
        {
            return null;
        }
    }

    /**
     * Method 'spawnItem': Is called by 'ckeckDrop' method in Hotbar class, if player wants to drop an item.
     * Spawns the item as a new PickUpActor under the player.
     * 
     * @param 'item': The name of the item
     * @param 'hotbar': The reference to the hotbar
     */
    public void spawnDroppedItem(String item, Hotbar hotbar)
    {
        if(item == "longsword")
        {
            hotbar.getWorld().addObject(new Sword("longsword"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "bow1")
        {
            hotbar.getWorld().addObject(new Bow("bow1"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "redPotion")
        {
            hotbar.getWorld().addObject(new Potion("red", 1), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "arrow1")
        {
            hotbar.getWorld().addObject(new ArrowItem("arrow1", 1), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
    }
    
    /**
     * Method 'spawnItem': Is called by 'checkRemove' method in Enemy class, if the killed enemy drops an item.
     * Spawns the item as a new PickUpActor at the place where the enemy died.
     * 
     * @param 'item': The name of the item
     * @param 'enemy': The reference to the enemy
     */
    public void spawnDroppedItemFromEnemy(String item, Enemy enemy)
    {
        if(item == "longsword")
        {
            enemy.getWorld().addObject(new Sword("longsword"), enemy.getX(), enemy.getY());
        }
        else if(item == "bow1")
        {
            enemy.getWorld().addObject(new Bow("bow1"), enemy.getX(), enemy.getY());
        }
        else if(item == "redPotion")
        {
            enemy.getWorld().addObject(new Potion("red", 1), enemy.getX(), enemy.getY());
        }
        else if(item == "arrow1")
        {
            enemy.getWorld().addObject(new ArrowItem("arrow1", 1), enemy.getX(), enemy.getY());
        }
    }
}
