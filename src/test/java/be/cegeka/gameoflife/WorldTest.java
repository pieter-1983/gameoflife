package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class WorldTest {

    private World world;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testIfWorldGetGrid_ReturnsFilledInGrid() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(world.getGrid().get(0).get(0).isAlive()).isEqualTo(true);
        Assertions.assertThat(world.getGrid().get(0).get(1).isAlive()).isEqualTo(false);
        Assertions.assertThat(world.getGrid().get(0).get(2).isAlive()).isEqualTo(true);
        Assertions.assertThat(world.getGrid().get(1).get(0).isAlive()).isEqualTo(false);
        Assertions.assertThat(world.getGrid().get(1).get(1).isAlive()).isEqualTo(false);
        Assertions.assertThat(world.getGrid().get(1).get(2).isAlive()).isEqualTo(true);
        Assertions.assertThat(world.getGrid().get(2).get(0).isAlive()).isEqualTo(true);
        Assertions.assertThat(world.getGrid().get(2).get(1).isAlive()).isEqualTo(true);
        Assertions.assertThat(world.getGrid().get(2).get(2).isAlive()).isEqualTo(false);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidGridRow_ReturnsIndexOutOfBoundException() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(world.getGrid().get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidGridColumn_ReturnsIndexOutOfBoundException() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(world.getGrid().get(0).get(3));
    }

    @Test
    public void getNumberOfAliveNeighbours_ReturnsTheAmmountOfAliveNeighbours() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();


        Assertions.assertThat(world.getCell(0, 0).getNumberOfAliveNeighbours(world)).isEqualTo(0);
        Assertions.assertThat(world.getCell(0, 1).getNumberOfAliveNeighbours(world)).isEqualTo(3);
        Assertions.assertThat(world.getCell(0, 2).getNumberOfAliveNeighbours(world)).isEqualTo(1);
        Assertions.assertThat(world.getCell(1, 0).getNumberOfAliveNeighbours(world)).isEqualTo(3);
        Assertions.assertThat(world.getCell(1, 1).getNumberOfAliveNeighbours(world)).isEqualTo(5);
        Assertions.assertThat(world.getCell(1, 2).getNumberOfAliveNeighbours(world)).isEqualTo(2);
        Assertions.assertThat(world.getCell(2, 0).getNumberOfAliveNeighbours(world)).isEqualTo(1);
        Assertions.assertThat(world.getCell(2, 1).getNumberOfAliveNeighbours(world)).isEqualTo(2);
        Assertions.assertThat(world.getCell(2, 2).getNumberOfAliveNeighbours(world)).isEqualTo(2);
    }

    @Test
    public void getCell_returnsTheSpecifiedCell() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();


        Assertions.assertThat(world.getCell(1, 2)).isEqualToComparingFieldByField(new Cell(true,1,2));
    }
}
