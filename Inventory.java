import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends UI
{
    private boolean isInventoryOpen = false;  //Stores if inventory is open or closed

    private String itemToAdd;                 //Name of the item that is added to the inventory
    private int amountToAdd;                  //Amount of the item that is added to the inventory
    private int maxStackSize;                 //MaxStackSize of a stack of the added item

    private InventorySlot[] slots = new InventorySlot[40];   //Saves the inventory slots 

    private InventoryUI inventoryUI;          //Referenz to the InventoryUI

    public Inventory(InventoryUI newInventoryUI)
    {
        // setImage((GreenfootImage)null);

        //Create 40 empty inventory slots
        for(int i=0; i < 40; i++) 
        {
            slots[i] = new InventorySlot();
            slots[i].setSlotNumber(i);
        }

        inventoryUI = newInventoryUI;
    }

    public void addedToWorld(World w)
    {
        //Spawn the inventory slots
        for(int i=0; i < 40; i++) 
        {
            if(i <= 9)
            {
                getWorld().addObject(slots[i], 231 + i * 29, 132);
            }

            if(i <= 19)
            {
                getWorld().addObject(slots[i], 231 + (i - 10) * 29, 161);
            }

            if(i <= 29)
            {
                getWorld().addObject(slots[i], 231 + (i - 20) * 29, 190);
            }

            if(i <= 39)
            {
                getWorld().addObject(slots[i], 231 + (i - 30) * 29, 219);
            }
        }

        for(int i=0; i < 40; i++) 
        {
            slots[i].setImage((GreenfootImage)null);

            slots[i].getWorld().showText(null, slots[i].getX() + 5, slots[i].getY() + 5);
        }
    }
    
    public boolean isInventoryOpen()
    {
        return isInventoryOpen;
    }

    public InventoryUI getInventoryUI()
    {
        return inventoryUI;
    }

    //Called by player if "i" is pressed and inventory was closed
    public void openInventory()
    {
        isInventoryOpen = true;

        //Set inventory image visible
        inventoryUI.setImageVisible();        

        //Update inventory slots
        for(int i=0; i < 40; i++) 
        {
            slots[i].update();
        }
    }

    //Called by player if "i" is pressed and inventory was open
    public void closeInventory()
    {
        isInventoryOpen = false;

        //Hide the inventory picture
        inventoryUI.setImage((GreenfootImage)null);

        //Remove the picture and amount of the inventory slots
        for(int i=0; i < 40; i++) 
        {
            slots[i].setImage((GreenfootImage)null);

            slots[i].getWorld().showText(null, slots[i].getX() + 5, slots[i].getY() + 5);
        }
    }

    //Called if player picked up a pick up item
    public boolean addItem(PickUpItems item)
    {
        //Get variables from picked up item
        itemToAdd = item.getName();
        amountToAdd = item.getAmount();
        maxStackSize = item.getMaxStackSize();

        //If the item is stackable and there is already a stack of items in a slot, add the items to that slot 
        if(addItemToFilledSlot(itemToAdd, amountToAdd, maxStackSize))
        {
            return true;
        }

        //Add the item to the first empty slot
        if(addItemToFreeSlot(itemToAdd, amountToAdd))
        {
            return true;
        }

        return false;
    }

    public boolean addItemToFilledSlot(String itemToAdd, int amount, int maxStackSize)
    {
        for(int i=0; i < 40; i++)
        {
            if(slots[i].getName() == itemToAdd)
            {
                if(slots[i].getAmount() + amount <= maxStackSize)
                {
                    slots[i].addItem(itemToAdd, amount);
                    return true;
                }
                else if(!(slots[i].getAmount() == maxStackSize))
                {
                    //Fill up the Stack
                    int difference = maxStackSize - slots[i].getAmount();
                    int rest = amount - difference;

                    slots[i].addItem(itemToAdd, difference);

                    //Put the rest in an empty slot
                    if(addItemToFreeSlot(itemToAdd, rest))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addItemToFreeSlot(String itemToAdd, int amount)
    {
        for(int i=0; i < 40; i++)
        {
            if(slots[i].isEmpty())
            {
                slots[i].addItem(itemToAdd, amount);
                return true;
            }
        }
        return false;
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
            if(slots[slotNumberToAdd].getAmount() + amount <= getMaxStackSize(itemToAdd))
            {
                slots[slotNumberToAdd].addItem(itemToAdd, amount);

                slots[slotNumberToRemove].removeItem(amount);

                return true;
            }
            else if(!(slots[slotNumberToAdd].getAmount() == getMaxStackSize(itemToAdd)))
            {
                //Fill up the Stack
                int difference = getMaxStackSize(itemToAdd) - slots[slotNumberToAdd].getAmount();

                slots[slotNumberToAdd].addItem(itemToAdd, difference);

                //Leaves the rest in the old slot
                slots[slotNumberToRemove].removeItem(difference); 
                return true;
            }
        }
        return false;
    }
    
    public boolean addItemToSpecificSlotFromHotbar(String itemToAdd, int amount, int slotNumberToAdd, int slotNumberToRemove)
    {
        if(slots[slotNumberToAdd].isEmpty())
        {
            slots[slotNumberToAdd].addItem(itemToAdd, amount);

            getWorld().getObjects(Hotbar.class).get(0).removeItemAtSpecificSlot(amount, slotNumberToRemove);

            return true;
        }
        // else if(slots[slotNumberToAdd].getName() == itemToAdd)
        // {
        // if(slots[slotNumberToAdd].getAmount() + amount <= maxStackSize)
        // {
        // slots[slotNumberToAdd].addItem(itemToAdd, amount);

        // slots[slotNumberToRemove].removeItem(amount);

        // return true;
        // }
        // else if(!(slots[slotNumberToAdd].getAmount() == maxStackSize))
        // {
        // //Fill up the Stack
        // int difference = maxStackSize - slots[slotNumberToAdd].getAmount();

        // slots[slotNumberToAdd].addItem(itemToAdd, difference);

        // //Leaves the rest in the old slot
        // slots[slotNumberToRemove].removeItem(difference); 
        // return true;
        // }
        // }
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
    
    public int getMaxStackSize(String itemName)
    {
        if(itemName == "redPotion")
        {
            return 64;
        }
        else
        {
            return 64;
        }
    }
}
