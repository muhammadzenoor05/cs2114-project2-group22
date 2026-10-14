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

## Next Steps
- Muhammad will help verify that `Inventory` and `QuestLog` correctly use the shared generic `LinkedChain<T>` class and assist
- with final integration.
- Charlotte will review all test classes accordingly with all updated classes, as well as to make sure the 'LinkedChain<T>' is implemented properly. Additionally, will add finishing touches in terms of format.

## Attribution
| File | Team member(s) | Contribution |
| Item.java | Muhammad Bhatti | Implemented the Item data class based on the project specification |
| Quest.java | Muhammad Bhatti | Implemented the Quest data class based on the project specification |
| QuestTest | Charlotte Linney | Implemented QuestTest methods based on Quest class
| QuestLogTest | Charlotte Linney | Implemented QuestLogTest methods based on QuestLog class
| ItemTest | Charlotte Linney | Implemented ItemTest methods based on Item class
| InventoryTest | Charlotte Linney | Implemented InventoryTest methods based on Inventory class
| GameTrackerTest | Charlotte Linney | Implemented GameTrackerTest methods based on GameTracker class

## GenAI Use
