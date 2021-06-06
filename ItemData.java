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
    
    //----- Standart thrust ----- 
    //----- cane -----
    private String caneItemType = "meleeWeapon";
    private int caneDamage = 30;
    private double caneUseCooldown = 750000000.0;
    private int caneMaxStackSize = 1;
    private GreenfootImage caneIcon = new GreenfootImage("objects/weapons/caneIcon.png");
    
    //----- Oversize thrust -----
    //----- crystalBlue -----
    private String crystalBlueItemType = "meleeWeapon";
    private int crystalBlueDamage = 30;
    private double crystalBlueUseCooldown = 750000000.0;
    private int crystalBlueMaxStackSize = 1;
    private GreenfootImage crystalBlueIcon = new GreenfootImage("objects/weapons/crystalBlueIcon.png");
    
    //----- crystalPink -----
    private String crystalPinkItemType = "meleeWeapon";
    private int crystalPinkDamage = 30;
    private double crystalPinkUseCooldown = 750000000.0;
    private int crystalPinkMaxStackSize = 1;
    private GreenfootImage crystalPinkIcon = new GreenfootImage("objects/weapons/crystalPinkIcon.png");
    
    //----- crystalRed -----
    private String crystalRedItemType = "meleeWeapon";
    private int crystalRedDamage = 30;
    private double crystalRedUseCooldown = 750000000.0;
    private int crystalRedMaxStackSize = 1;
    private GreenfootImage crystalRedIcon = new GreenfootImage("objects/weapons/crystalRedIcon.png");
    
    //----- crystalYellow -----
    private String crystalYellowItemType = "meleeWeapon";
    private int crystalYellowDamage = 30;
    private double crystalYellowUseCooldown = 750000000.0;
    private int crystalYellowMaxStackSize = 1;
    private GreenfootImage crystalYellowIcon = new GreenfootImage("objects/weapons/crystalYellowIcon.png");
    
    //----- dragonSpear -----
    private String dragonSpearItemType = "meleeWeapon";
    private int dragonSpearDamage = 30;
    private double dragonSpearUseCooldown = 750000000.0;
    private int dragonSpearMaxStackSize = 1;
    private GreenfootImage dragonSpearIcon = new GreenfootImage("objects/weapons/dragonSpearIcon.png");
    
    //----- dragonSpearMetall -----
    private String dragonSpearMetallItemType = "meleeWeapon";
    private int dragonSpearMetallDamage = 30;
    private double dragonSpearMetallUseCooldown = 750000000.0;
    private int dragonSpearMetallMaxStackSize = 1;
    private GreenfootImage dragonSpearMetallIcon = new GreenfootImage("objects/weapons/dragonSpearMetallIcon.png");
    
    //----- spear -----
    private String spearItemType = "meleeWeapon";
    private int spearDamage = 30;
    private double spearUseCooldown = 750000000.0;
    private int spearMaxStackSize = 1;
    private GreenfootImage spearIcon = new GreenfootImage("objects/weapons/spearIcon.png");
    
    //----- spearMetall -----
    private String spearMetallItemType = "meleeWeapon";
    private int spearMetallDamage = 30;
    private double spearMetallUseCooldown = 750000000.0;
    private int spearMetallMaxStackSize = 1;
    private GreenfootImage spearMetallIcon = new GreenfootImage("objects/weapons/spearMetallIcon.png");
    
    //----- staffBlue -----
    private String staffBlueItemType = "meleeWeapon";
    private int staffBlueDamage = 30;
    private double staffBlueUseCooldown = 750000000.0;
    private int staffBlueMaxStackSize = 1;
    private GreenfootImage staffBlueIcon = new GreenfootImage("objects/weapons/staffBlueIcon.png");
    
    //----- staffOrange -----
    private String staffOrangeItemType = "meleeWeapon";
    private int staffOrangeDamage = 30;
    private double staffOrangeUseCooldown = 750000000.0;
    private int staffOrangeMaxStackSize = 1;
    private GreenfootImage staffOrangeIcon = new GreenfootImage("objects/weapons/staffOrangeIcon.png");
    
    //----- staffPink -----
    private String staffPinkItemType = "meleeWeapon";
    private int staffPinkDamage = 30;
    private double staffPinkUseCooldown = 750000000.0;
    private int staffPinkMaxStackSize = 1;
    private GreenfootImage staffPinkIcon = new GreenfootImage("objects/weapons/staffPinkIcon.png");
    
    //----- staffYellow -----
    private String staffYellowItemType = "meleeWeapon";
    private int staffYellowDamage = 30;
    private double staffYellowUseCooldown = 750000000.0;
    private int staffYellowMaxStackSize = 1;
    private GreenfootImage staffYellowIcon = new GreenfootImage("objects/weapons/staffYellowIcon.png");
    
    //----- trident -----
    private String tridentItemType = "meleeWeapon";
    private int tridentDamage = 30;
    private double tridentUseCooldown = 750000000.0;
    private int tridentMaxStackSize = 1;
    private GreenfootImage tridentIcon = new GreenfootImage("objects/weapons/tridentIcon.png");
    
    //----- tridentMetall -----
    private String tridentMetallItemType = "meleeWeapon";
    private int tridentMetallDamage = 30;
    private double tridentMetallUseCooldown = 750000000.0;
    private int tridentMetallMaxStackSize = 1;
    private GreenfootImage tridentMetallIcon = new GreenfootImage("objects/weapons/tridentMetallIcon.png");
    
    //----- tridentOrange -----
    private String tridentOrangeItemType = "meleeWeapon";
    private int tridentOrangeDamage = 30;
    private double tridentOrangeUseCooldown = 750000000.0;
    private int tridentOrangeMaxStackSize = 1;
    private GreenfootImage tridentOrangeIcon = new GreenfootImage("objects/weapons/tridentOrangeIcon.png");
    
    //----- tridentYellow -----
    private String tridentYellowItemType = "meleeWeapon";
    private int tridentYellowDamage = 30;
    private double tridentYellowUseCooldown = 750000000.0;
    private int tridentYellowMaxStackSize = 1;
    private GreenfootImage tridentYellowIcon = new GreenfootImage("objects/weapons/tridentYellowIcon.png");
    
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
        else if(item == "crystalBlue")
        {
            return crystalBlueItemType;
        }
        else if(item == "crystalPink")
        {
            return crystalPinkItemType;
        }
        else if(item == "crystalRed")
        {
            return crystalRedItemType;
        }
        else if(item == "crystalYellow")
        {
            return crystalYellowItemType;
        }
        else if(item == "dragonSpear")
        {
            return dragonSpearItemType;
        }
        else if(item == "dragonSpearMetall")
        {
            return dragonSpearMetallItemType;
        }
        else if(item == "spear")
        {
            return spearItemType;
        }
        else if(item == "spearMetall")
        {
            return spearMetallItemType;
        }
        else if(item == "staffBlue")
        {
            return staffBlueItemType;
        }
        else if(item == "staffOrange")
        {
            return staffOrangeItemType;
        }
        else if(item == "staffPink")
        {
            return staffPinkItemType;
        }
        else if(item == "staffYellow")
        {
            return staffYellowItemType;
        }
        else if(item == "trident")
        {
            return tridentItemType;
        }
        else if(item == "tridentMetall")
        {
            return tridentMetallItemType;
        }
        else if(item == "tridentOrange")
        {
            return tridentOrangeItemType;
        }
        else if(item == "tridentYellow")
        {
            return tridentYellowItemType;
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
        else if(item == "crystalBlue")
        {
            return crystalBlueDamage;
        }
        else if(item == "crystalPink")
        {
            return crystalPinkDamage;
        }
        else if(item == "crystalRed")
        {
            return crystalRedDamage;
        }
        else if(item == "crystalYellow")
        {
            return crystalYellowDamage;
        }
        else if(item == "dragonSpear")
        {
            return dragonSpearDamage;
        }
        else if(item == "dragonSpearMetall")
        {
            return dragonSpearMetallDamage;
        }
        else if(item == "spear")
        {
            return spearDamage;
        }
        else if(item == "spearMetall")
        {
            return spearMetallDamage;
        }
        else if(item == "staffBlue")
        {
            return staffBlueDamage;
        }
        else if(item == "staffOrange")
        {
            return staffOrangeDamage;
        }
        else if(item == "staffPink")
        {
            return staffPinkDamage;
        }
        else if(item == "staffYellow")
        {
            return staffYellowDamage;
        }
        else if(item == "trident")
        {
            return tridentDamage;
        }
        else if(item == "tridentMetall")
        {
            return tridentMetallDamage;
        }
        else if(item == "tridentOrange")
        {
            return tridentOrangeDamage;
        }
        else if(item == "tridentYellow")
        {
            return tridentYellowDamage;
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
        else if(item == "crystalBlue")
        {
            return crystalBlueUseCooldown;
        }
        else if(item == "crystalPink")
        {
            return crystalPinkUseCooldown;
        }
        else if(item == "crystalRed")
        {
            return crystalRedUseCooldown;
        }
        else if(item == "crystalYellow")
        {
            return crystalYellowUseCooldown;
        }
        else if(item == "dragonSpear")
        {
            return dragonSpearUseCooldown;
        }
        else if(item == "dragonSpearMetall")
        {
            return dragonSpearMetallUseCooldown;
        }
        else if(item == "spear")
        {
            return spearUseCooldown;
        }
        else if(item == "spearMetall")
        {
            return spearMetallUseCooldown;
        }
        else if(item == "staffBlue")
        {
            return staffBlueUseCooldown;
        }
        else if(item == "staffOrange")
        {
            return staffOrangeUseCooldown;
        }
        else if(item == "staffPink")
        {
            return staffPinkUseCooldown;
        }
        else if(item == "staffYellow")
        {
            return staffYellowUseCooldown;
        }
        else if(item == "trident")
        {
            return tridentUseCooldown;
        }
        else if(item == "tridentMetall")
        {
            return tridentMetallUseCooldown;
        }
        else if(item == "tridentOrange")
        {
            return tridentOrangeUseCooldown;
        }
        else if(item == "tridentYellow")
        {
            return tridentYellowUseCooldown;
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
        else if(item == "crystalBlue")
        {
            return crystalBlueMaxStackSize;
        }
        else if(item == "crystalPink")
        {
            return crystalPinkMaxStackSize;
        }
        else if(item == "crystalRed")
        {
            return crystalRedMaxStackSize;
        }
        else if(item == "crystalYellow")
        {
            return crystalYellowMaxStackSize;
        }
        else if(item == "dragonSpear")
        {
            return dragonSpearMaxStackSize;
        }
        else if(item == "dragonSpearMetall")
        {
            return dragonSpearMetallMaxStackSize;
        }
        else if(item == "spear")
        {
            return spearMaxStackSize;
        }
        else if(item == "spearMetall")
        {
            return spearMetallMaxStackSize;
        }
        else if(item == "staffBlue")
        {
            return staffBlueMaxStackSize;
        }
        else if(item == "staffOrange")
        {
            return staffOrangeMaxStackSize;
        }
        else if(item == "staffPink")
        {
            return staffPinkMaxStackSize;
        }
        else if(item == "staffYellow")
        {
            return staffYellowMaxStackSize;
        }
        else if(item == "trident")
        {
            return tridentMaxStackSize;
        }
        else if(item == "tridentMetall")
        {
            return tridentMetallMaxStackSize;
        }
        else if(item == "tridentOrange")
        {
            return tridentOrangeMaxStackSize;
        }
        else if(item == "tridentYellow")
        {
            return tridentYellowMaxStackSize;
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
        else if(item == "crystalBlue")
        {
            return crystalBlueIcon;
        }
        else if(item == "crystalPink")
        {
            return crystalPinkIcon;
        }
        else if(item == "crystalRed")
        {
            return crystalRedIcon;
        }
        else if(item == "crystalYellow")
        {
            return crystalYellowIcon;
        }
        else if(item == "dragonSpear")
        {
            return dragonSpearIcon;
        }
        else if(item == "dragonSpearMetall")
        {
            return dragonSpearMetallIcon;
        }
        else if(item == "spear")
        {
            return spearIcon;
        }
        else if(item == "spearMetall")
        {
            return spearMetallIcon;
        }
        else if(item == "staffBlue")
        {
            return staffBlueIcon;
        }
        else if(item == "staffOrange")
        {
            return staffOrangeIcon;
        }
        else if(item == "staffPink")
        {
            return staffPinkIcon;
        }
        else if(item == "staffYellow")
        {
            return staffYellowIcon;
        }
        else if(item == "trident")
        {
            return tridentIcon;
        }
        else if(item == "tridentMetall")
        {
            return tridentMetallIcon;
        }
        else if(item == "tridentOrange")
        {
            return tridentOrangeIcon;
        }
        else if(item == "tridentYellow")
        {
            return tridentYellowIcon;
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
            hotbar.getWorld().addObject(new Melee("dagger"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "axe")
        {
            hotbar.getWorld().addObject(new Melee("axe"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "warhammer")
        {
            hotbar.getWorld().addObject(new Melee("warhammer"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "longsword")
        {
            hotbar.getWorld().addObject(new Melee("longsword"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "flail")
        {
            hotbar.getWorld().addObject(new Melee("flail"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "halberd")
        {
            hotbar.getWorld().addObject(new Melee("halberd"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "mace")
        {
            hotbar.getWorld().addObject(new Melee("mace"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "rapier")
        {
            hotbar.getWorld().addObject(new Melee("rapier"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "saber")
        {
            hotbar.getWorld().addObject(new Melee("saber"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "scythe")
        {
            hotbar.getWorld().addObject(new Melee("scythe"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "waraxe")
        {
            hotbar.getWorld().addObject(new Melee("waraxe"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "cane")
        {
            hotbar.getWorld().addObject(new Melee("cane"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "crystalBlue")
        {
            hotbar.getWorld().addObject(new Melee("crystalBlue"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "crystalPink")
        {
            hotbar.getWorld().addObject(new Melee("crystalPink"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "crystalRed")
        {
            hotbar.getWorld().addObject(new Melee("crystalRed"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "crystalYellow")
        {
            hotbar.getWorld().addObject(new Melee("crystalYellow"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "dragonSpear")
        {
            hotbar.getWorld().addObject(new Melee("dragonSpear"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "dragonSpearMetall")
        {
            hotbar.getWorld().addObject(new Melee("dragonSpearMetall"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "spear")
        {
            hotbar.getWorld().addObject(new Melee("spear"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "spearMetall")
        {
            hotbar.getWorld().addObject(new Melee("spearMetall"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "staffBlue")
        {
            hotbar.getWorld().addObject(new Melee("staffBlue"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "staffOrange")
        {
            hotbar.getWorld().addObject(new Melee("staffOrange"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "staffPink")
        {
            hotbar.getWorld().addObject(new Melee("staffPink"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "staffYellow")
        {
            hotbar.getWorld().addObject(new Melee("staffYellow"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "trident")
        {
            hotbar.getWorld().addObject(new Melee("trident"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "tridentMetall")
        {
            hotbar.getWorld().addObject(new Melee("tridentMetall"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "tridentOrange")
        {
            hotbar.getWorld().addObject(new Melee("tridentOrange"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
        }
        else if(item == "tridentYellow")
        {
            hotbar.getWorld().addObject(new Melee("tridentYellow"), hotbar.getWorld().getObjects(Player.class).get(0).getX(), hotbar.getWorld().getObjects(Player.class).get(0).getY() + 50);
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
            enemy.getWorld().addObject(new Melee("dagger"), enemy.getX(), enemy.getY());
        }
        else if(item == "axe")
        {
            enemy.getWorld().addObject(new Melee("axe"), enemy.getX(), enemy.getY());
        }
        else if(item == "warhammer")
        {
            enemy.getWorld().addObject(new Melee("warhammer"), enemy.getX(), enemy.getY());
        }
        else if(item == "longsword")
        {
            enemy.getWorld().addObject(new Melee("longsword"), enemy.getX(), enemy.getY());
        }
        else if(item == "flail")
        {
            enemy.getWorld().addObject(new Melee("flail"), enemy.getX(), enemy.getY());
        }
        else if(item == "halberd")
        {
            enemy.getWorld().addObject(new Melee("halberd"), enemy.getX(), enemy.getY());
        }
        else if(item == "mace")
        {
            enemy.getWorld().addObject(new Melee("mace"), enemy.getX(), enemy.getY());
        }
        else if(item == "rapier")
        {
            enemy.getWorld().addObject(new Melee("rapier"), enemy.getX(), enemy.getY());
        }
        else if(item == "saber")
        {
            enemy.getWorld().addObject(new Melee("saber"), enemy.getX(), enemy.getY());
        }
        else if(item == "scythe")
        {
            enemy.getWorld().addObject(new Melee("scythe"), enemy.getX(), enemy.getY());
        }
        else if(item == "waraxe")
        {
            enemy.getWorld().addObject(new Melee("waraxe"), enemy.getX(), enemy.getY());
        }
        else if(item == "cane")
        {
            enemy.getWorld().addObject(new Melee("cane"), enemy.getX(), enemy.getY());
        }
        else if(item == "crystalBlue")
        {
            enemy.getWorld().addObject(new Melee("crystalBlue"), enemy.getX(), enemy.getY());
        }
        else if(item == "crystalPink")
        {
            enemy.getWorld().addObject(new Melee("crystalPink"), enemy.getX(), enemy.getY());
        }
        else if(item == "crystalRed")
        {
            enemy.getWorld().addObject(new Melee("crystalRed"), enemy.getX(), enemy.getY());
        }
        else if(item == "crystalYellow")
        {
            enemy.getWorld().addObject(new Melee("crystalYellow"), enemy.getX(), enemy.getY());
        }
        else if(item == "dragonSpear")
        {
            enemy.getWorld().addObject(new Melee("dragonSpear"), enemy.getX(), enemy.getY());
        }
        else if(item == "dragonSpearMetall")
        {
            enemy.getWorld().addObject(new Melee("dragonSpearMetall"), enemy.getX(), enemy.getY());
        }
        else if(item == "spear")
        {
            enemy.getWorld().addObject(new Melee("spear"), enemy.getX(), enemy.getY());
        }
        else if(item == "spearMetall")
        {
            enemy.getWorld().addObject(new Melee("spearMetall"), enemy.getX(), enemy.getY());
        }
        else if(item == "staffBlue")
        {
            enemy.getWorld().addObject(new Melee("staffBlue"), enemy.getX(), enemy.getY());
        }
        else if(item == "staffOrange")
        {
            enemy.getWorld().addObject(new Melee("staffOrange"), enemy.getX(), enemy.getY());
        }
        else if(item == "staffPink")
        {
            enemy.getWorld().addObject(new Melee("staffPink"), enemy.getX(), enemy.getY());
        }
        else if(item == "staffYellow")
        {
            enemy.getWorld().addObject(new Melee("staffYellow"), enemy.getX(), enemy.getY());
        }
        else if(item == "trident")
        {
            enemy.getWorld().addObject(new Melee("trident"), enemy.getX(), enemy.getY());
        }
        else if(item == "tridentMetall")
        {
            enemy.getWorld().addObject(new Melee("tridentMetall"), enemy.getX(), enemy.getY());
        }
        else if(item == "tridentOrange")
        {
            enemy.getWorld().addObject(new Melee("tridentOrange"), enemy.getX(), enemy.getY());
        }
        else if(item == "tridentYellow")
        {
            enemy.getWorld().addObject(new Melee("tridentYellow"), enemy.getX(), enemy.getY());
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
