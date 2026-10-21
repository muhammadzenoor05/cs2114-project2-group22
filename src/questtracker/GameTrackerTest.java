package questtracker;

import student.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for GameTracker. Uses ByteArray streams to ensure the expected output is printed.
 * 
 * @author Charlotte Linney and Alex Leon
 * @version 2026.10.14
 */
public class GameTrackerTest extends TestCase
{
    /**
     * Sets up 
     */
    @BeforeEach
    public void setUp()
    {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    /**
     * Resets variables from setUp 
     */
    @AfterEach
    public void tearDown()
    {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    /**
    * Tests that GameTracker constructor works.
     */
    public void testConstructor()
    {
        GameTracker tracker = new GameTracker();

        assertNotNull(tracker);
    }

    /**
     * Tests an invalid main menu choice.
     */
    public void testHandleMenuChoiceInvalid()
    {
        System.setIn(new ByteArrayInputStream("0\n".getBytes()));

        GameTracker tracker = new GameTracker();

        tracker.handleMenuChoice(99);

        assertTrue(output.toString().contains("Invalid choice"));
    }

    /**
     * Tests an invalid inventory menu choice.
     */
    public void testInventoryMenuInvalidChoice()
    {
        System.setIn(new ByteArrayInputStream("99\n".getBytes()));

        GameTracker tracker = new GameTracker();

        tracker.inventoryMenu();

        assertTrue(output.toString().contains("Invalid choice"));
    }

    /**
     * Tests an invalid quest menu choice.
     */
    public void testQuestMenuInvalidChoice()
    {
        System.setIn(new ByteArrayInputStream("99\n".getBytes()));

        GameTracker tracker = new GameTracker();

        tracker.questMenu();

        assertTrue(output.toString().contains("Invalid choice"));
    }

            
}
