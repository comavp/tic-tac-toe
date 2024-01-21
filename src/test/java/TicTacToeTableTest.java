import org.junit.Test;
import ru.comavp.table.TicTacToeTable;

import java.util.List;

import static org.junit.Assert.*;

public class TicTacToeTableTest {

    @Test
    public void testIsGameOver() {
        String[] gameNotOver = new String[] {
                "X", "X", "0",
                "0", "0", "X",
                "X", "0", "0"
        };

        String[] gameOver1 = new String[] {
                "X", "X", "X",
                "0", "0", "X",
                "X", "0", "0"
        };
        String[] gameOver2 = new String[] {
                "0", "0", "X",
                "X", "X", "X",
                "X", "0", "0"
        };
        String[] gameOver3 = new String[] {
                "0", "0", "X",
                "X", "0", "0",
                "X", "X", "X"
        };
        String[] gameOver4 = new String[] {
                "0", "0", "X",
                "0", "X", "X",
                "0", "X", "0"
        };
        String[] gameOver5 = new String[] {
                "0", "0", "X",
                "X", "0", "0",
                "X", "0", "X"
        };
        String[] gameOver6 = new String[] {
                "X", "0", "0",
                "X", "X", "0",
                "0", "X", "0"
        };
        String[] gameOver7 = new String[] {
                "X", "0", "0",
                "X", "X", "0",
                "0", "X", "X"
        };
        String[] gameOver8 = new String[] {
                "X", "0", "0",
                "X", "0", "X",
                "0", "X", "0"
        };

        assertFalse(new TicTacToeTable(gameNotOver).isGameOver());

        assertTrue(new TicTacToeTable(gameOver1).isGameOver());
        assertTrue(new TicTacToeTable(gameOver2).isGameOver());
        assertTrue(new TicTacToeTable(gameOver3).isGameOver());

        assertTrue(new TicTacToeTable(gameOver4).isGameOver());
        assertTrue(new TicTacToeTable(gameOver5).isGameOver());
        assertTrue(new TicTacToeTable(gameOver6).isGameOver());

        assertTrue(new TicTacToeTable(gameOver7).isGameOver());
        assertTrue(new TicTacToeTable(gameOver8).isGameOver());
    }

    @Test
    public void testGetEmptyIndexes() {
        TicTacToeTable ticTacToeTable1 = new TicTacToeTable();
        List<Integer> expectedResult1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        TicTacToeTable ticTacToeTable2 = new TicTacToeTable(new String[]{"0", "2", "3", "X", "0", "6", "7", "X", "X"});
        List<Integer> expectedResult2 = List.of(2, 3, 6, 7);

        assertEquals(expectedResult1, ticTacToeTable1.getEmptyIndexes());
        assertEquals(expectedResult2, ticTacToeTable2.getEmptyIndexes());
    }
}
