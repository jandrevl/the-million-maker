package com.jandrevl.the_million_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class GeneratedGameKey extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated_game_key);

        int[] numbersKeyArray = generateKey(50, 5);
        int[] starsKeyArray = generateKey(10, 2);

        String numbersKey = Arrays.toString(numbersKeyArray);
        String starsKey = Arrays.toString(starsKeyArray);

        TextView numbers = (TextView) findViewById(R.id.textView5);
        numbers.setText(numbersKey);

        TextView stars = (TextView) findViewById(R.id.textView7);
        stars.setText(starsKey);





    }

    private int[] generateKey(int totalNumbers, int slots) {
        int[] numbersKey = new int[slots];
        Random rand = new Random();
        for (int i = 0; i < slots; i++) {
            numbersKey[i] = rand.nextInt(totalNumbers) + 1;
            for(int j = 0; j < i; j++) {
                if(numbersKey[i] == numbersKey[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(numbersKey);
        return numbersKey;
    }

    public void generateNewKeys(View view) {
        Intent intent = new Intent(this, GeneratedGameKey.class);
        startActivity(intent);
    }





}