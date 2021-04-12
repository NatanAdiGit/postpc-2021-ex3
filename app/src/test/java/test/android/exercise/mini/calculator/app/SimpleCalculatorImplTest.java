package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.SimpleCalculatorImpl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.io.Serializable;

import static org.junit.Assert.*;

public class SimpleCalculatorImplTest {

  @Test
  public void when_noInputGiven_then_outputShouldBe0(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_inputIsPlus_then_outputShouldBe0Plus(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertPlus();
    assertEquals("0+", calculatorUnderTest.output());
  }


  @Test
  public void when_inputIsMinus_then_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertMinus();
    String expected = "0-"; // TODO: decide the expected output when having a single minus
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingInsertDigitWithIllegalNumber_then_exceptionShouldBeThrown(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    try {
      calculatorUnderTest.insertDigit(357);
      fail("should throw an exception and not reach this line");
    } catch (RuntimeException e) {
      System.out.println();
    }
  }


  @Test
  public void when_callingDeleteLast_then_lastOutputShouldBeDeleted(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.deleteLast();
    assertEquals("1", calculatorUnderTest.output());
  }

  @Test
  public void when_callingClear_then_outputShouldBeCleared(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    for (int i = 0; i < 10; i++)
      calculatorUnderTest.insertDigit(i);
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_savingState_should_loadThatStateCorrectly(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    // give some input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);

    // save current state
    Serializable savedState = calculatorUnderTest.saveState();
    assertNotNull(savedState);

    // call `clear` and make sure calculator cleared
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    // load the saved state and make sure state was loaded correctly
    calculatorUnderTest.loadState(savedState);
    assertEquals("5+7", calculatorUnderTest.output());
  }

  @Test
  public void when_savingStateFromFirstCalculator_should_loadStateCorrectlyFromSecondCalculator(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();
    // TODO: implement the test based on this method's name.
    //  you can get inspiration from the test method `when_savingState_should_loadThatStateCorrectly()`
    // add 0+2+4+6+8+ to the first calculator output.
    for (int i = 0; i < 10; i++)
      if (i % 2 == 0)
      firstCalculator.insertDigit(i);
      else
        firstCalculator.insertPlus();

    // save current state
    Serializable savedFirstState = firstCalculator.saveState();
    assertNotNull(savedFirstState);

    // load the input of the first calculator to the second one.
    secondCalculator.loadState(savedFirstState);

    // check the two outputs are the same.
    assertEquals(firstCalculator.output(), secondCalculator.output());
  }

  // TODO:
  //  the existing tests are not enough since they only test simple use-cases with small inputs.
  //  write at least 10 methods to test correct behavior with complicated inputs or use-cases.
  //  examples:
  //  - given input "5+7-13<DeleteLast>25", expected output is "5+17-125"
  //  - given input "9<Clear>12<Clear>8-7=", expected output is "1"
  //  - given input "8-7=+4=-1=", expected output is "4"
  //  - given input "999-888-222=-333", expected output is "-111-333"
  //  - with 2 calculators, give them different inputs, then save state on first calculator and load the state into second calculator, make sure state loaded well
  //  etc etc.
  //  feel free to be creative in your tests!

  // as describe in the submission page.
  @Test
  public void test_output_is_that_same_as_input() {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertDigit(3);
    assertEquals("14-5+7-83", calculatorUnderTest.output());

  }

  // as describe in the submission page.
  @Test
  public void Calling_deleteLast_with_an_empty_input_should_be_ok(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    try {
      calculatorUnderTest.deleteLast();
      assertEquals("0", calculatorUnderTest.output());
    } catch (RuntimeException e) {
      fail("should not throw an exception");
    }
  }

  @Test
  public void test_delete_operator_from_the_middle(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertDigit(0);
    calculatorUnderTest.insertEquals();
    assertEquals("70", calculatorUnderTest.output());
  }

  @Test
  public void test_delete_a_digit_from_the_middle(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertDigit(0);
    calculatorUnderTest.insertEquals();
    assertEquals("67", calculatorUnderTest.output());
  }

  @Test
  public void when_two_operators_placed_one_after_the_other_last_should_not_be_add(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus(); // insert minus after plus.
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertDigit(0);
    calculatorUnderTest.insertEquals();
    assertEquals("67", calculatorUnderTest.output());
  }

  @Test
  public void when_a_lot_of_operators_are_added_oneAfterTheOther_only_first_one_is_seen(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    for (int i = 0; i < 100; i ++)
      if (i % 2 == 0)
        calculatorUnderTest.insertPlus();
      else
        calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertEquals();
    assertEquals("20", calculatorUnderTest.output());
  }

  @Test
  public void test_clear_multiple_times(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    for (int i = 0; i < 100; i++) {
      calculatorUnderTest.insertDigit(i % 10);
      if (i % 2 == 0)
        calculatorUnderTest.insertPlus();
      else
        calculatorUnderTest.insertMinus();

      if (i % 10 == 0)
        calculatorUnderTest.clear();
    }
    // after for the output is 1-2+3-4+5-6+7-8+9
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertEquals();
    assertEquals("1",calculatorUnderTest.output());
  }

  @Test
  public void test_delete_last_multiple_times(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    for (int i = 0; i < 100; i++) {
      calculatorUnderTest.insertDigit(i % 10);
      if (i % 2 == 0)
        calculatorUnderTest.insertPlus();
      else
        calculatorUnderTest.insertMinus();
    }

    for (int i = 0; i < 200; i++) {
      calculatorUnderTest.deleteLast();
    }

    assertEquals("0", calculatorUnderTest.output());
  }


  @Test
  public void test_concatenation_of_equal_signs() {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    for (int i = 1; i < 100; i++) {
      if (i < 10)
        calculatorUnderTest.insertDigit(i);
      else {
        calculatorUnderTest.insertDigit(i/10);
        calculatorUnderTest.insertDigit(i%10);
      }
      if (i % 10 == 0 || i == 99){
        calculatorUnderTest.insertEquals();
      }
      calculatorUnderTest.insertPlus();
    }
    assertEquals("4950+", calculatorUnderTest.output());
  }

  @Test
  public void test_load_state_from_one_calculator_to_other_that_has_nonEmpty_input() {
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();
    // add 0+2+4+6+8+ to the first calculator output.
    for (int i = 0; i < 10; i++)
      if (i % 2 == 0)
        firstCalculator.insertDigit(i);
      else
        firstCalculator.insertPlus();

    // add 1+3+5+7+9+ to the first calculator output.
    for (int i = 0; i < 10; i++)
      if (i % 2 == 1)
        firstCalculator.insertDigit(i);
      else
        firstCalculator.insertPlus();

    // save current state
    Serializable savedFirstState = firstCalculator.saveState();
    assertNotNull(savedFirstState);

    // load the input of the first calculator to the second one.
    secondCalculator.loadState(savedFirstState);

    // check the two outputs are the same.
    assertEquals(firstCalculator.output(), secondCalculator.output());
  }


  @Test
  public void test_if_correct_calculation_by_random_numbers(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    Random rnd = new Random();
    List<String> inputList = new ArrayList<>();
    long results = 0;
    int sign = 1;
    for (int i = 0; i < 1000; i++){
      StringBuilder numberAsStr = new StringBuilder();
      int digits = rnd.nextInt(4);
      digits++; // to get the range 1-4

      if (rnd.nextInt(2) == 0){
        calculatorUnderTest.insertPlus();
        inputList.add("+");
        sign = 1;
      }
      else{
        calculatorUnderTest.insertMinus();
        inputList.add("-");
        sign = -1;
      }

      for (int j = 0; j < digits; j++) {
        int digit = rnd.nextInt(10);
        numberAsStr.append(Integer.toString(digit));
        calculatorUnderTest.insertDigit(digit);
      }
      results += sign * Long.parseLong(numberAsStr.toString());
      inputList.add(numberAsStr.toString());
    }
    calculatorUnderTest.insertEquals();
    String failureMessage = "the test failed with the next input" + inputList.toString();
    assertEquals(failureMessage, Long.toString(results), calculatorUnderTest.output());
  }


}