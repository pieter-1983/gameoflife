package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class RulesTest {

    private World world;
    private Rules rules;


    @Before
    public void setUp() throws Exception {
        world = new World(3);
        world.populate(new Cell(true), new Cell(false), new Cell(true),
            new Cell(false), new Cell(false), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));
        rules = new Rules();

    }


    @Test
    public void checkIfCellDiesInNextGenerationIfITHasFewerThan2LiveNeighbours() throws Exception {
        Assertions.assertThat(rules.tick(world).getGrid()[0][0]).isEqualTo(false);
        Assertions.assertThat(rules.tick(world).getGrid()[0][2]).isEqualTo(false);
        Assertions.assertThat(rules.tick(world).getGrid()[2][0]).isEqualTo(false);

    }
}
