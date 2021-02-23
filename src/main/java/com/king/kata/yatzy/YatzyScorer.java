package com.king.kata.yatzy;

import java.util.*;
import java.util.stream.Collectors;


public class YatzyScorer {

    public int calculateScore(Category category, YatzyRoll roll) {
        int returnValue = 0;

        switch (category) {
            case CHANCE ->  returnValue = Arrays.stream(roll.getDice()).sum();
            case YATZY -> {
                int i = roll.getDice()[0];
                returnValue = Arrays.stream(roll.getDice()).allMatch(e -> e == i) ? 50 : 0;
            }
            case ONES -> returnValue = (int) Arrays.stream(roll.getDice()).filter(e -> e == 1).count();
            case TWOS -> returnValue = (int) Arrays.stream(roll.getDice()).filter(e -> e == 2).count() * 2;
            case THREES -> returnValue = (int) Arrays.stream(roll.getDice()).filter(e -> e == 3).count() * 3;
            case FOURS -> returnValue = (int) Arrays.stream(roll.getDice()).filter(e -> e == 4).count() * 4;
            case FIVES -> returnValue = (int) Arrays.stream(roll.getDice()).filter(e -> e == 5).count() * 5;
            case SIXES -> returnValue = (int) Arrays.stream(roll.getDice()).filter(e -> e == 6).count() * 6;
            case PAIR -> {
            	int[] temp = roll.getDice();
                while (true) {
                    int highestNumber = Arrays.stream(temp).max().getAsInt();
                    if (Arrays.stream(temp).filter(e -> e == highestNumber).count() >= 2) {
                        returnValue = highestNumber * 2;
                        break;
                    }
                    temp = Arrays.stream(temp).filter(e -> e != highestNumber).toArray();
                    if (temp.length == 0) {
                        break;
                    }
                }
            }
            case TWO_PAIR -> {
            }

            case THREE_OF_A_KIND -> {
                int[] temp = roll.getDice();
				do {
					int highestNumber = Arrays.stream(temp).max().getAsInt();
					if (Arrays.stream(temp).filter(e -> e == highestNumber).count() >= 3) {
						returnValue = highestNumber * 3;
					}
					temp = Arrays.stream(temp).filter(e -> e != highestNumber).toArray();
					if (temp.length == 0) {
						break;
					}
				} while (true);

            }
            case FOUR_OF_A_KIND -> {
                int[] temp = roll.getDice();
				do {
					int highestNumber = Arrays.stream(temp).max().getAsInt();
					if (Arrays.stream(temp).filter(e -> e == highestNumber).count() >= 4) {
						returnValue = highestNumber + highestNumber + highestNumber;
					}
					temp = Arrays.stream(temp).filter(e -> e != highestNumber).toArray();
					if (temp.length == 0) {
						break;
					}
				} while (true);

            }
            case SMALL_STRAIGHT -> {
                int[] temp = Arrays.stream(roll.getDice()).sorted().toArray();
                if (temp[0] == 1) {
                    int k = 0;
                    for (int i : temp) {
                        if (i > k && i < k + 2) {
                            returnValue = 15;
                        } else {
                            returnValue = 0;
                        }
                        k = i;
                    }
                }
            }

            case LARGE_STRAIGHT -> {
                int[] temp = Arrays.stream(roll.getDice()).sorted().toArray();
                if (temp[0] == 2) {
                    int k = 1;
                    for (int i : temp) {
                        if (i > k && i < k + 2) {
                            returnValue += i;
                        } else {
                            returnValue = 0;
                            break;
                        }
                        k = i;
                    }
                }

            }
			case FULL_HOUSE -> {
				int[] temp = Arrays.stream(roll.getDice()).sorted().toArray();
				int firstNumber = (int) Arrays.stream(temp).filter(e -> e == temp[0]).count();
				if (firstNumber == 2 ^ firstNumber == 3){
					int lastNumber = (int) Arrays.stream(temp).filter(e -> e == temp[4]).count();
					if (lastNumber == 2 ^ lastNumber == 3){
						returnValue = Arrays.stream(temp).sum();
					}
				}
			}
        }

        return returnValue;
    }
}

