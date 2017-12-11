package com.example.khalessi.pizzabestellen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    public static final String SEC_BOTSCHAFT = "botschaftBack";
    private Button button;
    public int REQ_CODE = 2305;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent auftrag = getIntent();
        Bundle extras = auftrag.getExtras();
        String botschaft = extras.getString(MainActivity.KEY_BOTSCHAFT);

        //Daten anzeigen
        TextView tv = (TextView) findViewById(R.id.tvThirdViewBestellung);
        tv.setText(botschaft);

        button = (Button) findViewById(R.id.bestaettigung);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onZurueckClick(view);
            }
        });
    }

    public void onZurueckClick(View view) {

        Intent it = new Intent(getApplicationContext(), MainActivity.class);

        //Auftrag  (Intent) erstellen
        //  Intent it = new Intent();
        // it.setClass(this, SecondActivity.class);

        it.putExtra(ThirdActivity.SEC_BOTSCHAFT, getString(R.string.order_confirmation_message));

        //neue Activity
        //  startActivityForResult(it, REQ_CODE);

        setResult(ThirdActivity.RESULT_OK, it);

        finish();
    }
}
