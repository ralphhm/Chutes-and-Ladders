Chutes and Ladders
==================

## Questions

### 1) Is it solvable?

Given the above representation of a board come up with an algorithm to determine if a board is solveable (i.e.
the game can be won). How many boards in `chutes_and_ladders.txt` are unsolvable?

### Answer
1575 boards are unsolvable. The number is can be printed out by calling the main function in  ``Ùnsolvable.kt``

### 2) Minimum Number of Rolls

The minimum number of rolls required to win given the board represented above is 7. What is the _sum_ of
the minimum number of rolls required to win on each solvable board in `chutes_and_ladders.txt`?

### Answer
The sum of the minimum number rolls is 35875. The sum can be printed out by calling the main function of ``MinimumRolls.kt``
A test case is written to test the functionality of the method ``Board.findMinRolls`` by checking whether the return value is 7 for the sample board.

## Algorithm
To find out whether a board is solvable and if solvable what are the minimum number of rolls the function ``Board.findMinRolls`` was created that does the following. It starts from the current position (initially field/position 0) and simulates every move(or transition) from the current position by putting the destinations within reach (current position + 1..6) together with the number of rolls that are needed to reach the destination in a priority queue but only if the algorithm did not yet reached this destination with a lower number of rolls. After visiting all reachable positions from the current position it picks the next source position from the priority queue. As the priority queue primarily prioritises by lowest number of rolls the pick will always have the minimum number of rolls in the queue. In combination with the fact that the current number of rolls is incremented and destinations are only visited once the queue always contains positions with the minimum number of rolls to reach these destinations. When the algorithm finds a reachable destination to be the final destination it just returns the number of rolls to reach this destination. When the algorithm visited all reachable destinations and there is no more field left in the queue it returns ``-1`` as indicator that the board is not solvable.

### Alternative approach to find out solvability
An alternative approach to correctly find out the solvability for the boards in `chutes_and_ladders.txt` can be found as the function `Board.isSolvable`. It checks for special conditions that makes a board unsolvable. These conditions are:
* if there is a chute from the final position and no ladder to it the board is unsolvable
* if there is at least one position direct reach of the final position that doesn't have a chute the board is solvable
This algorithm works well for the sample boards but fails for a board that has a consecutive row of 6 fields outside of the reach of the final position that all have chutes making the rest of the board after the row unreachable. The last test in `BoardTest.kt` makes that clear for the following sample board:
````
3 7 6
C 6 9
C 5 10
C 4 11
C 3 12
C 2 13
C 1 14
````

### Alternative approach to find minimum number of rolls
Chutes and Ladders fulfil the requirements Markov Chain analyses as moving from one field to the next field doesn't depend on previous moves making it memoryless. The Markov Chain analysis can be used to calculate probabilities that a player is on a field after a given number of rolls. By generating a transition matrix that contains the probabilities to move from one field to another and multiplying it with a column vector that represents the probability state at roll number zero we receive the probability distribution after roll number one. Doing this all over again and observing the probability that the final field is reached we may get to an iteration where the propability of the final field is non zero. At this time we found the minimum number of rolls.