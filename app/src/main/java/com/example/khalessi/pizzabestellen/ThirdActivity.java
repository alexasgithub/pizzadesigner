package com.example.khalessi.pizzabestellen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent auftrag = getIntent();
        Bundle extras = auftrag.getExtras();
        String botschaft = extras.getString(MainActivity.KEY_BOTSCHAFT);

        //Daten anzeigen
        TextView tv = (TextView) findViewById(R.id.bestelltext);
        tv.setText(botschaft);
    }
}
