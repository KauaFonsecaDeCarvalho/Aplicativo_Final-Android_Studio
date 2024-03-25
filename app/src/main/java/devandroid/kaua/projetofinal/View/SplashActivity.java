package devandroid.kaua.projetofinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.kaua.projetofinal.Database.PokemonDatabase;
import devandroid.kaua.projetofinal.R;

public class SplashActivity extends AppCompatActivity {
    public static final int TIME_OUT_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comutartelaSplash();
    }

    private void comutartelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                PokemonDatabase db = new PokemonDatabase(SplashActivity.this);
                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT_SPLASH);
    }
}