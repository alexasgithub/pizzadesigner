package com.example.khalessi.pizzabestellen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Alexandra Filbert on 04.12.17.
 */

public class MainActivity extends AppCompatActivity {


    static final String KEY_BOTSCHAFT = "bestellung";
    static final int REQ_CODE = 2305;

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
    public String best;

    private Bestellung bestellung = new Bestellung();

    /**
     * Einstellungen werden im outState gespeichert.
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("meinText", best.toString());
    }

    /**
     * Die jeweiligen Spinner werden initialisiert,
     * die Auswahl in einem ArrayAdapter zwischengespeichert und
     * ein Listener angebunden.
     *
     * @param savedInstanceState
     */
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

        ArrayAdapter<CharSequence> belaegeAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.belaege,
                        R.layout.layout_simple_spinner_item
                );
        belaegeAdapter.setDropDownViewResource(R.layout.layout_simple_spinner_dropdown_item);
        belaegeAuswahl.setAdapter(belaegeAdapter);

        belaegeAuswahl.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long l) {
                bestellung.setBelag1(belaege[position]);

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


        ArrayAdapter<CharSequence> belaegeZweiAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.belaege,
                        R.layout.layout_simple_spinner_item
                );
        belaegeZweiAdapter.setDropDownViewResource(R.layout.layout_simple_spinner_dropdown_item);
        belaegeAuswahlZwei.setAdapter(belaegeZweiAdapter);


        belaegeAuswahlZwei.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long l) {
                bestellung.setBelag2(belaege[position]);

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

        ArrayAdapter<CharSequence> belaegeDreiAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.belaege,
                        R.layout.layout_simple_spinner_item
                );
        belaegeDreiAdapter.setDropDownViewResource(R.layout.layout_simple_spinner_dropdown_item);
        belaegeAuswahlDrei.setAdapter(belaegeDreiAdapter);

        belaegeAuswahlDrei.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long l) {
                bestellung.setBelag3(belaege[position]);



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
        ArrayAdapter<CharSequence> wurstAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.wurst,
                        R.layout.layout_simple_spinner_item
                );
        wurstAdapter.setDropDownViewResource(R.layout.layout_simple_spinner_dropdown_item);
        wurstAuswahl.setAdapter(wurstAdapter);

        wurstAuswahl.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long l) {
                bestellung.setWurst(wurst[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Zugriff auf das Array
        wurst = getResources().getStringArray(R.array.wurst);

        kaeseAuswahl = (Spinner) findViewById(R.id.kaese);
        ArrayAdapter<CharSequence> kaeseAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.kaese,
                        R.layout.layout_simple_spinner_item
                );
        kaeseAdapter.setDropDownViewResource(R.layout.layout_simple_spinner_dropdown_item);
        kaeseAuswahl.setAdapter(kaeseAdapter);

        kaeseAuswahl.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long l) {
                bestellung.setKaese(kaese[position]);
                // setItemStyle(adapterView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Zugriff auf das Array
        kaese = getResources().getStringArray(R.array.kaese);

        if (savedInstanceState != null) {
           //  meinText = bestellung.toString());
        }
        best = bestellung.toString();


        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSecondIntent();
            }
        });
    }

/*
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

*/
    /**
     * Startet die nächste Activity der App und versendet Intents
     *
     */


    private void startSecondIntent() {
        Intent it = new Intent(getApplicationContext(), SecondActivity.class);

        it.putExtra(MainActivity.KEY_BOTSCHAFT, getString(R.string.ihre_bestellung)+": \n\n"+bestellung.toString());
        //neue Activity
        startActivityForResult(it, REQ_CODE);
    }



    /**
     * Empfängt Nachrichten
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE && resultCode == SecondActivity.RESULT_OK) {

            Bundle bnd = data.getExtras();
            String resultString = bnd.getString(SecondActivity.SEC_BOTSCHAFT);


            TextView tv = (TextView) findViewById(R.id.ausgabe);
            tv.setText(resultString);

        }
    }

}
