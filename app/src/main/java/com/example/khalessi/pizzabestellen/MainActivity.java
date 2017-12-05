package com.example.khalessi.pizzabestellen;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

import static com.example.khalessi.pizzabestellen.R.id.ausgabe;
import static com.example.khalessi.pizzabestellen.R.id.beginning;
import static com.example.khalessi.pizzabestellen.R.id.chains;

public class MainActivity extends AppCompatActivity {

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

    private Spinner belaegeAuswahlZwei;
    private String[] belaegeZwei;
    private Spinner belaegeAuswahlDrei;
    private String[] belaegeDrei;
    private Button button;

    private Bestellung bestellung = new Bestellung();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // zwischenspeichern des aktuellen zustands
        // spaeter
        outState.putString("meinText", meinText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teigAuswahl = (Spinner) findViewById(R.id.teig);
        ArrayAdapter<CharSequence> teigAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.teig,
                        R.layout.layout_simple_spinner_item
                );
        teigAdapter.setDropDownViewResource(R.layout.layout_simple_spinner_dropdown_item);
        teigAuswahl.setAdapter(teigAdapter);

        teigAuswahl.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long l) {
                bestellung.setTeig(teig[position]);
                //setItemStyle(adapterView);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                bestellung.setTeig(getResources().getStringArray(R.array.teig)[0]);
            }
        });
        //Zugriff auf das Array
        teig = getResources().getStringArray(R.array.teig);

        belaegeAuswahl = (Spinner) findViewById(R.id.belaege);
        belaegeAuswahl.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long l) {
                bestellung.setBelag1(belaege[position]);
                setItemStyle(adapterView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                bestellung.setBelag1(getResources().getStringArray(R.array.belaege)[0]);
            }
        });
        belaegeAuswahl.setSelection(0);


        //Zugriff auf das Array
        belaege = getResources().getStringArray(R.array.belaege);


        belaegeAuswahlZwei = (Spinner) findViewById(R.id.belaegeZwei);
        belaegeAuswahlZwei.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long l) {
                bestellung.setBelag2(belaege[position]);
                setItemStyle(adapterView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                bestellung.setBelag2(getResources().getStringArray(R.array.belaege)[1]);
            }
        });
        belaegeAuswahlZwei.setSelection(1);

        //Zugriff auf das Array
        belaegeZwei = getResources().getStringArray(R.array.belaege);

        belaegeAuswahlDrei = (Spinner) findViewById(R.id.belaegeDrei);
        belaegeAuswahlDrei.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long l) {
                bestellung.setBelag3(belaege[position]);
                setItemStyle(adapterView);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                bestellung.setBelag3(getResources().getStringArray(R.array.belaege)[2]);
            }
        });
        belaegeAuswahlDrei.setSelection(2);

        //Zugriff auf das Array
        belaege = getResources().getStringArray(R.array.belaege);

        wurstAuswahl = (Spinner) findViewById(R.id.wurst);
        wurstAuswahl.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long l) {
                bestellung.setWurst(wurst[position]);
                setItemStyle(adapterView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Zugriff auf das Array
        wurst = getResources().getStringArray(R.array.wurst);

        kaeseAuswahl = (Spinner) findViewById(R.id.kaese);
        kaeseAuswahl.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long l) {
                bestellung.setKaese(kaese[position]);
                setItemStyle(adapterView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Zugriff auf das Array
        kaese = getResources().getStringArray(R.array.kaese);

        if (savedInstanceState != null) {
            // meinText = savedInstanceState.getString(kaese.getText().toString());
        }

    }

    private void setItemStyle(AdapterView<?> adapterView) {
        if (adapterView != null) {
            TextView childAt = (TextView) adapterView.getChildAt(0);
            if (childAt != null) {
                childAt.setTextColor(Color.WHITE);
                childAt.setTypeface(null, Typeface.BOLD_ITALIC);
            }
        }
    }

    public void onSpeichernClick(View v) {
        ausgabeText = (TextView) findViewById(ausgabe);
        ausgabeText.setText(bestellung.toString());
    }

}
