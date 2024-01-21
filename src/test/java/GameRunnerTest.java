import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import ru.comavp.game.Game;
import ru.comavp.game.GameRunner;
import ru.comavp.players.RandomStrategyPlayer;
import ru.comavp.table.TicTacToeTable;

@RunWith(MockitoJUnitRunner.class)
public class GameRunnerTest {

    @Test
    @Ignore
    public void testWrongDrawSituation() {
        /* Test case (user move)
        * "X", "X", "0",
        * "4", "0", "6",
        * "X", "0", "X"
        * */

        TicTacToeTable table = new TicTacToeTable();
        table.addSymbol(1, "X");
        table.addSymbol(2, "X");
        table.addSymbol(3, "0");
        table.addSymbol(5, "0");
        table.addSymbol(7, "X");
        table.addSymbol(8, "0");
        table.addSymbol(9, "X");

        Game gameRunner = new GameRunner(table, new RandomStrategyPlayer());

        // todo
    }
}
