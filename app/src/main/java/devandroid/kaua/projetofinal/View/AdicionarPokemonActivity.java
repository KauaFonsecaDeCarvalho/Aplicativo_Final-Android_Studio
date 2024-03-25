package devandroid.kaua.projetofinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import devandroid.kaua.projetofinal.Controller.PokemonsController;
import devandroid.kaua.projetofinal.Model.Pokemon;
import devandroid.kaua.projetofinal.R;

public class AdicionarPokemonActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String Opcao;
        Opcao = parent.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    Button buttonAdicionar;
    Button buttonVoltar;
    EditText nomePokemon;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_pokemon);

        PokemonsController pokemonsController = new PokemonsController(AdicionarPokemonActivity.this);

        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        nomePokemon = findViewById(R.id.editTextNomePokemon);



    Spinner SpinnerPokemon = findViewById(R.id.SpinnerPokemon);
    SpinnerPokemon.setOnItemSelectedListener(this);


    buttonVoltar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }

    });

    buttonAdicionar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int contadorAtual = pokemonsController.getContador();

            pokemonsController.incrementarContador();

            if (contadorAtual >= 5){
                buttonAdicionar.setEnabled(false);
                Toast.makeText(AdicionarPokemonActivity.this, ("Limite de pokémons, atingido com sucesso!"), Toast.LENGTH_SHORT).show();

            }else{
                String NomePokemon;
                String formaPokemon;

                NomePokemon = nomePokemon.getText().toString();
                formaPokemon  = SpinnerPokemon.getSelectedItem().toString();

                Pokemon pokemonTime = new Pokemon();
                pokemonTime.setNome(NomePokemon);
                pokemonTime.setForma(formaPokemon);

                pokemonsController.adicionarPokemon(pokemonTime);

                Toast.makeText(AdicionarPokemonActivity.this, ("Seu pokemon é um " + NomePokemon +" " + formaPokemon), Toast.LENGTH_SHORT).show();



            }
        }
    });
    }




}