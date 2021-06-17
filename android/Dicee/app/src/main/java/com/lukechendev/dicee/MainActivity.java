package com.lukechendev.dicee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final static String DICE_1_NUM = "DICE_1_NUM";
    private final static String DICE_2_NUM = "DICE_2_NUM";

    private final int[] diceArr = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6,
    };

    private ImageView leftDice;
    private ImageView rightDice;

    private int leftDiceNum = 0;
    private int rightDiceNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("dicee", "onCreate");
        setContentView(R.layout.activity_main);

        Button rollButton = findViewById(R.id.rollButton);
        leftDice  = findViewById(R.id.dice1);
        rightDice  = findViewById(R.id.dice2);

        final Calendar cal = Calendar.getInstance();
        final Date d = cal.getTime();
        final Random random = new Random(d.getTime());

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftDiceNum = random.nextInt(6);
                leftDice.setImageResource(diceArr[leftDiceNum]);
                Log.d("dicee", "ldice: "+ leftDiceNum);

                rightDiceNum = random.nextInt(6);
                rightDice.setImageResource(diceArr[rightDiceNum]);
                Log.d("dicee", "rdice: "+ rightDiceNum);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("dicee", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("dicee", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("dicee", "onResume");
    }

    /* onRunning */

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("dicee", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("dicee", "onStop (Could be killed at anytime so may not appear)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Log.d("dicee", "onDestroy finishing (Could be killed at anytime so might not appear / Called at rotation)");
        } else {
            Log.d("dicee", "onDestroy (Could be killed at anytime so might not appear / Called at rotation)");
        }
    }

    // This callback is called only when there is a saved instance that is previously saved by using
    // onSaveInstanceState(). We restore some state in onCreate(), while we can optionally restore
    // other state here, possibly usable after onStart() has completed.
    // The savedInstanceState Bundle is same as the one used in onCreate().
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("dicee", "onRestoreInstanceState");

        leftDiceNum = savedInstanceState.getInt(DICE_1_NUM);
        rightDiceNum = savedInstanceState.getInt(DICE_2_NUM);
        leftDice.setImageResource(diceArr[leftDiceNum]);
        rightDice.setImageResource(diceArr[rightDiceNum]);
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
        Log.d("dicee", "onSaveInstanceState");
        outState.putInt(DICE_1_NUM, leftDiceNum);
        outState.putInt(DICE_2_NUM, rightDiceNum);
    }
}
