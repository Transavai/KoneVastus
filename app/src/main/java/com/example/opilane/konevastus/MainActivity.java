package com.example.opilane.konevastus;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView konetekst;
    ImageButton mic;
    Button räägi, puhasta, stop;
    String tekst;
    int tulemus;
    TextToSpeech kõneks;

    private EditText kirjuta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        konetekst= findViewById(R.id.kõnetekst);
        mic = findViewById(R.id.mic);
        räägi= findViewById(R.id.räägi);
        puhasta = findViewById(R.id. puhasta);
        stop = findViewById(R.id.stop);
        kirjuta = findViewById(R.id.kirjutatekst);
        kõneks = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
               if(status == TextToSpeech.SUCCESS)
               {tulemus = kõneks.setLanguage(Locale.getDefault());

               }
               else
               {
                   Toast.makeText(getApplicationContext(), "Sellised vahendi tööd ei toeta sinu seade", Toast.LENGTH_SHORT).show();

               }




        }});




    }
    public void mic (View view){Kasutajakõneleb();}

    private void Kasutajakõneleb(){
        Intent intent= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Ütle midagi");
        try{startActivityForResult(intent, 100);}
        catch (ActivityNotFoundException a){Toast.makeText(getApplicationContext(), "Sellised vahendi tööd ei toeta sinu seade", Toast.LENGTH_SHORT). show();}
    }

    public void onActivityResult(int request)



}
