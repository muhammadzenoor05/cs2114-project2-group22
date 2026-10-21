package questtracker;

import student.TestCase;

/**
 * Tests for QuestLog
 *
 * @author Charlotte Linney
 * @version 2026.10.20
 */
public class QuestLogTest extends TestCase {

    /**
     * Test constructor creates empty quest log
     */
    public void testConstructor() {
        QuestLog log = new QuestLog();

        assertEquals(0, log.getNumberOfQuests());
    }


    /**
     * Test addQuest and getNumberOfQuests
     */
    public void testAddQuest() {
        QuestLog log = new QuestLog();
        Quest quest = new Quest("Dragon Hunt");

        log.addQuest(quest);

        assertEquals(1, log.getNumberOfQuests());
    }


    /**
     * Test findQuest when quest exists
     */
    public void testFindQuest() {
        QuestLog log = new QuestLog();
        Quest quest = new Quest("Dragon Hunt");

        log.addQuest(quest);

        assertEquals(quest, log.findQuest("Dragon Hunt"));
    }


    /**
     * Test findQuest with null name
     */
    public void testFindQuestNull() {
        QuestLog log = new QuestLog();

        Exception thrown = null;

        try {
            log.findQuest(null);
        }
        catch (Exception e) {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Test findQuest with empty string
     */
    public void testFindQuestEmpty() {
        QuestLog log = new QuestLog();

        Exception thrown = null;

        try {
            log.findQuest("");
        }
        catch (Exception e) {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Test findQuest when quest is not found
     */
    public void testFindQuestNotFound() {
        QuestLog log = new QuestLog();

        Exception thrown = null;

        try {
            log.findQuest("Missing Quest");
        }
        catch (Exception e) {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Test removeQuest when quest exists
     */
    public void testRemoveQuest() {
        QuestLog log = new QuestLog();
        Quest quest = new Quest("Dragon Hunt");

        log.addQuest(quest);

        assertTrue(log.removeQuest("Dragon Hunt"));
        assertEquals(0, log.getNumberOfQuests());
    }


    /**
     * Test removeQuest with null name
     */
    public void testRemoveQuestNull() {
        QuestLog log = new QuestLog();

        Exception thrown = null;

        try {
            log.removeQuest(null);
        }
        catch (Exception e) {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Test removeQuest with empty name
     */
    public void testRemoveQuestEmpty() {
        QuestLog log = new QuestLog();

        Exception thrown = null;

        try {
            log.removeQuest("");
        }
        catch (Exception e) {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Test updateQuestProgress with negative value
     */
    public void testUpdateQuestProgressNegative() {
        QuestLog log = new QuestLog();
        Quest quest = new Quest("Dragon Hunt");

        log.addQuest(quest);

        Exception thrown = null;

        try {
            log.updateQuestProgress("Dragon Hunt", -5);
        }
        catch (Exception e) {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Test updateQuestProgress with valid value
     */
    public void testUpdateQuestProgress() {
        QuestLog log = new QuestLog();
        Quest quest = new Quest("Dragon Hunt");

        log.addQuest(quest);

        log.updateQuestProgress("Dragon Hunt", 10);

        assertEquals(10, quest.getProgress());
    }


    /**
     * Test completeTheQuest
     */
    public void testCompleteTheQuest() {
        QuestLog log = new QuestLog();
        Quest quest = new Quest("Dragon Hunt");

        log.addQuest(quest);

        log.completeTheQuest("Dragon Hunt");

        assertTrue(quest.isCompleted());
    }


    /**
     * Test displayQuests runs without exception
     */
    public void testDisplayQuests() {
        QuestLog log = new QuestLog();

        log.displayQuests();

        assertEquals(0, log.getNumberOfQuests());
    }

     /**
     * Test updateHistory with no completed quests
     */
    public void testUpdateHistoryNoCompletedQuests() {
        QuestLog log = new QuestLog();

        log.addQuest(new Quest("Dragon Hunt", "slay the dragon"));
        log.addQuest(new Quest("Find Treasure", "look for treasure"));

        log.updateHistory();

        assertEquals(2, log.getNumberOfQuests());
    }
    
    /**
     * Test displayHistory runs when history is empty
     */
    public void testDisplayHistoryEmpty() {
        QuestLog log = new QuestLog();

        log.displayHistory();

        assertEquals(0, log.getNumberOfQuests());
    }
    
    /**
     * tets removeQuest for a quest not found
     */
    public void testRemoveQuestNotFound() {
    QuestLog log = new QuestLog();

    assertFalse(log.removeQuest("Missing Quest"));
}
    
    /**
     * Test updateHistory adds completed quests to history
     */
    public void testUpdateHistory() {
        QuestLog log = new QuestLog();

        Quest quest = new Quest("Dragon Hunt");
        log.addQuest(quest);

        quest.completeQuest();

        log.updateHistory();

        assertEquals(1, log.getHistorySize());
    }
    
    /**
     * Test displayHistory with a completed quest
     */
    public void testDisplayHistory() {
        QuestLog log = new QuestLog();

        Quest quest = new Quest("Dragon Hunt");
        log.addQuest(quest);

        log.completeTheQuest("Dragon Hunt");

        assertEquals(1, log.getHistorySize());

        log.displayHistory();
    }
}
