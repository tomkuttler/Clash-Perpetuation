import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hotbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hotbar extends UI 
{
    private HotbarSlot[] slots = new HotbarSlot[10];   //Saves the hotbar slots

    private int currentSlot = 0;                       //Highlited slot
    private String currentSlotItem;                    //Item in current slot
        
    private double pressCooldown = 100000000.0;  //Cooldown of 100 milion nanosec (0,1sec) between pressing a key
    private double lastPressedKeyTime;         //Saves the time of the last key press

    private HotbarUI hotbarUI;
    private HotbarHighlight hotbarHighlight;
    private Inventory inventory;

    int amount = 0;   

    public Hotbar(HotbarUI newHotbarUI, HotbarHighlight newHotbarHighlight, Inventory newInventory)
    {
        setImage((GreenfootImage)null);

        //Create 10 empty hotbar slots
        for(int i = 0; i < 10; i++) 
        {
            slots[i] = new HotbarSlot();
            slots[i].setSlotNumber(i);
        }

        hotbarUI = newHotbarUI;
        hotbarHighlight = newHotbarHighlight;
        inventory = newInventory;
    }

    public void addedToWorld(World w)
    {
        for(int i = 0; i < 10; i++) 
        {            
            getWorld().addObject(slots[i], 632 + i * 48, 897);
            slots[i].update();
        }
        
        hotbarHighlight.updatePosition(currentSlot);
    }

    public void act() 
    {
        updateCurrentSlot();
        
        ckeckDrop();
    }
    
    public void updateCurrentSlot()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            double t = System.nanoTime();
            if(t - lastPressedKeyTime >= pressCooldown)
            {
                if(currentSlot > 0)
                {
                    currentSlot = currentSlot - 1;
                }
                else if(currentSlot == 0)
                {
                    currentSlot = 9;
                }

                hotbarHighlight.updatePosition(currentSlot);

                lastPressedKeyTime = System.nanoTime();
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            double t = System.nanoTime();
            if(t - lastPressedKeyTime >= pressCooldown)
            {
                if(currentSlot < 9)
                {
                    currentSlot = currentSlot + 1;
                }
                else if(currentSlot == 9)
                {
                    currentSlot = 0;
                }

                hotbarHighlight.updatePosition(currentSlot);

                lastPressedKeyTime = System.nanoTime();
            }
        }
    }
    
    public void ckeckDrop()
    {
        if(Greenfoot.isKeyDown("q"))
        {
            double t = System.nanoTime();
            if(t - lastPressedKeyTime >= pressCooldown)
            {
                if(getCurrentSlotItem() != null)
                {
                    inventory.itemData.spawnItem(getCurrentSlotItem(), this);
                                        
                    removeItemAtSpecificSlot(1, currentSlot);
                    updateSpecificSlot(currentSlot);
                                                            
                    lastPressedKeyTime = System.nanoTime();
                }
            }
        }
    }
    
    public void updateSpecificSlot(int slotNumberToUpdate)
    {
        slots[slotNumberToUpdate].update();
    }
    
    public int getCurrentSlot()
    {
        return currentSlot;
    }
    
    public HotbarUI getHotbarUI()
    {
        return hotbarUI;
    }
    
    public HotbarHighlight getHighlight()
    {
        return hotbarHighlight;
    }
    
    public String getCurrentSlotItem()
    {
        return slots[currentSlot].getName();
    }
    
    public boolean addItemToSpecificSlot(String itemToAdd, int amount, int slotNumberToAdd, int slotNumberToRemove)
    {
        if(slots[slotNumberToAdd].isEmpty())
        {
            slots[slotNumberToAdd].addItem(itemToAdd, amount);

            slots[slotNumberToRemove].removeItem(amount);

            return true;
        }
        else if(slots[slotNumberToAdd].getName() == itemToAdd)
        {
            if(slots[slotNumberToAdd].getAmount() + amount <= inventory.itemData.getMaxStackSize(itemToAdd))
            {
                slots[slotNumberToAdd].addItem(itemToAdd, amount);

                slots[slotNumberToRemove].removeItem(amount);

                return true;
            }
            else if(!(slots[slotNumberToAdd].getAmount() == inventory.itemData.getMaxStackSize(itemToAdd)))
            {
                //Fill up the Stack
                int difference = inventory.itemData.getMaxStackSize(itemToAdd) - slots[slotNumberToAdd].getAmount();

                slots[slotNumberToAdd].addItem(itemToAdd, difference);

                //Leaves the rest in the old slot
                slots[slotNumberToRemove].removeItem(difference); 
                return true;
            }
        }
        return false;
    }
    
    public boolean addItemToSpecificSlotFromInventory(String itemToAdd, int amount, int slotNumberToAdd, int slotNumberToRemove)
    {
        if(slots[slotNumberToAdd].isEmpty())
        {
            slots[slotNumberToAdd].addItem(itemToAdd, amount);

            inventory.removeItemAtSpecificSlot(amount, slotNumberToRemove);

            return true;
        }
        else if(slots[slotNumberToAdd].getName() == itemToAdd)
        {
            if(slots[slotNumberToAdd].getAmount() + amount <= inventory.itemData.getMaxStackSize(itemToAdd))
            {
                slots[slotNumberToAdd].addItem(itemToAdd, amount);

                inventory.removeItemAtSpecificSlot(amount, slotNumberToRemove);

                return true;
            }
            else if(!(slots[slotNumberToAdd].getAmount() == inventory.itemData.getMaxStackSize(itemToAdd)))
            {
                //Fill up the Stack
                int difference = inventory.itemData.getMaxStackSize(itemToAdd) - slots[slotNumberToAdd].getAmount();

                slots[slotNumberToAdd].addItem(itemToAdd, difference);

                //Leaves the rest in the old slot
                inventory.removeItemAtSpecificSlot(difference, slotNumberToRemove);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeItem(String item, int amount)
    {
        for(int i = 0; i < 10; i++)
        {
            if(slots[i].getName() == item)
            {
                slots[i].removeItem(amount);
                slots[i].update();
                
                return true;
            }
        }
        return false;
    }
    
    public boolean removeItemAtSpecificSlot(int amount, int slotNumberToRemove)
    {
        if(!slots[slotNumberToRemove].isEmpty())
        {
            slots[slotNumberToRemove].removeItem(amount);

            return true;
        }
        return false;
    }
    
    public boolean isInHotbar(String item)
    {
        for(int i = 0; i < 10; i++)
        {
            if(slots[i].getName() == item)
            {
                return true;
            }
        }
        return false;
    }
}
