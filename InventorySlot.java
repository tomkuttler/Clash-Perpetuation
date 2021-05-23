import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InventorySlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventorySlot extends UI
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

            if(!getIntersectingObjects(InventorySlot.class).isEmpty())
            {
                InventorySlot intersectingSlot = getIntersectingObjects(InventorySlot.class).get(0);

                if(intersectingSlot != null)
                {
                    getWorld().getObjects(Inventory.class).get(0).addItemToSpecificSlot(item, amount, intersectingSlot.getSlotNumber(), slotNumber);

                    //Teleport back
                    if(slotNumber <= 9)
                    {
                        setLocation(710 + slotNumber * 58, 329);
                    }

                    else if(slotNumber <= 19)
                    {
                        setLocation(710 + (slotNumber - 10) * 58, 387);
                    }

                    else if(slotNumber <= 29)
                    {
                        setLocation(710 + (slotNumber - 20) * 58, 445);
                    }

                    else if(slotNumber <= 39)
                    {
                        setLocation(710 + (slotNumber - 30) * 58, 503);
                    }

                    update();
                }
            }
            else if(!getIntersectingObjects(HotbarSlot.class).isEmpty())
            {
                HotbarSlot intersectingSlot = getIntersectingObjects(HotbarSlot.class).get(0);

                if(intersectingSlot != null)
                {
                    getWorld().getObjects(Hotbar.class).get(0).addItemToSpecificSlotFromInventory(item, amount, intersectingSlot.getSlotNumber(), slotNumber);

                    //Teleport back
                    if(slotNumber <= 9)
                    {
                        setLocation(710 + slotNumber * 58, 329);
                    }

                    else if(slotNumber <= 19)
                    {
                        setLocation(710 + (slotNumber - 10) * 58, 387);
                    }

                    else if(slotNumber <= 29)
                    {
                        setLocation(710 + (slotNumber - 20) * 58, 445);
                    }

                    else if(slotNumber <= 39)
                    {
                        setLocation(710 + (slotNumber - 30) * 58, 503);
                    }

                    update();
                }
            }
            else //Teleport back
            {
                if(slotNumber <= 9)
                {
                    setLocation(710 + slotNumber * 58, 329);
                }

                else if(slotNumber <= 19)
                {
                    setLocation(710 + (slotNumber - 10) * 58, 387);
                }

                else if(slotNumber <= 29)
                {
                    setLocation(710 + (slotNumber - 20) * 58, 445);
                }

                else if(slotNumber <= 39)
                {
                    setLocation(710 + (slotNumber - 30) * 58, 503);
                }
            }
            return;
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

        //Only update the image if inventory is open (if its closed it will be updated when its openen again)
        if(getWorld().getObjects(Inventory.class).get(0).isInventoryOpen())
        {
            update();
        }
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
        else
        {
            setImage(getWorld().getObjects(Inventory.class).get(0).itemData.getIcon(item));
        }

        if(amount > 1)
        {
            this.getWorld().showText(Integer.toString(amount), this.getX() + 15, this.getY() + 15);
        }
        else
        {
            this.getWorld().showText(null, this.getX() + 15, this.getY() + 15);
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
