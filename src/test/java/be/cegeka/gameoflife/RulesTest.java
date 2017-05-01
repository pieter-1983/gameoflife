package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class RulesTest {

    private Grid grid;
    private Rules rules;


    @Before
        public void setUp() throws Exception {
            grid = new Grid(3);
            grid.populate(true, false, true,
                                   false, false, true,
                                   true, true, false);
            rules =new Rules();

        }



    @Test
    public void checkIfCellDiesInNextGenerationIfITHasFewerThan2LiveNeighbours  () throws Exception {
        Assertions.assertThat(rules.tick(grid).getGrid()[0][0]).isEqualTo(false);

    }
}
