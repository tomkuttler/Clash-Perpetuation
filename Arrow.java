import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends AnimatedCharacter
{    
    private int direction;
    private int damage;    
    private int range;
    private int speed;

    private int spawnX;
    private int spawnY;
    
    private boolean alive = true;

    private boolean flying = false;
    private double flyCooldown = 500000000.0; //Object will fly after Cooldown of 500 milion nanosec (0,5sec)
    private double spawnTime; 
    
    private String target; //"enemy" if player shoot the arrow, "player" if enemy shoot the arrow

    private GreenfootImage arrowLeft = new GreenfootImage("bullets/arrowLeft.png");
    private GreenfootImage arrowRight = new GreenfootImage("bullets/arrowRight.png");
    private GreenfootImage arrowUp = new GreenfootImage("bullets/arrowUp.png");
    private GreenfootImage arrowDown = new GreenfootImage("bullets/arrowDown.png");

    public Arrow(int direction, int damage, int range, int speed, String target)
    {
        setImage((GreenfootImage)null);

        this.direction = direction;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.target = target;
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

            if(actor instanceof Objects)
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
