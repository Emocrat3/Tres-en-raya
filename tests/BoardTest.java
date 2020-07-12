import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void testBoardHasSize(){
        ArrayList<BoardFila> filas = new ArrayList<>();
        Board board = new Board (3,filas);

        assertEquals(3, board.size);
    }

    @Test
    public void testFilasHasRowsCount(){
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board (boardSize, boardShaper.boardInitialValue());

        assertEquals(boardSize, board.filas.size());
    }

    @Test
    public void testIndexOutOfRangeWhenAttemptSet(){
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board (boardSize, boardShaper.boardInitialValue());

        assertThrows(IllegalArgumentException.class, () ->
                board.setCharToIndex(10, Players.PLAYER1.identifyChar));
    }

    }

