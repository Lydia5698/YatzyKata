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

    @Test
    public void rollDicesWithTwoFours(){
        int[] roll = {1,1,2,4,4};
        assertThat(game.score(roll,"fours") ,is(8));
    }

    @Test
    public void rollDicesWithTwoTwos(){
        int[] roll = {2,3,2,5,1};
        assertThat(game.score(roll,"twos") ,is(4));
    }

    @Test
    public void rollDicesWithNoOneExpectedZero(){
        int[] roll = {3,3,3,4,5};
        assertThat(game.score(roll,"ones") ,is(0));
    }

    @Test
    public void rollAPairWithTwoFours(){
        int[] roll = {3,3,6,4,4};
        assertThat(game.score(roll,"pair"), is(8));
    }

    @Test
    public void rollAPairWithFourFours(){
        int[] roll = {4,4,6,4,4};
        assertThat(game.score(roll,"pair"), is(8));
    }

    @Test
    public void rollAPairWithNoPair(){
        int[] roll = {1,2,3,4,5};
        assertThat(game.score(roll,"pair"), is(0));
    }

    @Test
    public void rollTwoPairsWithTwoOnesAndTwoThrees(){
        int[] roll = {1,1,2,3,3};
        assertThat(game.score(roll,"two pairs"), is(8));
    }
    @Test
    public void rollTwoPairsWithNoRightPair(){
        int[] roll = {1,2,3,4,5};
        assertThat(game.score(roll,"two pairs"), is(0));
    }

}
