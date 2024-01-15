import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game {
    public int score(int[] roll, String category) {
        switch (category) {
            case "yatzy": {
                return checkYatzy(roll);
            }
            case "ones": {
                return checkAndCalculateTheNumbers(roll, 1);
            }
            case "twos": {
                return checkAndCalculateTheNumbers(roll, 2);
            }
            case "threes": {
                return checkAndCalculateTheNumbers(roll, 3);
            }
            case "fours": {
                return checkAndCalculateTheNumbers(roll, 4);
            }
            case "fives": {
                return checkAndCalculateTheNumbers(roll, 5);
            }
            case "sixes": {
                return checkAndCalculateTheNumbers(roll, 6);
            }
            case "pair": {
                return  checkAndCalculateAPair(roll);
            }
            case "two pairs": {
                return checkAndCalculateTwoPairs(roll);

            }
            case "three of a kind": {
                return checkAndCalculateThreeOfAKind(roll);
            }
            case "four of a kind":{
                int[] duplicateNumbers = getAllDuplicates(roll);
                if (Arrays.stream(duplicateNumbers).count() >=3){
                    return 4 * duplicateNumbers[0];
                }
                return 0;
            }
            default:
                return sumOfAllDice(roll);
            }
    }

    private int checkAndCalculateThreeOfAKind(int[] roll) { // // TODO: 15.01.24 Überarbeiten
        int[] duplicateNumbers = getAllDuplicates(roll);
        if (duplicateNumbers.length == 0){
            return 0;
        }
        else if (duplicateNumbers[0] == duplicateNumbers[1]){
            return 3 * duplicateNumbers[0];
        }
        else if(duplicateNumbers[1] == duplicateNumbers[2]){
            return 3 * duplicateNumbers[1];
        }
        return 0;
    }

    private int checkAndCalculateTwoPairs(int[] roll) {
        int score = 0;
        int[] duplicateNumbers = getAllDuplicates(roll);
        for (int duplicateNumber : duplicateNumbers) {
            score += 2 * duplicateNumber;
        }
        return score;
    }

    private int checkAndCalculateAPair(int[] roll) {
        int highestNumberInRoll;
        int[] duplicateNumbers = getAllDuplicates(roll);

        if (Arrays.stream(duplicateNumbers).max().isPresent()){
            highestNumberInRoll = Arrays.stream(duplicateNumbers).max().getAsInt();
            return 2 * highestNumberInRoll;
        }
        return 0;

    }

    private int[] getAllDuplicates(int[] roll) {
        Set<Integer> distinctNumbersSet  = new HashSet<>();
        return Arrays.stream(roll).filter(e -> !distinctNumbersSet.add(e)).toArray();
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
