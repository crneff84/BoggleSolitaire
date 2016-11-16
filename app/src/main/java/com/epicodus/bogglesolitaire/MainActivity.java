package com.epicodus.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private String[] consonants = new String[] {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
    private String[] vowels = new String[] {"a", "e", "i", "o", "u"};
    ArrayList<String> randomLetters = new ArrayList<>();
    @Bind(R.id.randomStringTextView) TextView mRandomStringTextView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Random rand = new Random();
        for (int i = 0; i < 6; i ++) {
            int j = rand.nextInt(20) + 1;
            randomLetters.add(consonants[j]);
        }

        for (int i = 0; i < 2; i ++) {
            int j = rand.nextInt(5) + 1;
            randomLetters.add(vowels[j]);
        }

        mRandomStringTextView.setText(randomLetters.toString());



    }
}
