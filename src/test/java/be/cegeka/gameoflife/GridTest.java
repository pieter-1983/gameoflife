package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class GridTest {

    private Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = new Grid(3);

    }

    @Test
    public void testIfPopulateGrid_ReturnsFilledInGrid() throws Exception {
        grid.populate(new Cell(true), new Cell(false), new Cell(true),
                      new Cell(false), new Cell(false), new Cell(true),
                      new Cell(true), new Cell(true), new Cell(false));
        Assertions.assertThat(grid.getGrid()[0][0].isAlive()).isEqualTo(true);
        Assertions.assertThat(grid.getGrid()[0][1].isAlive()).isEqualTo(false);
        Assertions.assertThat(grid.getGrid()[0][2].isAlive()).isEqualTo(true);
        Assertions.assertThat(grid.getGrid()[1][0].isAlive()).isEqualTo(false);
        Assertions.assertThat(grid.getGrid()[1][1].isAlive()).isEqualTo(false);
        Assertions.assertThat(grid.getGrid()[2][0].isAlive()).isEqualTo(true);
        Assertions.assertThat(grid.getGrid()[2][1].isAlive()).isEqualTo(true);
        Assertions.assertThat(grid.getGrid()[2][2].isAlive()).isEqualTo(false);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIfInvalidGridLocation_ReturnsIndexOutOfBoundException() throws Exception {

        Assertions.assertThat(grid.getGrid()[3][0]);


    }
}
