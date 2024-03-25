package devandroid.kaua.projetofinal.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.kaua.projetofinal.Model.Pokemon;

public class PokemonDatabase extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "pokemon_db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public PokemonDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabela =
                "CREATE TABLE Time(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nomePokemon TEXT, " +
                        "formaPokemon TEXT) ";

        db.execSQL(sqlTabela);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void salvarObjeto(String tabela, ContentValues dados) {

        db.insert(tabela, null, dados);

    }

    public List<Pokemon> listarDados() {

        List<Pokemon> lista = new ArrayList<>();

        Pokemon registro;

        String querySQL = "SELECT * FROM Time";

        cursor = db.rawQuery(querySQL, null);

        if (cursor.moveToFirst()) {

            do {
                registro = new Pokemon();

                registro.setId(cursor.getInt(0));
                registro.setNome(cursor.getString(1));
                registro.setForma(cursor.getString(2));
                lista.add(registro);
            } while (cursor.moveToNext());
        }

        else {}

        return lista;

    }

    public void alterarObjeto(String tabela, ContentValues dados){

        int id = dados.getAsInteger("id");

        db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)});

    }

    public void deletarObjeto(String tabela, int id) {

        db.delete(tabela, "id=?",
                new String[]{Integer.toString(id)});

    }

}

