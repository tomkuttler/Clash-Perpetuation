import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Player class is the main character the golden knight.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class Player extends AnimatedCharacter
{
    //----- Animation -----    
    private static final int animationSpeed = 20;              //Number of animation frames per second

    //----- Movement -----
    private static final int walkSpeed = 60;                   //Move 60 pixel per second
    private int moveX;                                         //The direction for x movement. (-1, 0 or 1)
    private int moveY;                                         //The direction for y movement. (-1, 0 or 1)
    private int xOffset, yOffset;                              //Direction for attacking

    //----- Collision -----
    private int oldX;                                          //Stores the x position from the last tick. Used for collision
    private int oldY;                                          //Stores the y position from the last tick. Used for collision

    //----- Health -----
    private int health;                                        //Current health of the player
    private static final int maxHealth = 100;                  //Max health of the player
    private boolean alive = true;                              //True if player is alive, false if dead  

    //----- Pick up items -----
    private static final int pickUpRange = 65;                 //How close the player needs to be to pick up a PickUpItem

    //----- Hotbar -----
    private String currentSlotItem = "";                       //Stores the name of the item that is in the current slot
    private String currentSlotItemType = "";                   //Stores the type of the item that is in the current slot

    //----- Cooldowns -----
    private double lastUse;                                    //Stores the time of the last use of an item     

    private static final double pressCooldown = 250000000.0;   //Cooldown of 250 milion nanosec (0,25sec) between pressing a key
    private double lastPressedKeyTime;                         //Stores the time of the last key press

    private static final double removeCooldown = 2000000000.0; //Player will be removed after Cooldown of 2 bilion nanosec (2sec) (after Health <= 0)
    private double deathTime;                                  //Stores the time when the player died

    private static final double textCooldown = 10000000000.0;  //A new kill all enemys text will be spawned after Cooldown of 10 bilion nanosec (10sec) (after the last spawn if player didnt move)
    private double lastTextTime;                               //Stores the time when the last kill all enemys text was displayed

    //----- References -----
    private PlayerHealthBar bar;                               //Reference to the health bar manager
    private HitCooldownBar hitBar;                             //Reference to the hit cooldown bar manager
    public Inventory inventory;                                //Reference to the inventory manager
    public Hotbar hotbar;                                      //Reference to the hotbar manager    

    //----- Layer images -----
    private static final GreenfootImage player = new GreenfootImage("player/goldenKnightNoWeapon.png");
    
    private static final GreenfootImage dagger = new GreenfootImage("weapons/melee/slash/dagger.png");
    private static final GreenfootImage axe = new GreenfootImage("weapons/melee/slash/axe.png");
    private static final GreenfootImage warhammer = new GreenfootImage("weapons/melee/slash/warhammer.png");

    private static final GreenfootImage longsword = new GreenfootImage("weapons/melee/oversize/slash/longsword.png");           
    private static final GreenfootImage flail = new GreenfootImage("weapons/melee/oversize/slash/flail.png");           
    private static final GreenfootImage halberd = new GreenfootImage("weapons/melee/oversize/slash/halberd.png");           
    private static final GreenfootImage mace = new GreenfootImage("weapons/melee/oversize/slash/mace.png");           
    private static final GreenfootImage rapier = new GreenfootImage("weapons/melee/oversize/slash/rapier.png");           
    private static final GreenfootImage saber = new GreenfootImage("weapons/melee/oversize/slash/saber.png");           
    private static final GreenfootImage scythe = new GreenfootImage("weapons/melee/oversize/slash/scythe.png");           
    private static final GreenfootImage waraxe = new GreenfootImage("weapons/melee/oversize/slash/waraxe.png");           

    private static final GreenfootImage cane = new GreenfootImage("weapons/melee/thrust/cane.png");
    
    private static final GreenfootImage crystalRed = new GreenfootImage("weapons/melee/oversize/thrust/crystalRed.png");
    private static final GreenfootImage crystalYellow = new GreenfootImage("weapons/melee/oversize/thrust/crystalYellow.png");
    private static final GreenfootImage dragonSpear = new GreenfootImage("weapons/melee/oversize/thrust/dragonSpear.png");
    private static final GreenfootImage dragonSpearMetall = new GreenfootImage("weapons/melee/oversize/thrust/dragonSpearMetall.png");
    private static final GreenfootImage spear = new GreenfootImage("weapons/melee/oversize/thrust/spear.png");
    private static final GreenfootImage spearMetall = new GreenfootImage("weapons/melee/oversize/thrust/spearMetall.png");    
    private static final GreenfootImage staffOrange = new GreenfootImage("weapons/melee/oversize/thrust/staffOrange.png");        
    private static final GreenfootImage tridentOrange = new GreenfootImage("weapons/melee/oversize/thrust/tridentOrange.png");
    private static final GreenfootImage tridentYellow = new GreenfootImage("weapons/melee/oversize/thrust/tridentYellow.png");    

    private static final GreenfootImage bow1 = new GreenfootImage("weapons/ranged/bow1.png");
    private static final GreenfootImage arrow = new GreenfootImage("weapons/ranged/arrow.png");
    
    /**
     * Player Constructor: Sets the speed, creates the spriteSheet of the character, creates the animations and sets variables.
     * 
     * @param 'newBar': Reference to the health bar manager
     * @param 'newHitBar': Reference to the hit cooldown bar manager
     * @param 'newInventory': Reference to the inventory manager
     * @param 'newHotbar': Reference to the hotbar manager
     */ 
    public Player(PlayerHealthBar newBar, HitCooldownBar newHitBar, Inventory newInventory, Hotbar newHotbar) 
    {        
        //Set the speed
        changeSpeed(walkSpeed, animationSpeed);

        //Create spriteSheet
        setLayer(0, player);

        //----- BUILD ANIMATIONS -----
        //Build walking animation (primary animation)
        animations.put("walk", Animation.createAnimation(getSpriteSheet(), 9, 4, 9, 64, 64));                
        //Build a slash animation for swinging a weapon or taking a potion
        animations.put("slash", Animation.createAnimation(getSpriteSheet(), 13, 4, 6, 64, 64));
        //Build a swing animation for swinging a weapon (oversize = 192 * 192 pixel)
        animations.put("slashOversize", Animation.createAnimation(getSpriteSheet(), 8, 4, 6, 192, 192));
        //Build a thrust animation for thrusting a weapon 
        animations.put("thrust", Animation.createAnimation(getSpriteSheet(), 5, 4, 8, 64, 64));
        //Build a thrust animation for thrusting a weapon (oversize = 192 * 192 pixel)
        animations.put("thrustOversize", Animation.createAnimation(getSpriteSheet(), 12, 4, 8, 192, 192));
        //Build a shoot animation for shooting with a bow
        animations.put("shoot", Animation.createAnimation(getSpriteSheet(), 17, 4, 13, 64, 64));
        //Build dying animation
        animations.put("die", Animation.createAnimation(getSpriteSheet(), 21, 1, 6, 64, 64));

        //Set primary animation (default animation)
        primaryAnimation = animations.get("walk");

        //Start: facing downward
        direction = 3;

        //For the starting image, grab the 0th frame from the current facing dirction
        setImage(primaryAnimation.getOneImage(direction, 0));

        //Set full health
        health = maxHealth;

        //Spawn new Collider
        setCollider(28, 55, 0, 4);

        //Set References
        bar = newBar;
        hitBar = newHitBar;
        inventory = newInventory;
        hotbar = newHotbar;
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'act' method of the AnimatedCharacter superclass to perform animations and movement.
     */
    public void act() 
    {        
        move();

        updateLayers();

        useItem();

        checkCollision();

        storePosition();

        checkPickUp();

        toggleInventory();

        checkChangeMap();

        checkRemove();

        //Call superclass act() to perform animations and movement
        super.act();
    }    

    /**
     * Method 'move': Is called every tick by the 'act' method.
     * It sets the move variables if 'w', 's', 'd' or 'a' is pressed.
     * If an item was used, it checks if the use cooldown of that item has expired, because the character is not able to move while using an item / attacking.
     */    
    public void move()
    {
        if(alive)
        {
            double t = System.nanoTime();
            if(t - lastUse >= inventory.itemData.getUseCooldown(currentSlotItem))
            {
                //Each tick, movement is reset
                moveX = 0; 
                moveY = 0;

                if(Greenfoot.isKeyDown("w"))
                {
                    moveY = -1;
                }
                else if(Greenfoot.isKeyDown("s"))
                {
                    moveY = 1;
                }
                else if(Greenfoot.isKeyDown("d"))
                {
                    moveX = 1;
                }
                else if(Greenfoot.isKeyDown("a"))
                {
                    moveX = -1;
                }

                if(moveX != 0 || moveY != 0)
                {
                    //Set directions for attacking. -1, 0 or 1 for each axis to represent which direction the player is facing
                    xOffset = moveX;
                    yOffset = moveY;

                    moveInDirection(moveX, moveY);                    
                } 
                else 
                {
                    stopMoving();                    
                }
            }
            else
            {
                stopMoving();
            }
        }
    }

    /**
     * Method 'updateLayers': Is called every tick by the 'act' method.
     * It sets the currentSlotItem variable to the name of the item in the current hotbar slot, if the item changed.
     * If the item changed the layers of the spriteSheet will be updated and the animations will be refreshed to show the correct item in the current hotbar slot.
     * To get the currentSlotItemType, the mothod 'getItemType' in ItemData class will be called.
     */
    public void updateLayers()
    {
        if(currentSlotItem != hotbar.getCurrentSlotItem())
        {
            currentSlotItem = hotbar.getCurrentSlotItem();

            if(currentSlotItem == null)
            {
                setLayer(1, null);
                setLayer(2, null);
            }            
            else if(currentSlotItem == "dagger")
            {
                setLayer(1, dagger);
                setLayer(2, null);
            }
            else if(currentSlotItem == "axe")
            {
                setLayer(1, axe);
                setLayer(2, null);
            }
            else if(currentSlotItem == "warhammer")
            {
                setLayer(1, warhammer);
                setLayer(2, null);
            }
            else if(currentSlotItem == "longsword")
            {
                setLayer(1, longsword);
                setLayer(2, null);
            }
            else if(currentSlotItem == "flail")
            {
                setLayer(1, flail);
                setLayer(2, null);
            }
            else if(currentSlotItem == "halberd")
            {
                setLayer(1, halberd);
                setLayer(2, null);
            }
            else if(currentSlotItem == "mace")
            {
                setLayer(1, mace);
                setLayer(2, null);
            }
            else if(currentSlotItem == "rapier")
            {
                setLayer(1, rapier);
                setLayer(2, null);
            }
            else if(currentSlotItem == "saber")
            {
                setLayer(1, saber);
                setLayer(2, null);
            }
            else if(currentSlotItem == "scythe")
            {
                setLayer(1, scythe);
                setLayer(2, null);
            }
            else if(currentSlotItem == "waraxe")
            {
                setLayer(1, waraxe);
                setLayer(2, null);
            }
            else if(currentSlotItem == "cane")
            {
                setLayer(1, cane);
                setLayer(2, null);
            }            
            else if(currentSlotItem == "crystalRed")
            {
                setLayer(1, crystalRed);
                setLayer(2, null);
            }
            else if(currentSlotItem == "crystalYellow")
            {
                setLayer(1, crystalYellow);
                setLayer(2, null);
            }
            else if(currentSlotItem == "dragonSpear")
            {
                setLayer(1, dragonSpear);
                setLayer(2, null);
            }
            else if(currentSlotItem == "dragonSpearMetall")
            {
                setLayer(1, dragonSpearMetall);
                setLayer(2, null);
            }
            else if(currentSlotItem == "spear")
            {
                setLayer(1, spear);
                setLayer(2, null);
            }
            else if(currentSlotItem == "spearMetall")
            {
                setLayer(1, spearMetall);
                setLayer(2, null);
            }            
            else if(currentSlotItem == "staffOrange")
            {
                setLayer(1, staffOrange);
                setLayer(2, null);
            }                        
            else if(currentSlotItem == "tridentOrange")
            {
                setLayer(1, tridentOrange);
                setLayer(2, null);
            }
            else if(currentSlotItem == "tridentYellow")
            {
                setLayer(1, tridentYellow);
                setLayer(2, null);
            }            
            else if(currentSlotItem == "bow1")
            {
                setLayer(1, bow1);
                setLayer(2, arrow);
            }
            else if(currentSlotItem == "greenPotion" || currentSlotItem == "redPotion" || currentSlotItem == "bluePotion" || currentSlotItem == "purplePotion" || currentSlotItem == "whitePotion")
            {
                setLayer(1, null);
                setLayer(2, null);                                
            }

            refresh(primaryAnimation);
            refresh(animations.get("slash"));
            refresh(animations.get("slashOversize"));                
            refresh(animations.get("thrust"));
            refresh(animations.get("thrustOversize"));
            refresh(animations.get("shoot"));
            refresh(animations.get("die"));

            currentSlotItemType = inventory.itemData.getItemType(currentSlotItem);
        }        
    }

    /**
     * Method 'useItem': Is called every tick by the 'act' method.
     * If an item was used already, it checks if the use cooldown of that item has expired.
     * If the cooldown has expired, and if the left mouse button is pressed, it plays the corresponding animation and checks if an enemy was hit / spwans an arrow / heals the player.
     */ 
    public void useItem() 
    {
        if(alive && !inventory.isInventoryOpen())
        {
            if(currentSlotItemType == "meleeWeapon")
            {
                double t = System.nanoTime();
                if(t - lastUse >= inventory.itemData.getUseCooldown(currentSlotItem))
                {
                    MouseInfo mouse = Greenfoot.getMouseInfo();
                    if(mouse != null)
                    {
                        int buttonNumber = mouse.getButton();
                        if(buttonNumber == 1) //1 = lmb, 3 = rmb
                        {
                            lastUse = t;

                            hitBar.itemUsed(inventory.itemData.getUseCooldown(currentSlotItem));

                            if(currentSlotItem == "dagger" || currentSlotItem == "axe" || currentSlotItem == "warhammer")
                            {
                                runTerminalAnimation("slash", direction);
                            }
                            else if(currentSlotItem == "longsword" || currentSlotItem == "flail" || currentSlotItem == "halberd" || currentSlotItem == "mace" || currentSlotItem == "rapier" || currentSlotItem == "saber" || currentSlotItem == "scythe" || currentSlotItem == "waraxe")
                            {
                                runTerminalAnimation("slashOversize", direction);
                            }
                            else if(currentSlotItem == "cane")
                            {
                                runTerminalAnimation("thrust", direction);
                            }
                            else
                            {
                                runTerminalAnimation("thrustOversize", direction);
                            }
                            
                            //Look for an Enemy 1 pixel away in the direction I'm facing
                            Enemy enemy = (Enemy)getOneObjectAtOffset(xOffset * (getImage().getWidth()/2 + 1), yOffset * (getImage().getWidth()/2 + 1), Enemy.class);

                            if(enemy != null)
                            {
                                enemy.gotHit(inventory.itemData.getDamage(currentSlotItem));
                            }
                        }
                    }
                }
            }
            else if(currentSlotItemType == "bow")
            {
                double t = System.nanoTime();
                if(t - lastUse >= inventory.itemData.getUseCooldown(currentSlotItem))
                {
                    MouseInfo mouse = Greenfoot.getMouseInfo();
                    if(mouse != null)
                    {
                        int buttonNumber = mouse.getButton();
                        if(buttonNumber == 1) //1 = lmb, 3 = rmb
                        {
                            if(hotbar.isInHotbar("arrow1"))
                            {
                                lastUse = t;

                                hitBar.itemUsed(inventory.itemData.getUseCooldown(currentSlotItem));

                                runTerminalAnimation("shoot", direction);
                                
                                if(direction == 0 || direction == 1)
                                {
                                    getWorld().addObject(new Arrow(direction, inventory.itemData.getDamage(currentSlotItem), inventory.itemData.getRange(currentSlotItem), inventory.itemData.getSpeed(currentSlotItem), "enemy"), getX() + 11, getY() - 1);
                                }
                                else if(direction == 2)
                                {
                                    getWorld().addObject(new Arrow(direction, inventory.itemData.getDamage(currentSlotItem), inventory.itemData.getRange(currentSlotItem), inventory.itemData.getSpeed(currentSlotItem), "enemy"), getX() - 4, getY() - 30);
                                }
                                else if(direction == 3)
                                {
                                    getWorld().addObject(new Arrow(direction, inventory.itemData.getDamage(currentSlotItem), inventory.itemData.getRange(currentSlotItem), inventory.itemData.getSpeed(currentSlotItem), "enemy"), getX() - 2, getY() + 20);
                                }

                                hotbar.removeItem("arrow1", 1);
                            }
                        }
                    }
                }
            }
            else if(currentSlotItemType == "healingItem")
            {                
                double t = System.nanoTime();
                if(t - lastUse >= inventory.itemData.getUseCooldown(currentSlotItem))
                {
                    MouseInfo mouse = Greenfoot.getMouseInfo();
                    if(mouse != null)
                    {
                        int buttonNumber = mouse.getButton();
                        if(buttonNumber == 1) //1 = lmb, 3 = rmb
                        {
                            if(health != maxHealth)
                            {
                                lastUse = t;

                                hitBar.itemUsed(inventory.itemData.getUseCooldown(currentSlotItem));

                                runTerminalAnimation("slash", direction);

                                heal(inventory.itemData.getHealthPoints(currentSlotItem));

                                hotbar.removeItemAtSpecificSlot(1, hotbar.getCurrentSlot());
                                hotbar.updateSpecificSlot(hotbar.getCurrentSlot());
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Method 'checkCollision': Is called every tick by the 'act' method.
     * If the collder of the player intersects another collider or an object, teleports the player back to his position of the last tick.
     */
    public void checkCollision()
    {
        if(myCollider.checkCollision())
        {
            setLocation(oldX, oldY);
        }
    }

    /**
     * Method 'storePosition': Is called every tick by the 'act' method.
     * It stores the current position of the player, so that information can be used next tick in the 'checkCollision' method, if the player collides with something.
     */
    public void storePosition() 
    {
        oldX = getX();
        oldY = getY();
    }

    /**
     * Method 'checkPickUp': Is called every tick by the 'act' method.
     * If 'e' is pressed, it will look for the the nearest PickUpItem thats in pickUpRange or it will look for the nearest Chest in pickUpRange.
     * The PickUpItem will be picked up and added to the inventory.
     * The Chest will be opened and the items in the chest will be added to the inventory.
     */
    public void checkPickUp()
    {
        if(Greenfoot.isKeyDown("e") && alive)
        {
            if(!getObjectsInRange(pickUpRange, PickUpItems.class).isEmpty())
            {
                //Look for an PickUpItem in range
                PickUpItems item = (PickUpItems)getObjectsInRange(pickUpRange, PickUpItems.class).get(0);

                if(item != null)
                {
                    if(inventory.addItem(item))
                    {
                        item.pickedUp();
                    }
                }
            }

            if(!getObjectsInRange(pickUpRange, Chest.class).isEmpty())
            {
                //Look for a Chest in range
                Chest chest = (Chest)getObjectsInRange(pickUpRange, Chest.class).get(0);

                if(chest != null && chest.isClosed())
                {
                    String[] items = chest.getItems();
                    int[] amount = chest.getAmount();

                    for(int i = 0; i < chest.getMaxSlots(); i++)
                    {
                        inventory.addItemFromChest(items[i], amount[i]);
                    }

                    chest.open();
                }
            }
        }
    }

    /**
     * Method 'toggleInventory': Is called every tick by the 'act' method.
     * If 'i' is pressed, it checks if the cooldown of the last key press has expired.
     * If the cooldown has expired, the inventory will be closed if it was open and opened if it was closed.
     */
    public void toggleInventory()
    {
        if(Greenfoot.isKeyDown("i") && alive)
        {
            double i = System.nanoTime();
            if(i - lastPressedKeyTime >= pressCooldown)
            {
                if(inventory.isInventoryOpen())
                {
                    inventory.closeInventory();
                    lastPressedKeyTime = System.nanoTime();
                }
                else
                {
                    inventory.openInventory();
                    lastPressedKeyTime = System.nanoTime();
                }
            }
        }
    }

    /**
     * Method 'checkChangeMap': Is called every tick by the 'act' method.
     * If the player walked to a specific place, change the map, if the player killed all enemys in the current map.
     * If the player did not kill all enemys a tutorial message will appear.
     */
    public void checkChangeMap() 
    {
        if(this.getWorld().getClass() == WorldMap1.class)
        {
            if(getX() > 1690)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap2(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
        else if(this.getWorld().getClass() == WorldMap2.class)
        {
            if(getY() > 875 && getX() > 800 && getX() < 1000)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap3(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
        else if(this.getWorld().getClass() == WorldMap3.class)
        {
            if(getX() > 1690 && getY() > 380 && getY() < 480)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap4(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
        else if(this.getWorld().getClass() == WorldMap4.class)
        {
            if(getY() < 10 && getX() > 1080 && getX() < 1200)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap5(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
        else if(this.getWorld().getClass() == WorldMap5.class)
        {
            if(getY() < 10 && getX() > 730 && getX() < 900)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap6(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
        else if(this.getWorld().getClass() == WorldMap6.class)
        {
            if(getY() < 590 && getX() > 855 && getX() < 875)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap7(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
        else if(this.getWorld().getClass() == WorldMap7.class)
        {
            if(getY() < 190 && getX() > 840 && getX() < 860)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap8(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
        else if(this.getWorld().getClass() == WorldMap8.class)
        {
            if(getY() < 10 && getX() > 790 && getX() < 950)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap9(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
        else if(this.getWorld().getClass() == WorldMap9.class)
        {
            if(getY() < 315 && getX() > 1015 && getX() < 1030)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap10(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
        else if(this.getWorld().getClass() == WorldMap10.class)
        {
            if(getY() < 85 && getX() > 855 && getX() < 875)
            {
                if(this.getWorld().getObjects(Enemy.class).isEmpty())
                {
                    Greenfoot.setWorld(new WorldMap11(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
                }
                else
                {
                    double t = System.nanoTime();
                    if(t - lastTextTime >= textCooldown)
                    {
                        lastTextTime = System.nanoTime();

                        this.getWorld().getObjects(Tutorial.class).get(0).killAllEnemysText();
                    }
                }
            }
        }
    }

    /**
     * Method 'checkRemove': Is called every tick by the 'act' method.
     * If the player is dead and the remove cooldown has expired, the player and his collider will be removed from the world.
     * The lose screen will be displayed.
     */
    public void checkRemove()
    {
        if(!alive)
        {
            if(System.nanoTime() - deathTime >= removeCooldown)
            {
                disableCollision();
                getWorld().removeObject(this);
                
                Greenfoot.setWorld(new LoseScreen());
            }
        }
    }

    /**
     * Method 'gotHit': Is called by the 'hit' method in Enemy class or the 'checkHit' method in Arrow class, 
     * if the enemy hit the player or an arrow hit the player.
     * It subtracts the damage from the health and updates the health bar.
     * If the health is <= 0 the player is dead the inventory wil be closed and the die animation will be played.
     * 
     * @param 'damage': The damage that the enemy deals
     */    
    public void gotHit(int damage)
    {
        health -= damage;

        bar.setValue(health);

        if(health <= 0)
        {
            alive = false;

            stopMoving();
            changeSpeed (0, 3);

            if(inventory.isInventoryOpen())
            {
                inventory.closeInventory();
            }

            runTerminalAnimation ("die", direction);

            deathTime = System.nanoTime();
        }
    }

    /**
     * Method 'isAlive': Is called by the 'hit' method in Enemy class, if the enemy wants to know if the player is alive.
     * 
     * @return: True if player is alive, false if dead
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Method 'heal': Is called by the 'useItem' method, if the player used a healing item.
     * It adds the health points that the item heals to the health of the player and updates the health bar.
     * 
     * @param 'healthPointsToAdd': The health points that the healing item restores
     */  
    public void heal(int healthPointsToAdd)
    {        
        if(health + healthPointsToAdd <= maxHealth)
        {
            health = health + healthPointsToAdd;
        }
        else
        {
            health = maxHealth;
        }

        bar.setValue(health);
    }
    
    /**
     * Method 'debugChangeMap': Is a debug method. Will not be called in game.
     * Change the map instantly without having to kill all enemys.
     * 
     * @param 'mapNumber': The number of the map that should be displayed.
     */
    public void debugChangeMap(int mapNumber)
    {
        if(mapNumber == 1)
        {
            Greenfoot.setWorld(new WorldMap1());
        }
        else if(mapNumber == 2)
        {
            Greenfoot.setWorld(new WorldMap2(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
        else if(mapNumber == 3)
        {
            Greenfoot.setWorld(new WorldMap3(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
        else if(mapNumber == 4)
        {
            Greenfoot.setWorld(new WorldMap4(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
        else if(mapNumber == 5)
        {
            Greenfoot.setWorld(new WorldMap5(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
        else if(mapNumber == 6)
        {
            Greenfoot.setWorld(new WorldMap6(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
        else if(mapNumber == 7)
        {
            Greenfoot.setWorld(new WorldMap7(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
        else if(mapNumber == 8)
        {
            Greenfoot.setWorld(new WorldMap8(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
        else if(mapNumber == 9)
        {
            Greenfoot.setWorld(new WorldMap9(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
        else if(mapNumber == 10)
        {
            Greenfoot.setWorld(new WorldMap10(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
        else if(mapNumber == 11)
        {
            Greenfoot.setWorld(new WorldMap11(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
        }
    }
}
