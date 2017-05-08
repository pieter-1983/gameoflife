package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class RulesTest {

    private Grid grid;
    private Rules rules;


    @Before
    public void setUp() throws Exception {
        grid = new Grid(3,new Cell(true), new Cell(false), new Cell(true),
            new Cell(false), new Cell(false), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));
        rules = new Rules();

    }


    @Test
    public void checkIfCellDiesInNextGenerationIfITHasFewerThan2LiveNeighbours() throws Exception {
        Assertions.assertThat(rules.tick(grid).getGrid().get(0).get(0).isAlive()).isEqualTo(false);
        Assertions.assertThat(rules.tick(grid).getGrid().get(0).get(2).isAlive()).isEqualTo(false);
        Assertions.assertThat(rules.tick(grid).getGrid().get(2).get(0).isAlive()).isEqualTo(false);

    }
}