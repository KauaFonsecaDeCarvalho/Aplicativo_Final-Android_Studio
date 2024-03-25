package devandroid.kaua.projetofinal.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;


import java.util.List;

import devandroid.kaua.projetofinal.Database.PokemonDatabase;
import devandroid.kaua.projetofinal.Model.Pokemon;

public class PokemonsController extends PokemonDatabase {
    private static final String PREFS_NAME = "listaValores";
    private Context context;


    public PokemonsController(Context context) {
        super(context);
        this.context = context;
    }

    public int getContador() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return prefs.getInt("contador", 0);
    }

    public void incrementarContador() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        int contador = prefs.getInt("contador", 0);
        contador++;

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("contador", contador);
        editor.apply();
    }
    public void diminuirContador(){
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        int contador = prefs.getInt("contador", 0);
        contador--;


        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("contador", contador);
        editor.apply();
    }



        public void adicionarPokemon(Pokemon pokemon) {

            ContentValues dados = new ContentValues();


            dados.put("nomePokemon", pokemon.getNome());
            dados.put("formaPokemon", pokemon.getForma());

            Log.d("PokemonsController", "Adicionando Pokémon ao banco de dados...");
            Log.d("PokemonsController", "Nome: " + pokemon.getNome() + ", Forma: " + pokemon.getForma());

            salvarObjeto("Time", dados);
        }

        public List<Pokemon> getListaDados(){
        return listarDados();
        }


    public void removerPokemon(int id) {
    deletarObjeto("Time", id);

    }
    }
