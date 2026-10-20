package questtracker;

/**
 * Tracks and updates the status of the quests in the game
 * 
 * @author Diya Saraf (diyas04)
 * @version 2026.09.16
 */
public class QuestLog {

    private LinkedChain<Quest> questList;
    private LinkedChain<Quest> history;

    public QuestLog() {
        questList = new LinkedChain<Quest>();
        history = new LinkedChain<Quest>();
    }


    /**
     * Adds a new quest to the quest log.
     * returns: void
     * parameters: Quest quest — the quest to add
     * Big-O: O(1) - just add to front of LinkedChain
     */
    public void addQuest(Quest quest) {
        questList.add(quest);
    }


    /**
     * Searches for a quest by name and removes it from the quest log if it is
     * found.
     * returns: boolean, true if the quest was removed, otherwise false
     * parameters: String name
     * Big-O: O(n) - must search for quest
     */
    public boolean removeQuest(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Enter a valid quest ");
        }
        Quest quest = findQuest(name);

        if (quest != null) {
            return questList.remove(quest);
        }

        return false;
    }


    /**
     * Searches the quest log for a quest with the specified name.
     * returns: Quest, the matching quest, or null if no quest is found
     * parameters: String name
     * Big-O: O(n) - must search for the quest
     */
    public Quest findQuest(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException();
        }
        Quest[] quests = questList.toArray(new Quest[questList.size()]);

        for (Quest quest : quests) {
            if (quest.getName().equals(name)) {
                return quest;
            }
        }
        throw new IllegalArgumentException("Quest not found");
    }


    /**
     * Finds a quest by name and increases its progress by the specified amount.
     * returns: void
     * parameters: String name — the quest to update; int amount — the amount of
     * progress to add
     * Big-O: O(n) - must find specified quest
     */
    public void updateQuestProgress(String name, int amount) {
        Quest quest = findQuest(name);
        if (amount < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        else {
            quest.addProgress(amount);
            if(quest.isCompleted()) {
                completeTheQuest(name);
            }
        }

    }


    /**
     * Finds the specified quest and marks it as completed.
     * returns: void
     * parameters: String name
     * Big-O: O(n) - must find specified quest
     */
    public void completeTheQuest(String name) {
        Quest[] quests = questList.toArray(new Quest[questList.size()]);

        for (Quest quest : quests) {
            if (quest.getName().equals(name)) {
                quest.completeQuest();
            }
        }
        updateHistory();
        removeQuest(name);
    }


    /**
     * Displays all quests currently stored in the quest log.
     * returns: void
     * parameters: none
     * Big-O: O(n) - print out each quest
     */
    // CHECK IF NEED system.out.println FOR THIS
    public void displayQuests() {
        System.out.print(questList.toString());
    }


    /**
     * Returns the number of quests currently stored in the quest log.
     * returns: int — the number of stored quests
     * parameters: none
     * Big-O: O(1) - return tracked attribute size
     */
    public int getNumberOfQuests() {
        return questList.size();
    }

    /**
     * Updates the history with the completed quests
     * returns: void
     * parameters: none
     */
    public void updateHistory() {
        //history.clear();
        Quest[] quests = questList.toArray(new Quest[questList.size()]);

        for (Quest quest : quests) {
            if (quest.isCompleted()) {
                history.add(quest);
            }
        }
    }
    
    public void displayHistory() {
        System.out.print(history.toString());
    }
}
