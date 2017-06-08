package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class GenerationTest {

    private World world;
    private Generation generation;


    @Before
    public void setUp() throws Exception {
        generation = new Generation();
    }

    @Test
    public void tick_WhenAliveCellHasFewerThan2AliveNeighbours_ShouldReturnADeadCell() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(0,2).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(2,0).isAlive()).isEqualTo(false);
    }

    @Test
    public void tick_WhenAliveCellHas2or3AliveNeighbours_ShouldReturnAliveCell() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(1,2).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(2,1).isAlive()).isEqualTo(true);
    }

    @Test
    public void tick_WhenAliveCellHas4orMoreAliveNeighbours_ShouldReturnADeadCell() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(true,0,1), new Cell(true,0,2),
                new Cell(true,1,0), new Cell(true,1,1), new Cell(true,1,2),
                new Cell(false,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,1).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,1).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,2).isAlive()).isEqualTo(false);
    }

    @Test
    public void tick_WhenDeadCellHas3AliveNeighbours_ShouldReturnAliveCell() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(1,0).isAlive()).isEqualTo(true);
    }

    @Test
    public void tick_WhenGivenASquareWorld_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(true,0,1), new Cell(false,0,2),
                new Cell(false,1,0), new Cell(true,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,0).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(0,1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(0,2).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(1,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,1).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,2).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(2,0).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(2,1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(2,2).isAlive()).isEqualTo(true);
    }

    @Test
    public void tick_WhenGivenWorldWith3RowsAnd4Columns_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(3).withNumberColumns(4).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0),new Cell(true,0,1), new Cell(false,0,2), new Cell(true,0,3),
                new Cell(false,1,0), new Cell(true,1,1), new Cell(true,1,2), new Cell(false,1,3),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2), new Cell(true,2,3)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,0).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(0,1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(0,2).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(0,3).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,1).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,2).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,3).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(2,0).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(2,1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(2,2).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(2,3).isAlive()).isEqualTo(false);
    }

    @Test
    public void tick_WhenGivenWorldWith4RowsAnd1Column_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(4).withNumberColumns(1).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0),
                new Cell(false,1,0),
                new Cell(true,2,0),
                new Cell(false,3,0)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(2,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(3,0).isAlive()).isEqualTo(false);
    }

    @Test
    public void tick_WhenGivenWorldWith1RowsAnd4Columns_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new World.WorldBuilder().withNumberOfRows(1).withNumberColumns(4).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(true,0,1), new Cell(true,0,2), new Cell(false,0,3)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(0,1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(0,2).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(0,3).isAlive()).isEqualTo(false);
    }
}
