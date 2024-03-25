package devandroid.kaua.projetofinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import devandroid.kaua.projetofinal.Controller.PokemonsController;
import devandroid.kaua.projetofinal.R;

public class RemoverPokemonActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_pokemon);
        Button buttonRemoverPokemon;
        Button buttonVoltar;
        EditText idPokemon;

        buttonRemoverPokemon = findViewById(R.id.buttonRemoverPokemon);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        idPokemon = findViewById(R.id.editTextNumberIdRemover);
        PokemonsController pokemonsController = new PokemonsController(RemoverPokemonActivity.this);

        Spinner SpinnerPokemon = findViewById(R.id.SpinnerPokemon);



        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonRemoverPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("listaValores", Context.MODE_PRIVATE);
                int contadorAtual = pokemonsController.getContador();
                if (contadorAtual < 0) {
                    contadorAtual *= 0;
                } else {

                    pokemonsController.diminuirContador();

                    Integer id;

                    id = Integer.parseInt(String.valueOf(idPokemon));

                    pokemonsController.removerPokemon(id);
                    Toast.makeText(RemoverPokemonActivity.this, ("Você removeu seu pokémon, que tinha o id " + idPokemon ), Toast.LENGTH_SHORT).show();
                }
            }
            });

    }
}