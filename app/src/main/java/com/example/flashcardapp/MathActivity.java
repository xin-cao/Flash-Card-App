package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Stack;


public class MathActivity extends AppCompatActivity {
    private static final String MyFlag = "lfa";  //this will be our trail of breadcrumbs for logging events.
    private Button genProblemButton;
    private Button submitProblem;
    private EditText userAnswer;
    private TextView topNum;
    private TextView operator;
    private TextView botNum;


    //MainActivity main = new MainActivity();

    public static int randomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static String fittyfitty() {
        if (randomNumber(1, 10) > 5) {
            return "*";
        } else {
            return "÷";
        }
    }
    // functions to get an array of feasible factors for division

    public static int[] checkDiv(int top) {
        Stack stack = new Stack();
        int subNum[] = new int[13];
        for (int i = 1; i < subNum.length; i++) {
            if (top % i == 0) {
                stack.push(i);
            }
        }
        int j = 0;
        while (!stack.empty()) {
            subNum[j] = (int) stack.pop();
            j++;
        }
        return subNum;
    }

    public static int[] shortenArr(int[] arr) {
        int i = 1;
        while (arr[i - 1] != 0) {
            i++;
        }
        int[] n = new int[i];
        for (int j = 0; j < n.length; j++) {
            n[j] = arr[j];
        }
        return n;
    }

    //function that selects random number from an array
    public static int bottomRand(int[] arr) {
        return arr[randomNumber(0, arr.length - 1)];
    }

    //function that generates array of 10 random divisible numbers based on numbers in an array
    public static int[] bottomTen(int[] arr) {
        int[] output = new int[10];
        for (int i = 0; i < output.length; i++) {
            output[i] = arr[randomNumber(0, arr.length - 1)];
        }
        return output;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        Log.e(MyFlag, "onCreate was just called");
        topNum = (TextView) findViewById(R.id.topNum);
        topNum.setText("hello");
        genProblemButton = (Button) findViewById(R.id.genProblemButton);
        genProblemButton.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            int tempArr[] = new int[13];
            int tNum[] = new int[10];
            int bNum[] = new int[10];
            String op[] = new String[10];
            String operator;
            int Op1, Op2, Answer;

            @Override
            public void onClick(View view) {
                topNum.setText("hello");
                for (; i <= tNum.length - 1; i++) {
                    tNum[i] = randomNumber(10, 144);
                    tempArr = checkDiv(tNum[i]);
                    bNum[i] = bottomRand(shortenArr(tempArr));
                    op[i] = fittyfitty();
                }
                Op1 = tNum[0];

            }

        });
/*
        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {

        });
        }
        */

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(MyFlag, "onDestroy was just called.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(MyFlag, "onRestart was just called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(MyFlag, "onPause was just called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(MyFlag, "onStop was just called.");
    }
}