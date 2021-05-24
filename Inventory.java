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

    private InventorySlot[] slots = new InventorySlot[40];   //Saves the inventory slots 

    private InventoryUI inventoryUI;          //Referenz to the InventoryUI

    public ItemData itemData = new ItemData();

    public Inventory(InventoryUI newInventoryUI)
    {
        setImage((GreenfootImage)null);

        //Create 40 empty inventory slots
        for(int i = 0; i < 40; i++) 
        {
            slots[i] = new InventorySlot();
            slots[i].setSlotNumber(i);
        }

        inventoryUI = newInventoryUI;
    }

    public void addedToWorld(World w)
    {
        //Spawn the inventory slots
        for(int i = 0; i < 40; i++) 
        {
            if(i <= 9)
            {
                getWorld().addObject(slots[i], 710 + i * 58, 329);
            }

            if(i <= 19)
            {
                getWorld().addObject(slots[i], 710 + (i - 10) * 58, 387);
            }

            if(i <= 29)
            {
                getWorld().addObject(slots[i], 710 + (i - 20) * 58, 445);
            }

            if(i <= 39)
            {
                getWorld().addObject(slots[i], 710 + (i - 30) * 58, 503);
            }
        }

        for(int i = 0; i < 40; i++) 
        {
            slots[i].setImage((GreenfootImage)null);

            slots[i].getWorld().showText(null, slots[i].getX() + 15, slots[i].getY() + 15);
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
        for(int i = 0; i < 40; i++) 
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
        for(int i = 0; i < 40; i++) 
        {
            slots[i].setImage((GreenfootImage)null);

            slots[i].getWorld().showText(null, slots[i].getX() + 15, slots[i].getY() + 15);
        }
    }

    //Called if player picked up a pick up item
    public boolean addItem(PickUpItems item)
    {
        //Get variables from picked up item
        itemToAdd = item.getName();
        amountToAdd = item.getAmount();

        //If the item is stackable and there is already a stack of items in a slot, add the items to that slot 
        if(addItemToFilledSlot(itemToAdd, amountToAdd))
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

    //Called if player opened a chest
    public boolean addItemFromChest(String item, int amount)
    {
        //Get variables from chest        
        itemToAdd = item;
        amountToAdd = amount;

        //If the item is stackable and there is already a stack of items in a slot, add the items to that slot 
        if(addItemToFilledSlot(itemToAdd, amountToAdd))
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

    public boolean addItemToFilledSlot(String itemToAdd, int amount)
    {
        for(int i = 0; i < 40; i++)
        {
            if(slots[i].getName() == itemToAdd)
            {
                if(slots[i].getAmount() + amount <= itemData.getMaxStackSize(itemToAdd))
                {
                    slots[i].addItem(itemToAdd, amount);
                    return true;
                }
                else if(!(slots[i].getAmount() == itemData.getMaxStackSize(itemToAdd)))
                {
                    //Fill up the Stack
                    int difference = itemData.getMaxStackSize(itemToAdd) - slots[i].getAmount();
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
        for(int i = 0; i < 40; i++)
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
            if(slots[slotNumberToAdd].getAmount() + amount <= itemData.getMaxStackSize(itemToAdd))
            {
                slots[slotNumberToAdd].addItem(itemToAdd, amount);

                slots[slotNumberToRemove].removeItem(amount);

                return true;
            }
            else if(!(slots[slotNumberToAdd].getAmount() == itemData.getMaxStackSize(itemToAdd)))
            {
                //Fill up the Stack
                int difference = itemData.getMaxStackSize(itemToAdd) - slots[slotNumberToAdd].getAmount();

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
        else if(slots[slotNumberToAdd].getName() == itemToAdd)
        {
            if(slots[slotNumberToAdd].getAmount() + amount <= itemData.getMaxStackSize(itemToAdd))
            {
                slots[slotNumberToAdd].addItem(itemToAdd, amount);

                getWorld().getObjects(Hotbar.class).get(0).removeItemAtSpecificSlot(amount, slotNumberToRemove);

                return true;
            }
            else if(!(slots[slotNumberToAdd].getAmount() == itemData.getMaxStackSize(itemToAdd)))
            {
                //Fill up the Stack
                int difference = itemData.getMaxStackSize(itemToAdd) - slots[slotNumberToAdd].getAmount();

                slots[slotNumberToAdd].addItem(itemToAdd, difference);

                //Leaves the rest in the old slot
                getWorld().getObjects(Hotbar.class).get(0).removeItemAtSpecificSlot(difference, slotNumberToRemove);
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
}
