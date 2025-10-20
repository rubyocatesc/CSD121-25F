package lab3.game;

public class GameState {
    private Board board; //holds the information of the board
    private char currentPlayer; //track the player's turn

    public GameState() {
        board = new Board(); //set an empty board at the start of the game
        currentPlayer = 'X'; // game will always start will with Player X
    }

    public Board getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer; //returns the symbol of the current player
    }
    //current player make a move.
    public boolean makeAMove(Position position) {
        if (board.playerMove(position, currentPlayer)) {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; //this switch the turns, if current player was X, change to O.
            return true; //if move is valid, the switch will happen
        }
        return false; //if spot is already taken, return false
    }

    public boolean isGameOver() {
        return board.checkWinner() != ' ' || board.isDraw();// if game has ended, check if a player won or it's a draw
    }
    // this will show the result of the game
    public String getGameResult() {
        char winner = board.checkWinner(); //check if there is a winner
        if (winner != ' ') { //if winner is not an empty space
            return "Player " + winner + " wins!"; //return the message with the winner's symbol
            
        }
        else if (board.isDraw()) { //if board is full but no winner.
            return "It's a draw!"; //return this message.
        }
        return " "; 
    }
}