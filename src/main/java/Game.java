import javax.sql.rowset.Predicate;
import java.util.Arrays;

public class Game {
    public int score(int[] roll, String category) {
        int score = 0;
        if (category.equals("yatzy")){
            if(Arrays.stream(roll).allMatch(i -> i == roll[0])){
                score = 50;
            }

        }
        else {
            for (int dice : roll) {
                score += dice;
            }
        }

        return score;
    }
}
