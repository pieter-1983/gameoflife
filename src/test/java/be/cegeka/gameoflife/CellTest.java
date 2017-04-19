package be.cegeka.gameoflife;

import org.junit.Test;

import static be.cegeka.gameoflife.Cell.dead;
import static be.cegeka.gameoflife.Cell.live;
import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {

    @Test
    public void cellIsEqualToAnotherCellWhenAliveIsTheSame() throws Exception {
        assertThat(live()).isEqualTo(live());
        assertThat(dead()).isEqualTo(dead());
        assertThat(live()).isNotEqualTo(dead());
        assertThat(dead()).isNotEqualTo(live());
    }

    @Test
    public void cellsToString_WhenAliveIsTrue_ThenLive() throws Exception {
        assertThat(live().toString()).isEqualTo("live");
    }

    @Test
    public void cellsToString_WhenAliveIsFalse_ThenDead() throws Exception {
        assertThat(dead().toString()).isEqualTo("dead");
    }

}