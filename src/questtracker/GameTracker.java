package questtracker

import java.util.Scanner;

/**
 * Manages menus and outputs. Uses scanner to parse user input
 * 
 * @author Alex Leon
 * @version 2026.10.13
 */
public class GameTracker
{
    private Inventory inventory;
    private QuestLog questLog;
    private Scanner scanner;

    /**
     * Creates a new GameTracker with an empty inventory and quest log.
     */
    public GameTracker()
    {
        inventory = new Inventory();
        questLog = new QuestLog();
        scanner = new Scanner(System.in);
    }


    /**
     * Runs the main application loop.
     */
    public void run()
    {
        boolean running = true;

        while (running)
        {
            displayMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clears newline

            if (choice == 0)
            {
                running = false;
            }
            else
            {
                handleMenuChoice(choice);
            }
        }

        System.out.println("Exiting Game Tracker.");
    }


    /**
     * Displays the main menu.
     */
    public void displayMainMenu()
    {
        System.out.println();
        System.out.println("=== Game Tracker ===");
        System.out.println("1. Inventory");
        System.out.println("2. Quest Log");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }


    /**
     * Handles a choice from the main menu.
     *
     * @param choice the menu option selected by the user
     */
    public void handleMenuChoice(int choice)
    {
        if (choice == 1)
        {
            inventoryMenu();
        }
        else if (choice == 2)
        {
            questMenu();
        }
        else
        {
            System.out.println("Invalid choice.");
        }
    }


    /**
     * Displays and handles inventory options.
     */
    public void inventoryMenu()
    {
        System.out.println();
        System.out.println("=== Inventory ===");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Find Item");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1)
        {
            inventory.displayInventory();
        }
        else if (choice == 2)
        {
            System.out.print("Item name: ");
            String name = scanner.nextLine();

            System.out.print("Item type: ");
            String type = scanner.nextLine();

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            Item item = new Item(name, type, quantity);
            inventory.addItem(item);
        }
        else if (choice == 3)
        {
            System.out.print("Item name to remove: ");
            String name = scanner.nextLine();

            boolean removed = inventory.removeItem(name);

            if (removed)
            {
                System.out.println("Item removed.");
            }
            else
            {
                System.out.println("Item not found.");
            }
        }
        else if (choice == 4)
        {
            System.out.print("Item name to find: ");
            String name = scanner.nextLine();

            Item item = inventory.findItem(name);

            if (item != null)
            {
                System.out.println(item);
            }
            else
            {
                System.out.println("Item not found.");
            }
        }
        else if (choice != 0)
        {
            System.out.println("Invalid choice.");
        }
    }


    /**
     * Displays and handles quest log options.
     */
    public void questMenu()
    {
        System.out.println();
        System.out.println("=== Quest Log ===");
        System.out.println("1. View Quests");
        System.out.println("2. Add Quest");
        System.out.println("3. Remove Quest");
        System.out.println("4. Update Quest Progress");
        System.out.println("5. Complete Quest");
        System.out.println("6. View Quest History");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1)
        {
            questLog.displayQuests();
        }
        else if (choice == 2)
        {
            System.out.print("Quest name: ");
            String name = scanner.nextLine();

            System.out.print("Quest description: ");
            String description = scanner.nextLine();

            Quest quest = new Quest(name, description);
            questLog.addQuest(quest);
        }
        else if (choice == 3)
        {
            System.out.print("Quest name to remove: ");
            String name = scanner.nextLine();

            boolean removed = questLog.removeQuest(name);

            if (removed)
            {
                System.out.println("Quest removed.");
            }
            else
            {
                System.out.println("Quest not found.");
            }
        }
        else if (choice == 4)
        {
            System.out.print("Quest name: ");
            String name = scanner.nextLine();

            System.out.print("Progress amount: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            questLog.updateQuestProgress(name, amount);
        }
        else if (choice == 5)
        {
            System.out.print("Quest name to complete: ");
            String name = scanner.nextLine();

            questLog.completeTheQuest(name);
        }
        else if (choice == 6)
        {
            questLog.displayHistory();
        }
        else if (choice != 0)
        {
            System.out.println("Invalid choice.");
        }
    }


    /**
     * Starts the program.
     */
    public static void main(String[] args)
    {
        GameTracker tracker = new GameTracker();
        tracker.run();
    }
}
