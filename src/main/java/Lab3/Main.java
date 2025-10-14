package lab3;

import lab3.game.Board;
import lab3.game.GameState;
import lab3.ui.Console;


public class Main {

    public static void main(String[] args) {

        // TODO: Initialize a TicTacToe game with a 3x3 board and two players
        GameState gameState = new GameState(new Board(), Player.X);
        while (true) {
            // TODO: Display the board
            Console.displayBoard(gameState.board());
            // TODO: Check if the game is over or a draw, and if so display the result and exit


            Player lastPlayer;
            if (gameState.currentPlayer() == Player.X) {
                lastPlayer = Player.O;
            } else {
                lastPlayer = Player.X;
            }

            if (gameState.board().isWin(lastPlayer)) {
                Console.println("Player " + lastPlayer + " has won the game!");
                break; //exit the game loop
            }

            if (gameState.board().isDraw()) {
                Console.println("The game is a draw!");
                break; //exit the game loop
            }

            // TODO: Get the next move from the player and update the game state

            boolean validMove = false;
            while (validMove == false) {
                Position move = Console.getMove(gameState.currentPlayer()); //tell the current player to move until a valid value is entered

                if(gameState.board().isTaken(move)==false) {

                    Board newBoard = gameState.board().placeMove(move, gameState.currentPlayer());
                    Player nextPlayer;
                    if (gameState.currentPlayer() == Player.X) {
                        nextPlayer = Player.O;
                    }
                    else {
                        nextPlayer = Player.X;
                    }
                }
                else {
                    Console.println("That position is already taken. Please try again.");
                }
            }
        }
        Console.displayBoard(gameState.board());
        Console.println("Game Over! Thank you for playing");
    }
}


