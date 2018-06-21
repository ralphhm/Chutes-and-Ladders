Chutes and Ladders
==================

Chutes and Ladders, or "Snakes" and Ladders, was Invented by Hindu spiritual leaders 
to teach children about the rewards of good deeds and the negative consequences of bad ones. 
Here it's appropriated to pose computer science questions.

<img src="https://camo.githubusercontent.com/65d5d069c84ec1ff86958b14e978cd5210e7c082/687474703a2f2f692e696d6775722e636f6d2f4e366d345a51392e6a7067" height="400px">

## How to Play

### Setup

One needs a board -- usually 8x8, 10x10, or 12x12 -- and to number each square on the board
1 to (in the case of a 10x10 board) 100. You put your piece on square "zero" (outside the board). 

### Gameplay

Each turn you roll a fair 6 sided die and move that many spaces. When you land at the base of a ladder you
immediately climb the ladder to the top. Given the board in the picture, if you were to roll a 4
on your first turn, you'd end up on square 14. Conversely, if you land at the top of a chute, you
would immediately move your piece to the bottom of that chute. You win when you reach the last square but you must roll
and land on the last square exactly. If you're on the second to last square and you roll a 2 or higher you pass the turn.

# Questions

## Representing a Board

For the purposes of the questions to follow, boards will be represented in the following text format.
The first line will be three integers, `W` `H` and `T`, separated by a space, where the first is the **w**idth of the board, the second is the **h**eight, and the third is the **t**otal number of chutes _and_ ladders. Following that will be `T`
lines representing the chutes and the ladders. The first character will be `C` or `L` (for chute and ladder respectively)
and then two integers `A` and `B`, `1 <= A < B <= (W x H)`, where `A` is the bottom of the chute or ladder and `B` is the top.

For Example -- the board pictured above would be represented like...
```
10 10 19
L 1 38
L 4 14
C 6 16
L 9 31
C 11 49
C 19 62
L 21 42
C 24 87
C 26 47
L 28 84
L 36 44
L 51 67
C 53 56
C 60 64
L 71 91
C 73 93
C 75 95
C 78 98
L 80 100
```

[`chutes_and_ladders.txt`](https://gist.githubusercontent.com/zconnelly/a570fd44a9984ea7fa5f9a58e6a29181/raw/f89b72c4bb7fcf6e3eaff29629b3367967aff329/chutes_and_ladders.txt) contains 10,000 boards. 
You can assume that each of these boards is valid in that there will never be a single space containing both a chute top and a ladder bottom (as well as the other constraints set above)

### Is it solvable?

Given the above representation of a board come up with an algorithm to determine if a board is solveable (i.e.
the game can be won). How many boards in `chutes_and_ladders.txt` are unsolvable?

### Minimum Number of Rolls

The minimum number of rolls required to win given the board represented above is 7. What is the _sum_ of
the minimum number of rolls required to win on each solvable board in `chutes_and_ladders.txt`?