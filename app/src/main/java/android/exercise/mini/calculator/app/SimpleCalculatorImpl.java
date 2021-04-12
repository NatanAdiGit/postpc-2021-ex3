package android.exercise.mini.calculator.app;

import java.io.Serializable;

public class SimpleCalculatorImpl implements SimpleCalculator {

  static final String DIGIT_ILLEGAL_MESS = "Digits can only by integers between 0-9";

  // todo: add fields as needed
  // the current output of the calculator.
  private String curInput = "";

  @Override
  public String output() {
    // todo: return output based on the current state
    if (curInput.length() > 0)
          return curInput;
    return "0";
  }

  @Override
  public void insertDigit(int digit) throws IllegalArgumentException{
    // todo: insert a digit
    if (digit < 0 || digit > 9)
      throw new IllegalArgumentException(DIGIT_ILLEGAL_MESS);
    curInput += Integer.toString(digit);
  }

  @Override
  public void insertPlus() {
    // todo: insert a plus
    if (curInput.length() == 0)
      curInput = "0+";
    else {
      char lastChar = curInput.charAt(curInput.length() - 1);
      if (lastChar != '+' && lastChar != '-')
        curInput += "+";
    }
  }

  @Override
  public void insertMinus() {
    // todo: insert a minus
    if (curInput.length() == 0)
      curInput = "0-";
    else {
      char lastChar = curInput.charAt(curInput.length() - 1);
      if (lastChar != '+' && lastChar != '-')
        curInput += "-";
    }
  }

  @Override
  public void insertEquals() {
    // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
    //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
    curInput = Long.toString(calculateCurInput());
  }

  /**
   * Calculate the input.
   * @return the result of the calculation.
   */
  private long calculateCurInput() {
    // if there is no input the results should be zero.
    if (curInput.length() == 0)
      return 0;

    long result = 0;
    int index = 0, curSign = 1;
    StringBuilder num = new StringBuilder();

    while (index < curInput.length()) {
      if (curInput.charAt(index) == '-') {
        curSign = -1;
        index++;
      } else if (curInput.charAt(index) == '+') {
        curSign = 1;
        index++;
      }

      while ((index < curInput.length()) && (curInput.charAt(index) != '-')
              && (curInput.charAt(index) != '+')) {

        num.append(curInput.charAt(index));
        index++;
      }

      if (num.toString().length() > 0) {
        result += curSign * Long.parseLong(num.toString());
        num = new StringBuilder();
      }
    }
    return result;
  }


  @Override
  public void deleteLast() {
    // todo: delete the last input (digit, plus or minus)
    //  e.g.
    //  if input was "12+3" and called `deleteLast()`, then delete the "3"
    //  if input was "12+" and called `deleteLast()`, then delete the "+"
    //  if no input was given, then there is nothing to do here
    if (curInput.length() > 0)
         curInput = curInput.substring(0, curInput.length() - 1);
  }

  @Override
  public void clear() {
    // todo: clear everything (same as no-input was never given)
    curInput = "";
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    // todo: insert all data to the state, so in the future we can load from this state
    state.setState(curInput);
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    curInput = casted.getState();
    // todo: use the CalculatorState to load
  }

  private static class CalculatorState implements Serializable {
    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
    private String state;

    public String getState(){
      return state;
    }

    public void setState(String newState){
      state = newState;
    }
  }
}
