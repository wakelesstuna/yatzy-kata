package com.king.kata.yatzy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class YatzyTest {

	private YatzyScorer yatzyScorer;

	@BeforeEach
	public void setUp() {
		yatzyScorer = new YatzyScorer();
	}

	@Test
	public void testForExceptions() {
		try {
			yatzyScorer.calculateScore(Category.CHANCE, new YatzyRoll(-1, 2, 1, 4, 6));
			fail();
		} catch (InputMismatchException expectedException) {
		}
	}

	@Test
	public void testIfNotCorrectCategory(){

		int score = yatzyScorer.calculateScore(Category.TEST_ENUM, new YatzyRoll(5, 2, 1, 4, 6));
		assertEquals(0, score);
	}

	@Test
	public void testIfNotCorrectCategory2(){

		int score = yatzyScorer.calculateScore(Category.TEST_ENUM, new YatzyRoll(5, 2, 1, 4, 6));
		assertNotEquals(15, score);
	}


	//------------ CHANCE -----------------\\
	@Test
	public void chanceScoresCorrectly() {
		int score = yatzyScorer.calculateScore(Category.CHANCE, new YatzyRoll(5, 2, 1, 4, 6));
		assertEquals(18, score);
	}

	@Test
	public void chanceScoresNotCorrectly() {
		int score = yatzyScorer.calculateScore(Category.CHANCE, new YatzyRoll(5, 2, 1, 4, 6));
		assertNotEquals(3, score);
	}

	//------------ YATZY -----------------\\
	@Test
	public void yatzyScoresCorrectly() {
		int score = yatzyScorer.calculateScore(Category.YATZY, new YatzyRoll(5, 5, 5, 5, 5));
		assertEquals(50, score);
	}

	@Test
	public void yatzyScoresNotCorrectly() {
		int score = yatzyScorer.calculateScore(Category.YATZY, new YatzyRoll(5, 2, 1, 4, 6));
		assertNotEquals(15, score);
	}

	@Test
	public void countDiceSumCorrect(){
		int score = yatzyScorer.countDiceSum(new YatzyRoll(1, 2, 1, 4, 6), 1);
		assertEquals(2, score);
	}

	@Test
	public void countDiceSumNotCorrect(){
		int score = yatzyScorer.countDiceSum(new YatzyRoll(1, 2, 1, 4, 6), 1);
		assertNotEquals(50, score);
	}

	//------------ ONES -----------------\\
	@Test
	public void countOnesCorrectlyEquals2() {
		int score = yatzyScorer.calculateScore(Category.ONES, new YatzyRoll(1, 2, 1, 4, 6));
		assertEquals(2, score);
	}

	@Test
	public void countOnesCorrectlyEquals3() {
		int score = yatzyScorer.calculateScore(Category.ONES, new YatzyRoll(1, 2, 1, 4, 1));
		assertEquals(3, score);
	}

	@Test
	public void countOnesCorrectlyEquals0() {
		int score = yatzyScorer.calculateScore(Category.ONES, new YatzyRoll(4, 2, 3, 4, 6));
		assertEquals(0, score);
	}

	//------------ TWOS -----------------\\
	@Test
	public void countTwosCorrectlyEquals2() {
		int score = yatzyScorer.calculateScore(Category.TWOS, new YatzyRoll(1, 2, 1, 2, 6));
		assertEquals(4, score);
	}

	@Test
	public void countTwosCorrectlyEquals3() {
		int score = yatzyScorer.calculateScore(Category.TWOS, new YatzyRoll(2, 2, 1, 2, 1));
		assertEquals(6, score);
	}

	@Test
	public void countTwosCorrectlyEquals0() {
		int score = yatzyScorer.calculateScore(Category.TWOS, new YatzyRoll(4, 1, 3, 4, 6));
		assertEquals(0, score);
	}

	//------------ THREES -----------------\\
	@Test
	public void countThreesCorrectlyEquals2() {
		int score = yatzyScorer.calculateScore(Category.THREES, new YatzyRoll(1, 2, 3, 3, 6));
		assertEquals(6, score);
	}

	@Test
	public void countThreesNotCorrectlyEquals3() {
		int score = yatzyScorer.calculateScore(Category.THREES, new YatzyRoll(3, 3, 1, 3, 1));
		assertNotEquals(6, score);
	}

	@Test
	public void countThreesCorrectlyEquals3() {
		int score = yatzyScorer.calculateScore(Category.THREES, new YatzyRoll(3, 3, 1, 3, 1));
		assertEquals(9, score);
	}

	@Test
	public void countThreesCorrectlyEquals0() {
		int score = yatzyScorer.calculateScore(Category.THREES, new YatzyRoll(4, 1, 5, 1, 1));
		assertEquals(0, score);
	}

	//------------ FOURS -----------------\\
	@Test
	public void countFoursCorrectlyEquals4() {
		int score = yatzyScorer.calculateScore(Category.FOURS, new YatzyRoll(1, 4, 3, 3, 6));
		assertEquals(4, score);
	}

	@Test
	public void countThreesNotCorrectlyEquals8() {
		int score = yatzyScorer.calculateScore(Category.FOURS, new YatzyRoll(4, 3, 1, 4, 1));
		assertEquals(8, score);
	}

	@Test
	public void countThreesNotCorrectlyEquals4() {
		int score = yatzyScorer.calculateScore(Category.FOURS, new YatzyRoll(3, 4, 1, 3, 1));
		assertNotEquals(9, score);
	}

	@Test
	public void countThreesNotCorrectlyEquals16() {
		int score = yatzyScorer.calculateScore(Category.FOURS, new YatzyRoll(4, 4, 4, 4, 1));
		assertNotEquals(4, score);
	}

	//------------ FIVES -----------------\\
	@Test
	public void countFivesCorrectlyEquals5() {
		int score = yatzyScorer.calculateScore(Category.FIVES, new YatzyRoll(1, 4, 5, 3, 6));
		assertEquals(5, score);
	}

	@Test
	public void countFivesCorrectlyEquals15() {
		int score = yatzyScorer.calculateScore(Category.FIVES, new YatzyRoll(4, 5, 5, 4, 5));
		assertEquals(15, score);
	}

	@Test
	public void countFivesNotCorrectlyEquals5() {
		int score = yatzyScorer.calculateScore(Category.FIVES, new YatzyRoll(3, 5, 1, 3, 1));
		assertNotEquals(9, score);
	}

	@Test
	public void countFivesNotCorrectlyEquals10() {
		int score = yatzyScorer.calculateScore(Category.FIVES, new YatzyRoll(4, 5, 5, 4, 1));
		assertNotEquals(4, score);
	}

	//------------ SIXES -----------------\\
	@Test
	public void countSixesCorrectlyEquals6() {
		int score = yatzyScorer.calculateScore(Category.SIXES, new YatzyRoll(1, 4, 5, 3, 6));
		assertEquals(6, score);
	}

	@Test
	public void countSixesCorrectlyEquals0() {
		int score = yatzyScorer.calculateScore(Category.SIXES, new YatzyRoll(1, 2, 3, 4, 5));
		assertEquals(0, score);
	}

	@Test
	public void countSixesCorrectlyEquals12() {
		int score = yatzyScorer.calculateScore(Category.SIXES, new YatzyRoll(6, 5, 6, 4, 5));
		assertEquals(12, score);
	}

	@Test
	public void countSixesNotCorrectlyEquals6() {
		int score = yatzyScorer.calculateScore(Category.SIXES, new YatzyRoll(3, 5, 6, 3, 1));
		assertNotEquals(9, score);
	}

	@Test
	public void countSixesNotCorrectlyEquals10() {
		int score = yatzyScorer.calculateScore(Category.SIXES, new YatzyRoll(6, 6, 6, 6, 1));
		assertNotEquals(4, score);
	}

	//------------ PAIR -----------------\\
	@Test
	public void pairTestForOnes() {
		int score = yatzyScorer.calculateScore(Category.PAIR, new YatzyRoll(4, 1, 3, 1, 6));
		assertEquals(2, score);
	}

	@Test
	public void pairTestForOnesWithThreeOnes() {
		int score = yatzyScorer.calculateScore(Category.PAIR, new YatzyRoll(4, 1, 1, 1, 6));
		assertEquals(2, score);
	}

	@Test
	public void pairTestForSixes() {
		int score = yatzyScorer.calculateScore(Category.PAIR, new YatzyRoll(4, 1, 6, 1, 6));
		assertEquals(12, score);
	}

	@Test
	public void pairTestForSixesWithThreeSixes() {
		int score = yatzyScorer.calculateScore(Category.PAIR, new YatzyRoll(1, 6, 6, 6, 6));
		assertEquals(12, score);
	}

	@Test
	public void noPairFoundTest() {
		int score = yatzyScorer.calculateScore(Category.PAIR, new YatzyRoll(1, 2, 3, 4, 5));
		assertEquals(0, score);
	}

	//------------ TWO PAIR -----------------\\




	//------------ THREE OF A KIND -----------------\\
	@Test
	public void threeOfKindWithOnes() {
		int score = yatzyScorer.calculateScore(Category.THREE_OF_A_KIND, new YatzyRoll(1, 1, 6, 1, 6));
		assertEquals(3, score);
	}

	@Test
	public void threeOfKindWithThrees() {
		int score = yatzyScorer.calculateScore(Category.THREE_OF_A_KIND, new YatzyRoll(1, 3, 6, 3, 3));
		assertEquals(9, score);
	}

	@Test
	public void notThreeOfKind() {
		int score = yatzyScorer.calculateScore(Category.THREE_OF_A_KIND, new YatzyRoll(1, 2, 3, 4, 5));
		assertEquals(0, score);
	}

	@Test
	public void notThreeOfKindWrongAnswer() {
		int score = yatzyScorer.calculateScore(Category.THREE_OF_A_KIND, new YatzyRoll(1, 2, 3, 4, 5));
		assertNotEquals(200, score);
	}

	//------------ FOUR OF A KIND -----------------\\
	@Test
	public void fourOfKindWithOnes() {
		int score = yatzyScorer.calculateScore(Category.FOUR_OF_A_KIND, new YatzyRoll(1, 1, 1, 1, 6));
		assertEquals(4, score);
	}

	@Test
	public void fourOfKindWithOnesNotRightResult() {
		int score = yatzyScorer.calculateScore(Category.FOUR_OF_A_KIND, new YatzyRoll(1, 1, 1, 1, 6));
		assertNotEquals(6, score);
	}

	@Test
	public void fourOfKindWithThrees() {
		int score = yatzyScorer.calculateScore(Category.FOUR_OF_A_KIND, new YatzyRoll(1, 3, 3, 3, 3));
		assertEquals(12, score);
	}

	@Test
	public void notFourOfKind() {
		int score = yatzyScorer.calculateScore(Category.FOUR_OF_A_KIND, new YatzyRoll(1, 2, 3, 4, 5));
		assertEquals(0, score);
	}

	//------------ SMALL STRAIGHT -----------------\\
	@Test
	public void smallStraight() {
		int score = yatzyScorer.calculateScore(Category.SMALL_STRAIGHT, new YatzyRoll(1, 2, 3, 4, 5));
		assertEquals(15, score);
	}

	@Test
	public void smallStraightNotRightAnswer() {
		int score = yatzyScorer.calculateScore(Category.SMALL_STRAIGHT, new YatzyRoll(1, 2, 3, 4, 5));
		assertNotEquals(200, score);
	}

	@Test
	public void notSmallStraightStartWithOne() {
		int score = yatzyScorer.calculateScore(Category.SMALL_STRAIGHT, new YatzyRoll(1, 2, 8, 4, 5));
		assertEquals(0, score);
	}

	@Test
	public void notSmallStraightNotStartWithOne() {
		int score = yatzyScorer.calculateScore(Category.SMALL_STRAIGHT, new YatzyRoll(6, 2, 8, 4, 5));
		assertNotEquals(15, score);
	}

	@Test
	public void notSmallStraightNotStartWithOneQ() {
		int score = yatzyScorer.calculateScore(Category.SMALL_STRAIGHT, new YatzyRoll(1, 2, 3, 4, 6));
		assertNotEquals(15, score);
	}

	//------------ LARGE STRAIGHT -----------------\\
	@Test
	public void largeStraight() {
		int score = yatzyScorer.calculateScore(Category.LARGE_STRAIGHT, new YatzyRoll(2, 3, 4, 5, 6));
		assertEquals(20, score);
	}

	@Test
	public void largeStraightFail() {
		int score = yatzyScorer.calculateScore(Category.LARGE_STRAIGHT, new YatzyRoll(2, 3, 2, 5, 6));
		assertNotEquals(20, score);
	}

	@Test
	public void largeStraightNotRightAnswer() {
		int score = yatzyScorer.calculateScore(Category.LARGE_STRAIGHT, new YatzyRoll(2, 3, 4, 5, 6));
		assertNotEquals(200, score);
	}

	@Test
	public void notLargeStraightStartWithTwo() {
		int score = yatzyScorer.calculateScore(Category.LARGE_STRAIGHT, new YatzyRoll(2, 1, 1, 1, 1));
		assertEquals(0, score);
	}

	@Test
	public void notLargeStraightNotStartWithTwo() {
		int score = yatzyScorer.calculateScore(Category.LARGE_STRAIGHT, new YatzyRoll(6, 2, 8, 4, 5));
		assertNotEquals(20, score);
	}

	//------------ FULL HOUSE -----------------\\
	@Test
	public void fullHouseCorrect() {
		int score = yatzyScorer.calculateScore(Category.FULL_HOUSE, new YatzyRoll(1, 1, 1, 2, 2));
		assertEquals(7, score);
	}

	@Test
	public void fullHouseCorrect2() {
		int score = yatzyScorer.calculateScore(Category.FULL_HOUSE, new YatzyRoll(1, 1, 2, 2, 2));
		assertEquals(8, score);
	}

	@Test
	public void fullHouseCorrect3() {
		int score = yatzyScorer.calculateScore(Category.FULL_HOUSE, new YatzyRoll(6, 6, 6, 2, 2));
		assertEquals(22, score);
	}

	@Test
	public void fullHouseNotCorrect() {
		int score = yatzyScorer.calculateScore(Category.FULL_HOUSE, new YatzyRoll(1, 1, 6, 2, 2));
		assertNotEquals(7, score);
	}

	@Test
	public void fullHouseNotCorrect2() {
		int score = yatzyScorer.calculateScore(Category.FULL_HOUSE, new YatzyRoll(1, 2, 3, 4, 5));
		assertNotEquals(7, score);
	}








}
