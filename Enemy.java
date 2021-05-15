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

    private Direction d;

    private int health;

    private int detectPlayerRange;   //Detection range of the enemy    
    private int attackRange;          //Attack range of the enemy
    private int damage;               //Attack damage of the enemy

    private double hitCooldown;  //Cooldown between hits
    private double lastHit;                //Saves the time of the last hit

    private int playerX;                   //Current X-Position of the Player
    private int playerY;                   //Current Y-Position of the Player

    private int oldX;                      //Used for collision
    private int oldY;                      //Used for collision

    private boolean isColliding = false;   //Used for path finding
    private String path = "rightDown";     //Used for path finding
    private double collidingCooldown;      //Cooldown after a collision -> isColliding = false
    private double lastCollisionTime;      //Stores the time of the last collision

    private double removeCooldown; //Enemy will be removed after Cooldown (after Health <= 0)
    private double deathTime;              //Stores the time then enemy died

    public void setup(int health, int detectPlayerRange, int attackRange, int damage, double hitCooldown, double removeCooldown, double collidingCooldown)
    {
        this.health = health;
        this.detectPlayerRange = detectPlayerRange;
        this.attackRange = attackRange;
        this.damage = damage;
        this.hitCooldown = hitCooldown;
        this.removeCooldown = removeCooldown;
        this.collidingCooldown = collidingCooldown;
    }

    public void act() 
    {
        //Call superclass act() to perform animations and movement
        super.act();
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

    //Enemy movement: move if distance to player < detectPlayerRange && > 40
    public void moveToPlayer()
    {
        if(alive)
        {
            if (Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) < detectPlayerRange) //If distance to player < detectPlayerRange
            {
                if(Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) < 40) //If distance to player < 25 -> stop moving
                {
                    stopMoving();
                }

                if(!isColliding)
                {
                    if (getX() < playerX && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > 40)
                    {
                        moveInDirection (1, 0);
                    }

                    else if (getX() > playerX && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > 40)
                    {
                        moveInDirection (-1, 0);
                    }

                    else if (getY() < playerY && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > 40)
                    {
                        moveInDirection (0, 1);
                    }

                    else if (getY() > playerY && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > 40)
                    {
                        moveInDirection (0, -1);
                    }
                }
                else
                {
                    if (getY() < playerY && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > 40)
                    {
                        moveInDirection (0, 1);
                    }

                    else if (getY() > playerY && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > 40)
                    {
                        moveInDirection (0, -1);
                    }
                    else if (getX() < playerX && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > 40)
                    {
                        moveInDirection (1, 0);
                    }

                    else if (getX() > playerX && Math.sqrt((getX()-playerX)*(getX()-playerX) + (getY()-playerY)*(getY()-playerY)) > 40)
                    {
                        moveInDirection (-1, 0);
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

                        runTerminalAnimation("attack", false, false, direction);

                        player.gotHit(damage);
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
            isColliding = true;
            lastCollisionTime = System.nanoTime();
        }
        else
        {
            if(System.nanoTime() - lastCollisionTime >= collidingCooldown)
            {
                isColliding = false;
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
                getWorld().removeObject(this);
            }
        }
    }

    //Called if Player attacked and this enemy was in range and the nearest
    public void gotHit(int damage)
    {
        health = health - damage;

        if(health <= 0)
        {
            if(alive)
            {
                stopMoving();
                changeSpeed (0, 3);                
                runTerminalAnimation("die", false, false, direction);
                alive = false;
                deathTime = System.nanoTime();
            }
        }
    }
}
