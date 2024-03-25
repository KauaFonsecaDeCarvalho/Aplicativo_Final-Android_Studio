package devandroid.kaua.projetofinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import devandroid.kaua.projetofinal.Controller.PokemonsController;
import devandroid.kaua.projetofinal.Model.Pokemon;
import devandroid.kaua.projetofinal.R;

public class VerTimeActivity extends AppCompatActivity {

    Button buttonTime1;
    Button buttonVoltarMain;

    PokemonsController pokemonsController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_time);

        pokemonsController = new PokemonsController(VerTimeActivity.this);


        buttonVoltarMain = findViewById(R.id.buttonVoltar);
        buttonTime1 = findViewById(R.id.buttonTime1);



        buttonVoltarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirTime();

            }
        });


    }

    private void exibirTime() {

        PokemonsController pokemonsController = new PokemonsController(VerTimeActivity.this);

        TextView textViewPokemon1 = findViewById(R.id.textViewPokemon1);
        TextView textViewPokemon2 = findViewById(R.id.textViewPokemon2);
        TextView textViewPokemon3 = findViewById(R.id.textViewPokemon3);
        TextView textViewPokemon4 = findViewById(R.id.textViewPokemon4);
        TextView textViewPokemon5 = findViewById(R.id.textViewPokemon5);
        TextView textViewPokemon6 = findViewById(R.id.textViewPokemon6);

        List<Pokemon> listaPokemons = pokemonsController.getListaDados();


        if (!listaPokemons.isEmpty()) {

            for (int i = 0; i < Math.min(listaPokemons.size(), 6); i++) {
                Pokemon pokemon = listaPokemons.get(i);


                int textViewId = getResources().getIdentifier("textViewPokemon" + (i + 1), "id", getPackageName());


                TextView textViewPokemon = findViewById(textViewId);


                textViewPokemon.setText(pokemon.getNome());
            }
        }

    }
}
