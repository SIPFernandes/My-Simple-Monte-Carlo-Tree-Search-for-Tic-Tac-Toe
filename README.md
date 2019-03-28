# My-Simple-Monte-Carlo-Tree-Search
While i was implementing the Monte Carlo Tree Search algorithm to learn and play Tic-Tac-Toe from scratch, I found out a simpler and efficient way of doing it then the one that every one is talking about in the web.
I tested it with my Tic-Tac-Toe reactive agent and with the Alpha Beta Pruning on MiniMAx. 
Did 1000 games against each of this two algorithms n times and it never loses, we just need to have 1000 simulations per child, give 1 value to victory, 0 to defeat and 0 to draw. If it starts second we only need 2500 simulations each child, give 1 value to victory, 1 to draw and 0 to defeat.

The board implemented was taken from an Alpha Beta Pruning algorithm that i used to test my Monte Carlo Tree Search, I just added there the methods needed to implement my algorithm which will be asked by the interface that i will provide. 

The Alpha Beta Pruning algorithm can be found here: https://github.com/LazoCoder/Tic-Tac-Toe
