package questtracker;

import student.TestCase;


/**
 * Tests for Item
 * 
 * @author Charlotte Linney
 * @version 2026.10.20
 */
public class ItemTest extends TestCase
{
    /**
     * Tests setUp
     */
    public void testConstructor()
    {
        Item item = new Item("Potion", "Consumable", 5);

        assertEquals("Potion", item.getName());
        assertEquals("Consumable", item.getType());
        assertEquals(5, item.getQuantity());
    }


    /**
     * Tests setUp with null name
     */
    public void testConstructorNullName()
    {
        Exception thrown = null;

        try
        {
            new Item(null, "Consumable", 5);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests setUp with no name
     */
    public void testConstructorEmptyName()
    {
        Exception thrown = null;

        try
        {
            new Item("", "Consumable", 5);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests setUp with null type
     */
    public void testConstructorNullType()
    {
        Exception thrown = null;

        try
        {
            new Item("Potion", null, 5);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests setUp with no type
     */
    public void testConstructorEmptyType()
    {
        Exception thrown = null;

        try
        {
            new Item("Potion", "", 5);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests setUp with invalid quantity
     */
    public void testConstructorInvalidQuantity()
    {
        Exception thrown = null;

        try
        {
            new Item("Potion", "Consumable", 0);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests setQuantity
     */
    public void testSetQuantity()
    {
        Item item = new Item("Potion", "Consumable", 5);

        item.setQuantity(10);

        assertEquals(10, item.getQuantity());
    }


    /**
     * Tests setQuantity if user attempts to set to 0
     */
    public void testSetQuantityInvalid()
    {
        Item item = new Item("Potion", "Consumable", 5);

        Exception thrown = null;

        try
        {
            item.setQuantity(0);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests addQuantity
     */
    public void testAddQuantity()
    {
        Item item = new Item("Potion", "Consumable", 5);

        item.addQuantity(3);

        assertEquals(8, item.getQuantity());
    }


    /**
     * Tests addQuantity when user tries to add 0
     */
    public void testAddQuantityInvalid()
    {
        Item item = new Item("Potion", "Consumable", 5);

        Exception thrown = null;

        try
        {
            item.addQuantity(0);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests toString
     */
    public void testToString()
    {
        Item item = new Item("Potion", "Consumable", 5);

        assertEquals("Potion (Consumable) x5", item.toString());
    }

    /**
     * Tests getName
     */
    public void testGetName() {
        Item item = new Item("Potion", "Consumable", 1);
        assertEquals("Potion", item.getName());
    }

    /**
     * Tests getType
     */
    public void testGetType() {
        Item item = new Item("Potion", "Consumable", 1);
        assertEquals("Consumable", item.getType());
    }

    /**
     * Tests getQuantity
     */
    public void testGetQuantity() {
        Item item = new Item("l", "la", 1);
        assertEquals(1, item.getQuantity());
    }
}