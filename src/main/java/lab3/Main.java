package lab3;

import lab3.game.Board;
import lab3.ui.Console;
import lab3.game.GameState;
import lab3.game.Position;


public class Main {

    public static void main(String[] args) {
        //GameState will track the board and player turns.
        GameState game = new GameState();
        //
        Console console = new Console();

        //Display welcome message and instruction on how to enter moves
        console.displayMessage("============================");
        console.displayMessage("    Welcome to TicTacToe!");
        console.displayMessage("============================");
        console.displayMessage("How to Play:");
        console.displayMessage(" Enter your move as two values.");
        console.displayMessage(" Format: row column");
        console.displayMessage("    Examples: '1 2' or 't m'");
        console.displayMessage("");
        console.displayMessage("");
        

        // TODO: Initialize a TicTacToe game with a 3x3 board and two players

        while (true) { //loop until game is over
            //Display the board
            console.displayMessage("\n Current board:");
            console.displayMessage(game.getBoard().toString()); //print the current board by converting the board object into a string using its toString() method
            //Check if the game is over or a draw, and if so display the result and exit
            if (game.isGameOver()) {
                //If game is finished, print result and exit the loop
                console.displayMessage(game.getGameResult()); //Get the result of the game message (win or draw) from the Gamestate and print it.
                break;
            }
            
            //Get the next move from the player and update the game state
            Position move = console.getNextMove(game.getCurrentPlayer()); //Display the message for the current player to enter their move and store it as a Position move
        
            if (!game.makeAMove(move)) { //check if the spot is already take, if so it will print an error message and to try again.
                console.displayMessage("\n This position is already taken! Try again.");
            }
        }
    }
}

