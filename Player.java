import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Player class is the main character the golden knight.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends AnimatedCharacter
{
    //----- Animation -----    
    private int animationSpeed = 20;              //Number of animation frames per second

    //----- Movement -----
    private int walkSpeed = 60;                   //Move 60 pixel per second
    private int moveX;                            //The direction for x movement. (-1, 0 or 1)
    private int moveY;                            //The direction for y movement. (-1, 0 or 1)
    private int xOffset, yOffset;                 //Direction for attacking

    //----- Collision -----
    private int oldX;                             //Stores the x position from the last tick. Used for collision
    private int oldY;                             //Stores the y position from the last tick. Used for collision

    //----- Health -----
    private int health;                           //Current health of the player
    private int maxHealth = 100;                  //Max health of the player
    private boolean alive = true;                 //True if player is alive, false if dead  

    //----- Pick up items -----
    private int pickUpRange = 65;                 //How close the player needs to be to pick up a PickUpItem

    //----- Hotbar -----
    private String currentSlotItem = "";          //Stores the name of the item that is in the current slot
    private String currentSlotItemType = "";      //Stores the type of the item that is in the current slot

    //----- Cooldowns -----
    private double lastUse;                       //Stores the time of the last use of an item     

    private double pressCooldown = 250000000.0;   //Cooldown of 250 milion nanosec (0,25sec) between pressing a key
    private double lastPressedKeyTime;            //Stores the time of the last key press

    private double removeCooldown = 2000000000.0; //Player will be removed after Cooldown of 2 bilion nanosec (2sec) (after Health <= 0)
    private double deathTime;                     //Stores the time the player died

    //----- References -----
    private PlayerHealthBar bar;                  //Reference to the health bar manager
    private HitCooldownBar hitBar;                //Reference to the hit cooldown bar manager
    public Inventory inventory;                   //Reference to the inventory manager
    public Hotbar hotbar;                         //Reference to the hotbar manager    

    //----- Layer images -----    
    private GreenfootImage dagger = new GreenfootImage("weapons/melee/slash/dagger.png");
    private GreenfootImage axe = new GreenfootImage("weapons/melee/slash/axe.png");
    private GreenfootImage warhammer = new GreenfootImage("weapons/melee/slash/warhammer.png");

    private GreenfootImage longsword1 = new GreenfootImage("weapons/melee/oversize/slash/longsword-universal.png");           
    private GreenfootImage longsword2 = new GreenfootImage("weapons/melee/oversize/slash/longsword-attack.png");
    private GreenfootImage flail1 = new GreenfootImage("weapons/melee/oversize/slash/flail-universal.png");           
    private GreenfootImage flail2 = new GreenfootImage("weapons/melee/oversize/slash/flail-attack.png");
    private GreenfootImage halberd1 = new GreenfootImage("weapons/melee/oversize/slash/halberd-universal.png");           
    private GreenfootImage halberd2 = new GreenfootImage("weapons/melee/oversize/slash/halberd-attack.png");
    private GreenfootImage mace1 = new GreenfootImage("weapons/melee/oversize/slash/mace-universal.png");           
    private GreenfootImage mace2 = new GreenfootImage("weapons/melee/oversize/slash/mace-attack.png");
    private GreenfootImage rapier1 = new GreenfootImage("weapons/melee/oversize/slash/rapier-universal.png");           
    private GreenfootImage rapier2 = new GreenfootImage("weapons/melee/oversize/slash/rapier-attack.png");
    private GreenfootImage saber1 = new GreenfootImage("weapons/melee/oversize/slash/saber-universal.png");           
    private GreenfootImage saber2 = new GreenfootImage("weapons/melee/oversize/slash/saber-attack.png");
    private GreenfootImage scythe1 = new GreenfootImage("weapons/melee/oversize/slash/scythe-universal.png");           
    private GreenfootImage scythe2 = new GreenfootImage("weapons/melee/oversize/slash/scythe-attack.png");
    private GreenfootImage waraxe1 = new GreenfootImage("weapons/melee/oversize/slash/waraxe-universal.png");           
    private GreenfootImage waraxe2 = new GreenfootImage("weapons/melee/oversize/slash/waraxe-attack.png");

    private GreenfootImage cane = new GreenfootImage("weapons/melee/thrust/cane.png");

    private GreenfootImage crystalBlue = new GreenfootImage("weapons/melee/oversize/thrust/crystalBlue.png");
    private GreenfootImage crystalPink = new GreenfootImage("weapons/melee/oversize/thrust/crystalPink.png");
    private GreenfootImage crystalRed = new GreenfootImage("weapons/melee/oversize/thrust/crystalRed.png");
    private GreenfootImage crystalYellow = new GreenfootImage("weapons/melee/oversize/thrust/crystalYellow.png");
    private GreenfootImage dragonSpear = new GreenfootImage("weapons/melee/oversize/thrust/dragonSpear.png");
    private GreenfootImage dragonSpearMetall = new GreenfootImage("weapons/melee/oversize/thrust/dragonSpearMetall.png");
    private GreenfootImage spear = new GreenfootImage("weapons/melee/oversize/thrust/spear.png");
    private GreenfootImage spearMetall = new GreenfootImage("weapons/melee/oversize/thrust/spearMetall.png");
    private GreenfootImage staffBlue = new GreenfootImage("weapons/melee/oversize/thrust/staffBlue.png");
    private GreenfootImage staffOrange = new GreenfootImage("weapons/melee/oversize/thrust/staffOrange.png");
    private GreenfootImage staffPink = new GreenfootImage("weapons/melee/oversize/thrust/staffPink.png");
    private GreenfootImage staffYellow = new GreenfootImage("weapons/melee/oversize/thrust/staffYellow.png");
    private GreenfootImage trident = new GreenfootImage("weapons/melee/oversize/thrust/trident.png");
    private GreenfootImage tridentMetall = new GreenfootImage("weapons/melee/oversize/thrust/tridentMetall.png");
    private GreenfootImage tridentOrange = new GreenfootImage("weapons/melee/oversize/thrust/tridentOrange.png");
    private GreenfootImage tridentYellow = new GreenfootImage("weapons/melee/oversize/thrust/tridentYellow.png");    
    
    private GreenfootImage bow1 = new GreenfootImage("weapons/ranged/bow1.png");
    private GreenfootImage arrow = new GreenfootImage("weapons/ranged/arrow.png");

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
        setLayer(0, new GreenfootImage("player/goldenKnightNoWeapon.png"));

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

        changeMap();

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
                setLayer(1, longsword1);
                setLayer(2, longsword2);
            }
            else if(currentSlotItem == "flail")
            {
                setLayer(1, flail1);
                setLayer(2, flail2);
            }
            else if(currentSlotItem == "halberd")
            {
                setLayer(1, halberd1);
                setLayer(2, halberd2);
            }
            else if(currentSlotItem == "mace")
            {
                setLayer(1, mace1);
                setLayer(2, mace2);
            }
            else if(currentSlotItem == "rapier")
            {
                setLayer(1, rapier1);
                setLayer(2, rapier2);
            }
            else if(currentSlotItem == "saber")
            {
                setLayer(1, saber1);
                setLayer(2, saber2);
            }
            else if(currentSlotItem == "scythe")
            {
                setLayer(1, scythe1);
                setLayer(2, scythe2);
            }
            else if(currentSlotItem == "waraxe")
            {
                setLayer(1, waraxe1);
                setLayer(2, waraxe2);
            }
            else if(currentSlotItem == "cane")
            {
                setLayer(1, cane);
                setLayer(2, null);
            }
            else if(currentSlotItem == "crystalBlue")
            {
                setLayer(1, crystalBlue);
                setLayer(2, null);
            }
            else if(currentSlotItem == "crystalPink")
            {
                setLayer(1, crystalPink);
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
            else if(currentSlotItem == "staffBlue")
            {
                setLayer(1, staffBlue);
                setLayer(2, null);
            }
            else if(currentSlotItem == "staffOrange")
            {
                setLayer(1, staffOrange);
                setLayer(2, null);
            }
            else if(currentSlotItem == "staffPink")
            {
                setLayer(1, staffPink);
                setLayer(2, null);
            }
            else if(currentSlotItem == "staffYellow")
            {
                setLayer(1, staffYellow);
                setLayer(2, null);
            }
            else if(currentSlotItem == "trident")
            {
                setLayer(1, trident);
                setLayer(2, null);
            }
            else if(currentSlotItem == "tridentMetall")
            {
                setLayer(1, tridentMetall);
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
     * Method 'changeMap': Is called every tick by the 'act' method.
     * If the player walked to a specific place, change the map.
     */
    public void changeMap() 
    {
        if(this.getWorld().getClass() == WorldMap1.class)
        {
            if(getX() > 1690)
            {
                Greenfoot.setWorld(new WorldMap2(this, bar, hitBar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
            }
        }
    }

    /**
     * Method 'checkRemove': Is called every tick by the 'act' method.
     * If the player is dead and the remove cooldown has expired, the player and his collider will be removed from the world.
     */
    public void checkRemove()
    {
        if(!alive)
        {
            if(System.nanoTime() - deathTime >= removeCooldown)
            {
                disableCollision();
                getWorld().removeObject(this);
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
}
