import java.util.Arrays;

public class Game {
    public int score(int[] roll, String category) {
        int score;
        switch (category) {
            case "yatzy":
                score = checkYatzy(roll);

                break;
            case "ones":
                score = checkAndCalculateTheNumbers(roll,1);

                break;
            case "twos": {
                score = checkAndCalculateTheNumbers(roll, 2);

                break;
            }
            case "threes": {
                score = checkAndCalculateTheNumbers(roll, 3);

                break;
            }
            case "fours": {
                score = checkAndCalculateTheNumbers(roll, 4);

                break;
            }
            case "fives": {
                score = checkAndCalculateTheNumbers(roll, 5);

                break;
            }
            case "sixes": {
                score = checkAndCalculateTheNumbers(roll, 6);

                break;
            }
            case "pair": {
                score = checkAndCalculateAPair(roll);

                break;
            }
            case "two pairs": {
                // zwei Zahlen finden
                for (int i = 0; i < roll.length; i++){
                    score = 0;
                }
                score = 8;

                break;
            }
            default:
                score = sumOfAllDice(roll);
                break;
            }

        return score;
    }

    private int checkAndCalculateAPair(int[] roll) {
        int highestNumberInRoll;
        if (Arrays.stream(roll).max().isPresent()){
            highestNumberInRoll = Arrays.stream(roll).max().getAsInt();
        } else {
            highestNumberInRoll = 0;
        }
        if(Arrays.stream(roll).filter(i -> i == highestNumberInRoll).count() == 2){
            return 2 * highestNumberInRoll;
        }
        return 0;
    }

    private int checkAndCalculateTheNumbers(int[] roll, int number) {
        int quantityOfTheNumber = (int) Arrays.stream(roll).filter(i -> i == number).count();
        return number * quantityOfTheNumber;
    }

    private int checkYatzy(int[] roll) {
        if (Arrays.stream(roll).allMatch(i -> i == roll[0])) {
            return 50;
        }
        return 0;
    }

    private int sumOfAllDice(int[] roll) {
        int score = 0;
        for (int dice : roll) {
            score += dice;
        }
        return score;
    }

}
