package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class GenerationTest {

    private World world;
    private Generation generation;


    @Before
    public void setUp() throws Exception {
        generation = new Generation();
    }


    @Test
    public void tick_WhenAliveCellHasFewerThan2AliveNeighbours_ShouldReturnADeadCell() throws Exception {
        world = new World(3,
            new Cell(true), new Cell(false), new Cell(true),
            new Cell(false), new Cell(false), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));

        Assertions.assertThat(generation.tick(world).getGrid().get(0).get(0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getGrid().get(0).get(2).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getGrid().get(2).get(0).isAlive()).isEqualTo(false);
    }
    @Test
    public void tick_WhenAliveCellHas2or3AliveNeighbours_ShouldReturnAliveCell() throws Exception {
        world = new World(3,
            new Cell(true), new Cell(false), new Cell(true),
            new Cell(false), new Cell(false), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));

        Assertions.assertThat(generation.tick(world).getGrid().get(1).get(2).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getGrid().get(2).get(1).isAlive()).isEqualTo(true);
    }
    @Test
    public void tick_WhenAliveCellHas4orMoreAliveNeighbours_ShouldReturnADeadCell() throws Exception {
        world = new World(3,
            new Cell(true), new Cell(true), new Cell(true),
            new Cell(false), new Cell(true), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));

        Assertions.assertThat(generation.tick(world).getGrid().get(0).get(1).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getGrid().get(1).get(1).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getGrid().get(1).get(2).isAlive()).isEqualTo(false);
    }
    @Test
    public void tick_WhenDeadCellHas3AliveNeighbours_ShouldReturnAliveCell() throws Exception {
        world = new World(3,
            new Cell(true), new Cell(false), new Cell(true),
            new Cell(false), new Cell(false), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));

        Assertions.assertThat(generation.tick(world).getGrid().get(0).get(1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getGrid().get(1).get(0).isAlive()).isEqualTo(true);
    }

    @Test
    public void tick_WhenGivenAWorld_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new World(3,
            new Cell(true), new Cell(true), new Cell(false),
            new Cell(false), new Cell(true), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));

        Assertions.assertThat(generation.tick(world).getGrid().get(0).get(0).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getGrid().get(0).get(1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getGrid().get(0).get(2).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getGrid().get(1).get(0).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getGrid().get(1).get(1).isAlive()).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).getGrid().get(1).get(2).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getGrid().get(2).get(0).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getGrid().get(2).get(1).isAlive()).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).getGrid().get(2).get(2).isAlive()).isEqualTo(true);
    }
}
