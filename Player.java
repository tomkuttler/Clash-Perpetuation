import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends AnimatedCharacter
{
    //Animation
    private int walkSpeed;
    private int walkAnimSpeed;

    private GreenfootImage longsword1;
    private GreenfootImage longsword2;
    private GreenfootImage bow1;
    private GreenfootImage arrow;
    
    private Animation playerWalk, playerSwing;

    private int moveX, moveY;
    private int xOffset, yOffset;          //Direction for attacking

    private int oldX;                      //Used for collision
    private int oldY;                      //Used for collision

    //Attributes
    private int health;                    //Player health
    private int maxHealth = 100;           //Max health player
    private boolean alive = true;          //Is player alive

    private int swordDamage = 100;         //Melee attack damage of the player
    private double swordHitCooldown = 1000000000.0;  //Cooldown of 1 bilion nanosec (1sec) between hits

    private int bowDamage = 50;            //Ranged attack damage of the player
    private int bowRange = 200;            //Bow range of the player
    private double bowHitCooldown = 1000000000.0;  //Cooldown of 1 bilion nanosec (1sec) between hits

    private int pickUpRange = 50;          //How close the player needs to be to pick up a PickUpItem

    private String currentWeapon;

    private String currentSlotItem = "";

    private double lastHit;                //Saves the time of the last hit  

    private double pressCooldown = 250000000.0;  //Cooldown of 250 milion nanosec (0,25sec) between pressing a key
    private double lastPressedKeyTime;         //Saves the time of the last key press

    private HealthBar bar;                 //Referenz HealthBar
    private Inventory inventory;           //Referenz Inventory
    private Hotbar hotbar;                 //Referenz Hotbar

    private double removeCooldown = 2000000000.0; //Object will be removed after Cooldown of 2 bilion nanosec (2sec) (after Health <= 0)
    private double deathTime;              //Stores the time then enemy died

    public Player(HealthBar newBar, Inventory newInventory, Hotbar newHotbar) {        
        //Set variables for speed 
        walkSpeed = 60;     // pixels to move per SECOND
        walkAnimSpeed = 20; // number of animations frames per SECOND 

        //Set the speed
        changeSpeed(walkSpeed, walkAnimSpeed);

        //Store the layer images
        longsword1 = new GreenfootImage("weapons/longsword-universal.png");
        longsword2 = new GreenfootImage("weapons/longsword-attack.png");
        bow1 = new GreenfootImage("weapons/bow1.png");
        arrow = new GreenfootImage("weapons/arrow.png");

        //SETUP ANIMATIONS
        //Create sprite sheets
        setLayer(0, new GreenfootImage("player/goldenKnightNoWeapon.png"));
        // setLayer(1, new GreenfootImage("weapons/longsword-universal.png"));
        // setLayer(2, new GreenfootImage("weapons/longsword-attack.png"));
        // setLayer(3, new GreenfootImage("weapons/bow1.png"));
        // setLayer(4, new GreenfootImage("weapons/arrow.png"));

        //Build walking animation (primary animation)
        animations.put("move", Animation.createAnimation(getSpriteSheet(), 9, 4, 9, 64, 64));
        //Build a swing animation for swinging a weapon
        animations.put("swordAttack", Animation.createAnimation(getSpriteSheet(), 8, 4, 6, 192, 192));
        //Build a shoot animation for shooting a ammo
        animations.put("bowAttack", Animation.createAnimation(getSpriteSheet(), 17, 4, 13, 64, 64));
        //Build dying animation
        animations.put("die", Animation.createAnimation(getSpriteSheet(), 21, 1, 6, 64, 64));

        //Set primary animation (default animation)
        primaryAnimation = animations.get("move");

        //Start: facing downward
        direction = Direction.DOWN;

        //For the starting image, grab the 0th frame from the current facing dirction
        setImage(primaryAnimation.getOneImage(direction, 0));

        //Set full health
        health = maxHealth;

        setCollider(28, 55, 0, 4);

        //Referenz to HealthBar
        bar = newBar;

        //Referenz to Inventory
        inventory = newInventory;

        //Referenz to Hotbar
        hotbar = newHotbar;
    }

    public void act() 
    {        
        move();

        updateLayers();

        attack();

        checkCollision();

        storePosition();

        checkPickUp();

        toggleInventory();

        changeMap();

        checkRemove();

        //Call superclass act() to perform animations and movement
        super.act();
    }    

    //Player movement: move if w,a,s,d key is pressed    
    public void move()
    {
        if(alive)
        {
            // Each tick, movement is reset
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
                // set sides/directions for attacking. -1, 0 or 1 for each axis to represent
                // which direction the player is facing, to be used in collision detection
                xOffset = moveX;
                yOffset = moveY;
                moveInDirection (moveX, moveY);
            } else if(!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("d")) 
            {
                stopMoving();
            }
        }
    }

    public void updateLayers()
    {
        if(currentSlotItem != hotbar.getCurrentSlotItem())
        {
            currentSlotItem = hotbar.getCurrentSlotItem();

            if(currentSlotItem == null)
            {
                setLayer(1, null);
                setLayer(2, null);
                setLayer(3, null);
                setLayer(4, null);

                refresh(primaryAnimation);
                refresh(animations.get("swordAttack"));
                refresh(animations.get("bowAttack"));
                
                currentWeapon = null;
            }

            if(currentSlotItem == "longsword")
            {
                setLayer(1, longsword1);
                setLayer(2, longsword2);
                setLayer(3, null);
                setLayer(4, null);
                
                refresh(primaryAnimation);
                refresh(animations.get("swordAttack"));
                refresh(animations.get("bowAttack"));
                
                currentWeapon = "sword";
            }
            
            if(currentSlotItem == "bow1")
            {
                setLayer(1, null);
                setLayer(2, null);
                setLayer(3, bow1);
                setLayer(4, arrow);
                
                refresh(primaryAnimation);
                refresh(animations.get("swordAttack"));
                refresh(animations.get("bowAttack"));
                
                currentWeapon = "bow";
            }
        }        
    }

    //Checks if cooldown -> if lmb is pressed -> updates lastHit, if enemy is in range -> call gotHit() on enemy 
    public void attack() 
    {
        if(alive && !inventory.isInventoryOpen())
        {
            if(currentWeapon == "sword")
            {
                double t = System.nanoTime();
                if(t - lastHit >= swordHitCooldown)
                {
                    MouseInfo mouse = Greenfoot.getMouseInfo();
                    if(mouse != null)
                    {
                        int buttonNumber = mouse.getButton();
                        if(buttonNumber == 1) //1 = lmb, 3 = rmb
                        {
                            lastHit = t;

                            runTerminalAnimation("swordAttack", false, false, direction);

                            //Look for an Enemy 1 pixel away in the direction I'm facing
                            Enemy enemy = (Enemy)getOneObjectAtOffset(xOffset * (getImage().getWidth()/2 + 1), yOffset * (getImage().getWidth()/2 + 1), Enemy.class);

                            if(enemy != null)
                            {
                                enemy.gotHit(swordDamage);
                            }
                        }
                    }
                }
            }
            else if(currentWeapon == "bow")
            {
                double t = System.nanoTime();
                if(t - lastHit >= bowHitCooldown)
                {
                    MouseInfo mouse = Greenfoot.getMouseInfo();
                    if(mouse != null)
                    {
                        int buttonNumber = mouse.getButton();
                        if(buttonNumber == 1) //1 = lmb, 3 = rmb
                        {
                            lastHit = t;

                            runTerminalAnimation("bowAttack", false, false, direction);

                            if(direction == direction.RIGHT || direction == direction.LEFT)
                            {
                                getWorld().addObject(new Arrow(direction, bowDamage, bowRange), getX() + 11, getY() - 1);
                            }
                            else if(direction == direction.UP)
                            {
                                getWorld().addObject(new Arrow(direction, bowDamage, bowRange), getX() - 4, getY() - 30);
                            }
                            else if(direction == direction.DOWN)
                            {
                                getWorld().addObject(new Arrow(direction, bowDamage, bowRange), getX() - 2, getY() + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    //If Player collides with someone/something -> teleports the player back to his old location
    public void checkCollision()
    {
        if(myCollider.checkCollision())
        {
            setLocation(oldX, oldY);
        }
    }

    //Stores current X and Y position, used for collision
    public void storePosition() 
    {
        oldX = getX();
        oldY = getY();
    }

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
        }
    }

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

    //Change the current map if walked to a specific place
    public void changeMap() 
    {
        if(this.getWorld().getClass() == WorldMap1.class)
        {
            if(getX() > 580)
            {
                Greenfoot.setWorld(new WorldMap2(this, bar, inventory, inventory.getInventoryUI(), hotbar, hotbar.getHotbarUI(), hotbar.getHighlight()));
            }
        }
    }

    //If !alive -> wait removeTimer -> removeObject
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

    //Called if enemy attacked and hit the player
    public void gotHit(int damage)
    {
        health = health - damage;

        bar.setValue(health);

        if(health <= 0)
        {
            alive = false;
            stopMoving();
            changeSpeed (0, 3);
            runTerminalAnimation ("die", false, false, direction);
            deathTime = System.nanoTime();
        }
    }

    //Called if object wants to know if Player is alive
    public boolean isAlive()
    {
        return alive;
    }

    //Called if player picked up a healing item
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

    //Demo how to add/remove layers
    public void changeLayers()
    {
        if (Greenfoot.isKeyDown("1")){
            setLayer(1, null);
            setLayer(2, null);
            refresh(primaryAnimation);
        } else if (Greenfoot.isKeyDown("2")){
            setLayer(1, longsword1);
            setLayer(2, longsword2);
            refresh(primaryAnimation);
        }
    }
}
