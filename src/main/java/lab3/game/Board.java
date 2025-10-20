package lab3.game;

public class Board {
    //encapsulate the representation of the tictactoe board and provide instance methods to access and update it
    private char[][] board;

    public Board() {
        board = new char [3][3]; //create a 3x3 grid and represented as board
        
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                board[i][j] = ' '; //set all the spot or position empty initially
            }
        }
    }

// convert the row enum (TOP, MIDDLE, BOTTOM) to its corresponding index in the array.
private int convertRow(Row row) {
    switch (row) {
        case TOP: return 0;  //array 0
        case MIDDLE: return 1;  //array 1
        case BOTTOM: return 2; // array 2

    }
    return 1;
}
//convert the column enum (LEFT, MIDDLE, RIGHT) to its corresponding index in the array
private int convertColumn(Column column) {
    switch (column) {
        case LEFT: return 0;
        case MIDDLE: return 1;
        case RIGHT: return 2;
    }
    return 1;
}
//Try to place the player's move on the board if the board is empty
public boolean playerMove(Position position, char playerSymbol) {
    int row = convertRow(position.row()); //get the row index from the enum
    int column = convertColumn(position.column()); //get the column index from the enum
    //converted postion into a board.
    if (board[row][column] == ' ') {  //place the move only if spot is empty
        board[row][column] = playerSymbol; //place the move on the board
        return true; //Move was successful
    }
    return false; //spot is already taken.
}

//check for winner
public char checkWinner() {
    //check rows for winning combinations
    for (int i = 0; i <3; i++) {
        //check if the row has three identical non-empty marks.
        //check first spot if filled, if not empty, it must be 'X' or 'O'. Does the first spot match the second spot? Does the second spot match the third spot?
        if (board[i][0] != ' ' && board [i][0] == board[i][1] && board [i][1] == board[i][2]) {          
                //if all conditions are true, return the winning player's symbol. 
            return board [i][0];
        }
    }
    // check columns for winning combinations
    for (int j = 0; j < 3; j++) {
        ////check if the column has three identical non-empty marks.
        if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
            return board [0][j]; //if all conditions are true, return the winning player's symbol. 
        }
    }
    //check diagonals for any winning combinations
    if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
        return board[0][0]; //if all conditions are true, return the winning player's symbol. 
    }
    if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
        return board[0][2]; //if all conditions are true, return the winning player's symbol. 
    }

    return ' '; // No winner
}   
//check if the game is a draw by checking every spot for an empty space first.
public boolean isDraw() { //loop to check all the spot on the board
    for (int i=0; i<3; i++) {
        for (int j=0; j<3; j++) {
            if (board[i][j] == ' ') { //check for empty space. 
                return false;  //If there is atleast one spot empty, game is still active.
            }
        }
    }
    return true; //all spots were checked and none were empty. It's a draw!
}
//convert the board to a readable string format for printing
@Override //annotation

public String toString() {
    StringBuilder sb = new StringBuilder(); //use StringBuilder to build the string to represent the board. StringBuilder allows to append strings together.
    sb.append(" ").append(board[0][0]).append(" | ").append(board[0][1]).append(" | ").append(board[0][2]).append("\n"); //formatting for the first row of the board.
    sb.append(" ---------\n"); //separate first row from second row
    sb.append(" ").append(board[1][0]).append(" | ").append(board[1][1]).append(" | ").append(board[1][2]).append("\n");//formatting for the second row of the board.
    sb.append(" ---------\n"); //separate second row from third row
    sb.append(" ").append(board[2][0]).append(" | ").append(board[2][1]).append(" | ").append(board[2][2]).append("\n");//formatting for the third row of the board.

    return sb.toString(); // return the string built by the StringBuilder
}
}
