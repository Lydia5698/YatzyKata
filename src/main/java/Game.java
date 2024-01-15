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
                int quantityOfTwos = (int) Arrays.stream(roll).filter(i -> i == 2).count();
                score = 2 * quantityOfTwos;

                break;
            }
            case "threes": {
                int quantityOfThrees = (int) Arrays.stream(roll).filter(i -> i == 3).count();
                score = 3 * quantityOfThrees;

                break;
            }
            case "fours": {
                int quantityOfFours = (int) Arrays.stream(roll).filter(i -> i == 4).count();
                score = 4 * quantityOfFours;

                break;
            }
            case "fives": {
                int quantityOfFives = (int) Arrays.stream(roll).filter(i -> i == 5).count();
                score = 5 * quantityOfFives;

                break;
            }
            case "sixes": {
                int quantityOfSixes = (int) Arrays.stream(roll).filter(i -> i == 6).count();
                score = 6 * quantityOfSixes;

                break;
            }
            case "pair": {
                score = 8;

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
