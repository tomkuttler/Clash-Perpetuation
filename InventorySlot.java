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

    public void update()
    {      
        if(item == null)
        {
            setImage(new GreenfootImage("ui/testInventorySlot.png"));

            if(amount > 1)
            {
                this.getWorld().showText(Integer.toString(amount), this.getX() + 5, this.getY() + 5);
            }
        }

        if(item == "redPotion")
        {
            setImage(new GreenfootImage("objects/healingItems/redPotion.png"));

            if(amount > 1)
            {
                this.getWorld().showText(Integer.toString(amount), this.getX() + 5, this.getY() + 5);
            }
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
