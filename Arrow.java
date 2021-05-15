import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends AnimatedCharacter
{    
    private Direction direction;
    private int damage;    
    private int range;

    private int spawnX;
    private int spawnY;
    
    private boolean alive = true;

    private boolean flying = false;
    private double flyCooldown = 500000000.0; //Object will fly after Cooldown of 500 milion nanosec (0,5sec)
    private double spawnTime;  

    private GreenfootImage arrowLeft = new GreenfootImage("bullets/arrowLeft.png");
    private GreenfootImage arrowRight = new GreenfootImage("bullets/arrowRight.png");
    private GreenfootImage arrowUp = new GreenfootImage("bullets/arrowUp.png");
    private GreenfootImage arrowDown = new GreenfootImage("bullets/arrowDown.png");

    public Arrow(Direction d, int damage, int range)
    {
        setImage((GreenfootImage)null);

        direction = d;
        this.damage = damage;
        this.range = range;
    }

    public void addedToWorld(World w)
    {
        spawnTime = System.nanoTime();

        spawnX = getX();
        spawnY = getY();
    }

    public void act() 
    {
        checkHit();
        
        fly();
    }

    public void checkHit()
    {
        if(alive && !getIntersectingObjects(Actor.class).isEmpty())
        {
            Actor actor = getIntersectingObjects(Actor.class).get(0);

            if (actor instanceof Enemy)
            {
                Enemy enemy = getIntersectingObjects(Enemy.class).get(0);

                enemy.gotHit(damage);

                getWorld().removeObject(this);
                alive = false;
            }

            if (actor instanceof Objects)
            {
                Object object = getIntersectingObjects(Object.class).get(0);

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
    
    public void fly()
    {
        if(flying && alive)
        {
            if(direction == Direction.LEFT)
            {
                if(getX() >  spawnX - range)
                {
                    setLocation(getX() - 5, getY());
                }
                else
                {
                    getWorld().removeObject(this);
                    alive = false;
                }
            }

            if(direction == Direction.RIGHT)
            {
                if(getX() < spawnX + range)
                {
                    setLocation(getX() + 5, getY());
                }
                else
                {
                    getWorld().removeObject(this);
                    alive = false;
                }
            }

            if(direction == Direction.UP)
            {
                if(getY() > spawnY - range)
                {
                    setLocation(getX(), getY() - 5);
                }
                else
                {
                    getWorld().removeObject(this);
                    alive = false;
                }
            }

            if(direction == Direction.DOWN)
            {
                if(getY() < spawnY + range)
                {
                    setLocation(getX(), getY() + 5);
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

            if(direction == Direction.LEFT)
            {
                setImage(arrowLeft);
            }

            if(direction == Direction.RIGHT)
            {
                setImage(arrowRight);
            }

            if(direction == Direction.UP)
            {
                setImage(arrowUp);
            }

            if(direction == Direction.DOWN)
            {
                setImage(arrowDown);
            }
        }
    }
}
