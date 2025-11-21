Why can you change the type of the returned value in promptForPlayer without changing the return type in the function signature?

When HumanPlayer extends Player, HumanPlayer is Player. Since HumanPlayer is Player, we can use HumanPlayer as a return. HumanPlayer is a subclass of Player and in Java, we can return a subclass when the method returns the parent class. 



Explain why the error occurred initially and why adding the abstract method signature fixes the error. (HINT: What is the type of the ‘whoseTurn’ variable in TicTacToeGame.doNextTurn?)

whoseTurn is a type Player. When compiling, it will checks if Player class have a pickNextMove method. If there's none, it will give an error. By adding abstract before the pickNextMove, Player class will include the method pickNextMove.


Explain in detail (using the terminology we have discussed in class) how it is possible that neither our main method nor our TicTacToeGame class need change at all when adding new Player types to our game.  Your discussion must include an explanation of how the single call to pickNextMove in TicTacToeGame.doNextTurn works correctly no matter whose turn it is or which types the players are.

