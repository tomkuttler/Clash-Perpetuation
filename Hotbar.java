import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Hotbar class stores the items in the hotbar and manages the tranfer of items between slots and the selection of the current hotbar slot by clicking / pressing the left or right key.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hotbar extends UI 
{
    private HotbarSlot[] slots = new HotbarSlot[10];                //This array contains the 10 hotbar slots

    private int currentSlot = 0;                                    //The slot number of the currently selected slot of the hotbar
    private String currentSlotItem;                                 //The item that is in the currently selected slot of the hotbar
        
    private static final double pressCooldown = 100000000.0;        //Cooldown of 100 milion nanosec (0,1sec) between pressing a key (Prevents "jumping" over hotbar slots)
    private double lastPressedKeyTime;                              //Saves the time of the last key press (left / right key or 'q' key)

    private HotbarUI hotbarUI;                                      //Reference to the background image of the hotbar
    private HotbarHighlight hotbarHighlight;                        //Reference to the image that indicates the currently selected hotbar slot
    private Inventory inventory;                                    //Reference to the inventory manager

    /**
     * Hotbar Constructor: Sets the hotbar image to null, because this class just manages the hotbar and is not the image of the hotbar,
     * creates 10 new empty hotbar slots and sets the references.
     * 
     * @param 'newHotbarUI': Reference to the background image of the hotbar
     * @param 'newHotbarHighlight': Reference to the image that indicates the currently selected hotbar slot
     * @param 'newInventory': Reference to the inventory manager
     */ 
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

    /**
     * Method 'addedToWorld': Is called when the hotbar object is placed in the world.
     * It sets the location of the hotbar slots and updates them. It updates the HotbarHighlight too. 
     * 
     * @param 'World w': The world in which the hotbar object will be placed in
     */
    public void addedToWorld(World w)
    {
        for(int i = 0; i < 10; i++) 
        {            
            getWorld().addObject(slots[i], 632 + i * 48, 897);
            slots[i].update();
        }
        
        hotbarHighlight.updatePosition(currentSlot);
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'updateCurrentSlot' method and the 'checkDrop' method.
     */
    public void act() 
    {
        updateCurrentSlot();
        
        ckeckDrop();
    }
    
    /**
     * Method 'updateCurrentSlot': Is called every tick by the 'act' method.
     * It updates the currentSlot variable if the left or right key are pressed and enough time passed since the last press (avoid "jumping" over slots).
     * If the currently selected slot changed, the 'updatePosition' method in HotbarHighight class will be called to update the position of the image of the highlighted slot.
     */
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
    
    /**
     * Method 'ckeckDrop': Is called every tick by the 'act' method.
     * If 'q' is pressed and enough time passed since the last press, a new item will be spawned in the world and the dropped item will be removed from the current slot.
     */
    public void ckeckDrop()
    {
        if(Greenfoot.isKeyDown("q"))
        {
            double t = System.nanoTime();
            if(t - lastPressedKeyTime >= pressCooldown)
            {
                if(getCurrentSlotItem() != null)
                {
                    //Spawn a new pick up item in the world
                    inventory.itemData.spawnDroppedItem(getCurrentSlotItem(), this);
                    
                    //Remove the dropped item from the current slot
                    removeItemAtSpecificSlot(1, currentSlot);
                    updateSpecificSlot(currentSlot);
                                                            
                    lastPressedKeyTime = System.nanoTime();
                }
            }
        }
    }
    
    /**
     * Method 'updateSpecificSlot': Is called by the 'ckeckDrop' method or the 'useItem' method in Player class, if items were removed from a specific slot
     * and the slot has to be updated so it shows the right item image and amount.
     * 
     * @param 'slotNumberToUpdate': The number of the slot that has to be updated (must be 0 - 9)
     */
    public void updateSpecificSlot(int slotNumberToUpdate)
    {
        slots[slotNumberToUpdate].update();
    }
    
    /**
     * Method 'getCurrentSlot': Is called by the 'useItem' method in Player class, if the player wants to know the slot number of the currently selected slot.
     * 
     * @return: The slot number of the currently selected slot (0 - 9)
     */
    public int getCurrentSlot()
    {
        return currentSlot;
    }
    
    /**
     * Method 'getHotbarUI': Is called by the 'changeMap' method in Player class, if the player wants a reference to the HotbarUI.
     * Is needed to send the reference to a new map, if the player changes the map.
     * 
     * @return: The reference to the HotbarUI object
     */
    public HotbarUI getHotbarUI()
    {
        return hotbarUI;
    }
    
    /**
     * Method 'getHighlight': Is called by the 'changeMap' method in Player class, if the player wants a reference to the HotbarHighlight.
     * Is needed to send the reference to a new map, if the player changes the map.
     * 
     * @return: The reference to the HotbarHighlight object
     */
    public HotbarHighlight getHighlight()
    {
        return hotbarHighlight;
    }
    
    /**
     * Method 'getCurrentSlotItem': Is called by the 'ckeckDrop' method or 'updateLayers' method in Player class, if the name of the item in the currently selected slot is needed
     * 
     * @return: The name of the item thats in the currently selected slot
     */
    public String getCurrentSlotItem()
    {
        return slots[currentSlot].getName();
    }
    
    /**
     * Method 'addItemToSpecificSlot': Is called by the 'checkDrag' method in HotbarSlot class, if a HotbarSlot was dragged on top of a other HotbarSlot.
     * The items of the dragged slot are transmitted to the stationary slot, if the stationary slot is empty or the item of the stationary slot matches the item of the dragged slot
     * so they can be stacked together.
     * 
     * @param 'itemToAdd': The name of the item of the dragged slot
     * @param 'amount': The amount of the item of the dragged slot
     * @param 'slotNumberToAdd': The slot number of the stationary hotbar slot, to which the item will be transferred (must be 0 - 9)
     * @param 'slotNumberToRemove': The slot number of the dragged hotbar slot, from which the item will be transferred (must be 0 - 9)
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
            if(slots[slotNumberToAdd].getAmount() + amount <= inventory.itemData.getMaxStackSize(itemToAdd)) //If all items from the dragged slot fit in the stationary slot -> Transfer the items
            {
                slots[slotNumberToAdd].addItem(itemToAdd, amount);

                slots[slotNumberToRemove].removeItem(amount);

                return true;
            }
            else if(!(slots[slotNumberToAdd].getAmount() == inventory.itemData.getMaxStackSize(itemToAdd))) //If the stationary slot is not already at the max stack size -> Fill up the stationary slot and leave the rest in the dragged slot
            {
                //Fill up the Stack
                int difference = inventory.itemData.getMaxStackSize(itemToAdd) - slots[slotNumberToAdd].getAmount();

                slots[slotNumberToAdd].addItem(itemToAdd, difference);

                //Leaves the rest in the dragged slot
                slots[slotNumberToRemove].removeItem(difference); 
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method 'addItemToSpecificSlotFromInventory': Is called by the 'checkDrag' method in InventorySlot class, if a InventorySlot was dragged on top of a HotbarSlot.
     * The items of the dragged slot are transmitted to the stationary slot, if the stationary slot is empty or the item of the stationary slot matches the item of the dragged slot
     * so they can be stacked together.
     * 
     * @param 'itemToAdd': The name of the item of the dragged slot
     * @param 'amount': The amount of the item of the dragged slot
     * @param 'slotNumberToAdd': The slot number of the stationary hotbar slot, to which the item will be transferred (must be 0 - 9)
     * @param 'slotNumberToRemove': The slot number of the dragged inventory slot, from which the item will be transferred (must be 0 - 39)
     * 
     * @return: True if items were tranferred, false if not
     */
    public boolean addItemToSpecificSlotFromInventory(String itemToAdd, int amount, int slotNumberToAdd, int slotNumberToRemove)
    {
        if(slots[slotNumberToAdd].isEmpty()) //If the stationary slot is empty -> Transfer the items
        {
            slots[slotNumberToAdd].addItem(itemToAdd, amount);

            inventory.removeItemAtSpecificSlot(amount, slotNumberToRemove);

            return true;
        }
        else if(slots[slotNumberToAdd].getName() == itemToAdd) //If the stationary slot is not empty, but the same item is in both slots
        {
            if(slots[slotNumberToAdd].getAmount() + amount <= inventory.itemData.getMaxStackSize(itemToAdd)) //If all items from the dragged slot fit in the stationary slot -> Transfer the items
            {
                slots[slotNumberToAdd].addItem(itemToAdd, amount);

                inventory.removeItemAtSpecificSlot(amount, slotNumberToRemove);

                return true;
            }
            else if(!(slots[slotNumberToAdd].getAmount() == inventory.itemData.getMaxStackSize(itemToAdd))) //If the stationary slot is not already at the max stack size -> Fill up the stationary slot and leave the rest in the dragged slot
            {
                //Fill up the Stack
                int difference = inventory.itemData.getMaxStackSize(itemToAdd) - slots[slotNumberToAdd].getAmount();

                slots[slotNumberToAdd].addItem(itemToAdd, difference);

                //Leaves the rest in the dragged slot
                inventory.removeItemAtSpecificSlot(difference, slotNumberToRemove);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method 'removeItem': Is called by the 'useItem' method in Player class, if items should be removed from the hotbar (not from a specific slot).
     * 
     * @param 'item': The name of the item that should be removed
     * @param 'amount': The amount of the item that should be removed
     * 
     * @return: True if items were found and removed, false if not
     */
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
    
    /**
     * Method 'removeItemAtSpecificSlot': Is called by the 'ckeckDrop' method or the 'addItemToSpecificSlotFromHotbar' method in Inventory class or the 'useItem' method Player class, 
     * if items should be removed from a specific slot of the hotbar.
     * 
     * @param 'amount': The amount of the item that should be removed
     * @param 'slotNumberToRemove': The slot number of the slot from which the item should be removed (must be 0 - 9)
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
    
    /**
     * Method 'isInHotbar': Is called by 'useItem' method Player class. Searches one item in the hotbar.
     * 
     * @param 'isInHotbar': The name of the item that should be searched after
     * 
     * @return: True if item(s) was / were found in the hotbar, false if not
     */
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
