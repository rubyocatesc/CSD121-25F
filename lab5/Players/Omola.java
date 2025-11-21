package tictactoe.players;

import tictactoe.game.Board;
import tictactoe.game.Position;
import java.util.List;

/** Omola is a "One MOve Look-Ahead" computer player.
 * If there is one or more winning mobes, Omola picks one of them.
 * Otherwise, it will block the opponent.
 */
public class Omola extends Player {
    public Omola() {
        super("Omola");
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        List<Position> emptyPositions=currentBoard.getEmptyCells();

        for (Position pos : emptyPositions) {
            Board testBoard = new Board(currentBoard);
            testBoard.placeNextToken(pos);

            if (testBoard.getWinner() != null) {
                return pos;
            }
        }


        for (Position pos:emptyPositions) {
            Board testBoard = new Board(currentBoard);
            testBoard.placeNextToken(pos);


            List<Position> remainingPositions = testBoard.getEmptyCells();
            for (Position opponentPos : remainingPositions) {
                Board opponentTestBoard = new Board(testBoard);
                opponentTestBoard.placeNextToken(opponentPos);

                if (opponentTestBoard.getWinner() != null) {
                    return pos;
                }
            }
        }
        return emptyPositions.get(0);
    }
}