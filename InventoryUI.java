import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The InventoryUI class is used to display a inventory image under the inventory slots. All functionality is located in the Inventory class and the InventorySlot class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventoryUI extends UI
{
    //----- Object image -----
    GreenfootImage inventory = new GreenfootImage("ui/inventory.png");
    
    /**
     * InventoryUI Constructor: Makes the image 2 times bigger and sets it.
     */
    public InventoryUI()
    {
        inventory.scale(inventory.getWidth() * 2, inventory.getHeight() * 2);
        setImage((GreenfootImage)null);
    }
    
    /**
     * Method 'setImageVisible': Is called by 'openInventory' in Inventory class if player pressed the 'i' to open the inventory.
     * It sets image visible.
     */
    public void setImageVisible()
    {
        setImage(inventory);
    }
}
