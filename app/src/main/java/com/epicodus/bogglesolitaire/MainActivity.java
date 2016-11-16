package com.epicodus.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private String[] consonants = new String[] {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
    private String[] vowels = new String[] {"a", "e", "i", "o", "u"};
    private ArrayList<String> randomLetters = new ArrayList<>();
    ArrayList<String> words = new ArrayList<>();
    private ListView mListView;
    @Bind(R.id.wordInput) EditText mWordInput;
    @Bind(R.id.addWordButton) Button mAddWordButton;
    @Bind(R.id.randomStringTextView) TextView mRandomStringTextView;

    public static final String TAG = "logs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Random rand = new Random();
        for (int i = 0; i < 6; i ++) {
            int j = rand.nextInt(21);
            randomLetters.add(consonants[j]);
        }

        for (int i = 0; i < 2; i ++) {
            int j = rand.nextInt(5);
            randomLetters.add(vowels[j]);
        }

        mRandomStringTextView.setText(randomLetters.toString());

        mListView = (ListView) findViewById(R.id.wordListView);

        mAddWordButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean output = false;
                Integer letterCount = 0;
                String[] inputArray = mWordInput.getText().toString().split("");
                if(inputArray.length <= 9) {
                    for (int i=0; i < inputArray.length; i++){
                        for(int j=0; j< randomLetters.size(); j++) {
                           if (inputArray[i].equals(randomLetters.get(j))) {
                               letterCount+= 1;
                               break;
                           }
                        }
                    }
                    if(inputArray.length == letterCount +1) {
                        output = true;
                        Log.i(TAG, "true!" + letterCount.toString() + " Array: " + inputArray.length);
                    } else {
                        Log.i(TAG, "false!" + letterCount.toString() + " Array: " + inputArray.length);
                    }
                }
                if (output) {
                    words.add(mWordInput.getText().toString());
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, words);
                    mListView.setAdapter(adapter);
                }


            }
        });

    }
}
