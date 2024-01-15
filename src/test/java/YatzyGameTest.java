import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;

public class YatzyGameTest {

    @Test
    public void rollAChanceWithScoreFourteen(){
        Game game = new Game();
        int[] roll = {1,1,3,3,6};
        assertThat(game.score(roll, "chance"), is(14));
    }

    @Test
    public void rollAYatzyWithOnes(){
        Game game = new Game();
        int[] roll = {1,1,1,1,1};
        assertThat(game.score(roll, "yatzy"), is(50));
    }

    @Test
    public void rollAYatzyWithOnesAndOneTwoExpectZero(){
        Game game = new Game();
        int[] roll = {1,2,1,1,1};
        assertThat(game.score(roll, "yatzy"), is(0));
    }
}
