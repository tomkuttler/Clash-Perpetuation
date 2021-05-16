import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HotbarSlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HotbarSlot extends UI
{
    private String item = null;
    private int amount = 0;
    private int slotNumber;
    
    private boolean drag = false;
    
    private boolean wasInitiated = false;      //Used to prevent multiple unnecessary initiasations
    private double initCooldown = 100000000;   //100 milion nanosec (0,1s) after spawn slots will be initialised
    private double spawnTime;                  //Stores the time when slots were spawned
    
    public HotbarSlot()
    {
        spawnTime = System.nanoTime();
    }

    public void act()
    {
        init();
        
        checkDrag();
    }
    
    public void init()
    {
        if(!wasInitiated)
        {
            double t = System.nanoTime();
            if(t - spawnTime >= initCooldown)
            {
                wasInitiated = true;
                update();
            }
        }
    }
    
    public void checkDrag()
    {
        if(getWorld().getObjects(Inventory.class).get(0).isInventoryOpen() == true)
        {
            if(Greenfoot.mousePressed(this) && !drag)
            {
                drag = true;

                World world = getWorld();
                MouseInfo mi = Greenfoot.getMouseInfo();
                world.removeObject(this);
                world.addObject(this, mi.getX(), mi.getY());
                return;
            }

            if(Greenfoot.mouseDragged(this) && drag)
            {            
                MouseInfo mi = Greenfoot.getMouseInfo();
                setLocation(mi.getX(), mi.getY());
                return;
            }

            if(Greenfoot.mouseDragEnded(null) && drag)
            {
                drag = false;

                if(!getIntersectingObjects(HotbarSlot.class).isEmpty())
                {
                    HotbarSlot intersectingSlot = getIntersectingObjects(HotbarSlot.class).get(0);

                    if(intersectingSlot != null)
                    {
                        getWorld().getObjects(Hotbar.class).get(0).addItemToSpecificSlot(item, amount, intersectingSlot.getSlotNumber(), slotNumber);
                        
                        setLocation(192 + slotNumber * 24, 384);                        

                        update();
                    }
                }
                else
                {                    
                    setLocation(192 + slotNumber * 24, 384);                                       
                }
                return;
            }
        }
    }

    public void setSlotNumber(int slotNumber)
    {
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber()
    {
        return slotNumber;
    }

    public boolean isEmpty()
    {
        if(item == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void addItem(String item, int amount)
    {
        this.item = item;

        this.amount = this.amount + amount;

        update();        
    }

    public void removeItem(int amount)
    {
        this.amount = this.amount - amount;

        if(this.amount == 0)
        {
            this.item = null;
        }

        //Only update the image if inventory is open (if its closed it will be updated when its openen again)
        if(getWorld().getObjects(Inventory.class).get(0).isInventoryOpen())
        {
            update();
        }
    }

    public void update()
    {      
        if(item == null)
        {
            setImage(new GreenfootImage("ui/testInventorySlot.png"));

            if(amount > 1)
            {
                this.getWorld().showText(Integer.toString(amount), this.getX() + 5, this.getY() + 5);
            }
            else
            {
                this.getWorld().showText(null, this.getX() + 5, this.getY() + 5);
            }
        }

        if(item == "redPotion")
        {
            setImage(new GreenfootImage("objects/healingItems/redPotion.png"));

            if(amount > 1)
            {
                this.getWorld().showText(Integer.toString(amount), this.getX() + 5, this.getY() + 5);
            }
            else
            {
                this.getWorld().showText(null, this.getX() + 5, this.getY() + 5);
            }
        }
    }

    public String getName()
    {
        return item;
    }

    public int getAmount()
    {
        return amount;
    }
}
