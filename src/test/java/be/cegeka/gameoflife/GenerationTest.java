package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class GenerationTest {

    private List<List<Boolean>> world;
    private Generation generation;


    @Before
    public void setUp() throws Exception {
        generation = new Generation();
    }

    @Test
    public void tick_WhenAliveCellHasFewerThan2AliveNeighbours_ShouldReturnADeadCell() throws Exception {
        world = new ArrayList<List<Boolean>>();
        world.add(new ArrayList(Arrays.asList(true, false, true)));
        world.add(new ArrayList(Arrays.asList(false, false, true)));
        world.add(new ArrayList(Arrays.asList(true, true, false)));

        Assertions.assertThat(generation.tick(world).get(0).get(0)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(0).get(2)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(2).get(0)).isEqualTo(false);
    }

    @Test
    public void tick_WhenAliveCellHas2or3AliveNeighbours_ShouldReturnAliveCell() throws Exception {
        world = new ArrayList<List<Boolean>>();
        world.add(new ArrayList(Arrays.asList(true, false, true)));
        world.add(new ArrayList(Arrays.asList(false, false, true)));
        world.add(new ArrayList(Arrays.asList(true, true, false)));

        Assertions.assertThat(generation.tick(world).get(1).get(2)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(2).get(1)).isEqualTo(true);
    }

    @Test
    public void tick_WhenAliveCellHas4orMoreAliveNeighbours_ShouldReturnADeadCell() throws Exception {
        world = new ArrayList<List<Boolean>>();
        world.add(new ArrayList(Arrays.asList(true, true, true)));
        world.add(new ArrayList(Arrays.asList(true, true, true)));
        world.add(new ArrayList(Arrays.asList(false, true, false)));

        Assertions.assertThat(generation.tick(world).get(0).get(1)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(0)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(1)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(2)).isEqualTo(false);
    }

    @Test
    public void tick_WhenDeadCellHas3AliveNeighbours_ShouldReturnAliveCell() throws Exception {
        world = new ArrayList<List<Boolean>>();
        world.add(new ArrayList(Arrays.asList(true, false, true)));
        world.add(new ArrayList(Arrays.asList(false, false, true)));
        world.add(new ArrayList(Arrays.asList(true, true, false)));

        Assertions.assertThat(generation.tick(world).get(0).get(1)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(1).get(0)).isEqualTo(true);
    }

    @Test
    public void tick_WhenGivenASquareWorld_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new ArrayList<List<Boolean>>();
        world.add(new ArrayList(Arrays.asList(true, true, false)));
        world.add(new ArrayList(Arrays.asList(false, true, true)));
        world.add(new ArrayList(Arrays.asList(true, true, false)));

        Assertions.assertThat(generation.tick(world).get(0).get(0)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(0).get(1)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(0).get(2)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(1).get(0)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(1)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(2)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(2).get(0)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(2).get(1)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(2).get(2)).isEqualTo(true);
    }

    @Test
    public void tick_WhenGivenWorldWith3RowsAnd4Columns_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new ArrayList<List<Boolean>>();
        world.add(new ArrayList(Arrays.asList(true, true, false, true)));
        world.add(new ArrayList(Arrays.asList(false, true, true, false)));
        world.add(new ArrayList(Arrays.asList(true, true, false, true)));

        Assertions.assertThat(generation.tick(world).get(0).get(0)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(0).get(1)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(0).get(2)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(0).get(3)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(0)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(1)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(2)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(3)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(2).get(0)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(2).get(1)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(2).get(2)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(2).get(3)).isEqualTo(false);
    }

    @Test
    public void tick_WhenGivenWorldWith4RowsAnd1Column_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new ArrayList<List<Boolean>>();
        world.add(new ArrayList(Arrays.asList(true)));
        world.add(new ArrayList(Arrays.asList(false)));
        world.add(new ArrayList(Arrays.asList(true)));
        world.add(new ArrayList(Arrays.asList(false)));

        Assertions.assertThat(generation.tick(world).get(0).get(0)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(1).get(0)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(2).get(0)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(3).get(0)).isEqualTo(false);
    }

    @Test
    public void tick_WhenGivenWorldWith1RowsAnd4Columns_ShouldReturnANewWorldPopulatedByGameOfLiveRules() throws Exception {
        world = new ArrayList<List<Boolean>>();
        world.add(new ArrayList(Arrays.asList(true,true,true,false)));


        Assertions.assertThat(generation.tick(world).get(0).get(0)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(0).get(1)).isEqualTo(true);
        Assertions.assertThat(generation.tick(world).get(0).get(2)).isEqualTo(false);
        Assertions.assertThat(generation.tick(world).get(0).get(3)).isEqualTo(false);
    }
}
