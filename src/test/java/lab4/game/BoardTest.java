package lab4.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static lab4.game.Board.Status.*;
import static lab4.game.Row.*;
import static lab4.game.Col.*;



public class BoardTest {

    @Test
    void testBoardIsEmpty() {
        var board = new Board();
        assertEquals(InProgress, board.getStatus());

    }

    @Test
    void testPlaceX() {
        var board = new Board();
        Position pos = new Position(Row.Top, Col.Left);
        board.placeX(pos);
        assertTrue(board.isOccupiedAt(pos));
    }

    @Test
    void testPlaceO() {
        var board = new Board();
        Position pos = new Position(Row.Middle, Col.Middle);
        board.placeO(pos);
        assertTrue(board.isOccupiedAt(pos));
    }

    @Test
    void testXWinRow() {
        var board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeX(new Position(Row.Top, Col.Middle));
        board.placeX(new Position(Row.Top, Col.Right));
        assertEquals(XWins, board.getStatus());

    }

    @Test
    void testOWinColumn() {
        var board = new Board();
        board.placeO(new Position(Row.Top, Col.Left));
        board.placeO(new Position(Row.Middle, Col.Left));
        board.placeO(new Position(Row.Bottom, Col.Left));
        assertEquals(OWins, board.getStatus());

    }

    @Test
    void testXWinDiagonal() {
        var board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeX(new Position(Row.Middle, Col.Middle));
        board.placeX(new Position(Row.Bottom, Col.Right));
        assertEquals(XWins, board.getStatus());

    }

    @Test
    void testDraw() {
        var board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeO(new Position(Row.Top, Col.Middle));
        board.placeX(new Position(Row.Top, Col.Right));
        board.placeO(new Position(Row.Middle, Col.Middle));
        board.placeX(new Position(Row.Middle, Col.Left));
        board.placeO(new Position(Row.Bottom, Col.Left));
        board.placeX(new Position(Row.Bottom, Col.Middle));
        board.placeO(new Position(Row.Middle, Col.Right));
        board.placeX(new Position(Row.Bottom, Col.Right));
        assertEquals(Draw, board.getStatus());
    }

    @Test
    void testBoardIsFull() {
        var board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeO(new Position(Row.Top, Col.Middle));
        board.placeX(new Position(Row.Top, Col.Right));
        board.placeO(new Position(Row.Middle, Col.Middle));
        board.placeX(new Position(Row.Middle, Col.Left));
        board.placeO(new Position(Row.Bottom, Col.Left));
        board.placeX(new Position(Row.Bottom, Col.Middle));
        board.placeO(new Position(Row.Middle, Col.Right));
        board.placeX(new Position(Row.Bottom, Col.Right));
        assertTrue(board.isFull());
    }
}