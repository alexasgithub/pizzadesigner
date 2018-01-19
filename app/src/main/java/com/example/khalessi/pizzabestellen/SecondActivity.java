package com.example.khalessi.pizzabestellen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Alexandra Filbert on 04.12.17.
 */

public class SecondActivity extends AppCompatActivity {

    public static final String SEC_BOTSCHAFT = "botschaftBack";
    private Button button;
    public int REQ_CODE = 2305;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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

    /**
     * Sofern der Zurückbutton getätigt oder die Bestellung bestätigt wird,
     * gehe zum Ausgangsaktivity
     *
     * @param view
     */
    public void onZurueckClick(View view) {

        Intent it = new Intent(getApplicationContext(), MainActivity.class);

        it.putExtra(SecondActivity.SEC_BOTSCHAFT, getString(R.string.order_confirmation_message));

        setResult(SecondActivity.RESULT_OK, it);

        finish();
    }
}
