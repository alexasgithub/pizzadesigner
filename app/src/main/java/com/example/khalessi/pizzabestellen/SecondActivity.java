package com.example.khalessi.pizzabestellen;

/**
 * Created by Alexandra Filbert on 07.12.17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    static final String SEC_BOTSCHAFT = "bestaettigung";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Intent beschaffen
        Intent auftrag = getIntent();
        Bundle extras = auftrag.getExtras();
        String botschaft = extras.getString(MainActivity.KEY_BOTSCHAFT);

        //Daten anzeigen
        TextView tv = (TextView) findViewById(R.id.bestelltext);
        tv.setText(botschaft);


    }

    public void onZurueckClick(View view) {

        Intent result = new Intent();
        result.putExtra(SEC_BOTSCHAFT, "Bestellung erhalten");
        // startActivity(result);
        setResult(Activity.RESULT_OK, result);
        //  intent.setClass(this, MainActivity.class);
        //startActivity(intent);

        finish();
    }
}
