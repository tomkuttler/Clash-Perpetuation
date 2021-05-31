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
    //----- Standart slash -----    
    //----- dagger -----
    private String daggerItemType = "meleeWeapon";
    private int daggerDamage = 10;
    private double daggerUseCooldown = 350000000.0;
    private int daggerMaxStackSize = 1;
    private GreenfootImage daggerIcon = new GreenfootImage("objects/weapons/daggerIcon.png");
    
    //----- axe -----
    private String axeItemType = "meleeWeapon";
    private int axeDamage = 40;
    private double axeUseCooldown = 1500000000.0;
    private int axeMaxStackSize = 1;
    private GreenfootImage axeIcon = new GreenfootImage("objects/weapons/axeIcon.png");
    
    //----- warhammer -----
    private String warhammerItemType = "meleeWeapon";
    private int warhammerDamage = 50;
    private double warhammerUseCooldown = 2000000000.0;
    private int warhammerMaxStackSize = 1;
    private GreenfootImage warhammerIcon = new GreenfootImage("objects/weapons/warhammerIcon.png");
    
    //----- Oversize slash  -----
    //----- longsword -----
    private String longswordItemType = "meleeWeapon";
    private int longswordDamage = 30;
    private double longswordUseCooldown = 750000000.0;
    private int longswordMaxStackSize = 1;
    private GreenfootImage longswordIcon = new GreenfootImage("objects/weapons/longswordIcon.png");

    //----- flail -----
    private String flailItemType = "meleeWeapon";
    private int flailDamage = 20;
    private double flailUseCooldown = 700000000.0;
    private int flailMaxStackSize = 1;
    private GreenfootImage flailIcon = new GreenfootImage("objects/weapons/flailIcon.png");
    
    //----- halberd -----
    private String halberdItemType = "meleeWeapon";
    private int halberdDamage = 35;
    private double halberdUseCooldown = 1000000000.0;
    private int halberdMaxStackSize = 1;
    private GreenfootImage halberdIcon = new GreenfootImage("objects/weapons/halberdIcon.png");
    
    //----- mace -----
    private String maceItemType = "meleeWeapon";
    private int maceDamage = 15;
    private double maceUseCooldown = 1000000000.0;
    private int maceMaxStackSize = 1;
    private GreenfootImage maceIcon = new GreenfootImage("objects/weapons/maceIcon.png");
    
    //----- rapier -----
    private String rapierItemType = "meleeWeapon";
    private int rapierDamage = 30;
    private double rapierUseCooldown = 650000000.0;
    private int rapierMaxStackSize = 1;
    private GreenfootImage rapierIcon = new GreenfootImage("objects/weapons/rapierIcon.png");
    
    //----- saber -----
    private String saberItemType = "meleeWeapon";
    private int saberDamage = 20;
    private double saberUseCooldown = 600000000.0;
    private int saberMaxStackSize = 1;
    private GreenfootImage saberIcon = new GreenfootImage("objects/weapons/saberIcon.png");
    
    //----- scythe -----
    private String scytheItemType = "meleeWeapon";
    private int scytheDamage = 40;
    private double scytheUseCooldown = 750000000.0;
    private int scytheMaxStackSize = 1;
    private GreenfootImage scytheIcon = new GreenfootImage("objects/weapons/scytheIcon.png");
    
    //----- waraxe -----
    private String waraxeItemType = "meleeWeapon";
    private int waraxeDamage = 50;
    private double waraxeUseCooldown = 750000000.0;
    private int waraxeMaxStackSize = 1;
    private GreenfootImage waraxeIcon = new GreenfootImage("objects/weapons/waraxeIcon.png");
    
    //----- Standart slash ----- 
    //----- cane -----
    private String caneItemType = "meleeWeapon";
    private int caneDamage = 30;
    private double caneUseCooldown = 750000000.0;
    private int caneMaxStackSize = 1;
    private GreenfootImage caneIcon = new GreenfootImage("objects/weapons/caneIcon.png");
    
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
    //----- greenPotion -----
    private String greenPotionItemType = "healingItem";
    private int greenPotionMaxStackSize = 64;
    private int greenPotionHealthPoints = 5;
    private double greenPotionUseCooldown = 1000000000.0;
    private GreenfootImage greenPotionIcon = new GreenfootImage("objects/healingItems/greenPotion.png");
    
    //----- redPotion -----
    private String redPotionItemType = "healingItem";
    private int redPotionMaxStackSize = 64;
    private int redPotionHealthPoints = 10;
    private double redPotionUseCooldown = 1000000000.0;
    private GreenfootImage redPotionIcon = new GreenfootImage("objects/healingItems/redPotion.png");
    
    //----- bluePotion -----
    private String bluePotionItemType = "healingItem";
    private int bluePotionMaxStackSize = 64;
    private int bluePotionHealthPoints = 15;
    private double bluePotionUseCooldown = 1000000000.0;
    private GreenfootImage bluePotionIcon = new GreenfootImage("objects/healingItems/bluePotion.png");
    
    //----- purplePotion -----
    private String purplePotionItemType = "healingItem";
    private int purplePotionMaxStackSize = 64;
    private int purplePotionHealthPoints = 20;
    private double purplePotionUseCooldown = 1000000000.0;
    private GreenfootImage purplePotionIcon = new GreenfootImage("objects/healingItems/purplePotion.png");
    
    //----- whitePotion -----
    private String whitePotionItemType = "healingItem";
    private int whitePotionMaxStackSize = 64;
    private int whitePotionHealthPoints = 25;
    private double whitePotionUseCooldown = 1000000000.0;
    private GreenfootImage whitePotionIcon = new GreenfootImage("objects/healingItems/whitePotion.png");

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
        daggerIcon.scale(daggerIcon.getWidth() * 2, daggerIcon.getHeight() * 2);
        maceIcon.scale(maceIcon.getWidth() * 2, maceIcon.getHeight() * 2);
        
        greenPotionIcon.scale(greenPotionIcon.getWidth() * 2, greenPotionIcon.getHeight() * 2);
        redPotionIcon.scale(redPotionIcon.getWidth() * 2, redPotionIcon.getHeight() * 2);
        bluePotionIcon.scale(bluePotionIcon.getWidth() * 2, bluePotionIcon.getHeight() * 2);
        purplePotionIcon.scale(purplePotionIcon.getWidth() * 2, purplePotionIcon.getHeight() * 2);
        whitePotionIcon.scale(whitePotionIcon.getWidth() * 2, whitePotionIcon.getHeight() * 2);
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
        if(item == "dagger")
        {
            return daggerItemType;
        }
        else if(item == "axe")
        {
            return axeItemType;
        }
        else if(item == "warhammer")
        {
            return warhammerItemType;
        }
        else if(item == "longsword")
        {
            return longswordItemType;
        }
        else if(item == "flail")
        {
            return flailItemType;
        }
        else if(item == "halberd")
        {
            return halberdItemType;
        }
        else if(item == "mace")
        {
            return maceItemType;
        }
        else if(item == "rapier")
        {
            return rapierItemType;
        }
        else if(item == "saber")
        {
            return saberItemType;
        }
        else if(item == "scythe")
        {
            return scytheItemType;
        }
        else if(item == "waraxe")
        {
            return waraxeItemType;
        }
        else if(item == "cane")
        {
            return caneItemType;
        }
        else if(item == "bow1")
        {
            return bow1ItemType;
        }
        else if(item == "greenPotion")
        {
            return greenPotionItemType;
        }
        else if(item == "redPotion")
        {
            return redPotionItemType;
        }
        else if(item == "bluePotion")
        {
            return bluePotionItemType;
        }
        else if(item == "purplePotion")
        {
            return purplePotionItemType;
        }
        else if(item == "whitePotion")
        {
            return whitePotionItemType;
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
        if(item == "dagger")
        {
            return daggerDamage;
        }
        else if(item == "axe")
        {
            return axeDamage;
        }
        else if(item == "warhammer")
        {
            return warhammerDamage;
        }
        else if(item == "longsword")
        {
            return longswordDamage;
        }
        else if(item == "flail")
        {
            return flailDamage;
        }
        else if(item == "halberd")
        {
            return halberdDamage;
        }
        else if(item == "mace")
        {
            return maceDamage;
        }
        else if(item == "rapier")
        {
            return rapierDamage;
        }
        else if(item == "saber")
        {
            return saberDamage;
        }
        else if(item == "scythe")
        {
            return scytheDamage;
        }
        else if(item == "waraxe")
        {
            return waraxeDamage;
        }
        else if(item == "cane")
        {
            return caneDamage;
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
        if(item == "dagger")
        {
            return daggerUseCooldown;
        }
        else if(item == "axe")
        {
            return axeUseCooldown;
        }
        else if(item == "warhammer")
        {
            return warhammerUseCooldown;
        }
        else if(item == "longsword")
        {
            return longswordUseCooldown;
        }
        else if(item == "flail")
        {
            return flailUseCooldown;
        }
        else if(item == "halberd")
        {
            return halberdUseCooldown;
        }
        else if(item == "mace")
        {
            return maceUseCooldown;
        }
        else if(item == "rapier")
        {
            return rapierUseCooldown;
        }
        else if(item == "saber")
        {
            return saberUseCooldown;
        }
        else if(item == "scythe")
        {
            return scytheUseCooldown;
        }
        else if(item == "waraxe")
        {
            return waraxeUseCooldown;
        }
        else if(item == "cane")
        {
            return caneUseCooldown;
        }
        else if(item == "bow1")
        {
            return bow1UseCooldown;
        }
        else if(item == "greenPotion")
        {
            return greenPotionUseCooldown;
        }
        else if(item == "redPotion")
        {
            return redPotionUseCooldown;
        }
        else if(item == "bluePotion")
        {
            return bluePotionUseCooldown;
        }
        else if(item == "purplePotion")
        {
            return purplePotionUseCooldown;
        }
        else if(item == "whitePotion")
        {
            return whitePotionUseCooldown;
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
        if(item == "dagger")
        {
            return daggerMaxStackSize;
        }
        else if(item == "axe")
        {
            return axeMaxStackSize;
        }
        else if(item == "warhammer")
        {
            return warhammerMaxStackSize;
        }
        else if(item == "longsword")
        {
            return longswordMaxStackSize;
        }
        else if(item == "flail")
        {
            return flailMaxStackSize;
        }
        else if(item == "halberd")
        {
            return halberdMaxStackSize;
        }
        else if(item == "mace")
        {
            return maceMaxStackSize;
        }
        else if(item == "rapier")
        {
            return rapierMaxStackSize;
        }
        else if(item == "saber")
        {
            return saberMaxStackSize;
        }
        else if(item == "scythe")
        {
            return scytheMaxStackSize;
        }
        else if(item == "waraxe")
        {
            return waraxeMaxStackSize;
        }
        else if(item == "cane")
        {
            return caneMaxStackSize;
        }
        else if(item == "bow1")
        {
            return bow1MaxStackSize;
        }
        else if(item == "greenPotion")
        {
            return greenPotionMaxStackSize;
        }
        else if(item == "redPotion")
        {
            return redPotionMaxStackSize;
        }
        else if(item == "bluePotion")
        {
            return bluePotionMaxStackSize;
        }
        else if(item == "purplePotion")
        {
            return purplePotionMaxStackSize;
        }
        else if(item == "whitePotion")
        {
            return whitePotionMaxStackSize;
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
        if(item == "greenPotion")
        {
            return greenPotionHealthPoints;
        }
        else if(item == "redPotion")
        {
            return redPotionHealthPoints;
        }
        else if(item == "bluePotion")
        {
            return bluePotionHealthPoints;
        }
        else if(item == "purplePotion")
        {
            return purplePotionHealthPoints;
        }
        else if(item == "whitePotion")
        {
            return whitePotionHealthPoints;
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
        if(item == "dagger")
        {
            return daggerIcon;
        }
        else if(item == "axe")
        {
            return axeIcon;
        }
        else if(item == "warhammer")
        {
            return warhammerIcon;
        }
        else if(item == "longsword")
        {
            return longswordIcon;
        }
        else if(item == "flail")
        {
            return flailIcon;
        }
        else if(item == "halberd")
        {
            return halberdIcon;
        }
        else if(item == "mace")
        {
            return maceIcon;
        }
        else if(item == "rapier")
        {
            return rapierIcon;
        }
        else if(item == "saber")
        {
            return saberIcon;
        }
        else if(item == "scythe")
        {
            return scytheIcon;
        }
        else if(item == "waraxe")
        {
            return waraxeIcon;
        }
        else if(item == "cane")
        {
            return caneIcon;
        }
        else if(item == "bow1")
        {
            return bow1Icon;
        }
        else if(item == "greenPotion")
        {
            return greenPotionIcon;
        }
        else if(item == "redPotion")
        {
            return redPotionIcon;
        }
        else if(item == "bluePotion")
        {
            return bluePotionIcon;
        }
        else if(item == "purplePotion")
        {
            return purplePotionIcon;
        }
        else if(item == "whitePotion")
        {
            return whitePotionIcon;
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
        if(item == "dagger")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("dagger"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "axe")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("axe"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "warhammer")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("warhammer"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "longsword")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("longsword"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "flail")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("flail"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "halberd")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("halberd"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "mace")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("mace"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "rapier")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("rapier"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "saber")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("saber"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "scythe")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("scythe"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "waraxe")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("waraxe"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "cane")
        {
            hotbar.getWorld().addObject(new MeleeWeapon("cane"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "bow1")
        {
            hotbar.getWorld().addObject(new Bow("bow1"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "greenPotion")
        {
            hotbar.getWorld().addObject(new Potion("green", 1), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "redPotion")
        {
            hotbar.getWorld().addObject(new Potion("red", 1), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "bluePotion")
        {
            hotbar.getWorld().addObject(new Potion("blue", 1), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "purplePotion")
        {
            hotbar.getWorld().addObject(new Potion("purple", 1), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "whitePotion")
        {
            hotbar.getWorld().addObject(new Potion("white", 1), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
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
    public void spawnDroppedItemFromEnemy(String item, int amount, Enemy enemy)
    {        
        if(item == "dagger")
        {
            enemy.getWorld().addObject(new MeleeWeapon("dagger"), enemy.getX(), enemy.getY());
        }
        else if(item == "axe")
        {
            enemy.getWorld().addObject(new MeleeWeapon("axe"), enemy.getX(), enemy.getY());
        }
        else if(item == "warhammer")
        {
            enemy.getWorld().addObject(new MeleeWeapon("warhammer"), enemy.getX(), enemy.getY());
        }
        else if(item == "longsword")
        {
            enemy.getWorld().addObject(new MeleeWeapon("longsword"), enemy.getX(), enemy.getY());
        }
        else if(item == "flail")
        {
            enemy.getWorld().addObject(new MeleeWeapon("flail"), enemy.getX(), enemy.getY());
        }
        else if(item == "halberd")
        {
            enemy.getWorld().addObject(new MeleeWeapon("halberd"), enemy.getX(), enemy.getY());
        }
        else if(item == "mace")
        {
            enemy.getWorld().addObject(new MeleeWeapon("mace"), enemy.getX(), enemy.getY());
        }
        else if(item == "rapier")
        {
            enemy.getWorld().addObject(new MeleeWeapon("rapier"), enemy.getX(), enemy.getY());
        }
        else if(item == "saber")
        {
            enemy.getWorld().addObject(new MeleeWeapon("saber"), enemy.getX(), enemy.getY());
        }
        else if(item == "scythe")
        {
            enemy.getWorld().addObject(new MeleeWeapon("scythe"), enemy.getX(), enemy.getY());
        }
        else if(item == "waraxe")
        {
            enemy.getWorld().addObject(new MeleeWeapon("waraxe"), enemy.getX(), enemy.getY());
        }
        else if(item == "cane")
        {
            enemy.getWorld().addObject(new MeleeWeapon("cane"), enemy.getX(), enemy.getY());
        }
        else if(item == "bow1")
        {
            enemy.getWorld().addObject(new Bow("bow1"), enemy.getX(), enemy.getY());
        }
        else if(item == "greenPotion")
        {
            enemy.getWorld().addObject(new Potion("green", amount), enemy.getX(), enemy.getY());
        }
        else if(item == "redPotion")
        {
            enemy.getWorld().addObject(new Potion("red", amount), enemy.getX(), enemy.getY());
        }
        else if(item == "bluePotion")
        {
            enemy.getWorld().addObject(new Potion("blue", amount), enemy.getX(), enemy.getY());
        }
        else if(item == "purplePotion")
        {
            enemy.getWorld().addObject(new Potion("purple", amount), enemy.getX(), enemy.getY());
        }
        else if(item == "whitePotion")
        {
            enemy.getWorld().addObject(new Potion("white", amount), enemy.getX(), enemy.getY());
        }
        else if(item == "arrow1")
        {
            enemy.getWorld().addObject(new ArrowItem("arrow1", amount), enemy.getX(), enemy.getY());
        }
    }
}
