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

    @Test
    public void rollThreeOfAKindWithThrees(){
        int[] roll = {3,3,3,3,3};
        assertThat(game.score(roll,"three of a kind"), is(9));
    }
    @Test
    public void rollThreeOfAKindWithAlsoTwoOfAKind(){
        int[] roll = {2,3,3,3,2};
        assertThat(game.score(roll,"three of a kind"), is(9));
    }

    @Test
    public void rollThreeOfAKindNoRightThreeOfAKind(){
        int[] roll = {1,2,3,4,5};
        assertThat(game.score(roll,"three of a kind"), is(0));
    }

    @Test
    public void rollFourOfAKindWithTwos(){
        int[] roll = {3,2,2,2,2};
        assertThat(game.score(roll,"four of a kind"), is(8));
    }
    @Test
    public void rollFourOfAKindWithOnlyTwos(){
        int[] roll = {2,2,2,2,2};
        assertThat(game.score(roll,"four of a kind"), is(8));
    }

    @Test
    public void rollFourOfAKindWithNoFourOfAKind(){
        int[] roll = {2,4,3,1,5};
        assertThat(game.score(roll,"four of a kind"), is(0));
    }

    @Test
    public void rollSmallStraight(){
        int[] roll = {2,1,3,4,5};
        assertThat(game.score(roll,"small straight"), is(15));
    }

    @Test
    public void rollNoRightSmallStraight(){
        int[] roll = {4,2,3,4,5};
        assertThat(game.score(roll,"small straight"), is(0));
    }

    @Test
    public void rollLargeStraight(){
        int[] roll = {2,6,3,4,5};
        assertThat(game.score(roll,"large straight"), is(20));
    }

    @Test
    public void rollNoRightLargeStraight(){
        int[] roll = {1,2,3,4,5};
        assertThat(game.score(roll,"large straight"), is(0));
    }

    @Test
    public void rollFullHouse(){
        int[] roll = {2,1,2,1,2};
        assertThat(game.score(roll,"full house"), is(8));
    }

    @Test
    public void rollNoFullHouse(){
        int[] roll = {1,2,2,3,1};
        assertThat(game.score(roll,"full house"), is(0));
    }

    @Test
    public void rollNoFullHouseWithOnlyTwos(){
        int[] roll = {2,2,2,2,2};
        assertThat(game.score(roll,"full house"), is(0));
    }

}
