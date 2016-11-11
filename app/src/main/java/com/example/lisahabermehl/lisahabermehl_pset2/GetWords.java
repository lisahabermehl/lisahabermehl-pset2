package com.example.lisahabermehl.lisahabermehl_pset2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by lisahabermehl on 07/11/16.
 */

public class GetWords extends AppCompatActivity
{
    // create an intent (?) of class Story
    Story story;
    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_words);

        Bundle extras = getIntent().getExtras();
        String previousActivity = extras.getString("callingActivity");

        // open the txt file
        InputStream openStory = null;
        try
        {
            openStory = getAssets().open("madlib1_tarzan.txt");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        story = new Story(openStory);

        // to see how many placeholders are left use the methods: getPlaceholderRemainingCount and isFilledIn
        TextView amountPlaceholders = (TextView) findViewById(R.id.amountPlaceholders);
        int amount = story.getPlaceholderRemainingCount();
        amountPlaceholders.setText(amount + " word(s) left");

        EditText enterPlaceholder = (EditText) findViewById(R.id.enterPlaceholder);
        String placeholderNeeded = story.getNextPlaceholder();
        enterPlaceholder.setText(placeholderNeeded);

        word = enterPlaceholder.getText().toString();

        TextView pleaseType = (TextView) findViewById(R.id.pleaseType);
        // String placeholderNeeded = story.getNextPlaceholder();
        pleaseType.setText("Please type a/an " + placeholderNeeded);
    }


    // then filling in that placeholder by calling fillInPlaceholder
    public void fillPlaceholder (String word)
    {
        if (story.getPlaceholderCount() == 0)
        {
            // "intention to do something"
            Intent finishedStory = new Intent (this, FinalStory.class);

            // data to go to getWords screen
            finishedStory.putExtra("callingActivity2", story.toString());
            startActivity(finishedStory);
        }
    }
}
