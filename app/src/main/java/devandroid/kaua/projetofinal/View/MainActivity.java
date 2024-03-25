package devandroid.kaua.projetofinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import devandroid.kaua.projetofinal.R;

public class MainActivity extends AppCompatActivity {

    Button ButtonAdicionar;
    Button buttonRemover;
    Button buttonVerTimes;
    Integer Contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonAdicionar = findViewById(R.id.buttonAdicionar);
        Contador = 0;

        buttonRemover = findViewById(R.id.buttonRemover);

        buttonVerTimes = findViewById(R.id.buttonVerTime);


        ButtonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAdicionar = new Intent(MainActivity.this, AdicionarPokemonActivity.class);
                startActivity(intentAdicionar);
            }
        });

        buttonRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRemover = new Intent(MainActivity.this, RemoverPokemonActivity.class);
                startActivity(intentRemover);
            }
        });

        buttonVerTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVerTimes = new Intent(MainActivity.this, VerTimeActivity.class);
                startActivity(intentVerTimes);
            }
        });


    }
}