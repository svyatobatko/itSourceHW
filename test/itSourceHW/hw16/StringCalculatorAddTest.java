package itSourceHW.hw16;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import itSourceHW.hw16.StringCalculatorAdd;

public class StringCalculatorAddTest {

	String FIELD_ZERO_ARGUNENTS = "";
	int REZULT_ZERO = 0;
	String FIELD_ONE_ARGUNENTS = "1";
	int REZULT_ONE = 1;
	String FIELD_TWO_ARGUNENTS = "1,2";
	int REZULT_TWO = 3;
	String FIELD_TWO_ARGUNENTS_2 = "5,7";
	int REZULT_TWO_2 = 12;

	String FIELD_THREE_ARGUNENTS = "1\n2,3";
	int REZULT_THREE = 6;

	String FIELD_TWO_ARGUNENTS_AND_DELIMITER = ";\n1,2";
	int REZULT_TWO_AND_DELIMITER = 3;

	String FIELD_TWO_ARGUNENTS_AND_NEGATIVE = "1,-2";

	String FIELD_TWO_ARGUNENTS_AND_BIGEST_FIRST = "1001,2";
	int REZULT_TWO_AND_BIGEST_FIRST = 2;
	String FIELD_TWO_ARGUNENTS_AND_BIGEST_SECOND = "1,1002";
	int REZULT_TWO_AND_BIGEST_SECOND = 1;
	String FIELD_TWO_ARGUNENTS_AND_BIGEST_BOTH = "1001,1002";
	int REZULT_TWO_AND_BIGEST_BOTH = 0;

	String FIELD_TWO_ARGUNENTS_AND_DELIMITER_ANY_LENGHT = ";;;;1,;;;;2";
	int REZULT_TWO_AND_DELIMITER_ANY_LENGHT = 3;
	String FIELD_TWO_ARGUNENTS_AND_DELIMITER_ANY = ";#;!;#;1,;#;%;#;2";
	int REZULT_TWO_AND_DELIMITER_ANY = 3;
	String FIELD_TWO_ARGUNENTS_AND_LONG_DELIMITER = "\n\n\n1,;\n\n\n2";
	int REZULT_TWO_AND_LONG_DELIMITER = 3;

	@Test
	public void testCalculationAddWhenFieldIsEmptyTheraAnserIsZero() throws Exception  {
		StringCalculatorAdd stringCalculatorAddZero = new StringCalculatorAdd(FIELD_ZERO_ARGUNENTS);
		assertEquals(REZULT_ZERO, stringCalculatorAddZero.getResult());
	}

	@Test
	public void testCalculationAddWhenFieldIsOneArgumentTheraAnserIsOneArgument() throws Exception  {
		StringCalculatorAdd stringCalculatorAddOne = new StringCalculatorAdd(FIELD_ONE_ARGUNENTS);
		assertEquals(REZULT_ONE, stringCalculatorAddOne.getResult());
	}

	@Test
	public void testCalculationAddWhenFieldIsTwoArgumentTheraAnserIsSummTwoArgument() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwo = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS);
		assertEquals(REZULT_TWO, stringCalculatorAddTwo.getResult());
	}

	@Test
	public void testCalculationAddWhenFieldIsTwoArgumentTheraAnserIsSummTwoArgument2() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwo2 = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS_2);
		assertEquals(REZULT_TWO_2, stringCalculatorAddTwo2.getResult());
	}

	@Test
	public void testCalculationAddWhenFieldIsThreeArgumentTheraAnserIsSummThreeArgument() throws Exception  {
		StringCalculatorAdd stringCalculatorAddThree = new StringCalculatorAdd(FIELD_THREE_ARGUNENTS);
		assertEquals(REZULT_THREE, stringCalculatorAddThree.getResult());
	}

	@Test
	public void testCalculationAddWhenFieldIsTwoArgumentAndDelimiterTheraAnserIsSummTwoArgument() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwoWithDelimiter = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS_AND_DELIMITER);
		assertEquals(REZULT_TWO_AND_DELIMITER, stringCalculatorAddTwoWithDelimiter.getResult());
	}

	@Test(expected = Exception.class)
	public void testCalculationAddWhenFieldIsTwoArgumentAndOneOfThemNegativeTheraAnserIsException() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwoDelimiter = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS_AND_NEGATIVE);
		stringCalculatorAddTwoDelimiter.getResult();
	}

	@Test
	public void testCalculationAddWhenFieldIsTwoArgumentAndBigest1000FirstTheraAnserIsSummArgumentWithoutBigest() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwoBigest1000First = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS_AND_BIGEST_FIRST);
		assertEquals(REZULT_TWO_AND_BIGEST_FIRST, stringCalculatorAddTwoBigest1000First.getResult());
	}

	@Test
	public void testCalculationAddWhenFieldIsTwoArgumentAndBigest1000SecondTheraAnserIsSummArgumentWithoutBigest() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwoBigest1000Second = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS_AND_BIGEST_SECOND);
		assertEquals(REZULT_TWO_AND_BIGEST_SECOND, stringCalculatorAddTwoBigest1000Second.getResult());
	}

	@Test
	public void testCalculationAddWhenFieldIsTwoArgumentAndBigest1000BothTheraAnserIsSummArgumentWithoutBigest() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwoBigest1000Both = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS_AND_BIGEST_BOTH);
		assertEquals(REZULT_TWO_AND_BIGEST_BOTH, stringCalculatorAddTwoBigest1000Both.getResult());
	}


	@Test
	public void testCalculationAddWhenFieldIsTwoArgumentAndDelimiterAnyLenghtTheraAnserIsSummTwoArgument() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwoWithDelimiterAnyLenght = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS_AND_DELIMITER_ANY_LENGHT);
		assertEquals(REZULT_TWO_AND_DELIMITER_ANY_LENGHT, stringCalculatorAddTwoWithDelimiterAnyLenght.getResult());
	}

	@Test
	public void testCalculationAddWhenFieldIsTwoArgumentAndDelimiterAnyTheraAnserIsSummTwoArgument() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwoWithDelimiterAny = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS_AND_DELIMITER_ANY);
		assertEquals(REZULT_TWO_AND_DELIMITER_ANY, stringCalculatorAddTwoWithDelimiterAny.getResult());
	}

	@Test
	public void testCalculationAddWhenFieldIsTwoArgumentAndLongDelimiterTheraAnserIsSummTwoArgument() throws Exception  {
		StringCalculatorAdd stringCalculatorAddTwoWithLongDelimiter = new StringCalculatorAdd(FIELD_TWO_ARGUNENTS_AND_LONG_DELIMITER);
		assertEquals(REZULT_TWO_AND_LONG_DELIMITER, stringCalculatorAddTwoWithLongDelimiter.getResult());
	}


}
