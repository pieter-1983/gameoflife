package be.cegeka.gameoflife;

import org.junit.Ignore;
import org.junit.Test;

import static be.cegeka.gameoflife.Cell.dead;
import static be.cegeka.gameoflife.Cell.live;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class GenerationTest {

    @Test
    public void getLiveNeighbours_NoCellAtPosition_ReturnsEmptyList() throws Exception {
        Generation generationWithOneCell = Generation.of(asList(dead()));
        assertThat(generationWithOneCell.getLiveNeighbours(0,1)).isEmpty();
    }

    @Test
    public void getLiveNeighbours_CellAtPositionHasOnlyLiveNeighbours_ReturnsAllNeighbourCells() throws Exception {
        Generation generationWithOneCell = Generation.of
                ( asList(live(), live(), live())
                , asList(live(), live(), live())
                , asList(live(), live(), live())
                );
        assertThat(generationWithOneCell.getLiveNeighbours(1,1)).hasSize(8);
    }

    @Test
    @Ignore("still implementing other tests")
    public void getLiveNeighbours_CellAtPositionHasOnlyDeadNeighbours_ReturnsEmptyList() throws Exception {

    }
}