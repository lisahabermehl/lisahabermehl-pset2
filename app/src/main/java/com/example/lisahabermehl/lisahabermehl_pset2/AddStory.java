package com.example.lisahabermehl.lisahabermehl_pset2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by lisahabermehl on 11/11/16.
 */

public class AddStory extends Activity
{
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.story);

        Bundle extras = getIntent().getExtras();
        String previousActivity = extras.getString("callingActivity");
    }

}
