public class Game {
    public int score(int[] roll) {
        int score = 0;
        for (int dice : roll) {
            score += dice;
        }
        return score;
    }
}
