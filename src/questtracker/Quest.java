package questtracker;
/**
 * Represents a quest in the game tracker.
 *
 * @author Muhammad Zenoor Hayat Bhatti
 * @version 2026.10.10
 */
public class Quest
{
    private String name;
    private String description;
    private int progress;
    private boolean completed;


    /**
     * Creates a new quest.
     *
     * @param name
     *            the name of the quest
     * @param description
     *            the description of the quest
     */
    public Quest(String name, String description)
    {
        if (name == null || name.equals(""))
        {
            throw new IllegalArgumentException();
        }

        if (description == null)
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.description = description;
        this.progress = 0;
        this.completed = false;
    }


    /**
     * Returns the quest name.
     *
     * @return the quest name
     */
    public String getName()
    {
        return name;
    }


    /**
     * Returns the quest description.
     *
     * @return the quest description
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Returns the current quest progress.
     *
     * @return the progress
     */
    public int getProgress()
    {
        return progress;
    }


    /**
     * Returns whether the quest is completed.
     *
     * @return true if completed
     */
    public boolean isCompleted()
    {
        return completed;
    }


    /**
     * Adds to the quest's current progress.
     *
     * @param amount
     *            the amount of progress to add
     */
    public void addProgress(int amount)
    {
        if (amount < 0)
        {
            throw new IllegalArgumentException();
        }

        progress += amount;

        if (progress >= 100)
        {
            progress = 100;
            completed = true;
        }
    }


    /**
     * Marks the quest as completed.
     */
    public void completeQuest()
    {
        progress = 100;
        completed = true;
    }


    /**
     * Returns a String representation of the quest.
     *
     * @return quest information
     */
    @Override
    public String toString()
    {
        return name + " - " + progress + "%";
    }
}