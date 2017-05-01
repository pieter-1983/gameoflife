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
        grid.populate(true, false, true,
            false, false, true,
            true, true, false);
        Assertions.assertThat(grid.getGrid()[0][0]).isEqualTo(true);
        Assertions.assertThat(grid.getGrid()[0][1]).isEqualTo(false);
        Assertions.assertThat(grid.getGrid()[0][2]).isEqualTo(true);
        Assertions.assertThat(grid.getGrid()[1][0]).isEqualTo(false);
        Assertions.assertThat(grid.getGrid()[1][1]).isEqualTo(false);
        Assertions.assertThat(grid.getGrid()[2][0]).isEqualTo(true);
        Assertions.assertThat(grid.getGrid()[2][1]).isEqualTo(true);
        Assertions.assertThat(grid.getGrid()[2][2]).isEqualTo(false);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIfInvalidGridLocation_ReturnsIndexOutOfBoundException() throws Exception {

        Assertions.assertThat(grid.getGrid()[3][0]);


    }
}
