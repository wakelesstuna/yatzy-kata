package com.king.kata.yatzy;

import java.util.*;

public class YatzyScorer {

    public int calculateScore(Category category, YatzyRoll roll) {
        switch (category) {
            case CHANCE -> { return chance(roll);}
            case YATZY -> { return yatzy(roll);}
            case ONES -> { return countDiceSum(roll,1);}
            case TWOS -> { return countDiceSum(roll,2);}
            case THREES -> { return  countDiceSum(roll,3);}
            case FOURS -> { return countDiceSum(roll,4);}
            case FIVES -> { return countDiceSum(roll,5);}
            case SIXES -> { return countDiceSum(roll,6);}
            case PAIR ->  { return pair(roll);}
            case TWO_PAIR -> { }
            case THREE_OF_A_KIND -> { return threeOrFourOfKind(roll, 3);}
            case FOUR_OF_A_KIND -> { return threeOrFourOfKind(roll, 4);}
            case SMALL_STRAIGHT -> { return smallOrLargeStraight(roll,1);}
            case LARGE_STRAIGHT -> { return smallOrLargeStraight(roll,2);}
            case FULL_HOUSE -> { return fullHouse(roll); }
        }
        return 0;
    }

    public int chance(YatzyRoll roll){
        return roll.getDiceAsStream().sum();
    }

    public int yatzy(YatzyRoll roll){
        int i = roll.getDice()[0];
        return roll.getDiceAsStream().allMatch(e -> e == i) ? 50 : 0;
    }

    public int countDiceSum(YatzyRoll roll, int numberChoice){
        return (int) roll.getDiceAsStream().filter(e -> e == numberChoice).count() * numberChoice;
    }

    public int pair(YatzyRoll roll){
        int[] temp = roll.getDice();
        while (true) {
            int highestNumber = Arrays.stream(temp).max().getAsInt();
            if (Arrays.stream(temp).filter(e -> e == highestNumber).count() >= 2) {
                return highestNumber * 2;
            }
            temp = Arrays.stream(temp).filter(e -> e != highestNumber).toArray();
            if (temp.length == 0) {
                return 0;
            }
        }
    }

    public int threeOrFourOfKind(YatzyRoll roll, int threeOrFour){
        int[] temp = roll.getDice();
        do {
            int highestNumber = Arrays.stream(temp).max().getAsInt();
            if (Arrays.stream(temp).filter(e -> e == highestNumber).count() >= threeOrFour) {
                return highestNumber * threeOrFour;
            }
            temp = Arrays.stream(temp).filter(e -> e != highestNumber).toArray();
            if (temp.length == 0) {
                return 0;
            }
        } while (true);
    }

    public int smallOrLargeStraight(YatzyRoll roll, int straightStartNumber){
        int score = 0;
        int[] temp = roll.getSortedArray();
        if (temp[0] == straightStartNumber) {
            int k = straightStartNumber - 1;
            for (int i : temp) {
                if (i > k && i < k + 2) {
                    score += i;
                }else {
                    return 0;
                }
                k = i;
            }
        }
        return score;
    }

    public int fullHouse(YatzyRoll roll){
        int[] temp = roll.getSortedArray();
        int firstNumber = (int) Arrays.stream(temp).filter(e -> e == temp[0]).count();
        if (firstNumber == 2 ^ firstNumber == 3){
            int lastNumber = (int) Arrays.stream(temp).filter(e -> e == temp[4]).count();
            if (lastNumber == 2 ^ lastNumber == 3){
                return Arrays.stream(temp).sum();
            }
        }
        return 0;
    }
}

