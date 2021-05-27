import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Hotbar class stores the items in the inventory and manages the tranfer of items between slots.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends UI
{
    private InventorySlot[] slots = new InventorySlot[40];   //This array contains the 40 inventory slots
    
    private boolean isInventoryOpen = false;                 //True if inventory is open, false if closed

    private InventoryUI inventoryUI;                         //Reference to the InventoryUI

    public ItemData itemData = new ItemData();               //Creates a new ItemData object, which is used to store attributes of items in it

    /**
     * Inventory Constructor: Sets the inventory image to null, because this class just manages the inventory and is not the image of the inventory,
     * creates 40 new empty hotbar slots and sets the reference to the InventoryUI object.
     * 
     * @param 'newInventoryUI': Reference to the background image of the inventory
     */ 
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

    /**
     * Method 'addedToWorld': Is called when the hotbar object is placed in the world.
     * It sets the location of the inventory slots and updates them.
     * 
     * @param 'World w': The world in which the hotbar object will be placed in
     */
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

    /**
     * Method 'isInventoryOpen': Is called by the 'checkDrag' method in HotbarSlot class or the 'checkDrag' method in the InventorySlot class or the 'toggleInventory' method in player class, 
     * if they want to know if the inventory is open.
     * 
     * @return: True if inventory is currently open, false if not
     */
    public boolean isInventoryOpen()
    {
        return isInventoryOpen;
    }

    /**
     * Method 'getInventoryUI': Is called by the 'changeMap' method in Player class, if the player wants a reference to the InventoryUI.
     * Is needed to send the reference to a new map, if the player changes the map.
     * 
     * @return: The reference to the InventoryUI object
     */
    public InventoryUI getInventoryUI()
    {
        return inventoryUI;
    }

    /**
     * Method 'openInventory': Is called by the 'toggleInventory' method in Player class, if the player pressed 'i' and the inventory was closed before.
     * Sets the isInventoryOpen variable, sets the inventory image visible and updates the inventory slots.
     */
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

    /**
     * Method 'closeInventory': Is called by the 'toggleInventory' method in Player class, if the player pressed 'i' and the inventory was open before.
     * Sets the isInventoryOpen variable, sets the inventory image hidden and removes the images of the inventory slots and the amount-text.
     */
    public void closeInventory()
    {
        isInventoryOpen = false;

        //Hide the inventory picture
        inventoryUI.setImage((GreenfootImage)null);

        //Remove the image of the inventory slots and amount-text of the inventory slots
        for(int i = 0; i < 40; i++) 
        {
            slots[i].setImage((GreenfootImage)null);

            slots[i].getWorld().showText(null, slots[i].getX() + 15, slots[i].getY() + 15);
        }
    }

    /**
     * Method 'addItem': Is called by the 'checkPickUp' method in Player class, if the player picked up a PickUpItem.
     * Gets the name and amount from the reference to the PickUpItem.
     * If the item can be stacked on a slot in the inventory, adds the items to that slot.
     * If the item cant be stacked on a slot in the inventory, adds the items to the first empty slot.
     * 
     * @param 'item': The reference to the PickUpItem that the player picked up
     * 
     * @return: True if the item was added to the inventory, false if not
     */
    public boolean addItem(PickUpItems item)
    {
        //Get variables from picked up item
        String itemToAdd = item.getName();
        int amountToAdd = item.getAmount();

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

    /**
     * Method 'addItemFromChest': Is called by the 'checkPickUp' method in Player class, if the player opened a chest.
     * If the item can be stacked on a slot in the inventory, adds the items to that slot.
     * If the item cant be stacked on a slot in the inventory, adds the items to the first empty slot.
     * 
     * @param 'itemToAdd': The name of the item that was in the chest and will be added to the inventory now
     * @param 'amountToAdd': The amount of the item that was in the chest and will be added to the inventory now
     * 
     * @return: True if the item was added to the inventory, false if not
     */
    public boolean addItemFromChest(String itemToAdd, int amountToAdd)
    {
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

    /**
     * Method 'addItemToFilledSlot': Is called by the 'addItem' method or the 'addItemFromChest' method to check if the item can be added to a filled slot.
     * If the item is in one of the inventory slots already, checks if all items can be added to that slot. If so adds the items to that slot.
     * If they dont fit in the slot completly, the stack will be filled and the rest will be added to a free slot.
     * 
     * @param 'itemToAdd': The name of the item that will be added to the slot
     * @param 'amountToAdd': The amount of the item that will be added to the slot
     * 
     * @return: True if the item was added, false if not
     */
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

    /**
     * Method 'addItemToFreeSlot': Is called by the 'addItem' method or the 'addItemFromChest' method or the 'addItemToFilledSlot' method 
     * to check if one slot is free and the item can be added to that slot.
     * 
     * @param 'itemToAdd': The name of the item that will be added to the slot
     * @param 'amountToAdd': The amount of the item that will be added to the slot
     * 
     * @return: True if the item was added, false if not
     */
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

    /**
     * Method 'addItemToSpecificSlot': Is called by the 'checkDrag' method in InventorySlot class, if a InventorySlot was dragged on top of a other InventorySlot.
     * The items of the dragged slot are transmitted to the stationary slot, if the stationary slot is empty or the item of the stationary slot matches the item of the dragged slot
     * so they can be stacked together.
     * 
     * @param 'itemToAdd': The name of the item of the dragged slot
     * @param 'amount': The amount of the item of the dragged slot
     * @param 'slotNumberToAdd': The slot number of the stationary inventory slot, to which the item will be transferred (must be 0 - 39)
     * @param 'slotNumberToRemove': The slot number of the dragged inventory slot, from which the item will be transferred (must be 0 - 39)
     * 
     * @return: True if items were tranferred, false if not
     */
    public boolean addItemToSpecificSlot(String itemToAdd, int amount, int slotNumberToAdd, int slotNumberToRemove)
    {
        if(slots[slotNumberToAdd].isEmpty()) //If the stationary slot is empty -> Transfer the items
        {
            slots[slotNumberToAdd].addItem(itemToAdd, amount);

            slots[slotNumberToRemove].removeItem(amount);

            return true;
        }
        else if(slots[slotNumberToAdd].getName() == itemToAdd) //If the stationary slot is not empty, but the same item is in both slots
        {
            if(slots[slotNumberToAdd].getAmount() + amount <= itemData.getMaxStackSize(itemToAdd)) //If all items from the dragged slot fit in the stationary slot -> Transfer the items
            {
                slots[slotNumberToAdd].addItem(itemToAdd, amount);

                slots[slotNumberToRemove].removeItem(amount);

                return true;
            }
            else if(!(slots[slotNumberToAdd].getAmount() == itemData.getMaxStackSize(itemToAdd))) //If the stationary slot is not already at the max stack size -> Fill up the stationary slot and leave the rest in the dragged slot
            {
                //Fill up the Stack
                int difference = itemData.getMaxStackSize(itemToAdd) - slots[slotNumberToAdd].getAmount();

                slots[slotNumberToAdd].addItem(itemToAdd, difference);

                //Leaves the rest in the dragged slot
                slots[slotNumberToRemove].removeItem(difference); 
                return true;
            }
        }
        return false;
    }

    /**
     * Method 'addItemToSpecificSlotFromHotbar': Is called by the 'checkDrag' method in HotbarSlot class, if a HotbarSlot was dragged on top of a InventorySlot.
     * The items of the dragged slot are transmitted to the stationary slot, if the stationary slot is empty or the item of the stationary slot matches the item of the dragged slot
     * so they can be stacked together.
     * 
     * @param 'itemToAdd': The name of the item of the dragged slot
     * @param 'amount': The amount of the item of the dragged slot
     * @param 'slotNumberToAdd': The slot number of the stationary inventory slot, to which the item will be transferred (must be 0 - 39)
     * @param 'slotNumberToRemove': The slot number of the dragged hotbar slot, from which the item will be transferred (must be 0 - 9)
     * 
     * @return: True if items were tranferred, false if not
     */
    public boolean addItemToSpecificSlotFromHotbar(String itemToAdd, int amount, int slotNumberToAdd, int slotNumberToRemove)
    {
        if(slots[slotNumberToAdd].isEmpty()) //If the stationary slot is empty -> Transfer the items
        {
            slots[slotNumberToAdd].addItem(itemToAdd, amount);

            getWorld().getObjects(Hotbar.class).get(0).removeItemAtSpecificSlot(amount, slotNumberToRemove);

            return true;
        }
        else if(slots[slotNumberToAdd].getName() == itemToAdd) //If the stationary slot is not empty, but the same item is in both slots
        {
            if(slots[slotNumberToAdd].getAmount() + amount <= itemData.getMaxStackSize(itemToAdd)) //If all items from the dragged slot fit in the stationary slot -> Transfer the items
            {
                slots[slotNumberToAdd].addItem(itemToAdd, amount);

                getWorld().getObjects(Hotbar.class).get(0).removeItemAtSpecificSlot(amount, slotNumberToRemove);

                return true;
            }
            else if(!(slots[slotNumberToAdd].getAmount() == itemData.getMaxStackSize(itemToAdd))) //If the stationary slot is not already at the max stack size -> Fill up the stationary slot and leave the rest in the dragged slot
            {
                //Fill up the Stack
                int difference = itemData.getMaxStackSize(itemToAdd) - slots[slotNumberToAdd].getAmount();

                slots[slotNumberToAdd].addItem(itemToAdd, difference);

                //Leaves the rest in the dragged slot
                getWorld().getObjects(Hotbar.class).get(0).removeItemAtSpecificSlot(difference, slotNumberToRemove);
                return true;
            }
        }
        return false;
    }

    /**
     * Method 'removeItemAtSpecificSlot': Is called by the 'addItemToSpecificSlotFromInventory' method in Hotbar class, 
     * if items should be removed from a specific slot of the Inventory.
     * 
     * @param 'amount': The amount of the item that should be removed
     * @param 'slotNumberToRemove': The slot number of the slot from which the item should be removed (must be 0 - 39)
     * 
     * @return: True if items were found and removed, false if not
     */
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
