package be.cegeka.gameoflife;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapperTest {


    private ArrayList<List<Boolean>> booleanLists;
    private World world;
    private Mapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new Mapper();
    }

    @Test
    public void convertNestedListsOfBooleansToWorld_returnsWorldWithTheSameValuesAndSizesAsTheLists() throws Exception {
        booleanLists = new ArrayList<List<Boolean>>();
        booleanLists.add(new ArrayList(Arrays.asList(true, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(false, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(true, true, false)));

        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(mapper.convertNestedListsOfBooleansToWorld(booleanLists)).isEqualTo(world);

    }

    @Test
    public void convertWorldToNestedListsOfBooleans_returnsBooleanListsWithTheSameValuesAndSizesAsTheWorldObject() throws Exception {
        booleanLists = new ArrayList<List<Boolean>>();
        booleanLists.add(new ArrayList(Arrays.asList(true, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(false, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(true, true, false)));

        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true,0,0), new Cell(false,0,1), new Cell(true,0,2),
                new Cell(false,1,0), new Cell(false,1,1), new Cell(true,1,2),
                new Cell(true,2,0), new Cell(true,2,1), new Cell(false,2,2)))).buildWorld();

        Assertions.assertThat(mapper.convertWorldToNestedListsOfBooleans(world)).isEqualTo(booleanLists);

    }

}
