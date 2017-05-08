package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class GridTest {

    private Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = new Grid(3,new Cell(true), new Cell(false), new Cell(true),
            new Cell(false), new Cell(false), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));


    }

    @Test
    public void testIfPopulateGrid_ReturnsFilledInGrid() throws Exception {

        Assertions.assertThat(grid.getGrid().get(0).get(0).isAlive()).isEqualTo(true);
        Assertions.assertThat(grid.getGrid().get(0).get(1).isAlive()).isEqualTo(false);
        Assertions.assertThat(grid.getGrid().get(0).get(2).isAlive()).isEqualTo(true);
        Assertions.assertThat(grid.getGrid().get(1).get(0).isAlive()).isEqualTo(false);
        Assertions.assertThat(grid.getGrid().get(1).get(1).isAlive()).isEqualTo(false);
        Assertions.assertThat(grid.getGrid().get(1).get(2).isAlive()).isEqualTo(true);
        Assertions.assertThat(grid.getGrid().get(2).get(0).isAlive()).isEqualTo(true);
        Assertions.assertThat(grid.getGrid().get(2).get(1).isAlive()).isEqualTo(true);
        Assertions.assertThat(grid.getGrid().get(2).get(2).isAlive()).isEqualTo(false);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIfInvalidGridRow_ReturnsIndexOutOfBoundException() throws Exception {
        Assertions.assertThat(grid.getGrid().get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIfInvalidGridColumn_ReturnsIndexOutOfBoundException() throws Exception {
        Assertions.assertThat(grid.getGrid().get(0).get(9));
    }

    @Test
    public void checkIfGetNumberOfAliveNeighbours_ReturnsTheAmmountOfAliveNeighbours() throws Exception {
        Assertions.assertThat(grid.getNumberOfAliveNeighbours(0,0)).isEqualTo(0);
        Assertions.assertThat(grid.getNumberOfAliveNeighbours(0,1)).isEqualTo(3);
        Assertions.assertThat(grid.getNumberOfAliveNeighbours(0,2)).isEqualTo(1);
        Assertions.assertThat(grid.getNumberOfAliveNeighbours(1,0)).isEqualTo(3);
        Assertions.assertThat(grid.getNumberOfAliveNeighbours(1,1)).isEqualTo(5);
        Assertions.assertThat(grid.getNumberOfAliveNeighbours(1,2)).isEqualTo(2);
        Assertions.assertThat(grid.getNumberOfAliveNeighbours(2,0)).isEqualTo(1);
        Assertions.assertThat(grid.getNumberOfAliveNeighbours(2,1)).isEqualTo(2);
        Assertions.assertThat(grid.getNumberOfAliveNeighbours(2,2)).isEqualTo(2);
    }


}
