package com.example.khalessi.pizzabestellen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.khalessi.pizzabestellen.R.id.ausgabe;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    private final String TAG = "Bestellung";
    private String meinText;
    private TextView ausgabeText;

    private Spinner teigAuswahl;
    private String[] teig;
    private Spinner belaegeAuswahl;
    private String[] belaege;
    private Spinner wurstAuswahl;
    private String[] wurst;
    private Spinner kaeseAuswahl;
    private String[] kaese;
    private Spinner belaegeAuswahlzwei;
    private String[] belaegeZwei;
    Button button;
    public String bestellung, kaeseTag, teigTag, wurstTag, belaegeTag;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("meinText", meinText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        teigAuswahl = (Spinner) findViewById(R.id.teig);
        teigAuswahl.setOnItemSelectedListener(this);
        //Zugriff auf das Array
        teig = getResources().getStringArray(R.array.teig);


        belaegeAuswahl = (Spinner) findViewById(R.id.belaege);
        belaegeAuswahl.setOnItemSelectedListener(this);
        //Zugriff auf das Array
        belaege = getResources().getStringArray(R.array.belaege);

        wurstAuswahl = (Spinner) findViewById(R.id.wurst);
        wurstAuswahl.setOnItemSelectedListener(this);
        //Zugriff auf das Array
        wurst = getResources().getStringArray(R.array.wurst);

        kaeseAuswahl = (Spinner) findViewById(R.id.kaese);
        wurstAuswahl.setOnItemSelectedListener(this);
        //Zugriff auf das Array
        kaese = getResources().getStringArray(R.array.kaese);

        if (savedInstanceState != null) {
            // meinText = savedInstanceState.getString(kaese.getText().toString());
        }

    }

    public void onSpeichernClick(View v){
        ausgabeText = (TextView) findViewById(ausgabe);
        bestellung="Ihre Bestellung: "+teigTag+", "+belaegeTag+", "+wurstTag+", "+kaeseTag;

        ausgabeText.setText(bestellung);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String tag = teig.getSelectedItem().toString();

        String teigTag = teig[position];
        String belaegeTag = belaege[position];
        String wurstTag = wurst[position];
        String kaeseTag = kaese[position];
        Log.d(TAG, "Bestellung = " + belaegeTag + wurstTag + kaeseTag);
        ausgabeText = (TextView) findViewById(ausgabe);
        // meinText = ausgabe.getText().toString()+" ";
    /*    String bestellung = "";
        bestellung = "Ihre Bestellung: " + teigTag + ", " + belaegeTag + ", " + wurstTag + ", " + kaeseTag;

        ausgabeText.setText(bestellung);*/


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
