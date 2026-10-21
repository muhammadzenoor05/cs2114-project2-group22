package questtracker;

import student.TestCase;

/**
 * Tests for Inventory
 * 
 * @author Charlotte Linney
 * @version 2026.10.20
 *  */
public class InventoryTest extends TestCase {

    /**
     * Tests setUp
     */
    public void testConstructor() {
        Inventory inventory = new Inventory();

        assertEquals(0, inventory.getNumberOfItems());
    }

    /**
     * Tests addItem
     */
    public void testAddItemNewItem() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Sword", 1));

        assertTrue(inventory.containsItem("Sword"));
        assertEquals(1, inventory.getNumberOfItems());
    }

    /**
     * Tests addItem to existing item
     */
    public void testAddItemExistingItem() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Potion", 2));
        inventory.addItem(new Item("Potion", 3));

        assertEquals(5, inventory.findItem("Potion").getQuantity());
        assertEquals(1, inventory.getNumberOfItems());
    }

    /**
     * Tests removeItem if not found
     */
    public void testRemoveItemNotFound() {
        Inventory inventory = new Inventory();

        assertFalse(inventory.removeItem("Bow"));
    }

    /**
     * Tests removeItem on an item with 2 quantity
     */
    public void testRemoveItemQuantityGreaterThanOne() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Potion", 2));
        inventory.removeItem("Potion");

        assertEquals(1, inventory.findItem("Potion").getQuantity());
    }

    /**
     * Tests removeItem on an item with 1 quantity
     */
    public void testRemoveItemLastQuantity() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Sword", 1));
        inventory.removeItem("Sword");

        assertFalse(inventory.containsItem("Sword"));
        assertEquals(0, inventory.getNumberOfItems());
    }

    /**
     * Tests findItem if found
     */
    public void testFindItemFound() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Sword", 1));

        assertNotNull(inventory.findItem("Sword"));
    }

    /**
     * Tests findItem if not found
     */
    public void testFindItemNotFound() {
        Inventory inventory = new Inventory();

        assertNull(inventory.findItem("Sword"));
    }

    /**
     * Tests findItem if item is null
     */
    public void testFindItemNull() {
        Inventory inventory = new Inventory();

        Exception e = null;

        try {
            inventory.findItem(null);
        }
        catch (IllegalArgumentException ex) {
            e = ex;
        }

        assertNotNull(e);
    }

    /**
     * Tests containsItem
     */
    public void testContainsItem() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Sword", 1));

        assertTrue(inventory.containsItem("Sword"));
        assertFalse(inventory.containsItem("Potion"));
    }

    /**
     * Tests findItem on an item with no name
     */
    public void testFindItemEmptyString() {
        Inventory inventory = new Inventory();

        Exception e = null;

        try {
            inventory.findItem("");
        }
        catch (IllegalArgumentException ex) {
            e = ex;
        }

        assertNotNull(e);
    }
}