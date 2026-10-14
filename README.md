# Game Quest and Inventory Tracker

## How to Run

## How to Run Tests
In Eclipse, right-click the test class and select Run As → JUnit Test.
## Reflection
For the prototype, I implemented the `Item` and `Quest` classes based on the fields and behavior we defined in our specification. 
These classes were kept separate from the `LinkedChain` so that the linked structure only handles storage while the application classes 
handle game-specific data. The provided `LinkedChain` was used without changing its internal structure for my part of the prototype.

The main thing I figured out from our earlier unknowns was how the generic design connects to the application classes. `QuestLog` can 
use `LinkedChain<Quest>` and `Inventory` can use `LinkedChain<Item>` without needing separate linked chain implementations.

GameTracker.java was relatively simple to implement because it is mostly just responsible for printing various menus. When testing the class, I used ByteArrayInputStream to ensure that the specific outputs for invalid inputs matched the expected Strings such as "Invalid input." 

Our MVP still has some unfinished pieces. We need to add items such as coins and experience and limit inventory capacity. Our stretch goal from the initial scope of adding a quest history also should be implemented by next week.

## Next Steps
- Muhammad will help verify that `Inventory` and `QuestLog` correctly use the shared generic `LinkedChain<T>` class and assist
- with final integration.
- Charlotte will review all test classes accordingly with all updated classes, as well as to make sure the 'LinkedChain<T>' is implemented properly. Additionally, will add finishing touches in terms of format.
- Diya will attempt to implement our stretch goal of adding a completed quest history
- Alex will ensure that GameTracker integrates smoothly with other system classes and that we get the expected output across all menu options and invalid requests.

## Attribution
| File | Team member(s) | Contribution |
| Item.java | Muhammad Bhatti | Implemented the Item data class based on the project specification |
| Quest.java | Muhammad Bhatti | Implemented the Quest data class based on the project specification |
| QuestTest | Charlotte Linney | Implemented QuestTest methods based on Quest class
| QuestLogTest | Charlotte Linney | Implemented QuestLogTest methods based on QuestLog class
| ItemTest | Charlotte Linney | Implemented ItemTest methods based on Item class
| InventoryTest | Charlotte Linney | Implemented InventoryTest methods based on Inventory class
| GameTracker.java | Alex Leon | Implemented GameTracker class based on the project specification |
| GameTrackerTest | Charlotte Linney and Alex Leon| Implemented GameTrackerTest methods based on GameTracker class. Used ByteArrayInputStream to ensure the ouput when given an invalid input matched the expected String.
| Inventory.java | Diya Saraf | Implemented the Inventory class based on project specification |
| QuestLog.java | Diya Saraf | Implemented the QuestLog class based on project specification |


## GenAI Use
In creating GameTracker class and testing it I used GenAI. AI helped me design the output (what the menu would look like). I also used GenAI to write test cases with ByteArrayInputStream because I wasn't sure how to use it. This simulates a user's invalid input so that we can ensure that the output String matches the expected. 
