package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class WorldTest {

    private World world;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testIfWorldGetGrid_ReturnsFilledInGrid() throws Exception {
        world = new World(3,new Cell(true), new Cell(false), new Cell(true),
            new Cell(false), new Cell(false), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));


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
        world = new World(3,new Cell(true), new Cell(false), new Cell(true),
            new Cell(false), new Cell(false), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));

        Assertions.assertThat(world.getGrid().get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidGridColumn_ReturnsIndexOutOfBoundException() throws Exception {
        world = new World(3,new Cell(true), new Cell(false), new Cell(true),
            new Cell(false), new Cell(false), new Cell(true),
            new Cell(true), new Cell(true), new Cell(false));

        Assertions.assertThat(world.getGrid().get(0).get(9));
    }

    @Test
    public void getNumberOfAliveNeighbours_ReturnsTheAmmountOfAliveNeighbours() throws Exception {
        world = new World(3,new Cell(true), new Cell(false), new Cell(true),
                                                 new Cell(false), new Cell(false), new Cell(true),
                                                 new Cell(true), new Cell(true), new Cell(false));

        Assertions.assertThat(world.getNumberOfAliveNeighbours(0,0)).isEqualTo(0);
        Assertions.assertThat(world.getNumberOfAliveNeighbours(0,1)).isEqualTo(3);
        Assertions.assertThat(world.getNumberOfAliveNeighbours(0,2)).isEqualTo(1);
        Assertions.assertThat(world.getNumberOfAliveNeighbours(1,0)).isEqualTo(3);
        Assertions.assertThat(world.getNumberOfAliveNeighbours(1,1)).isEqualTo(5);
        Assertions.assertThat(world.getNumberOfAliveNeighbours(1,2)).isEqualTo(2);
        Assertions.assertThat(world.getNumberOfAliveNeighbours(2,0)).isEqualTo(1);
        Assertions.assertThat(world.getNumberOfAliveNeighbours(2,1)).isEqualTo(2);
        Assertions.assertThat(world.getNumberOfAliveNeighbours(2,2)).isEqualTo(2);
    }


}