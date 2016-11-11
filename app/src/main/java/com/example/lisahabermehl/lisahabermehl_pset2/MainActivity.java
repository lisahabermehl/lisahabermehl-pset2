package com.example.lisahabermehl.lisahabermehl_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onGetStartedClick (View view)
    {
        // "intention to do something"
        Intent getWordsUser = new Intent (this, GetWords.class);

        final int result = 1;
        // data to go to getWords screen
        getWordsUser.putExtra("callingActivity", "MainActivity");
        startActivity(getWordsUser);
    }
}
