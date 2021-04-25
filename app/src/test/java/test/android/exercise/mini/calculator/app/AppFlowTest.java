package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.MainActivity;
import android.exercise.mini.calculator.app.R;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {28})
public class AppFlowTest {

  private ActivityController<MainActivity> activityController;
  private MainActivity activityUnderTest;
  private View button0;
  private View button1;
  private View button2;
  private View button3;
  private View button4;
  private View button5;
  private View button6;
  private View button7;
  private View button8;
  private View button9;
  private View buttonBackspace;
  private View buttonClear;
  private View buttonPlus;
  private View buttonMinus;
  private View buttonEquals;
  private TextView textViewOutput;

  /** initialize main activity with a real calculator */
  @Before
  public void setup(){
    activityController = Robolectric.buildActivity(MainActivity.class);
    activityUnderTest = activityController.get();
    activityController.create().start().resume();
    button0 = activityUnderTest.findViewById(R.id.button0);
    button1 = activityUnderTest.findViewById(R.id.button1);
    button2 = activityUnderTest.findViewById(R.id.button2);
    button3 = activityUnderTest.findViewById(R.id.button3);
    button4 = activityUnderTest.findViewById(R.id.button4);
    button5 = activityUnderTest.findViewById(R.id.button5);
    button6 = activityUnderTest.findViewById(R.id.button6);
    button7 = activityUnderTest.findViewById(R.id.button7);
    button8 = activityUnderTest.findViewById(R.id.button8);
    button9 = activityUnderTest.findViewById(R.id.button9);
    buttonBackspace = activityUnderTest.findViewById(R.id.buttonBackSpace);
    buttonClear = activityUnderTest.findViewById(R.id.buttonClear);
    buttonPlus = activityUnderTest.findViewById(R.id.buttonPlus);
    buttonMinus = activityUnderTest.findViewById(R.id.buttonMinus);
    buttonEquals = activityUnderTest.findViewById(R.id.buttonEquals);
    textViewOutput = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
  }

  @Test
  public void flowTest1(){
    // run clicks on "13+5"
    for (View button: Arrays.asList(
      button1, button3, buttonPlus, button5
    )) {
      button.performClick();
    }

    assertEquals("13+5", textViewOutput.getText().toString());
  }


  @Test
  public void flowTest2(){
    // run clicks on "7+5<backspace>4="
    for (View button: Arrays.asList(
      button7, buttonPlus, button5, buttonBackspace, button4, buttonEquals
    )) {
      button.performClick();
    }

    assertEquals("11", textViewOutput.getText().toString());
  }


  // TODO: add at last 10 more flow tests

  @Test
  public void flowTest3(){
    // run clicks on "9+5+2+4=<clear>"
    for (View button: Arrays.asList(
            button9, buttonPlus, button5, buttonPlus, button2, buttonPlus, button4, buttonEquals,
            buttonClear)) {
      button.performClick();
    }

    assertEquals("0", textViewOutput.getText().toString());
  }

  @Test
  public void flowTest4(){
    // run clicks on "6-6="
    for (View button: Arrays.asList(
            button6, buttonMinus, button6, buttonEquals, button6)) {
      button.performClick();
    }

    assertEquals("6", textViewOutput.getText().toString());
  }


  @Test
  public void flowTest5(){
    // run clicks on "1-2=-1->-15=-15 should be 18"
    for (View button: Arrays.asList(
            button1, buttonMinus, button2, buttonEquals, button5, buttonEquals)) {
      button.performClick();
    }

    assertEquals("-15", textViewOutput.getText().toString());
  }

  @Test
  public void flowTest6(){
    // run clicks on "6+6+--++6===+ should be 18
    for (View button: Arrays.asList(
            button6, buttonPlus, button6, buttonPlus, buttonMinus, buttonMinus, buttonPlus,
            buttonPlus, button6, buttonEquals, buttonEquals, buttonEquals,buttonPlus)) {
      button.performClick();
    }

    assertEquals("18+", textViewOutput.getText().toString());
    buttonEquals.performClick();
    assertEquals("18", textViewOutput.getText().toString());

  }

  @Test
  public void flowTest7(){
    // run clicks on "6+0-0+6+="
    for (View button: Arrays.asList(
            button6, buttonPlus, button0, buttonMinus, button0, buttonPlus, button6,
            buttonPlus, buttonEquals)) {
      button.performClick();
    }

    assertEquals("12", textViewOutput.getText().toString());
  }

  @Test
  public void flowTest8(){
    // run clicks on "100-1-1-1-1......-1 should be zero
    button1.performClick();
    button0.performClick();
    button0.performClick();
    for (int i = 0; i < 100; i++) {
      buttonMinus.performClick();
      button1.performClick();
    }
    buttonEquals.performClick();
    assertEquals("0", textViewOutput.getText().toString());
  }

  @Test
  public void flowTest9(){
    // run clicks on "6+5+4+3+2+1=<delete last> should be 1"
    for (View button: Arrays.asList(
            button6, buttonPlus, button5, buttonPlus, button4, buttonPlus, button3,
            buttonPlus, button2, buttonPlus, button1, buttonEquals, buttonBackspace)) {
      button.performClick();
    }

    assertEquals("2", textViewOutput.getText().toString());
  }

  @Test
  public void flowTest10(){
    // run clicks on "=+-+=-+4-+4="
    for (View button: Arrays.asList(
            buttonEquals, buttonPlus, buttonMinus, buttonPlus, buttonEquals, buttonMinus, buttonPlus,
            button4, buttonMinus, buttonPlus, button4, buttonEquals)) {
      button.performClick();
    }

    assertEquals("-8", textViewOutput.getText().toString());
  }

  @Test
  public void flowTes11(){
    // run clicks on "6234<clear>121<delete last>+93=<delete last>"
    button6.performClick();
    button2.performClick();
    button3.performClick();
    button4.performClick();
    buttonClear.performClick();
    button1.performClick();
    button2.performClick();
    button1.performClick();
    buttonBackspace.performClick();
    buttonPlus.performClick();
    button9.performClick();
    button3.performClick();
    buttonEquals.performClick();
    buttonBackspace.performClick();

    assertEquals("10", textViewOutput.getText().toString());
  }

  @Test
  public void flowTest12(){
    // run clicks on "1000000000 +  1000000000000 = 1001000000000="
    button1.performClick();

    for (int i = 0 ; i < 9; i++)
      button0.performClick();

    buttonPlus.performClick();
    button1.performClick();

    for (int i = 0 ; i < 12; i++)
      button0.performClick();

    buttonEquals.performClick();
    assertEquals("1001000000000", textViewOutput.getText().toString());
  }


}
