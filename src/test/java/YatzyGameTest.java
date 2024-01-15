import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class YatzyGameTest {
    Game game;
    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void rollAChanceWithScoreFourteen(){
        int[] roll = {1,1,3,3,6};
        assertThat(game.score(roll, "chance"), is(14));
    }

    @Test
    public void rollAYatzyWithOnes(){
        int[] roll = {1,1,1,1,1};
        assertThat(game.score(roll, "yatzy"), is(50));
    }

    @Test
    public void rollAYatzyWithOnesAndOneTwoExpectZero(){
        int[] roll = {1,2,1,1,1};
        assertThat(game.score(roll, "yatzy"), is(0));
    }
}
