import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends AnimatedCharacter
{
    private boolean alive = true;

    private int health;
    private int maxHealth;           //Max health enemy

    private int detectPlayerRange;   //Detection range of the enemy    
    private int attackRange;          //Attack range of the enemy
    private int damage;               //Attack damage of the enemy

    private double hitCooldown;  //Cooldown between hits
    private double lastHit;                //Saves the time of the last hit

    private int playerX;                   //Current X-Position of the Player
    private int playerY;                   //Current Y-Position of the Player

    private int oldX;                      //Used for collision
    private int oldY;                      //Used for collision

    private String path = "priorityX";     //Used for path finding, priorityX = moves first in X and then in Y to player
    //                                                              priorityY = moves first in Y and then in X to player                                           

    private double removeCooldown; //Enemy will be removed after Cooldown (after Health <= 0)
    private double deathTime;              //Stores the time then enemy died
    
    private EnemyHealthBar bar;            //Referenz HealthBar

    public void setup(int health, int maxHealth, int detectPlayerRange, int attackRange, int damage, double hitCooldown, double removeCooldown)
    {
        this.health = health;
        this.maxHealth = maxHealth;
        this.detectPlayerRange = detectPlayerRange;
        this.attackRange = attackRange;
        this.damage = damage;
        this.hitCooldown = hitCooldown;
        this.removeCooldown = removeCooldown;
    }

    public void act() 
    {
        //Call superclass act() to perform animations and movement
        super.act();
    }    

    //Spawnes new EnemyHealthbar if no one exists
    public void updateHealthBar()
    {
        if(bar == null)
        {
            //Spawn HealthBar
            bar = new EnemyHealthBar(health, maxHealth); 
            getWorld().addObject(bar, getX(), getY() - 30);
        }
        else
        {
            if(Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > detectPlayerRange) //If distance to player < detectPlayerRange -> stop moving
            {
                bar.setImage((GreenfootImage)null);
            }
            else
            {
                bar.newImage();
            }
        }
    }
    
    //Updates the Player Position Variables
    public void updatePlayerPosition(Player player)
    {
        if(player.getWorld() != null)
        {
            playerX = player.getX();
            playerY = player.getY();
        }
    }
    
    //Enemy movement: move if distance to player < detectPlayerRange && > attackRange
    public void moveToPlayer()
    {
        if(alive)
        {
            if(Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > detectPlayerRange) //If distance to player < detectPlayerRange -> stop moving
            {
                stopMoving();
            }

            if (Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) < detectPlayerRange) //If distance to player < detectPlayerRange
            {
                if(Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) < attackRange) //If distance to player < attackRange -> stop moving
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

    //Checks if cooldown -> If player is in attack range -> updates lastHit, call gotHit() on player 
    public void hit(Player player)
    {
        if(alive)
        {
            if(player.isAlive())
            {
                if(Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) <= attackRange) //If player is in attack range
                {                    
                    double t = System.nanoTime();
                    if(t - lastHit >= hitCooldown)
                    {            
                        lastHit = t;

                        runTerminalAnimation("attack", direction);

                        player.gotHit(damage);
                    }
                }
            }
        }
    }

    //If Player collides with someone/something -> teleports the player back to his old location -> changes x/y priority
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

    //Stores current X and Y position, used for collision
    public void storePosition() 
    {
        oldX = getX();
        oldY = getY();
    }

    //If !alive -> wait removeTimer -> removeObject
    public void checkRemove()
    {
        if(!alive)
        {
            if(System.nanoTime() - deathTime >= removeCooldown)
            {
                disableCollision();
                getWorld().removeObject(bar);
                getWorld().removeObject(this);
            }
        }
    }

    //Called if Player attacked and this enemy was in range and the nearest
    public void gotHit(int damage)
    {
        health = health - damage;

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
