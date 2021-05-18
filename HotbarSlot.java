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

    public void act()
    {        
        checkDrag();
    }

    public void checkDrag()
    {
        //Only check drag if inventory is open
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

                        //Teleport back
                        setLocation(192 + slotNumber * 24, 384);                        

                        update();
                    }
                }
                else if(!getIntersectingObjects(InventorySlot.class).isEmpty())
                {
                    InventorySlot intersectingSlot = getIntersectingObjects(InventorySlot.class).get(0);

                    if(intersectingSlot != null)
                    {
                        getWorld().getObjects(Inventory.class).get(0).addItemToSpecificSlotFromHotbar(item, amount, intersectingSlot.getSlotNumber(), slotNumber);

                        //Teleport back
                        setLocation(192 + slotNumber * 24, 384);                        

                        update();
                    }                    
                    return;
                }
                else //Teleport back
                {                    
                    setLocation(192 + slotNumber * 24, 384);                                       
                }
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
    }

    public void update()
    {      
        if(item == null)
        {
            setImage(new GreenfootImage("ui/testInventorySlot.png"));
        }
        if(item == "redPotion")
        {
            setImage(new GreenfootImage("objects/healingItems/redPotion.png"));            
        }        
        if(item == "longsword")
        {
            setImage(new GreenfootImage("objects/weapons/longswordIcon.png"));
        }
        if(item == "bow1")
        {
            setImage(new GreenfootImage("objects/weapons/bow1Icon.png"));
        }
        
        if(amount > 1)
        {
            this.getWorld().showText(Integer.toString(amount), this.getX() + 5, this.getY() + 5);
        }
        else
        {
            this.getWorld().showText(null, this.getX() + 5, this.getY() + 5);
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
