import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

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
                return checkAndCalculateFourOfAKind(roll);
            }
            case "small straight": {
                return checkAndCalculateSmallStraight(roll);
            }
            case "large straight":{
                return checkAndCalculateLargeStraight(roll);
            }
            case "full house": {
                return checkAndCalculateFullHouse(roll);
            }
            default:
                return sumOfAllDice(roll);
            }
    }

    private int checkAndCalculateFullHouse(int[] roll) {
        int[] duplicateNumbers = getAllDuplicates(roll);
        if (duplicateNumbers.length == 3){
            return sumOfAllDice(roll);
        }
        return 0;
    }

    private int checkAndCalculateLargeStraight(int[] roll) {
        int[] largeStraight = {2,3,4,5,6};
        int score = 0;
        Arrays.sort(roll);
        if(Arrays.equals(roll, largeStraight)){
            score = 20;
        }
        return score;
    }

    private int checkAndCalculateSmallStraight(int[] roll) {
        int[] smallStraight = {1,2,3,4,5};
        Arrays.sort(roll);
        if(Arrays.equals(roll, smallStraight)){
            return 15;
        }
        return 0;
    }

    private int checkAndCalculateFourOfAKind(int[] roll) {
        int[] duplicateNumbers = getAllDuplicates(roll);
        if (duplicateNumbers.length >= 3){
            return 4 * duplicateNumbers[0];
        }
        return 0;
    }

    private int checkAndCalculateThreeOfAKind(int[] roll) { // // TODO: 15.01.24 gehts besser? Mit Stream Anzahl der gleichen Zahlen
        int[] duplicateNumbers = getAllDuplicates(roll);

        if (duplicateNumbers.length >= 3) {
            if (duplicateNumbers[0] == duplicateNumbers[1] || duplicateNumbers[0] == duplicateNumbers[2]){
                return 3 * duplicateNumbers[0];
            }
            if (duplicateNumbers[1] == duplicateNumbers[2]){
                return 3 * duplicateNumbers[1];
            }
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
