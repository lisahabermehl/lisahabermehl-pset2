package com.example.lisahabermehl.lisahabermehl_pset2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lisahabermehl on 08/11/16.
 */

public class FinalStory extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);

//        Bundle words = getIntent().getExtras();
        String name;

        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity2");

        Bundle words = getIntent().getExtras();
        TextView story = (TextView) findViewById(R.id.story);
    }

    public void backToStart(View view)
    {
        Intent goBack = new Intent (this,
                MainActivity.class);

        final int result = 1;

        goBack.putExtra("callingActivity3", "Final Story");

        startActivity(goBack);
        finish();
    }

    //    you can get the story's text by calling its toString() method
    //    a Story is Serializable, so it can be packed into an Intent as "extra" data
}
