import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Enemy class is the superclass of all enemys. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends AnimatedCharacter
{
    //----- Movement -----
    private int playerX;               //Current x position of the Player. Used for movement
    private int playerY;               //Current y position of the Player. Used for movement

    private String path = "priorityX"; //Used for path finding, "priorityX" = moves first in x direction and then in y direction to player, "priorityY" = moves first in y direction and then in x direction to player                                                          

    private int minDistance;           //Minimum distance between the enemy and the player

    //----- Collision -----
    private int oldX;                  //Stores the x position from the last tick. Used for collision
    private int oldY;                  //Stores the y position from the last tick. Used for collision

    //----- Health -----    
    private int health;                //Current health of the enemy
    private int maxHealth;             //Max health of the enemy
    private boolean alive = true;      //True if enemy is alive, false if dead

    //----- Attack -----
    private String enemyType;          //"melee" (if the enemy has a sword or dagger,...) or "ranged" (if the enemy has a bow) 

    private int bowRange;              //The range of the bow if the enemy has a bow
    private int bowSpeed;              //The speed of the bow if the enemy has a bow

    private int detectPlayerRange;     //Player detection range of the enemy     
    private int attackRange;           //Attack range of the enemy

    private int damage;                //Attack damage of the enemy

    //----- Cooldowns -----
    private double hitCooldown;        //Cooldown between hits
    private double lastHit;            //Stores the time of the last hit

    private double removeCooldown;     //Enemy will be removed after Cooldown (after Health <= 0)
    private double deathTime;          //Stores the time when the enemy died

    //----- Reference -----
    private Player player;             //Reference to the player
    private EnemyHealthBar bar;        //Reference to the HealthBar of the enemy

    /**
     * Method 'setup': Is called by the constructor in every Enemy subclass.
     * It sets the variables in this superclass to the values in the Enemy subclass.
     * 
     * @param 'maxHealth': Max health of the enemy
     * @param 'enemyType': "melee" (if the enemy has a sword or dagger,...) or "ranged" (if the enemy has a bow) 
     * @param 'detectPlayerRange': Player detection range of the enemy (in pixel) 
     * @param 'minDistance': Minimum distance between the enemy and the player
     * @param 'attackRange': Attack range of the enemy
     * @param 'bowRange': The range of the bow if the enemy has a bow
     * @param 'bowSpeed': The speed of the bow if the enemy has a bow
     * @param 'damage': Attack damage of the enemy
     * @param 'hitCooldown': Cooldown between hits
     * @param 'removeCooldown': Enemy will be removed after Cooldown (after Health <= 0)
     * @param 'bar': Reference to the HealthBar of the enemy
     * @param 'player': Reference to the player
     */
    public void setup(int maxHealth, String enemyType, int detectPlayerRange, int minDistance, int attackRange, int bowRange, int bowSpeed, int damage, double hitCooldown, double removeCooldown, EnemyHealthBar bar, Player player)
    {
        this.maxHealth = maxHealth;
        this.enemyType = enemyType;
        this.detectPlayerRange = detectPlayerRange;
        this.minDistance = minDistance;
        this.attackRange = attackRange;
        this.bowRange = bowRange;
        this.bowSpeed = bowSpeed;
        this.damage = damage;
        this.hitCooldown = hitCooldown;
        this.removeCooldown = removeCooldown;
        this.bar = bar;
        this.player = player;

        //Set full health
        health = maxHealth;
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'act' method of the AnimatedCharacter superclass to perform animations and movement.
     */
    public void act() 
    {
        //Call superclass act() to perform animations and movement
        super.act();
    }    

    /**
     * Method 'updateHealthBar': Is called every tick by the 'act' method in every Enemy subclass.
     * It shows the health bar if the player is in the detectPlayerRange and hides it if the player is too far away.
     */ 
    public void updateHealthBar()
    {
        if(Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > detectPlayerRange) //If distance to player > detectPlayerRange -> hide health bar
        {
            bar.setImage((GreenfootImage)null);
        }
        else
        {
            bar.newImage();
        }
    }

    /**
     * Method 'updatePlayerPosition': Is called every tick by the 'act' method in every Enemy subclass.
     * It stores the current position of the player, so that information can be used in the 'moveToPlayer' method, if the player is in range.
     */
    public void updatePlayerPosition()
    {
        if(player.getWorld() != null)
        {
            playerX = player.getX();
            playerY = player.getY();
        }
    }

    /**
     * Method 'moveToPlayer': Is called every tick by the 'act' method in every Enemy subclass.
     * It moves the enemy to the player if the player is in range and the enemy is not closer to the player than attackRange.
     * The enemy will move in x direction first if path is set to "priorityX" and in y direction if path is set to "priorityY".
     * The path variable will be changed if the enemy collides with something in the 'checkCollision' method.
     */
    public void moveToPlayer()
    {
        if(alive)
        {
            if(Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > detectPlayerRange) //If distance to player > detectPlayerRange -> stop moving
            {
                stopMoving();
            }

            if (Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) < detectPlayerRange) //If distance to player < detectPlayerRange
            {
                if(Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) < minDistance) //If distance to player < minDistance -> stop moving
                {
                    stopMoving();
                }

                if(path == "priorityX")
                {
                    if (getX() < playerX && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > attackRange)
                    {
                        moveInDirection (1, 0);
                        bar.setLocation(getX(), getY() - 30);
                    }

                    else if (getX() > playerX && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > attackRange)
                    {
                        moveInDirection (-1, 0);
                        bar.setLocation(getX(), getY() - 30);
                    }

                    else if (getY() < playerY && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > attackRange)
                    {
                        moveInDirection (0, 1);
                        bar.setLocation(getX(), getY() - 30);
                    }

                    else if (getY() > playerY && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > attackRange)
                    {
                        moveInDirection (0, -1);
                        bar.setLocation(getX(), getY() - 30);
                    }
                }
                else
                {
                    if (getY() < playerY && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > attackRange)
                    {
                        moveInDirection (0, 1);
                        bar.setLocation(getX(), getY() - 30);
                    }

                    else if (getY() > playerY && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > attackRange)
                    {
                        moveInDirection (0, -1);
                        bar.setLocation(getX(), getY() - 30);
                    }
                    else if (getX() < playerX && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > attackRange)
                    {
                        moveInDirection (1, 0);
                        bar.setLocation(getX(), getY() - 30);
                    }

                    else if (getX() > playerX && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > attackRange)
                    {
                        moveInDirection (-1, 0);
                        bar.setLocation(getX(), getY() - 30);
                    }
                }                                
            }
        }
    }

    /**
     * Method 'turnToPlayer': Is called every tick by the 'act' method in every Enemy subclass.
     * The enemy will turn to the player if the player is in range and the enemy is a ranged type.
     */
    public void turnToPlayer()
    {
        if(alive && enemyType == "ranged")
        {
            if (Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) < detectPlayerRange) //If distance to player < detectPlayerRange
            {
                int dx = playerX - getX();
                int dy = playerY - getY();

                double rotation = Math.atan2(dy, dx);
                rotation = Math.toDegrees(rotation);

                int rotationInt = (int) Math.round(rotation);

                if(rotationInt > -45 && rotationInt < 45)
                {
                    direction = 0;
                }
                else if(rotationInt > 135 && rotationInt < 180 || rotationInt > -180 && rotationInt < -135)
                {
                    direction = 1;
                }
                else if(rotationInt > -135 && rotationInt < -45)
                {
                    direction = 2;
                }
                else if(rotationInt > 45 && rotationInt < 135)
                {
                    direction = 3;
                }  
            }
        }
    }

    /**
     * Method 'hit': Is called every tick by the 'act' method in every Enemy subclass.
     * The enemy will attack the player if both are alive, the player is in attack range and enough time passed since the last hit.
     */
    public void hit()
    {
        if(alive)
        {
            if(player.isAlive())
            {
                if(Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) <= attackRange) //If player is in attack range
                {                    
                    if(enemyType == "melee")
                    {
                        double t = System.nanoTime();
                        if(t - lastHit >= hitCooldown)
                        {            
                            lastHit = t;

                            runTerminalAnimation("attack", direction);

                            player.gotHit(damage);
                        }
                    }
                    else if(enemyType == "ranged")
                    {
                        double t = System.nanoTime();
                        if(t - lastHit >= hitCooldown)
                        {            
                            lastHit = t;

                            runTerminalAnimation("attack", direction);

                            if(direction == 0 || direction == 1)
                            {
                                getWorld().addObject(new Arrow(direction, damage, bowRange, bowSpeed, "player"), getX() + 11, getY() - 1);
                            }
                            else if(direction == 2)
                            {
                                getWorld().addObject(new Arrow(direction, damage, bowRange, bowSpeed, "player"), getX() - 4, getY() - 30);
                            }
                            else if(direction == 3)
                            {
                                getWorld().addObject(new Arrow(direction, damage, bowRange, bowSpeed, "player"), getX() - 2, getY() + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Method 'checkCollision': Is called every tick by the 'act' method in every Enemy subclass.
     * If the collder of the enemy intersects another collider or an object, teleports the enemy back to his position of the last tick.
     * It toogles the path, so the enemy will try to walk in another direction to walk closer to the player if he is in range.
     */
    public void checkCollision()
    {
        if(alive && myCollider.checkCollision())
        {
            setLocation(oldX, oldY);

            //Toggle path
            if(path == "priorityX")
            {
                path = "priorityY";
            }
            else if(path == "priorityY")
            {
                path = "priorityX";
            }
        }
    }

    /**
     * Method 'storePosition': Is called every tick by the 'act' method in every Enemy subclass.
     * It stores the current position of the enemy, so that information can be used next tick in the 'checkCollision' method, if the enemy collides with something.
     */
    public void storePosition() 
    {
        oldX = getX();
        oldY = getY();
    }

    /**
     * Method 'checkRemove': Is called every tick by the 'act' method in every Enemy subclass.
     * If the enemy is dead and the remove cooldown has expired, the enemy and his collider will be removed from the world.
     * The enemy will drop an item randomly according to given rules.
     * 
     * @param 'dropItems': Array that contins the items that will be dropped if this enemy dies
     * @param 'dropAmount': Array that contins the amount of items that will be dropped if this enemy dies
     * @param 'probability': Array that contins the probability of dropping that item
     */
    public void checkRemove(String[] dropItems, int[] dropAmount, int[] probability)
    {
        if(!alive)
        {
            if(System.nanoTime() - deathTime >= removeCooldown)
            {
                disableCollision();
                getWorld().removeObject(bar);

                //----- Drop item -----
                int randomNumber = Greenfoot.getRandomNumber(101); //Random number between 0 (inclusive) and 100 (inclusive)

                if(randomNumber <= probability[0])
                {
                    player.inventory.itemData.spawnDroppedItemFromEnemy(dropItems[0], dropAmount[0], this);
                }
                else if(randomNumber > probability[0] && randomNumber <= (probability[0] + probability[1]))
                {
                    player.inventory.itemData.spawnDroppedItemFromEnemy(dropItems[1], dropAmount[1],  this);
                }
                else if(randomNumber > (probability[0] + probability[1]) && randomNumber <= (probability[0] + probability[1] + probability[2]))
                {
                    player.inventory.itemData.spawnDroppedItemFromEnemy(dropItems[2], dropAmount[2],  this);
                }
                else if(randomNumber > (probability[0] + probability[1] + probability[2]) && randomNumber <= (probability[0] + probability[1] + probability[2] + probability[3]))
                {
                    player.inventory.itemData.spawnDroppedItemFromEnemy(dropItems[3], dropAmount[3],  this);
                }
                else if(randomNumber > (probability[0] + probability[1] + probability[2] + probability[3]) && randomNumber <= (probability[0] + probability[1] + probability[2] + probability[3] + probability[4]))
                {
                    player.inventory.itemData.spawnDroppedItemFromEnemy(dropItems[4], dropAmount[4],  this);
                }

                getWorld().removeObject(this);                
            }
        }
    }

    /**
     * Method 'gotHit': Is called by the 'useItem' method in Player class or the 'checkHit' method in Arrow class, 
     * if the player hit the enemy or an arrow hit the enemy.
     * It subtracts the damage from the health and updates the health bar.
     * If the health is <= 0 the enemy is dead and the die animation will be played.
     * 
     * @param 'damage': The damage that the player / arrow deals
     */
    public void gotHit(int damage)
    {
        health -= damage;

        bar.setValue(health);

        if(health <= 0)
        {
            if(alive)
            {
                stopMoving();
                changeSpeed (0, 3);                
                runTerminalAnimation("die", direction);
                alive = false;
                deathTime = System.nanoTime();
            }
        }
    }
}
