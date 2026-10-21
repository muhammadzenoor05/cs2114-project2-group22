package questtracker;

/**
 * Tracks and updates a player's inventory
 * 
 * @author Diya Saraf (diyas04)
 * @version 2026.09.16
 */
public class Inventory {
    private LinkedChain<Item> inventory;

    public Inventory() {
        inventory = new LinkedChain<Item>();
    }


    /**
     * Adds an item to the inventory or increases the quantity if the item
     * already exists.
     * returns: void
     * parameters: Item item — the item to add to the inventory
     * Big-O: O(n) - search through inventory
     */
    public void addItem(Item item) {
        String itemName = item.getName();
        if (findItem(itemName) != null) {
            findItem(itemName).setQuantity(findItem(itemName).getQuantity() + item.getQuantity());
        }else {
            inventory.add(item);
        }
        

    }


    /**
     * Searches for an item by name and removes it from the inventory if it is
     * found.
     * returns: boolean, true if the item was removed, otherwise false
     * parameters: String name, the name of the item to remove
     * Big-O: O(n) - search through inventory
     */
    public boolean removeItem(String name) {
        if (findItem(name) == null) {
            return false;
        }
        Item found = findItem(name);
        if(found.getQuantity()>1) {
            found.setQuantity(found.getQuantity()-1);
        }else {
            inventory.remove(found);
        }
        return true;
    }


    /**
     * Determines whether an item with the specified name exists in the
     * inventory.
     * returns: boolean — true if the item exists, otherwise false
     * parameters: String name — the name of the item to search for
     * Big-O: O(n) - search through inventory
     */
    public boolean containsItem(String name) {
        Item[] items = inventory.toArray(new Item[inventory.size()]);

        for (Item item : items) {
            if (item.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Finds an item in the inventory
     * returns: Item - if found in the inventory, else returns null
     * parameters: String name - the name of the item to find
     * Big-O: O(n) - search through inventory
     */
    public Item findItem(String name) {
        if(name == null || name.equals("")) {
            throw new IllegalArgumentException("Item is not in inventory");
        }
        Item[] items = inventory.toArray(new Item[inventory.size()]);

        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        // maybe make this throw smth
        return null;
    }


    /**
     * Displays all items currently stored in the inventory.
     * returns: void
     * parameters: none
     * Big-O: O(n) - must display each element
     */
    public void displayInventory() {
        System.out.print(inventory.toString());
    }


    /*
     * Returns the number of item entries currently stored in the inventory.
     * returns: int — the number of stored item entries
     * parameters: none
     * Big-O: O(1) - return tracked attribute size
     */
    public int getNumberOfItems() {
        return inventory.size();
    }

}
