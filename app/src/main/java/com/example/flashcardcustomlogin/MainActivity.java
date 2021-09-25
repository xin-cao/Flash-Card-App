package com.example.flashcardcustomlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private static final String MyFlag = "lfa";  //this will be our trail of breadcrumbs for logging events.

    private Button GenProbBTN, SubmitBTN;
    private EditText editText;
    private TextView numTop, numBottom, Operator, Hint;

    private int[] results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(MyFlag, "onCreate was just called");

        GenProbBTN = (Button) findViewById(R.id.GenProbBTN);
        SubmitBTN = (Button) findViewById(R.id.SubmitBTN);
        editText = (EditText) findViewById(R.id.editText);
        numTop = (TextView) findViewById(R.id.numTop);
        numBottom = (TextView) findViewById(R.id.numBottom);
        Operator = (TextView) findViewById(R.id.Operator);
        Hint = (TextView) findViewById(R.id.Hint);

        GenProbBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //numTop.setText("no");
                generate();
            }
        });

    }

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
        Arrays.sort(subNum);
        return subNum;
    }
/*
    private int[] reversed(int[] array) {
        for(int i = 0; i < array.length / 2; i++)
        {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public static int[] shortenArr(int[] arr) {
        int i = 1;
        //int[] sorted = Arrays.sort(arr);
        //Collections.reverse(sorted);
        while (arr[i - 1] != 0) {
            i++;
        }
        int[] n = new int[i];
        for (int j = 0; j < n.length; j++) {
            n[j] = arr[-j+1];
        }
        return n;
    }*/

    //function that selects random number from an array
    public static int bottomRand(int[] arr) {
        int len = arr.length;
        int j = 0;
        List<Integer> noZeros = new ArrayList<Integer>();
        for(int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                j++;
            } else {
                noZeros.add(arr[j]);
                j++;
            }
        }
        return noZeros.get(randomNumber(0, noZeros.size() - 1));
    }

    //function that generates array of 10 random divisible numbers based on numbers in an array
    public static int[] bottomTen(int[] arr) {
        int[] output = new int[10];
        for (int i = 0; i < output.length; i++) {
            output[i] = arr[randomNumber(0, arr.length - 1)];
        }
        return output;
    }

    public void generate() {
        int top = (int) ((Math.random() * (144 - 10)) + 10);
        Boolean op = (Math.random() < 0.5);
        int bottom = (int) (Math.random() * 12);

        numTop.setText(Integer.toString(top));

        if(op){
            Operator.setText(R.string.Mul);
            numBottom.setText(Integer.toString(bottom));
            //results.add(top*bottom);
        }else{
            Operator.setText(R.string.Div);
            int bNum = bottomRand(checkDiv(top));
            numBottom.setText(Integer.toString(bNum));
            //results.add(top/bottom);
        }
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

