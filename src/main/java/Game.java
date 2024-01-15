import java.util.Arrays;

public class Game {
    public int score(int[] roll, String category) {
        int score = 0;
        switch (category) {
            case "yatzy":
                if (Arrays.stream(roll).allMatch(i -> i == roll[0])) {
                    score = 50;
                }

                break;
            case "ones":
                score = (int) Arrays.stream(roll).filter(i -> i == 1).count();

                break;
            case "twos": {
                int quantityOfFours = (int) Arrays.stream(roll).filter(i -> i == 2).count();
                score = 2 * quantityOfFours;

                break;
            }
            case "threes": {
                int quantityOfFours = (int) Arrays.stream(roll).filter(i -> i == 3).count();
                score = 3 * quantityOfFours;

                break;
            }
            case "fours": {
                int quantityOfFours = (int) Arrays.stream(roll).filter(i -> i == 4).count();
                score = 4 * quantityOfFours;

                break;
            }
            case "fives": {
                int quantityOfFours = (int) Arrays.stream(roll).filter(i -> i == 5).count();
                score = 5 * quantityOfFours;

                break;
            }
            default:
                score = sumOfAllDice(roll, score);
                break;
        }

        return score;
    }

    private int sumOfAllDice(int[] roll, int score) {
        for (int dice : roll) {
            score += dice;
        }
        return score;
    }

}
