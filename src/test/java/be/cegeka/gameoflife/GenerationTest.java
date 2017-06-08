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
        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(false), new Cell(true),
                new Cell(false), new Cell(false), new Cell(true),
                new Cell(true), new Cell(true), new Cell(false)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(0,2).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(2,0).isAlive()).isEqualTo(false);
    }

    @Test
    public void tick_WhenAliveCellHas2or3AliveNeighbours_ShouldReturnAliveCell() throws Exception {
        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(false), new Cell(true),
                new Cell(false), new Cell(false), new Cell(true),
                new Cell(true), new Cell(true), new Cell(false)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(1,2).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(2,1).isAlive()).isEqualTo(true);
    }

    @Test
    public void tick_WhenAliveCellHas4orMoreAliveNeighbours_ShouldReturnADeadCell() throws Exception {
        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(true), new Cell(true),
                new Cell(true), new Cell(true), new Cell(true),
                new Cell(false), new Cell(true), new Cell(false)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,1).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,1).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,2).isAlive()).isEqualTo(false);
    }

    @Test
    public void tick_WhenDeadCellHas3AliveNeighbours_ShouldReturnAliveCell() throws Exception {
        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(false), new Cell(true),
                new Cell(false), new Cell(false), new Cell(true),
                new Cell(true), new Cell(true), new Cell(false)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(1,0).isAlive()).isEqualTo(true);
    }

    @Test
    public void tick_WhenGivenASquareWorld_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(true), new Cell(false),
                new Cell(false), new Cell(true), new Cell(true),
                new Cell(true), new Cell(true), new Cell(false)))).buildWorld();

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
        world = new World.WorldBuilder().withRows(3).withColumns(4).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(true), new Cell(false), new Cell(true),
                new Cell(false), new Cell(true), new Cell(true), new Cell(false),
                new Cell(true), new Cell(true), new Cell(false), new Cell(true)))).buildWorld();

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
        world = new World.WorldBuilder().withRows(4).withColumns(1).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true),
                new Cell(false),
                new Cell(true),
                new Cell(false)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(1,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(2,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(3,0).isAlive()).isEqualTo(false);
    }

    @Test
    public void tick_WhenGivenWorldWith1RowsAnd4Columns_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new World.WorldBuilder().withRows(1).withColumns(4).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(true), new Cell(true), new Cell(false)))).buildWorld();

        Assertions.assertThat(generation.tick(world).getCell(0,0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(0,1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getCell(0,2).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getCell(0,3).isAlive()).isEqualTo(false);
    }
}
