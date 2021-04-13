package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }

    /*
    TODO:
    - find all views
    - initial update main text-view based on calculator's output
    - set click listeners on all buttons to operate on the calculator and refresh main text-view
     */

    // finding all views
    // the main text view.
    TextView calOutput = findViewById(R.id.textViewCalculatorOutput);

    // the numbers buttons of the calculator.
    TextView button0 = findViewById(R.id.button0);
    TextView button1 = findViewById(R.id.button1);
    TextView button2 = findViewById(R.id.button2);
    TextView button3 = findViewById(R.id.button3);
    TextView button4 = findViewById(R.id.button4);
    TextView button5 = findViewById(R.id.button5);
    TextView button6 = findViewById(R.id.button6);
    TextView button7 = findViewById(R.id.button7);
    TextView button8 = findViewById(R.id.button8);
    TextView button9 = findViewById(R.id.button9);

    // the operators buttons.
    TextView plusButton = findViewById(R.id.buttonPlus);
    TextView minusButton = findViewById(R.id.buttonMinus);
    TextView equalButton = findViewById(R.id.buttonEquals);

    // delete and clear buttons.
    View deleteButton = findViewById(R.id.buttonBackSpace);
    TextView clearButton = findViewById(R.id.buttonClear);

    //initial update main text-view based on calculator's output

    calOutput.setText(calculator.output());

    //set click listeners on all buttons to operate on the calculator and refresh main text-view
    /* ---------  numbers buttons --------- */

    button0.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(0);
        calOutput.setText(calculator.output());
      }
    });

    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(1);
        calOutput.setText(calculator.output());
      }
    });

    button2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(2);
        calOutput.setText(calculator.output());
      }
    });
    button3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(3);
        calOutput.setText(calculator.output());
      }
    });

    button4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(4);
        calOutput.setText(calculator.output());
      }
    });

    button5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(5);
        calOutput.setText(calculator.output());
      }
    });

    button6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(6);
        calOutput.setText(calculator.output());
      }
    });

    button7.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(7);
        calOutput.setText(calculator.output());
      }
    });

    button8.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(8);
        calOutput.setText(calculator.output());
      }
    });

    button9.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertDigit(9);
        calOutput.setText(calculator.output());
      }
    });

    /* ---------  numbers buttons --------- */

    /* ---------  operators buttons --------- */

    plusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertPlus();
        calOutput.setText(calculator.output());
      }
    });

    minusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertMinus();
        calOutput.setText(calculator.output());
      }
    });

    equalButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertEquals();
        calOutput.setText(calculator.output());
      }
    });

    /* ---------  operators buttons --------- */

    deleteButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.deleteLast();
        calOutput.setText(calculator.output());
      }
    });

    clearButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.clear();
        calOutput.setText(calculator.output());
      }
    });
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
  }
}



  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
  }
}