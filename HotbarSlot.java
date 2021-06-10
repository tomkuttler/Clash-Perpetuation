import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The HotbarSlot class saves the item name and amount of a slot. The hotbar slots can be dragged to transfer items. Empty orange debug slots can be shown for debugging. 
 * Otherwise, empty slots have a transparent image (necessary for Greenfoot intersecting detection).
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HotbarSlot extends UI
{
    private String item = null;   //The name of the item that is currently in this slot (null if the slot is empty)
    private int amount = 0;       //The amount of item(s) that is / are in currently in this slot (0 if the slot is empty)
    private int slotNumber;       //The slot number of this hotbar slot (0 - 9)

    private boolean drag = false; //True if mouse draggs this slot around currenty, false if not

    //----- Object image -----
    private static final GreenfootImage emptySlot = new GreenfootImage("ui/emptyInventorySlot.png");
    
    //----- Debug image -----
    //Uncomment the line below and comment the standart emptySlot image
    //private static final GreenfootImage emptySlot = new GreenfootImage("ui/testInventorySlot.png");
    
    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'checkDrag' method.
     */
    public void act()
    {        
        checkDrag();
    }

    /**
     * Method 'checkDrag': Is called every tick by the 'act' method.
     * It checks if the slot is being dragged by the mouse. 
     * If the slot will be released on a other HotbarSlot, the 'addItemToSpecificSlot' method in Hotbar class will be called.
     * If the slot will be released on a InventorySlot, the 'addItemToSpecificSlotFromHotbar' method in Inventory class will be called.
     * If the slot will be released somewhere else, it will be teleported back to his original location.
     */
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
                        setLocation(632 + slotNumber * 48, 897);                        

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
                        setLocation(632 + slotNumber * 48, 897);                        

                        update();
                    }                    
                    return;
                }
                else //Teleport back
                {                    
                    setLocation(632 + slotNumber * 48, 897);                                       
                }
            }
        }
    }

    /**
     * Method 'setSlotNumber': Is called by the Hotbar Constructor, when the hotbar slots are being created.
     * The ten slots will recieve an ascending slot number from 0 - 9.
     * 
     * @param 'slotNumber': The number from the Hotbar that will be the slot number of this hotbar slot
     */
    public void setSlotNumber(int slotNumber)
    {
        this.slotNumber = slotNumber;
    }

    /**
     * Method 'getSlotNumber': Is called by the 'checkDrag' method in HotbarSlot class or the 'checkDrag' method in InventorySlot class, 
     * if the dragged slots intersect another slot and want to know the slot number of that intersecting slot.
     * 
     * @return: The slot number of this hotbar slot
     */
    public int getSlotNumber()
    {
        return slotNumber;
    }

    /**
     * Method 'isEmpty': Is called by the 'addItemToSpecificSlot' method in Hotbar class or the 'addItemToSpecificSlotFromInventory' method in Hotbar class, 
     * if the items from two slots should be transferred and the stationary slot should be checked if he is empty.
     * 
     * @return: True if the slot is empty, false if not
     */
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

    /**
     * Method 'addItem': Is called by the 'addItemToSpecificSlot' method in Hotbar class or the 'addItemToSpecificSlotFromInventory' method in Hotbar class, 
     * if the items from two slots should be transferred and the item(s) should be added to this slot.
     * 
     * @param 'item': The name of the item that should be added to this slot
     * @param 'amount': The amount of items that should be added to this slot
     */
    public void addItem(String item, int amount)
    {
        this.item = item;

        this.amount = this.amount + amount;

        update();        
    }

    /**
     * Method 'removeItem': Is called by the 'removeItem' method in Hotbar class or the 'removeItemAtSpecificSlot' method in Hotbar class, 
     * if items should be removed from this slot.
     * 
     * @param 'amount': The amount of items that should be removed from this slot
     */
    public void removeItem(int amount)
    {
        this.amount = this.amount - amount;

        if(this.amount == 0)
        {
            this.item = null;
        }
    }

    /**
     * Method 'update': Is called by the 'addItem' method or the 'removeItem' method in Hotbar class, if items were added to or removed from this slot.
     * If the slot is now empty, the image of this slot will be set transparent and the amount will be removed.
     * If the slot is not empty, the icon of the item thats currently in this slot will be set to the slot image.
     * If there are more than 1 items in this slot the amount will be displayed as a text at the bottom right corner of the slot image.
     */
    public void update()
    {      
        if(item == null)
        {
            setImage(new GreenfootImage(emptySlot));
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

    /**
     * Method 'getName': Is called by the 'addItemToSpecificSlot' method in Hotbar class or the 'addItemToSpecificSlotFromInventory' method in Hotbar class,
     * or the 'removeItem' method in Hotbar class, if the Hotbar class needs the name of the item thats currently in this slot. (null if empty!)
     * 
     * @return: Name of the item thats currently in this slot (null if empty!)
     */
    public String getName()
    {
        return item;
    }

    /**
     * Method 'getAmount': Is called by the 'addItemToSpecificSlot' method in Hotbar class or the 'addItemToSpecificSlotFromInventory' method in Hotbar class,
     * if the Hotbar class needs the amount of the item thats currently in this slot. 
     * 
     * @return: The amount of the item thats currently in this slot 
     */
    public int getAmount()
    {
        return amount;
    }
}
