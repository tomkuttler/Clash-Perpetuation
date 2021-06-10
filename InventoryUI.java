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
    private static final GreenfootImage inventory = new GreenfootImage("ui/inventory.png");
    
    /**
     * InventoryUI Constructor: Sets the object image.
     */
    public InventoryUI()
    {
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
