import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Collider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Collider extends Actor
{
    //Instance variables
    private int offsetX;
    private int offsetY;
    private int xSize;
    private int ySize; 

    private GreenfootImage blank;
    private GreenfootImage highlight;

    /**
     * Constructor for objects of class Collider, for use when Collider is being
     * used as an object on it's own
     */
    public Collider(int xSize, int ySize, int offsetX, int offsetY)
    {
        setup(xSize, ySize, offsetX, offsetY);
    }

    protected void setup(int xSize, int ySize, int offsetX, int offsetY) 
    {
        this.xSize = xSize;
        this.ySize = ySize;
        this.offsetX = offsetX;
        this.offsetY = offsetY;

        blank = new GreenfootImage (xSize, ySize);
        highlight = new GreenfootImage (xSize, ySize);
        highlight.setColor (Color.RED);
        highlight.fill();
        highlight.setTransparency (75);

        setImage(blank);
        setImage(highlight);
    }

    public int getXOffset() 
    {
        return offsetX;
    }

    public int getYOffset() 
    {
        return offsetY;
    }

    public boolean checkCollision ()
    {
        if(!getIntersectingObjects(Collider.class).isEmpty() || !getIntersectingObjects(Objects.class).isEmpty())
        {
            return true;            
        }
        else
        {
            return false;
        }
    }
}
