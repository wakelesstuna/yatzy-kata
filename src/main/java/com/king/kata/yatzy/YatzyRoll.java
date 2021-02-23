package com.king.kata.yatzy;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

public class YatzyRoll {
	private final int[] dice;

	public YatzyRoll(int d1, int d2, int d3, int d4, int d5) {
		dice = new int[]{d1, d2, d3, d4, d5};
	}

	public int[] getDice() {
		return checkIfAllPositives(dice);
	}

	public int[] getSortedArray() {
		return getDiceAsStream().sorted().toArray();
	}

	public IntStream getDiceAsStream(){
		return Arrays.stream(checkIfAllPositives(dice));
	}



	private int[] checkIfAllPositives(int[] ints){
		if (Arrays.stream(ints).allMatch(e -> e >= 1)){
			return ints;
		} else {
			throw new InputMismatchException();
		}
	}

}
