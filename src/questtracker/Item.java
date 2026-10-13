package questtracker;
/**
 * Represents an item in the player's inventory.
 *
 * @author Muhammad Zenoor Hayat Bhatti
 * @version 2026.10.10
 */
public class Item
{
    private String name;
    private String type;
    private int quantity;


    /**
     * Creates a new inventory item.
     *
     * @param name
     *            the item's name
     * @param type
     *            the item's type
     * @param quantity
     *            the amount of the item
     */
    public Item(String name, String type, int quantity)
    {
        if (name == null || name.equals(""))
        {
            throw new IllegalArgumentException();
        }

        if (type == null || type.equals(""))
        {
            throw new IllegalArgumentException();
        }

        if (quantity <= 0)
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }


    /**
     * Returns the item's name.
     *
     * @return the item name
     */
    public String getName()
    {
        return name;
    }


    /**
     * Returns the item's type.
     *
     * @return the item type
     */
    public String getType()
    {
        return type;
    }


    /**
     * Returns the item's quantity.
     *
     * @return the quantity
     */
    public int getQuantity()
    {
        return quantity;
    }


    /**
     * Changes the quantity of this item.
     *
     * @param quantity
     *            the new quantity
     */
    public void setQuantity(int quantity)
    {
        if (quantity <= 0)
        {
            throw new IllegalArgumentException();
        }

        this.quantity = quantity;
    }


    /**
     * Adds to the current quantity.
     *
     * @param amount
     *            the amount to add
     */
    public void addQuantity(int amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException();
        }

        quantity += amount;
    }


    /**
     * Returns a String representation of the item.
     *
     * @return item information
     */
    @Override
    public String toString()
    {
        return name + " (" + type + ") x" + quantity;
    }
}