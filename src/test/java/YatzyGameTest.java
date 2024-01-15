import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class YatzyGameTest {

    @Test
    public void rollAChanceWithScoreFourteen(){
        Game game = new Game();
        int[] roll = {1,1,3,3,6};
        assertThat(game.score(roll), is(14));
    }
}
