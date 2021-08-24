import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The arrow class manges the flight of an arrow.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class Arrow extends Actor
{    
    //----- arrow attributes -----
    private int direction;                                 //Direction: 0 = Right, 1 = Left, 2 = Up, 3 = Down
    private int damage;                                    //The damage of this arrow
    private int range;                                     //The range of this arrow
    private int speed;                                     //The speed of this arrow

    //----- Spawn location -----
    private int spawnX;                                    //The x coordinate where the arrow was spawned
    private int spawnY;                                    //The y coordinate where the arrow was spawned
    
    //----- Alive -----
    private boolean alive = true;                          //True if arrow is "alive", false if not

    //----- Fly -----
    private boolean flying = false;                        //True if arrow is flying, false if not
    private static final double flyCooldown = 500000000.0; //Object will fly after Cooldown of 500 milion nanosec (0,5sec)
    private double spawnTime;                              //The time when the arrow was spawned
    
    //----- Target -----
    private String target;                                 //"enemy" if player shoot the arrow, "player" if enemy shoot the arrow

    //----- Object images -----
    private static final GreenfootImage arrowLeft = new GreenfootImage("bullets/arrowLeft.png");
    private static final GreenfootImage arrowRight = new GreenfootImage("bullets/arrowRight.png");
    private static final GreenfootImage arrowUp = new GreenfootImage("bullets/arrowUp.png");
    private static final GreenfootImage arrowDown = new GreenfootImage("bullets/arrowDown.png");

    /**
     * Arrow Constructor: Sets the arrow attributes.
     * 
     * @param 'direction': The direction in which the arrow is flying (0 = Right, 1 = Left, 2 = Up, 3 = Down)
     * @param 'damage': The damage of this arrow
     * @param 'range': The range of this arrow
     * @param 'speed': The speed of this arrow
     * @param 'target': The target of the arrow ("enemy" if player shoot the arrow, "player" if enemy shoot the arrow)
     */ 
    public Arrow(int direction, int damage, int range, int speed, String target)
    {
        setImage((GreenfootImage)null);

        this.direction = direction;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.target = target;
    }

    /**
     * Method 'addedToWorld': Is called when an animated character is placed in the world.
     * It sets the spawn time and the spawn location.
     * 
     * @param 'World w': The world in which the hotbar object will be placed in
     */
    public void addedToWorld(World w)
    {
        spawnTime = System.nanoTime();

        spawnX = getX();
        spawnY = getY();
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'checkHit' method and the 'fly' method.
     */
    public void act() 
    {
        checkHit();
        
        fly();
    }

    /**
     * Method 'checkHit': Is called every tick by the 'act' method.
     * If the arrow intersects an enemy and the target is an enemy the 'gotHit' method in Enemy class will be called and the arrow will be removed.
     * If the arrow intersects a player and the target is a player the 'gotHit' method in Player class will be called and the arrow will be removed.
     * If the arrow intersects an object or a collider, the arrow will be removed.
     * If the arrow is at the world border, the arrow will be removed.
     */
    public void checkHit()
    {
        if(alive && !getIntersectingObjects(Actor.class).isEmpty())
        {
            Actor actor = getIntersectingObjects(Actor.class).get(0);

            if(target == "enemy" && actor instanceof Enemy)
            {
                Enemy enemy = getIntersectingObjects(Enemy.class).get(0);

                enemy.gotHit(damage);

                getWorld().removeObject(this);
                alive = false;
            }
            
            if(target == "player" && actor instanceof Player)
            {
                Player player = getIntersectingObjects(Player.class).get(0);

                player.gotHit(damage);

                getWorld().removeObject(this);
                alive = false;
            }

            if(actor instanceof Objects || actor instanceof Collider)
            {
                getWorld().removeObject(this);
                alive = false;
            }
        }
        else if(getX() <= 5 || getX() >= getWorld().getWidth()-5 || getY() <= 5 || getY() >= getWorld().getHeight()-5)
        {
            getWorld().removeObject(this);
            alive = false;
        }
    }
    
    /**
     * Method 'fly': Is called every tick by the 'act' method.
     * Sets the location corresponding to the speed if the flight cooldown has expired.
     */
    public void fly()
    {
        if(flying && alive)
        {
            if(direction == 0)
            {
                if(getX() < spawnX + range)
                {
                    setLocation(getX() + speed, getY());
                }
                else
                {
                    getWorld().removeObject(this);
                    alive = false;
                }
            }

            if(direction == 1)
            {
                if(getX() >  spawnX - range)
                {
                    setLocation(getX() - speed, getY());
                }
                else
                {
                    getWorld().removeObject(this);
                    alive = false;
                }
            }
            
            if(direction == 2)
            {
                if(getY() > spawnY - range)
                {
                    setLocation(getX(), getY() - speed);
                }
                else
                {
                    getWorld().removeObject(this);
                    alive = false;
                }
            }

            if(direction == 3)
            {
                if(getY() < spawnY + range)
                {
                    setLocation(getX(), getY() + speed);
                }
                else
                {
                    getWorld().removeObject(this);
                    alive = false;
                }
            }
        }
        else if(System.nanoTime() - spawnTime >= flyCooldown)
        {
            flying = true;            

            if(direction == 0)
            {
                setImage(arrowRight);
            }
            
            if(direction == 1)
            {
                setImage(arrowLeft);
            }
            
            if(direction == 2)
            {
                setImage(arrowUp);
            }

            if(direction == 3)
            {
                setImage(arrowDown);
            }
        }
    }
}
