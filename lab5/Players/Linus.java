package tictactoe.players;

import tictactoe.game.Board;
import tictactoe.game.Position;
import tictactoe.game.Col;
import tictactoe.game.Row;

/** Linus is a computer player that picks its position starting from the top-left
*to right, then move down the next row.
 */
public class Linus extends Player {
    public Linus() {
        super("Linus"); 

    }
    /**
     *Pick move by checking position from top-left to bottom-right.
     *If empty position was found, return position
     */

    @Override
    public Position pickNextMove(Board currentBoard) {
        //create arrays of columns and rows to loop
        Col[] cols = {Col.Left, Col.Middle, Col.Right};
        Row[] rows = {Row.Top, Row.Middle, Row.Bottom};

        for (Row row:rows) { // loop each row
            for (Col col:cols) { // loop each column
                Position pos = new Position(row, col); //create position
                if (currentBoard.isEmptyAt(pos) ) { // if empty, return position
                    return pos;
                }
            }
        }
        return null;
    }
}