# My-Simple-Monte-Carlo-Tree-Search for Tic-Tac-Toe
While i was implementing the Monte Carlo Tree Search algorithm to play Tic-Tac-Toe from scratch, I discovered a simpler and yet more efficient way of doing it then the one that every one is talking about in the web.
I tested it with my Tic-Tac-Toe reactive agent and with the Alpha Beta Pruning on MiniMAx. 
While playing at first, I did sets of 1000 games and sets of 10000 games against each of this two algorithms n times and it never loses, we just need to have about 100 iterations, which means 100 simulations per child, give 1 value to victory, 0 to defeat and 1 to draw. The original algorithm needs about 1000 iterations do be able to not lose while playing first.

The board implemented was taken from an Alpha Beta Pruning algorithm that i used to test my Monte Carlo Tree Search, I just added there the methods needed to implement my algorithm which will be asked by the interface that i will provide.

The Alpha Beta Pruning algorithm can be found here: https://github.com/LazoCoder/Tic-Tac-Toe
